package skladovSoftwer;

import java.util.List;

public class NeopitenRabotnik extends Rabotnik{

	public NeopitenRabotnik(String name, int zaplata, Sklad sklad) {
		super(name, zaplata, sklad);
	}
	
	@Override
	public void podrediStokiteVSklada(List<Stoka> stokiZaPodrejdane) {
		for(Stoka stoka : stokiZaPodrejdane) {
			if(Math.random() >= 0.5) {
				continue;
			}
			this.sklad.addStoka(stoka);
		}
	}
}
