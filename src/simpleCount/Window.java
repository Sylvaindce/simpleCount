package simpleCount;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{
	private static JPanel items = new JPanel();
	private static JLabel screen = new JLabel();
	String[] op_butts_text = {"AC", "%", "/", "X", "-", "+", "sin", "cos", "tan", "x²", "√", "log", "exp", "="};
	JButton[] op_butts = new JButton[op_butts_text.length];
	String[] num_butts_text = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
	JButton[] num_butts = new JButton[num_butts_text.length];
	public Window(){
		//Init de la fenetre
		this.setTitle("simpleCount");
		this.setMinimumSize(new Dimension(550, 480));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//init des elements
		SetItem();
		
		//ajout des element a la fenetre
		this.setContentPane(items);
		this.setVisible(true);
	}
	public void SetItem(){
		items.setBackground(Color.DARK_GRAY);
		screen = new JLabel("0.");
		screen.setFont(new Font("Arial", Font.CENTER_BASELINE, 50));
		screen.setForeground(Color.BLACK);
		JPanel screenBack = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		screenBack.setBackground(Color.WHITE);
		screenBack.setPreferredSize(new Dimension(550, 85));
		screenBack.add(screen);
		items.add(screenBack);
		
		//Set Operator buttons
		JPanel Ops = new JPanel();
		Ops.setPreferredSize(new Dimension(550, 170));
		Ops.setBackground(Color.DARK_GRAY);		
		int i = 0;
		while (i != op_butts_text.length)
		{
			op_butts[i] = new JButton(op_butts_text[i]);
			op_butts[i].setPreferredSize(new Dimension(70, 70));
			op_butts[i].setForeground(Color.WHITE);
			op_butts[i].setBackground(new Color(210, 110, 0));
			op_butts[i].setOpaque(true);
			op_butts[i].setBorderPainted(false);
			op_butts[i].setFont(new Font("Arial", Font.BOLD, 14));
			switch (i) {
				case 0:
					op_butts[i].addActionListener(new Reset());
					break;
				case 6:
					op_butts[i].addActionListener(new sinnbr());
					break;
				case 7:
					op_butts[i].addActionListener(new cosnbr());
					break;
				case 8:
					op_butts[i].addActionListener(new tannbr());
					break;
				case 9:
					op_butts[i].addActionListener(new sqnbr());
					break;
				case 10:
					op_butts[i].addActionListener(new sqrnbr());
					break;
				case 11:
					op_butts[i].addActionListener(new lognbr());
					break;
				case 12:
					op_butts[i].addActionListener(new expnbr());
					break;
				case 13:
					op_butts[i].addActionListener(new Result());
					break;
				default:
					op_butts[i].addActionListener(new Operation());
					break;
			}
			/*if (i == 0)
				op_butts[i].addActionListener(new Reset());
			else if (i == 6)
				op_butts[i].addActionListener(new sinnbr());
			else if (i == 7)
				op_butts[i].addActionListener(new cosnbr());
			else if (i == 8)
				op_butts[i].addActionListener(new tannbr());
			else if (i == 9)
				op_butts[i].addActionListener(new sqnbr());
			else if (i == 10)
				op_butts[i].addActionListener(new sqrnbr());
			else if (i == 11)
				op_butts[i].addActionListener(new lognbr());
			else if (i == 12)
				op_butts[i].addActionListener(new expnbr());
			else if (i == 13)
				op_butts[i].addActionListener(new Result());		
			else
				op_butts[i].addActionListener(new Operation());*/
			Ops.add(op_butts[i]);
			i += 1;
		}
		items.add(Ops);

		//Set num buttons
		JPanel Nums = new JPanel();
		Nums.setPreferredSize(new Dimension(500, 160));
		Nums.setBackground(Color.DARK_GRAY);		
		i = 0;
		while (i != num_butts_text.length)
		{
			num_butts[i] = new JButton(num_butts_text[i]);
			num_butts[i].setPreferredSize(new Dimension(70, 70));
			num_butts[i].setForeground(Color.BLACK);
			num_butts[i].setBackground(Color.LIGHT_GRAY);
			num_butts[i].setOpaque(true);
			num_butts[i].setBorderPainted(false);
			num_butts[i].setFont(new Font("Arial", Font.BOLD, 17));
			num_butts[i].addActionListener(new AddNumber());
			Nums.add(num_butts[i]);
			i += 1;
		}
		items.add(Nums);
	}
	public static String getScreen() {
		return (screen.getText());
	}
	public static void setScreen(String arg) {
		String str;
		if (simpleCount.getScrnContent() != null)
			str = simpleCount.getScrnContent();
		else
			str = "";
		str = arg;
		simpleCount.setScrnContent(str);
		screen.setText(simpleCount.getScrnContent());
	}
}