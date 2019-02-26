import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class OpintojaksoOhjelma {

	public static void main(String[] args) {
		// Create hashMap for course		
		Map<String,Opintojakso> courses = new HashMap<String, Opintojakso>();

		
		String numb;
		String name;
		int points = 0;
		
		Scanner input = new Scanner(System.in);
		
		//Asks for 4 courses and takes in user input into variables above
		System.out.println("Syötä neljän opintojakson tiedot!");
		
		for (int i = 0; i < 4; i++) {
			System.out.print("Anna opintojakson tunnus: ");
			numb = input.next();
			input.nextLine();
			System.out.print("Anna opintojakson nimi: ");
			name = input.nextLine();
			System.out.print("Anna opintojakson laajuus: ");
			points = input.nextInt();
			Opintojakso newClass = new Opintojakso(numb, name, points);
			courses.put(numb, newClass);
			
		}
		// Set key and iterate Map to print
		Set<String> numbs = courses.keySet();
		Iterator<String> it = numbs.iterator();
		
		String nextNumb = null;
		Opintojakso nextOpintojakso = null;
		
		System.out.println("Opintojaksot: ");
		
			while(it.hasNext()) {
				nextNumb = it.next();
				nextOpintojakso = courses.get(nextNumb);
				
				System.out.println(nextOpintojakso.toString());
			}

	}

}
