package form;

import java.io.File;
import java.util.Scanner;

import application.UI;
import entities.ReadFile;


public class filter extends UI {

	public filter() {
		super();
	}

	public static void receiveFilter(String sOption) throws Exception {
		Scanner goMenu = new Scanner(System.in);
		try {	
			switch (sOption) {
			case "001":
				File file1 = new File("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Categories.txt");
				printCategories(file1, sOption);
				System.out.println();
				System.out.println();
								
				System.out.println("Click ENTER to go back menu:");
				goMenu.nextLine();
				
				UI.menuPrincipal();				
	
			case "002":
				File file2 = new File("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Plan.txt");
				File fileValid = new File ("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Categories.txt");
				printPlanCustos(file2, sOption, fileValid);

				System.out.println();
				System.out.println();
								
				System.out.println("Operation : ");
				System.out.println();
				System.out.println("[1] Menu Principal     [2] Add Record     [3] Delete Record  ");
				System.out.println();
				System.out.print("Enter the option :");
				String sOp2 = goMenu.nextLine();
				if (sOp2.equals("1")) {
					UI.menuPrincipal();
				}
				else if (sOp2.equals("2")){
					Operator.addCountPlan();
				}
				else if (sOp2.equals("3")) {
					Operator.deletePlan();
				}
				else {
					
					System.out.println("Invalid Operation");
					goMenu.nextLine();
					UI.menuPrincipal();					
				}				
	
			case "003":
				File file3 = new File("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Withdraw.txt");
				
				printWithDraw(file3, sOption);
				System.out.println();
				System.out.println();
								
				System.out.println("Operation : ");
				System.out.println();
				System.out.println("[1] Menu Principal     [2] Add Record     [3] Delete Record  ");
				System.out.println();
				System.out.print("Enter the option :");
				String sOp = goMenu.nextLine();
				if (sOp.equals("1")) {
					UI.menuPrincipal();
				}
				else if (sOp.equals("2")){
					Operator.addCount();
				}
				else if (sOp.equals("3")) {
					Operator.deleteCount();
				}
				else {
					
					System.out.println("Invalid Operation");
					goMenu.nextLine();
					UI.menuPrincipal();					
				}

	
				//break;
	
			case "004":
				File file4 = new File("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Plan.txt");
				File fileValid1 = new File ("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Categories.txt");
				printPlanVsWithDraw(file4, sOption, fileValid1);
				System.out.println();
				System.out.println();
								
				System.out.println("Click ENTER to go back menu:");
				goMenu.nextLine();
				
				UI.menuPrincipal();
				
			case "005":
				File file5 = new File("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Categories.txt");
				printAnualPlan(file5, sOption);
				System.out.println();
				System.out.println();
								
				System.out.println("Click ENTER to go back menu:");
				goMenu.nextLine();
				
				UI.menuPrincipal();		
				

				
			case "006":
				File file6 = new File("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Categories.txt");
				printAnualWithDraw(file6, sOption);
				System.out.println();
				System.out.println();
								
				System.out.println("Click ENTER to go back menu:");
				goMenu.nextLine();
				
				UI.menuPrincipal();		
				
			default:
				break;				
	
			}
		}
		catch(RuntimeException e){
			e.getMessage();
		}
	}

	public static void printPlanVsWithDraw(File sfile, String soption, File sVal) throws Exception {
		String category = null;
		String character = null;
		String characteraux = null;
		String price = null;
		String priceaux = null;
		String month, year, combination, combinationaux;
		double amount = 0;
		double amountaux = 0;
		double withdraw=0;
		int start = 0;
		int numberofcharacter = 0;
		int numberofcharacteraux = 0;
		int l = 0;
		int c = 0;

		File filewithdraw = new File(
				"C:\\\\Backup_Douglas\\\\Biblioteca\\\\Eclipse\\\\Plan_Custos\\\\DB\\\\Withdraw.txt");
		Scanner sValid = new Scanner(sVal).useDelimiter("\\;");
		Scanner filter = new Scanner(System.in);
		Scanner sc = new Scanner(sfile).useDelimiter("\\;");
		// Scanner auxsc = new Scanner(filewithdraw);

		System.out.print("Digite o mes (ex.08) : ");
		month = filter.nextLine();
		System.out.print("Digite o ano (ex.2020) : ");
		year = filter.nextLine();
		System.out.println();
		System.out.println("Description              Amount        Withdraw  Result");
		System.out.println("---------------------------------------------------------");
		try {
			while (sValid.hasNextLine()) {
				if (start>0){
					sc = new Scanner(sfile).useDelimiter("\\;");		
				}
				category = sValid.nextLine();
				String[] vectValid = category.split(";");				
				category = vectValid[1];			
				while (sc.hasNextLine()) {
					character = sc.nextLine();
					numberofcharacter = (character.length());
					String[] vect = character.split(";");
					combination = character.replace(";", "");
					combination = (combination.substring(combination.length() - 6, combination.length()));
					String sdata = month + year;
					if (vect[1].equals(category)) {
						if (combination.equals(sdata)) {
							Scanner auxsc = new Scanner(filewithdraw);
							amountaux = 0;
			
							// Logic to get information of withdraw
							while (auxsc.hasNextLine()) {
								characteraux = auxsc.nextLine();
								numberofcharacteraux = (characteraux.length());
								String[] vectaux = characteraux.split(";");
								combinationaux = characteraux.replace(".", "");
								combinationaux = (combinationaux.substring(8, 14));
								
								//System.out.println(vect[0]);
								if (combinationaux.equals(sdata)&&vectaux[2].equals(vect[1])) {
									priceaux =vectaux[3];
									amountaux += Double.valueOf(priceaux);
								}
							}
							//System.out.println(amountaux);
			
							price = vect[2];
							ReadFile readfile = new ReadFile(character);
							amount += Double.valueOf(price);
							System.out.println(readfile.getCharacter(numberofcharacter, 25, 15, 0, 0, soption,amountaux,8));
							withdraw +=amountaux;
							//auxsc.close();
						}
					
					}
	
				}
				start+=1;
				sc.close();
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		System.out.println("");
		System.out.println("---------------------------------------------------------");
		System.out.printf("Budget    : $  %.2f%n", amount);
		System.out.printf("Withdraw  : $  %.2f%n", withdraw);
		System.out.printf("Result    : $  %.2f%n", (amount-withdraw));

		
	}
	
	public static void printCategories(File sfile, String soption) throws Exception {
		String character = null;
		int numberofcharacter = 0;
		int l = 0;
		int c = 0;
		Scanner sc = new Scanner(sfile).useDelimiter("\\;");
		System.out.println();
		System.out.println("Code      Description            Order ID");
		System.out.println("-----------------------------------------");
		while (sc.hasNextLine()) {
			character = sc.nextLine();
			numberofcharacter = (character.length());
			String[] vect = character.split(";");
			ReadFile readfile = new ReadFile(character);
			System.out.println(readfile.getCharacter(numberofcharacter, 10, 25, 0, 0, soption,0.00,3));
		}
		System.out.println("-----------------------------------------");
	}
	
	public static void printPlanCustos(File sfile, String soption, File sVal) throws Exception {
		String category = null;
		String character = null;
		String price = null;
		String month, year, combination;		
		double amount = 0;
		int start = 0;
		int numberofcharacter = 0;
		int l = 0;
		int c = 0;
		Scanner filter = new Scanner(System.in);	
		Scanner sValid = new Scanner(sVal).useDelimiter("\\;");
		Scanner sc = new Scanner(sfile).useDelimiter("\\;");
		System.out.print("Digite o mes (ex.08) : ");
		month = filter.nextLine();
		System.out.print("Digite o ano (ex.2020) : ");
		year = filter.nextLine();
		System.out.println();
		System.out.println("Code    Description              Amount ");
		System.out.println("------------------------------------------");
		try {
			while (sValid.hasNextLine()) {
			if (start>0){
				sc = new Scanner(sfile).useDelimiter("\\;");		
			}
			category = sValid.nextLine();
			//System.out.println(category);
			
			String[] vectValid = category.split(";");
					
			category = vectValid[1];
			
				while (sc.hasNextLine()) {
					character = sc.nextLine();
					numberofcharacter = (character.length());
					String[] vect = character.split(";");
					combination = character.replace(";", "");
					combination = (combination.substring(combination.length() - 6, combination.length()));
					String sdata = month + year;
					if (vect[1].equals(category)) {
						if (combination.equals(sdata)) {
							price = vect[2];
							ReadFile readfile = new ReadFile(character);
							amount += Double.valueOf(price);
							System.out.println(readfile.getCharacter(numberofcharacter, 25, 10, 0, 0, soption,0.00,8));
						}
					}
				}
			start+=1;
			sc.close();
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.printf("Total de R$ : %.2f%n", amount);
		sc.close();
	}	

	public static void printWithDraw(File sfile, String soption) throws Exception {
		String character = null;
		String price = null;
		String month, year, combination;
		double amount = 0;
		int numberofcharacter = 0;
		int l = 0;
		int c = 0;
		Scanner filter = new Scanner(System.in);
		Scanner sc = new Scanner(sfile).useDelimiter("\\;");
		System.out.print("Digite o mes (ex.08) : ");
		month = filter.nextLine();
		System.out.print("Digite o ano (ex.2020) : ");
		year = filter.nextLine();
		System.out.println();
		System.out.println("Code    Data       Description             Amount ");
		System.out.println("--------------------------------------------------------------------");
		while (sc.hasNextLine()) {
			//l = sc.nextInt();
			//Starting function to remove line
			l+=1;
			character = sc.nextLine();
			numberofcharacter = (character.length());
			String[] vect = character.split(";");
			combination = character.replace(".", "");
			combination = combination.substring(8, 14);
			String sdata = month + year;

			if (combination.equals(sdata)) {
				price = vect[3];
				ReadFile readfile = new ReadFile(character);
				amount += Double.valueOf(price);
				System.out.println(readfile.getCharacter(numberofcharacter, 8, 10, 25, 10, soption,0.00,0));
				
			}

		}
		System.out.println("");
		System.out.println("----------------------------------");
		System.out.printf("Total de R$ : %.2f%n", amount);
		sc.close();
	}
	
	public static void printAnualPlan(File sfile, String soption) throws Exception {
		String character = null;
		int year = 0;
		int numberofcharacter = 0;
		int l = 0;
		int c = 0;
			
		Scanner sc = new Scanner(sfile).useDelimiter("\\;");
		Scanner filter = new Scanner(System.in);
		System.out.print("Digite o ano (ex.2020) : ");
		year = filter.nextInt();
		System.out.println();		
		//Header
		System.out.println("Description              Jan      Fev      Mar      Abr      Mai      Jun      Jul      Ago      Set      Out      Nov      Dez      Total     ");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		while (sc.hasNextLine()) {
			character = sc.nextLine();
			numberofcharacter = (character.length());
			String[] vect = character.split(";");
			ReadFile readfile = new ReadFile(character);
			System.out.println(readfile.getCharacter(numberofcharacter, 10, 25, 0, 0, soption,0.00,year));
			
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		//Result
		ReadFile readfile = new ReadFile("");
		System.out.println(readfile.getResultPlan(String.valueOf(year)));
	}
	
	public static void printAnualWithDraw(File sfile, String soption) throws Exception {
		String character = null;
		int year = 0;
		int numberofcharacter = 0;
		int l = 0;
		int c = 0;
			
		Scanner sc = new Scanner(sfile).useDelimiter("\\;");
		Scanner filter = new Scanner(System.in);
		System.out.print("Digite o ano (ex.2020) : ");
		year = filter.nextInt();
		System.out.println();		
		//Header
		System.out.println("Description              Jan      Fev      Mar      Abr      Mai      Jun      Jul      Ago      Set      Out      Nov      Dez      Total     ");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		while (sc.hasNextLine()) {
			character = sc.nextLine();
			numberofcharacter = (character.length());
			String[] vect = character.split(";");
			ReadFile readfile = new ReadFile(character);
			System.out.println(readfile.getCharacter(numberofcharacter, 10, 25, 0, 0, soption,0.00,year));
			
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		//Result
		ReadFile readfile = new ReadFile("");
		System.out.println(readfile.getResultPlan(String.valueOf(year)));
	}
}
