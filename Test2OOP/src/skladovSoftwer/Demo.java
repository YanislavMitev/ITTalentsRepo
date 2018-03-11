package skladovSoftwer;

import java.util.LinkedHashSet;
import java.util.Set;

public class Demo {
	private static String getRandomName() {
		String[] firstNames = { "Ivan", "Stoycho", "Nikoleta", "Yanislav", "Minzuharka", "Pruch", "Petyr", "Stoycho",
				"Nikoleta", "Yanislav", "Pruch", "Huligancho", "Radoy", "Kalkulatorka", "Roza", "Qnica" };
		String[] lastNames = { "Tirbushonov", "Karatopraklieva", "Minzuharev", "Keleshev", "Ahilesov", "Tazobedrev",
				"Mirkoskopova", "Milicionerski", "Grozeva", "Ovcharov", "Deleva", "Mitev", "Chichkov", "Minkov",
				"Kolarov", "Milev" };

		return firstNames[(int) (Math.random() * firstNames.length)] + " "
				+ lastNames[(int) (Math.random() * lastNames.length)];
	}
	
	private static String getRandomAddress() {
		String[] address = {"Bulevard Bulgaria", "Orlov Most", "Mladost", "Kriva reka", 
				"Luvov Most", "Orlandovci", "Fakulteta", "Lozenec", "Hladilnika"};
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		String[] street = {"Daskal Manol", "Dospat", "Kostur", "6ti septemvri", "Todor Kableshkov",
				"Milin Kamuk", "Sofronii Vrachanski", "Patriarh Evtimiy", "Evlogi i Hristo Georgievi"};
		
		return address[(int)(Math.random() * address.length)] + " " + numbers[(int)(Math.random() * numbers.length)] + 
				" " + street[(int)(Math.random() * street.length)];
	}
	private static int getRandomPice() {
		return (int)(Math.random() * 50 + 1);
	}
	
	private static int getRandomQuantity() {
		return (int)(Math.random() * 20 + 1);
	}
	
	private static int getMoney() {
		return (int)(Math.random() * 5000 + 1);
	}
	
	private static int getRandomZaplata() {
		return (int)(Math.random() * 2000 + 1);
	}
	
	private static String getRandomStoka() {
		String[] stoki = {"Banani","Chereshi", "Kufteta", "Charshafi",
				"Tanciorki", "Morkovi", "Molivi", "Lakochistitel", "Jele", 
				"Maratonki", "Banani", "Mecheta", "Gashti", "Chorapi", "Aerozol",
				"Muhozol", "Chereshi" };
		return stoki[(int)Math.random()*stoki.length];
	}
	
	private static String getRandomMagazinName() {
		String[] shops = {"345", "Fantastiko", "Bila", "Lidl", "Kaufland", "Pikadili", "Costco"};
		return shops[(int)Math.random()*shops.length];
	}
	
	private static Set<Stoka> getRandomSetOfStoki(){
		Set<Stoka> stoki = new LinkedHashSet<>();
		for(int index = 0; index < (int)(Math.random()*10) + 1; index++) {
			stoki.add(new Stoka(getRandomStoka(), getRandomPice(), getRandomQuantity()));
		}
		return stoki;
	}
	public static void main(String[] args) {
		Sklad sklad1 = new Sklad("Sklad 1" ,getRandomAddress());
		Sklad sklad2 = new Sklad("Sklad 2" ,getRandomAddress());
		Sklad sklad3 = new Sklad("Sklad 3" ,getRandomAddress());
		
		//-----------------------------------------------------------------------------
		//dobavqm 4 rabotnici w pyrwi sklad
		for(int index = 0; index < 4; index++) {
			sklad1.addRabotnik(new Rabotnik(getRandomName(), getRandomZaplata(), sklad1));
		}
		//dobavqm 5 distributori w pyrwi sklad
		for(int index = 0; index < 5; index++) {
			sklad1.addDistributor(new Distributor(getRandomName(), getMoney()));
		}
		
		//dobavqm na distributorite proizvolni magazini
		for(int index = 0; index < sklad1.getListOfDistributori().size(); index++) {
			sklad1
			.getListOfDistributori()
			.get(index)
			.setMagazin(new Magazin(getRandomMagazinName()));
		}
		//-----------------------------------------------------------------------------
		//dobavqm 4 rabotnici wyw wtori sklad
		for(int index = 0; index < 4; index++) {
			sklad2.addRabotnik(new Rabotnik(getRandomName(), getRandomZaplata(), sklad2));
		}
		//dobavqm 5 distributori wyw wtori sklad
		for(int index = 0; index < 5; index++) {
			sklad2.addDistributor(new Distributor(getRandomName(), getMoney()));
		}
		//dobavqm na distributorite ot sklad 2 proizvolen magazin
		for(int index = 0; index < sklad2.getListOfDistributori().size(); index++) {
			sklad2
			.getListOfDistributori()
			.get(index)
			.setMagazin(new Magazin(getRandomMagazinName()));
		}
		
		//-----------------------------------------------------------------------------
		//dobavqm 4 rabotnici w treti sklad
		for(int index = 0; index < 4; index++) {
			sklad3.addRabotnik(new Rabotnik(getRandomName(), getRandomZaplata(), sklad3));
		}
		//dobavqm 5 distributori w treti sklad
		for(int index = 0; index < 5; index++) {
			sklad3.addDistributor(new Distributor(getRandomName(), getMoney()));
		}
		//dobavqm na distributorite ot sklad 3 proizvolen magazin
		for(int index = 0; index < sklad3.getListOfDistributori().size(); index++) {
			sklad3
			.getListOfDistributori()
			.get(index)
			.setMagazin(new Magazin(getRandomMagazinName()));
		}
		//-----------------------------------------------------------------------------
	
		//dobavqm proizvolno kolichestvo stoka v sklad 1
		for(int index = 0; index < (int)(Math.random() * 30) + 1; index++) {
			sklad1.addStoka(new Stoka(getRandomStoka(), getRandomPice(), getRandomQuantity()));
		}
		//dobavqm proizvolno kolichestvo stoka v sklad 2
		for(int index = 0; index < (int)(Math.random() * 30) + 1; index++) {
			sklad2.addStoka(new Stoka(getRandomStoka(), getRandomPice(), getRandomQuantity()));
		}
		//dobavqm proizvolno kolichestvo stoka v sklad 3
		for(int index = 0; index < (int)(Math.random() * 30) + 1; index++) {
			sklad3.addStoka(new Stoka(getRandomStoka(), getRandomPice(), getRandomQuantity()));
		}		
		
		sklad1.dostavi(getRandomSetOfStoki(), new Magazin(getRandomMagazinName()));
		sklad2.dostavi(getRandomSetOfStoki(), new Magazin(getRandomMagazinName()));
		sklad3.dostavi(getRandomSetOfStoki(), new Magazin(getRandomMagazinName()));
		
		//statistika za sklad 1
		System.out.println("Sklad1");
		System.out.println("-------------------------------------------------------");
		for(Stoka stoka : sklad1.getNaiProdavanaStoka()) {
			System.out.println(stoka.getType() + " : " + stoka.getKolichestvo());
		}
		for(Rabotnik rab : sklad1.getNaiSlabRabotnik()) {
			System.out.println(rab.getName() + " : " + rab.getPrietiStoki());
		}
		sklad1.getStatistika();
		
		//statistika za sklad 2
		
		System.out.println("Sklad2");
		System.out.println("-------------------------------------------------------");
		for(Stoka stoka : sklad2.getNaiProdavanaStoka()) {
			System.out.println(stoka.getType() + " : " + stoka.getKolichestvo());
		}
		for(Rabotnik rab : sklad2.getNaiSlabRabotnik()) {
			System.out.println(rab.getName() + " : " + rab.getPrietiStoki());
		}
		sklad2.getStatistika();
		//statistika za sklad 3
		
		System.out.println("Sklad3");
		System.out.println("-------------------------------------------------------");
		for(Stoka stoka : sklad3.getNaiProdavanaStoka()) {
			System.out.println(stoka.getType() + " : " + stoka.getKolichestvo());
		}
		for(Rabotnik rab : sklad3.getNaiSlabRabotnik()) {
			System.out.println(rab.getName() + " : " + rab.getPrietiStoki());
		}
		sklad3.getStatistika();
		
	}

}
