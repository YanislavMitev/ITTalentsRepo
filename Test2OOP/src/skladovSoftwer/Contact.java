package skladovSoftwer;

public abstract class Contact {
	
	private String name;
	
	public Contact(String name) {
		this.setName(name);
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if(StaticMethods.checkString(name)) {
			this.name = name;
		}else {
			this.name = "";
			System.out.println("Invalid name. (CLASS: Sklad)");
		}
	}
}


