package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UI {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}	

	public static void menuPrincipal () {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		String soption;
		
		List<String> list = new ArrayList<>();
		list.add("001 - Categorias");
		list.add("002 - Planejamento Mensal");
		list.add("003 - Gastos diarios");
		list.add("004 - Custos Vs Planejamento Mensal");
		// list.add(2,"00 - Custos Vs Planejamento Mensal");
		try {
			System.out.println("Escolha uma das opcoes abaixo : ");
			System.out.println("----------------------------------");
			for (String x : list) {
				System.out.println(x);
			}
			System.out.println();
			System.out.print("Digite a opcao : ");
			soption = scan.nextLine();
			loopMenu(soption);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("Error : " + e.getMessage());
		}
	}
	
	public static void loopMenu (String sc) {
		clearScreen();
		menuPrincipal();
	}
}
