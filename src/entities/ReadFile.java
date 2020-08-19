package entities;

import java.text.DecimalFormat;

public class ReadFile {

	private String character;

	public ReadFile(String character) {
		this.character = character;
	}

	public String getCharacter(int numberofcharacter, int i1, int i2, int i3, int i4, String soption, double svalue) {
		int initial = 0;
		int lfinal = 0;
		// return character;
		String[] vect = character.split(";");
		String word1 = spaceInBlank(vect[0],i1);
		String word2 = spaceInBlank(vect[1],i2);
		if (soption.equals("003")) {
			String word3 = spaceInBlank(vect[2],i3);	
			String word4 = spaceInBlank(vect[3],i4);
			return word1 + word2 + word3 + word4;
		}
		if (soption.equals("004")) {
			
			String strvalue = String.valueOf(svalue);
			strvalue = spaceInBlank(strvalue,10);
			
			double Account2 = Double.valueOf(word2)-svalue;
			
			DecimalFormat formato = new DecimalFormat ("#.##");
			Account2 = Double.valueOf(formato.format(Account2));
			return word1 + word2 + strvalue +  Account2;
		}		
		
		
		return word1 + word2;
		
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


	
	
}
