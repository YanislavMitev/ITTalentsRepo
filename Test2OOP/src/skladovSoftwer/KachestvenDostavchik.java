package skladovSoftwer;

import java.util.List;

public final class KachestvenDostavchik extends Dostavchik {
	private static final float PERCENT = 0.3f;
	public KachestvenDostavchik(String name, int pari) {
		super(name, pari);
	}

	@Override
	public void buyStoka(List<Stoka> stoki) {
		if(stoki != null) {
			for(Stoka stoka : stoki) {
				this.kupeniStoki.add(new Stoka(stoka.getType(), (int)(stoka.getPrice() * PERCENT), Sklad.DEFAULT_KOLICHESTVO));
			}
		}else {
			System.out.println("Invalid list of stoki.");
			return;
		}	
	}

}
