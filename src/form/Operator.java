package form;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import application.UI;
import entities.ReadFile;

public class Operator extends ReadFile {

	private boolean checkBkp;
	public Operator(String character) {
		super(character);
	}
	
	//Add record WithDraw
	public static void addCount () throws Exception {
		Scanner reg = new Scanner(System.in);
		//Form to add Record
		System.out.println("*********************************************");
		System.out.println("To be sure type record as example : <11.07.2020;Lazer;700.00>");
		System.out.println();
		System.out.print("Type here new record : ");
		
		String newreg = reg.nextLine();
		//Validate
		String[] vect = newreg.split(";");
		String sName = vect[1];		
		//Insert 
		//New ID
		String opFile = "C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Withdraw.txt";
		ReadFile readfile = new ReadFile("opFile");
		String id = readfile.GetIdReadFile(opFile, 5);
		int newId = Integer.valueOf(id)+1;
		id = String.valueOf(newId);
		id = readfile.spaceInZero(id, 5);
		System.out.println();		
		System.out.println("Success : " + id +";"+ newreg);
		System.out.print("Are you sure to create this new record right now : Y or N ?");
		String sResponse = reg.nextLine().toUpperCase();
		
		
		if (sResponse.equals("Y") && readfile.GetValidate(sName)) {
			//Insert new record
			addLineFile(opFile, id +";"+ newreg);			
			System.out.print("Record save as success !");
			System.out.println();
			
			System.out.println("Click ENTER to go back menu:");
			reg.nextLine();
			UI.menuPrincipal();			
		}
		if (!readfile.GetValidate(sName)) {
			System.out.println("Invalid category make sure the right name.");
			System.out.println();
			System.out.println("Click ENTER to go back menu:");
			reg.nextLine();
			UI.menuPrincipal();
		}
		else {
		UI.menuPrincipal();
		}
	}

	// Add record Plan
	public static void addCountPlan () throws Exception {
		Scanner reg = new Scanner(System.in);
		//Form to add Record
		System.out.println("*********************************************");
		System.out.println("To be sure type record as example : <Agua;60.00;12;2021>");
		System.out.println();
		System.out.print("Type here new record : ");
		
		String newreg = reg.nextLine();
		//Validate
		String[] vect = newreg.split(";");
		String sName = vect[0];

		//Insert 
		//New ID
		String opFile = "C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Plan.txt";
		ReadFile readfile = new ReadFile("opFile");	
		String id = readfile.GetIdReadFile(opFile, 5);
		int newId = Integer.valueOf(id)+1;
		id = String.valueOf(newId);
		id = readfile.spaceInZero(id, 5);
		System.out.println();		
		System.out.println("Success : " + id +";"+ newreg);
		System.out.print("Are you sure to create this new record right now : Y or N ?");
		String sResponse = reg.nextLine().toUpperCase();
		

		if (sResponse.equals("Y") && readfile.GetValidate(sName)) {
			//Insert new record
			addLineFile(opFile, id +";"+ newreg);			
			System.out.print("Record save as success !");
			System.out.println();
			
			System.out.println("Click ENTER to go back menu:");
			reg.nextLine();
			UI.menuPrincipal();			
		}
		if (!readfile.GetValidate(sName)) {
			System.out.println("Invalid category make sure the right name.");
			System.out.println();
			System.out.println("Click ENTER to go back menu:");
			reg.nextLine();
			UI.menuPrincipal();
		}
		else {
		UI.menuPrincipal();
		}
	}
	
	
	private static void addLineFile(String path, String information) {
		// to create out of TRUE after path
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			if (path != null) {
				bw.write(information);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//Delete WithDraw
	public static void deleteCount () throws Exception {
		Scanner reg = new Scanner(System.in);
		//Form to add Record
		System.out.println("*********************************************");
		System.out.println("To be sure record to be deleted type Code example : <00076>");
		System.out.println();
		System.out.print("Type here delete record code : ");
		
		//Validate
		
		//Delete
		//ID find
		String opFile = "C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Withdraw.txt";
		ReadFile readfile = new ReadFile("opFile");
		String deleteReg = reg.nextLine();
		deleteReg = readfile.spaceInZero(deleteReg, 5);

		System.out.println();		
		System.out.println("Success : " + deleteReg);
		System.out.print("Are you sure to delete this record right now : Y or N ?");
		String sResponse = reg.nextLine().toUpperCase();
		if (sResponse.equals("Y")) {
			//Change File new record
			//Prepare Bckp and delete files
			String fileOrigin = "C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\WithDraw.txt";
			String fileDeletePath = "C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\WithDraw_New.txt";
			
			File sFile = new File(fileDeletePath);
			File sFileDest = new File(fileOrigin);

			changeLine(opFile, deleteReg, fileDeletePath);						
			System.out.println();
			System.out.println("Click ENTER to go back menu:");
			if (performDelete(fileDeletePath, fileOrigin)) {
				System.out.print("Record deleted as success !");
			}			
			
			reg.nextLine();			
			sFile.renameTo(sFileDest);
			UI.menuPrincipal();			
		}
		else {
		UI.menuPrincipal();
		}
	}

	//Delete Plan
	public static void deletePlan() throws Exception {
		Scanner reg = new Scanner(System.in);
		//Form to add Record
		System.out.println("*********************************************");
		System.out.println("To be sure record to be deleted type Code example : <00076>");
		System.out.println();
		System.out.print("Type here delete record code : ");
		
		//Validate
		
		//Delete
		//ID find
		String opFile = "C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Plan.txt";
		ReadFile readfile = new ReadFile("opFile");
		String deleteReg = reg.nextLine();
		deleteReg = readfile.spaceInZero(deleteReg, 5);

		System.out.println();		
		System.out.println("Success : " + deleteReg);
		System.out.print("Are you sure to delete this record right now : Y or N ?");
		String sResponse = reg.nextLine().toUpperCase();
		if (sResponse.equals("Y")) {
			//Change File new record
			//Prepare Bckp and delete files
			String fileOrigin = "C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Plan.txt";
			String fileDeletePath = "C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\Plan_New.txt";
			
			File sFile = new File(fileDeletePath);
			File sFileDest = new File(fileOrigin);

			changeLine(opFile, deleteReg, fileDeletePath);						
			System.out.println();
			System.out.println("Click ENTER to go back menu:");
			if (performDelete(fileDeletePath, fileOrigin)) {
				System.out.print("Record deleted as success !");
			}
			reg.nextLine();			
			sFile.renameTo(sFileDest);
			UI.menuPrincipal();			
		}
		else {
		UI.menuPrincipal();
		}
	}

	
	private static void changeLine(String path, String deleteReg, String fileDeletePath) {
		File file = new File(path);
		PerformBckp();
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				//System.out.println(sc.nextLine());
					//str=sc.nextLine().substring(0, 5);				
					deleteLineFile(fileDeletePath, sc.nextLine(),deleteReg, 5);					
				
			}
			//System.out.println("FINISHED");
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
	
	private static void deleteLineFile(String path, String information, String deleteReg, int size) {
		// to create out of TRUE after path
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			//Treatment to dont add record delete on new file
			if (!information.substring(0, size).equals(deleteReg)) {		
				if (path != null) {
					bw.write(information);
					bw.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	public static void PerformBckp() {
	    File myObj = new File("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\WithDraw_New.txt"); 
	    File myOriginObj = new File("C:\\Backup_Douglas\\Biblioteca\\Eclipse\\Plan_Custos\\DB\\WithDraw.txt");
	    
	    if (myObj.delete()) { 
	    	//System.out.println("OK");
	    } else {
	    	//System.out.println("Failed");
	    } 
	
	}
	public static boolean performDelete(String sfileNew, String sfileOrign) {
	    File myObj = new File (sfileNew); 
	    File myOriginObj = new File (sfileOrign);
	    
	    if (myOriginObj.delete()) { 
	    	//
	    	return true;
	    }
	     
	return false;
	}
	
}