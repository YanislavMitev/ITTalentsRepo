package skladovSoftwer;

import java.util.HashMap;
import java.util.Map;

public class Magazin extends Contact{
	private Map<Stoka, Integer> stoki;
	
	public Magazin(String name) {
		super(name);
		this.stoki = new HashMap<Stoka, Integer>();
	}

	public void addStoka(Stoka stoka) {
		if(stoka != null && this.stoki.containsKey(stoka)) {
			int currentAmount = this.stoki.get(stoka);
			this.stoki.put(stoka, currentAmount + stoka.getKolichestvo());
		}else {
			if(stoka != null) {
				this.stoki.put(stoka, stoka.getKolichestvo());
			}else {
				System.out.println("Invalid stoka.");
			}
		}
	}
	
	
	
}
