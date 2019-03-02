import java.util.Scanner;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class YstavatSovellus {
	// Program creates a list of friends, is able to search through them based off unique nickname.
	Scanner input = new Scanner(System.in);
	Ystava bro = new Ystava();
	Map<String,Ystava> friends = new HashMap<String, Ystava>();
	SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");
	
	public String parseTheDate(String friendBirth) {
		Date parseDate =null;
		try {
			parseDate = simpledate.parse(friendBirth);
		}
		catch(ParseException e){
			System.out.println("Juupajuu");
		}
		friendBirth = simpledate.format(parseDate);
		return friendBirth;
	}
	
	public void addFriend() {
		// Adds a friend to hashmap
		String friendNick, friendName, friendPhone, friendBirth;
		boolean exist = false;
		
		Set<String> nicks = friends.keySet();
		Iterator<String> it = nicks.iterator();
		
		String nextNick = null;
		Ystava nextYstava = null;
		
		
		// Ask for friend details
		// check if friend exists already
		System.out.print("Anna ystävän lempinimi: ");
		friendNick = input.nextLine();
		
		nextYstava = friends.get(friendNick);
		
		if(nextYstava == null) {
			System.out.print("Anna ystävän nimi: ");
			friendName = input.nextLine();
			System.out.print("Anna ystävän puhelinnumero: ");
			friendPhone = input.nextLine();
			System.out.print("Anna ystävän syntymäpäivämäärä muodossa pp.kk.vvvv: ");
			friendBirth = input.nextLine();
			friendBirth = parseTheDate(friendBirth); // Makes sure the userinput is in dd.MM.yyyy format
				
			//create new friend
			Ystava newYstava = new Ystava(friendName, friendNick, friendPhone, friendBirth);
			// put friend in hashmap with key attribute nickname
			friends.put(friendNick, newYstava);
			}
			
		else {
			System.out.println("Olet jo lisännyt tämän ystävän");
			System.out.println("Ystävän tiedot: " + nextYstava.toString());
		}

	}
	
	public void searchFriend() {
		// this could have been done better... I feel like just searching with friends.get(keyvalue) would've worked.
		Set<String> nicks = friends.keySet();
		Iterator<String> it = nicks.iterator();
		
		String searchFor;
		boolean found = false;
		
		System.out.print("Anna ystävän lempinimi: ");
		searchFor = input.nextLine();
		
		String nextNick = null;
		Ystava nextYstava = null;
		
		while(it.hasNext() || found == false) {
			try {
			nextNick = it.next();
			nextYstava = friends.get(searchFor);		
			found = true;
			if (found == true) {
				System.out.println("Ystävän tiedot: " + nextYstava.toString());
				break;
				}
			}

		catch(NoSuchElementException e){
			System.out.println("Ystävää, jonka lempinimi on " + searchFor + " ei ole");
			break;
		}
		catch(NullPointerException e) {
			System.out.print("Ystävää, jonka lempinimi on " + searchFor + " ei ole");
			break;
		}
		}
	}
	public void deleteFriend() {
		String delFriend;
		System.out.print("Anna ystävän lempinimi: ");
		delFriend = input.nextLine();
		try {
		System.out.print("Poistetaan ystävän tiedot: " + friends.get(delFriend).toString());
		}
		catch(NoSuchElementException e) {
			System.out.println("Ystävää ei ole");
		}
		catch(NullPointerException e) {
			System.out.println("Ystävää ei ole");
		}
		friends.remove(delFriend);
	}
	
	public void printAll() {
		//runs through hashmap and prints all values toString
		Set<String> nicks = friends.keySet();
		Iterator<String> it = nicks.iterator();
		
		String nextNick = null;
		Ystava nextYstava = null;
		
		while(it.hasNext()) {
			nextNick = it.next();
			nextYstava = friends.get(nextNick);
			
			System.out.println(nextYstava.toString());
		}
	}

	public static void main(String[] args) {
		// Takes in useraction and functions accordingly.
		
		Scanner input = new Scanner(System.in);
		YstavatSovellus newFriend = new YstavatSovellus(); // create olio of same class to call functions from same class
		
		int userInput = 0;
		// runs program while userinput != zero.
		do {
			System.out.println("1) Lisää ystävä\n2) Etsi ystävä\n3) Poista ystävä\n4) Tulosta ystävät\n0) Lopeta");
			System.out.print("Valitse: ");
			userInput = input.nextInt();
			switch(userInput){
				case 1:{
					newFriend.addFriend();
					break;
						}
				case 2:{
					newFriend.searchFriend();
					break;
						}
				case 3:{
					newFriend.deleteFriend();
					break;
						}
				case 4:{
					newFriend.printAll();
					break;
						}
				case 0:{
					break;
						}		
		}
			
		}while(userInput != 0);
		
	}

}
