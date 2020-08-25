package entitites;

public class WithDraw implements Comparable<WithDraw> {

	private String parameter;
	private Double withdraw;

	public WithDraw(String parameter, Double withdraw) {
		this.parameter = parameter;
		this.withdraw = withdraw;
	}

	public String getParameter() {
		return parameter;
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
		return -parameter.compareTo(other.getParameter());
	}
	
	
}
