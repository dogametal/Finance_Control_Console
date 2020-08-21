package entities;

import java.awt.geom.IllegalPathStateException;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ReadFile {

	private String character;

	public ReadFile(String character) {
		this.character = character;
	}

	public String getCharacter(int numberofcharacter, int i1, int i2, int i3, int i4, String soption, double svalue, int i5) {
		int initial = 0;
		int lfinal = 0;
		// return character;
		String[] vect = character.split(";");
		String word1 = null;
		String word2 = null;
		String word3 = null;	
		String word4 = null;
		String word5 = null;

		//Categories
		if (soption.equals("001")) {
			word1 = spaceInBlank(vect[0],i1);
			word2 = spaceInBlank(vect[1],i2);
			word3 = spaceInBlank(vect[2],i5); 
			return word1 + word2 + word3;
		}
		if (soption.equals("002")) {
			word1 = spaceInBlank(vect[1],i1);
			word2 = spaceInBlank(vect[2],i2);
			word5 =spaceInBlank(vect[0],i5);
			return word5 + word1 + word2;
		}
		
		if (soption.equals("003")) {
			word1 = spaceInBlank(vect[0],i1);
			word2 = spaceInBlank(vect[1],i2);
			word3 = spaceInBlank(vect[2],i3);	
			word4 = spaceInBlank(vect[3],i4);
			return word1 + word2 + word3 + word4;
		}
		if (soption.equals("004")) {
			word1 = spaceInBlank(vect[1],i1);
			word2 = spaceInBlank(vect[2],i2);			
			DecimalFormat formato = new DecimalFormat ("#.##");
			
			svalue = Double.valueOf(formato.format(svalue));
			
			String strvalue = String.valueOf(svalue);
			
			
			strvalue = spaceInBlank(strvalue,10);
			
			double Account2 = Double.valueOf(word2)-svalue;

			
			Account2 = Double.valueOf(formato.format(Account2));


			return word1 + word2 + strvalue +  Account2;
		}		
		
	
			//Anual
			if (soption.equals("005")) {
				word2 = spaceInBlank(vect[1],i2);
				
				//Running month to have information data
				String month;
				String year = String.valueOf(i5);
				double plan =0;
				word3 ="";
				int position = 8;
				
				for (int i = 1; i <= 12;i++) {
					if (i < 10) {
						month = "0" + String.valueOf(i);	
					}
					else {
						month = String.valueOf(i);
					}
					
					try {
					plan = getAnualPlan(vect[1]+month+year, "Plan");				
					}
					catch(RuntimeException e) {
						e.printStackTrace();
					}
					
					month = String.valueOf(plan);
					month = spaceInBlank(month, 9);
					
					//month = spaceInBlank(month + "-" + year, 9);
					
					word3 +=month;
					//plan +=plan;
					//word3 = String.valueOf(plan);
				}
				
				return word2 + word3;
		}
		
		return null;
		
	}


	public void setCharacter(String character) {
		this.character = character;
	}

	
	public String spaceInBlank(String sword, int space ) {
		int size = sword.length();
		int i = 1;
		int f = space - size;
		String blankspace = " ";
		
		for (i=1;i<f;i++) {
			blankspace = blankspace + " ";
		}
		return sword + blankspace;
	}

	public String spaceInZero(String sword, int space ) {
		int size = sword.length();
		int i = 1;
		int f = space - size;
		String blankspace = "0";
		
		for (i=1;i<f;i++) {
			blankspace = blankspace + "0";
		}
		return blankspace + sword;
	}	
	
	
	public String GetIdReadFile(String path, int size) {
		String id = null;
		File file = new File(path);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				id = sc.nextLine().substring(0, size);
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return id;
	}
	
	public boolean GetValidate(String sName) {
		File file = new File("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Categories.txt");
		String id = null;
		Scanner sc = null;
		int size = sName.length()+4;

		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {				
				id = sc.nextLine();				
				if (id.length()>=size) {				
					id = id.substring(4, size);					
					if (id.equals(sName)) {						
						return true;
					}					
				}
			}								
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return false;
	}	
	
	public double getAnualPlan(String parameter, String type) {
		File file = new File("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Plan.txt");
		String combination;
		String id = "";
		String[] vect;
		String find;
		String word1 = null;
		double plan = 0.0;
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {				
				id = sc.nextLine();				
				vect = id.split(";");			
				combination = id.replace(";", "");
				combination = vect[1]+(combination.substring(combination.length() - 6, combination.length()));
				if (combination.equals(parameter)) {
					plan+=Double.valueOf(vect[2]);
				}
				//System.out.println(parameter + " to " +combination);
				
				
			}						
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		sc.close();
		return plan;
	}	
}