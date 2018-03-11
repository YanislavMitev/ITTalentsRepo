package skladovSoftwer;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Rabotnik extends Contact{
	protected int zaplata;
	protected Sklad sklad;
	protected List<Stoka> prietiStoki;
	protected List<Stoka> otpisaniStoki;
	
	public Rabotnik(String name, int zaplata, Sklad sklad) {
		super(name);
		this.setSklad(sklad);
		this.zaplata = zaplata;
		this.prietiStoki = new ArrayList<Stoka>();
		this.otpisaniStoki = new ArrayList<Stoka>();
	}
	
	public void addPrietaStoka(Stoka stoka) {
		if(stoka != null && !this.prietiStoki.contains(stoka)) {
			this.prietiStoki.add(stoka);
		}else {
			System.out.println("Cannot add prieta stoka");
		}
	}
	
	public void podrediStokiteVSklada(List<Stoka> stokiZaPodrejdane) {
		for(Stoka stoka : stokiZaPodrejdane) {
			this.sklad.addStoka(stoka);
		}
	}

	public Sklad getSklad() {
		return this.sklad;
	}

	public void setSklad(Sklad sklad) {
		if(sklad != null) {
			this.sklad = sklad;
		}else {
			System.out.println("Invalid sklad.");
		}
	}

	public List<Stoka> getPrietiStoki() {
		return Collections.unmodifiableList(this.prietiStoki);
	};
	
	
	
}
