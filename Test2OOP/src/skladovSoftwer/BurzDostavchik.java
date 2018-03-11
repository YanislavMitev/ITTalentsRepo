package skladovSoftwer;

import java.util.List;

public final class BurzDostavchik extends Dostavchik{
	private static final float PERCENT = 0.15f;
	private static final float PERCENT_OF_LOSS = 0.1f;

	public BurzDostavchik(String name, int pari) {
		super(name, pari);
	}

	@Override
	public void buyStoka(List<Stoka> stoki) {
		if(stoki != null) {
			for(Stoka stoka : stoki) {
				if(Math.random() <= PERCENT_OF_LOSS) {
					continue;
				}
				this.kupeniStoki.add(new Stoka(stoka.getType(), (int)(stoka.getPrice() * PERCENT), Sklad.DEFAULT_KOLICHESTVO));
			}
		}else {
			System.out.println("Invalid list of stoki.");
			return;
		}		
	}
	
}
