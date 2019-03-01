import java.util.Scanner;
import java.text.DecimalFormat;

public class PainokerroinOhjelma {
	Scanner input = new Scanner(System.in);
	
	
	public static int kysyPaino(int userWeight) throws KelvotonPainoPoikkeus { 
		// Asks for the users weight
		Scanner input = new Scanner(System.in);
		String parWeight;
		// Used to loop until input = true
		boolean ger = false;
		
		do {
		System.out.print("Anna paino (kg): ");
		try {
		
			parWeight = input.nextLine();
		
			userWeight = Integer.parseInt(parWeight); // Check if input is a number
			if (userWeight <= 0) {
				String message = "Ei saa olla alle 0";
				throw new KelvotonPainoPoikkeus(message);
			}
			
			ger = true;
		}
		catch(NumberFormatException e) {
			System.out.println("Ei ole kokonaisluku");
		}
		catch(KelvotonPainoPoikkeus e) {
			System.out.println("Ei saa olla alle 0"); // make sure input is over 0 
		}

		}while(ger != true);
		return userWeight;
	} 
		

	
	public static double askHeight(double userHeight) throws KelvotonPituusPoikkeus {
		Scanner input = new Scanner(System.in);
		String parseDoub;
		boolean ger = false;
		
		do {
			try {
				System.out.print("Anna pituus (m): ");
				parseDoub = input.nextLine();
				// check if input is double
				userHeight = Double.parseDouble(parseDoub);
				if (userHeight <= 0 || userHeight > 3) {
					String message = "Kelvoton Pituus";
					throw new KelvotonPituusPoikkeus(message);
				}
				ger = true;
			}
			catch(NumberFormatException e) {
				System.out.println("Pitää olla desimaaliluku");
			}
			catch (KelvotonPituusPoikkeus e) {
				System.out.println("Ihmisen pituus pitää olla > 0 ja alle 3 metriä");
			}
		
		
		
		}while(ger != true);
		return userHeight;
	}
	
	public static double countBMI(int userWeight, double userHeight) {
		double userBMI = userWeight/(userHeight*userHeight);
		return userBMI;
	}

	public static void main(String[] args) throws KelvotonPainoPoikkeus, KelvotonPituusPoikkeus{
		// TODO Auto-generated method stub
		DecimalFormat nf = new DecimalFormat("0.00");
		
		int userWeight = 0;
		double userHeight = 0;
		
		userWeight = kysyPaino(userWeight);
		userHeight = askHeight(userHeight);
		
		System.out.print("Painokerroin on " + nf.format(countBMI(userWeight, userHeight)) + " (kun paino on "
				 + userWeight + "kg ja pituus on " + nf.format(userHeight) + " metrinä)");			

	}

}
