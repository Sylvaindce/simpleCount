package simpleCount;

public class simpleCount {
	private static double nb1;
	private static double nb2;
	private static double result;
	private static String operator;
	private static String ScrnContent;

	public static void main(String[] args) {
		System.out.print("simpleCount");
		nb1 = -0;
		nb2 = -0;
		operator = "";
		Window calc = new Window();
	}

	public static void calcResult() {
		switch(simpleCount.getOp()) {
			case "+": System.out.print("Addition");
					  	simpleCount.setResult(simpleCount.getNb1() + simpleCount.getNb2());
					  	simpleCount.setNb1(simpleCount.getResult());
					  	simpleCount.setNb2(-0);
					  	simpleCount.setOp("");
					  	break;
			case "-": System.out.print("Soustraction");
			  			simpleCount.setResult(simpleCount.getNb1() - simpleCount.getNb2());
			  			simpleCount.setNb1(simpleCount.getResult());
			  			simpleCount.setNb2(-0);
			  			simpleCount.setOp("");
			  			break;
			case "/": System.out.print("Division");
			  			simpleCount.setResult(simpleCount.getNb1() / simpleCount.getNb2());
			  			simpleCount.setNb1(simpleCount.getResult());
			  			simpleCount.setNb2(-0);
			  			simpleCount.setOp("");
			  			break;
			case "X": System.out.print("Multiplication");
			  			simpleCount.setResult(simpleCount.getNb1() * simpleCount.getNb2());
			  			simpleCount.setNb1(simpleCount.getResult());
			  			simpleCount.setNb2(-0);
			  			simpleCount.setOp("");
			  			break;
			default: System.out.print("Other");
					 break;
		}
		Window.setScreen(Double.toString(simpleCount.getResult()));
	}
	public static void setResult(double nbr) {
		result = nbr;
	}
	public static double getResult() {
		return (result);
	}
	public static void setScrnContent(String content) {
		ScrnContent = content;
	}
	public static String getScrnContent() {
		return (ScrnContent);
	}
	public static double getNb1() {
		return (nb1);
	}
	public static double getNb2() {
		return (nb2);
	}
	public static void setNb1(double nb) {
		nb1 = nb;
	}
	public static void setNb2(double nb) {
		nb2 = nb;
	}

	public static String getOp() {
		return (operator);
	}
	public static void setOp(String op) {
		operator = op;
	}
}