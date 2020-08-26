package entities;

public class WithDraw implements Comparable<WithDraw> {

	private String parameter;
	private String character;
	private Double withdraw;

	public WithDraw(String parameter, String character, Double withdraw) {
		this.parameter = parameter;
		this.withdraw = withdraw;
		this.character = character;
	}

	public String getParameter() {
		
		return parameter;
	}

	public String getCharacter() {
		return character;
	}

	
	public void setCharacter(String character) {
		this.character = character;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public Double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Double withdraw) {
		this.withdraw = withdraw;
	}

	

	@Override
	public int compareTo(WithDraw other) {
		//Decrescente Order signal -
		//return -parameter.compareTo(other.getParameter());
		//Crescente
		return parameter.compareTo(other.getParameter());
		
		
	}
	
	
}
