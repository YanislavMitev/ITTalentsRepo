package skladovSoftwer;

import java.util.List;
import java.util.Set;

public interface ISklad {
	public void zarediSklada(List<Stoka> listSysStoki);
	public void dostavi(Set<Stoka> stoki, Magazin magazin );
	public List<Stoka> getNaiProdavanaStoka();
	public List<Rabotnik> getNaiSlabRabotnik();
	public List<Stoka> getDeficitniStoki();
	public void getStatistika();
	public void getBalance();
}
