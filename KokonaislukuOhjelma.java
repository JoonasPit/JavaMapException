import java.util.Scanner;

public class KokonaislukuOhjelma {

	public static void main(String[] args) {
		// Reads User input 
		Scanner input = new Scanner(System.in);
		int toNbr;
		String userInput;
		boolean retry = false;
		
		
		for(int i = 1; i <= 3; i++) {
			System.out.print("Anna " + i + ". luku: ");
			while(!retry) {
			try{
				userInput = input.nextLine();
				toNbr = Integer.parseInt(userInput);
				retry = true;
			}
			catch(NumberFormatException e) {
				System.out.println("Syötä kokonaisluku numeronäppäimillä!");
				System.out.print("Anna " + i + ". luku: ");
				i--;
			}
		}
		}

	}
}
// not finished.
// loop asked integer
