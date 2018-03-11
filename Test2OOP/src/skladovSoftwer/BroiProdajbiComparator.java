package skladovSoftwer;

import java.util.Comparator;

public class BroiProdajbiComparator implements Comparator<Stoka> {
	public int compare(Stoka stoka1, Stoka stoka2) {
		return stoka1.getProdajbi() - stoka2.getProdajbi();
	};
}
