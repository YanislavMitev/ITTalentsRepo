package skladovSoftwer;

import java.util.Set;

public class Distributor extends Contact{
	private static final float COMISIONNA = 0.2f;
	private int pari;
	private int pariOtTekushtoZarejdane;
	private Magazin magazin;
	
	public Distributor(String name, int pari) {
		super(name);
		this.pari = pari;
	}
	public void setMagazin(Magazin magazin) {
		if(magazin != null && this.magazin == null) {
			this.magazin = magazin;
		}else {
			System.out.println("Cannot set magazin.");
		}
	}
	public Magazin getMagazin() {
		return this.magazin;
	}
	public void zarediMagazin(Magazin magazin, Set<Stoka> produkti) {
		this.pariOtTekushtoZarejdane = 0;
		if(magazin != null && produkti != null && !produkti.isEmpty()) {
			for(Stoka stoka : produkti) {
				int price = stoka.getPrice();
				stoka.setPrice(price + (int)(price*COMISIONNA));
				magazin.addStoka(stoka);
				this.pariOtTekushtoZarejdane += price;
				this.uvelichiMiParite((int)(price*COMISIONNA));
			}
		}
	}
	
	public void uvelichiMiParite(int pari) {
		if(pari > 0) {
			this.pari += pari;
		}
	}

	public int getPariOtTekushtoZarejdane() {
		return this.pariOtTekushtoZarejdane;
	}

	public static float getComisionna() {
		return COMISIONNA;
	}

	public void namaliMiParite(int namaliSys) {
		if(namaliSys > 0 && namaliSys < this.pari) {
			this.pari -= namaliSys;
		}else {
			this.pari = 0;
		}
	}

	
}
