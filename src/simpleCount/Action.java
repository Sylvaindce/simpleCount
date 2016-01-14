package simpleCount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class Operation implements ActionListener{
	public void actionPerformed(ActionEvent arg) {
		System.out.print("Operation");
		String str = ((JButton)arg.getSource()).getText();
		String exist = Window.getScreen();
		simpleCount.setOp(str);
		if (simpleCount.getNb1() == -0 && simpleCount.getNb2() == -0)
		{
			simpleCount.setNb1(Double.parseDouble(Window.getScreen()));				
			Window.setScreen(str);
		}
		//else if (simpleCount.getNb1() != 0 && simpleCount.getNb2() == -0)
		//{
			//System.out.print("ICI c'est PARIS");
			//System.out.print(exist);
			//Window.setScreen(str);
			//simpleCount.setNb2(Double.parseDouble(exist));
			//Result.calcResult();
			//Window.setScreen(Double.toString(simpleCount.getResult()));
		//}
		if (str == "%")
		{
			System.out.print("Pourcentage");
			simpleCount.setResult(simpleCount.getNb1() / 100);
			simpleCount.setNb1(simpleCount.getResult());
 			Window.setScreen(Double.toString(simpleCount.getNb1()));
		}
		else if (simpleCount.getNb1() != -0 && simpleCount.getNb2() == -0)
			Window.setScreen(str);
		//double tmp = Double.parseDouble("1234");
	}
}

class Reset implements ActionListener{
	public void actionPerformed(ActionEvent arg) {
		System.out.print("Reset");
		simpleCount.setScrnContent("");
		simpleCount.setOp("");
		simpleCount.setNb1(-0);
		simpleCount.setNb2(-0);
		simpleCount.setResult(-0);
		Window.setScreen("0.");
	}
}

class Result implements ActionListener{
	public void actionPerformed(ActionEvent arg) {
		System.out.print("Result");
		String str = ((JButton)arg.getSource()).getText();
		String nb2 = Window.getScreen();
		System.out.print("Le nombre 2 est :");
		System.out.print(nb2);
		System.out.print("Le nombre 1 est :");
		System.out.print(simpleCount.getNb1());
		if (simpleCount.getNb2() == -0)
			simpleCount.setNb2(Double.parseDouble(nb2.substring(1)));
		if (simpleCount.getNb1() != 0 && simpleCount.getNb2() != 0 && simpleCount.getOp() != "")
			simpleCount.calcResult();
		else if (simpleCount.getNb1() == 0 && simpleCount.getNb2() != 0 && simpleCount.getOp() != "")
			simpleCount.calcResult();
		else if (simpleCount.getNb2() == 0 && simpleCount.getNb1() != 0 && simpleCount.getOp() != "")
			simpleCount.calcResult();
		else if (simpleCount.getNb2() == 0 && simpleCount.getNb1() != 0)
			Window.setScreen(Double.toString(simpleCount.getNb1()));
		else if (simpleCount.getNb1() == 0 && simpleCount.getNb2() != 0)
			Window.setScreen(Double.toString(simpleCount.getNb2()));
		else
			Window.setScreen("0.");
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
		String res = Double.toString(simpleCount.getResult());
		if (res.length() > 8)
			res = res.substring(0, 8);
		Window.setScreen(res);
	}
}

class AddNumber implements ActionListener {
	public void actionPerformed(ActionEvent arg) {
		System.out.print("AddNumber");
		String num = ((JButton)arg.getSource()).getText();
		String exist = simpleCount.getScrnContent();
		System.out.print(exist);
		if (simpleCount.getScrnContent() == null || simpleCount.getScrnContent() == "0.") //&& simpleCount.getOp() != "")
		{
			Window.setScreen("");
			exist = "";
		}
		else
			exist = simpleCount.getScrnContent();
		exist = exist + num;
		Window.setScreen("");
		Window.setScreen(exist);
	}
}

class sinnbr implements ActionListener {
	public void actionPerformed(ActionEvent arg) {
		System.out.print("Sin");
		String num = simpleCount.getScrnContent();
		Double d;
		if (num != null)
			d = Math.sin(Math.toRadians(Double.parseDouble(num)));
		else
			d = 0.0;
		Window.setScreen("");
		num = Double.toString(d);
		if (num.length() > 5)
			num = num.substring(0, 8);
		Window.setScreen(num);
	}
}

class cosnbr implements ActionListener {
	public void actionPerformed(ActionEvent arg) {
		System.out.print("Cos");
		String num = simpleCount.getScrnContent();
		Double d;
		if (num != null)
			d = Math.cos(Math.toRadians(Double.parseDouble(num)));
		else
			d = 0.0;
		Window.setScreen("");
		num = Double.toString(d);
		if (num.length() > 5)
			num = num.substring(0, 8);
		Window.setScreen(num);
	}
}

class tannbr implements ActionListener {
	public void actionPerformed(ActionEvent arg) {
		System.out.print("tan");
		String num = simpleCount.getScrnContent();
		Double d;
		if (num != null)
			d = Math.tan(Math.toRadians(Double.parseDouble(num)));
		else
			d = 0.0;
		Window.setScreen("");
		num = Double.toString(d);
		if (num.length() > 8)
			num = num.substring(0, 8);
		Window.setScreen(num);
	}
}

class sqnbr implements ActionListener {
	public void actionPerformed(ActionEvent arg) {
		System.out.print("square");
		String num = simpleCount.getScrnContent();
		Double d;
		if (num != null)
			d = Double.parseDouble(num);
		else
			d = 0.0;
		d = d * d;
		Window.setScreen(Double.toString(d));
	}
}


class sqrnbr implements ActionListener {
	public void actionPerformed(ActionEvent arg) {
		System.out.print("square root");
		String num = simpleCount.getScrnContent();
		Double d;
		if (num != null)
			d = Math.sqrt(Double.parseDouble(num));
		else
			d = 0.0;
		num = Double.toString(d);
		if (num.length() > 8)
			num = num.substring(0, 8);
		Window.setScreen(num);
	}
}

class lognbr implements ActionListener {
	public void actionPerformed(ActionEvent arg) {
		System.out.print("log");
		String num = simpleCount.getScrnContent();
		Double d;
		if (num != null)
			d = Math.log(Double.parseDouble(num)) / Math.log(10);
		else
			d = 0.0;
		num = Double.toString(d);
		if (num.length() > 8)
			num = num.substring(0, 8);
		Window.setScreen(num);
	}
}

class expnbr implements ActionListener {
	public void actionPerformed(ActionEvent arg) {
		System.out.print("exp");
		String num = simpleCount.getScrnContent();
		Double d;
		if (num != null)
			d = Math.exp(Double.parseDouble(num));
		else
			d = 1.0;
		num = Double.toString(d);
		if (num.length() > 8)
			num = num.substring(0, 8);
		Window.setScreen(num);
	}
}
