package skladovSoftwer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Dostavchik extends Contact{
	private int pari;
	protected List<Stoka> kupeniStoki;
	
	public Dostavchik(String name, int pari){
		super(name);
		this.pari = pari;
		this.kupeniStoki = new ArrayList<Stoka>();
	}
	
	public abstract void buyStoka(List<Stoka> stoki);
	
	public void uvelichiMiParite(int pari) {
		if(pari > 0) {
			this.pari += pari;
		}
	}
	public void osvobodiSeOtKupeniStoki() {
		this.kupeniStoki.clear();
	}
	
	public List<Stoka> getKupeniStoki(){
		return Collections.unmodifiableList(this.kupeniStoki);
	}
}
