package skladovSoftwer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Sklad extends Contact implements ISklad{
	private static final int STARTING_OBOROT = 10_000;
	public static final int DEFAULT_KOLICHESTVO = 15;
	
	private String address;
	private int oborot;
	private int izharcheniPari;
	private List<Dostavchik> dostavchici;
	private List<Rabotnik> rabotnici;
	private List<Distributor> distributori; 
	private Map<Stoka, Integer> stoki;
	
	public Sklad(String name, String address) {
		super(name);
		this.address = address;
		this.oborot = STARTING_OBOROT;
		this.izharcheniPari = 0;
		this.dostavchici = new ArrayList<Dostavchik>();
		this.rabotnici = new ArrayList<Rabotnik>();
		this.distributori = new ArrayList<Distributor>();
		this.stoki = new HashMap<Stoka, Integer>();
	}

	
	public List<Distributor> getListOfDistributori(){
		return Collections.unmodifiableList(this.distributori);
	}
	public void addRabotnik(Rabotnik rabotnik) {
		if(rabotnik != null && !this.rabotnici.contains(rabotnik)) {
			this.rabotnici.add(rabotnik);
		}else {
			System.out.println("Cannot add rabotnik.");
		}
	}
	public void addDistributor(Distributor distributor) {
		if(distributor != null && !this.distributori.contains(distributor)) {
			this.distributori.add(distributor);
		}else {
			System.out.println("Cannot add distributor.");
		}
	}
	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		if(StaticMethods.checkString(address)) {
			this.address = address;
		}else {
			this.address = "";
			System.out.println("Invalid address. (CLASS: Sklad)");
		}
	}

	public int getOborot() {
		return this.oborot;
	}

	public void setOborot(int oborot) {
		if(oborot > 0) {
			this.oborot = oborot;
		}else {
			System.out.println("Negative oborot. Assigning default = 0.");
			this.oborot = 0;
		}
	}

	@Override
	public void zarediSklada(List<Stoka> listSysStoki) {
		if(listSysStoki != null) {
			if(this.dostavchici != null && !this.dostavchici.isEmpty()) {
				Dostavchik dostavchik = this.dostavchici.get((int)Math.random() * this.dostavchici.size());
				dostavchik.buyStoka(listSysStoki);
				Rabotnik rabotnik = this.rabotnici.get((int)Math.random() * this.dostavchici.size());
				
				for(Stoka stoka : dostavchik.getKupeniStoki()) {
					rabotnik.addPrietaStoka(stoka);
					dostavchik.uvelichiMiParite(stoka.getPrice());
					this.namaliMiParite(stoka.getPrice());
					this.izharcheniPari += stoka.getPrice();
				}
				rabotnik.podrediStokiteVSklada(rabotnik.getPrietiStoki());
				dostavchik.osvobodiSeOtKupeniStoki();
			}else {
				System.out.println("list of dostavchici = NULL or list of dostavchici is empty.");
			}
		}else {
			System.out.println("Invalid list sys stoki");
		}
	}
	
	public void addStoka(Stoka stoka) {
		if(stoka!=null) {
			if(this.stoki.containsKey(stoka)) {
				int stoki = this.stoki.get(stoka);
				this.stoki.put(stoka, stoki++);
			}else {
				this.stoki.put(stoka, 1);
			}
		}else {
			System.out.println("Invalid stoka.");
		}
	}
	
	@Override
	public void dostavi(Set<Stoka> stokiZaDostavqne, Magazin magazin) {
		Distributor distributor = this.distributori.get((int)Math.random() * this.distributori.size());
		Rabotnik rabotnik = this.rabotnici.get((int)Math.random() * this.rabotnici.size());
		distributor.zarediMagazin(magazin, stokiZaDostavqne);
		for(Stoka stoka : stokiZaDostavqne) {
			this.stoki.put(stoka, this.stoki.get(stoka) - stoka.getKolichestvo());
			rabotnik.otpisaniStoki.add(stoka);
			int uvelichiSys = distributor.getPariOtTekushtoZarejdane() - (int)(distributor.getPariOtTekushtoZarejdane() * distributor.getComisionna());
			this.uvelichiMiParite(uvelichiSys);
			distributor.namaliMiParite(uvelichiSys);
			stoka.uvelichiProdajbite();
		}
	}

	@Override
	public List<Stoka> getNaiProdavanaStoka() {
		List<Stoka> naiProdavanaStoka = new ArrayList<Stoka>();
		for(Entry<Stoka, Integer> entry : this.stoki.entrySet()) {
			naiProdavanaStoka.add(entry.getKey());
		}
		List<Stoka> stream = naiProdavanaStoka
				.stream()
				.sorted((stoka1, stoka2) -> stoka2.getProdajbi() - stoka1.getProdajbi())
				.limit(5)
				.collect(Collectors.toList());
		
		return Collections.unmodifiableList(stream);
	}
	
	@Override
	public List<Rabotnik> getNaiSlabRabotnik() {
		List<Rabotnik> naiSlabiRabotnici = new ArrayList<Rabotnik>();
		naiSlabiRabotnici.addAll(this.rabotnici);
		
		List<Rabotnik> stream = naiSlabiRabotnici.stream()
				.sorted((rabotnik1, rabotnik2) -> rabotnik1.getPrietiStoki().size() - rabotnik2.getPrietiStoki().size())
				.limit(3)
				.collect(Collectors.toList());
		
		return Collections.unmodifiableList(stream);
	}

	@Override
	public List<Stoka> getDeficitniStoki() {
		List<Stoka> deficitniStoki = new ArrayList<Stoka>();
		for(Entry<Stoka, Integer> entry : this.stoki.entrySet()) {
			if(entry.getKey().getKolichestvo() < 10) {
				deficitniStoki.add(entry.getKey());
			}
		}
		
		Collections.sort(deficitniStoki, (s1,s2) -> s1.getKolichestvo() - s2.getKolichestvo());
		
		return Collections.unmodifiableList(deficitniStoki);
	}

	@Override
	public void getStatistika() {
		
		for(Distributor d : this.distributori) {
			if(d != null) {
				System.out.println(d.getName() + " e izkaral " + d.getPariOtTekushtoZarejdane() + " pari.");
			}else {
				System.out.println("NULL DISTRIBUTOR, BREAKING...");
				break;
			}
		}
	}

	@Override
	public void getBalance() {
		System.out.println("Izharcheni pari za stoki: " + this.izharcheniPari);
		System.out.println("Tekusht balans: " + this.getOborot());
	}
	public void namaliMiParite(int pari) {
		if(pari > 0 && pari < this.oborot) {
			this.oborot -= pari;
		}
	}
	public void uvelichiMiParite(int pari) {
		if(pari > 0) {
			this.oborot += pari;
		}
	}
}
