import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.List;

public class KokonaislukuOhjelma {
	
	
	public static void askNum() {
		
	}

	public static void main(String[] args) {
		// Reads User input 
		List <Integer> numList = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		int toNbr;
		String userInput;
		boolean retry = false;
		int i = 0;
		
		
		do {
			System.out.print("Anna " + (i+1) + ". luku: ");
			try{
				userInput = input.next();
				toNbr = Integer.parseInt(userInput);
				i++;
				retry = true;
				numList.add(toNbr);
			}
			catch(NumberFormatException e) {
				System.out.println("Syötä kokonaisluku numeronäppäimillä!");
			}
			
		} while(retry != true || i != 10);
		System.out.println("LUVUT:");
		for(int b = 0; b < numList.size(); b++) {
			int theNum = numList.get(b);
			System.out.print(theNum + " ");
		}

	}
}
