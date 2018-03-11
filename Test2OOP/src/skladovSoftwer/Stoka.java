package skladovSoftwer;

public class Stoka{
	private static final int DEFAULT_PRICE = 5;
	private static final String DEFAULT_TYPE = "Hlqb";
	private String type;
	private int price;
	private int kolichestvo;
	private int broiProdajbi;
	
	public Stoka(String type, int price, int kolichestvo) {
		this.setType(type);
		this.setPrice(price);
		this.setKolichestvo(kolichestvo);
		this.broiProdajbi = 0;
	}
	public void uvelichiProdajbite() {
		this.broiProdajbi++;
	}
	private void setKolichestvo(int kolichestvo) {
		if(kolichestvo > 0) {
			this.kolichestvo = kolichestvo;
		}else {
			System.out.println("Invalid kolichestvo. Assigning to 0.");
			this.kolichestvo = 0;
		}
	}

	public void setPrice(int price) {
		if(price > 0) {
			this.price = price;
		}else {
			System.out.println("Invalid price. Assigning default.");
			this.price = DEFAULT_PRICE;
		}
	}

	private void setType(String type) {
		if(StaticMethods.checkString(type)) {
			this.type = type;
		}else {
			System.out.println("Invalid type. Assigning default.");
			this.type = DEFAULT_TYPE;
		}
	}

	public String getType() {
		return this.type;
	}

	public int getPrice() {
		return this.price;
	}

	public int getKolichestvo() {
		return this.kolichestvo;
	}
	public int getProdajbi() {
		return this.broiProdajbi;
	}
	@Override
	public int hashCode() {
		return this.type.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Stoka stoka;
		if(obj instanceof Stoka) {
			stoka = (Stoka)obj;
			if(this.getType().equals(stoka.getType())) {
				return true;
			}
		}
		return false;
	}
	
	
}
