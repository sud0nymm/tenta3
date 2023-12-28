package practicetentaex3;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame implements ActionListener {

	private JButton jb1, jb2, jb3, jb4, jb5;
	private JPanel jp1, jp2, jp3;
	private JTextField tf1, tf2;
	private JRadioButton jr1, jr2;
	private Calculator calc = new Calculator();
	
	public GUI() {
		
		Font f = new Font("SansSerif",Font.PLAIN, 25);
		
		//buttons
		jb1 = new JButton();
		jb2 = new JButton();
		jb3 = new JButton();
		jb4 = new JButton();
		jb5 = new JButton();
		
		jb1.setText("+");
		jb2.setText("-");
		jb3.setText("/");
		jb4.setText("*");
		jb5.setText("=");
		
		jb1.setFont(f);
		jb2.setFont(f);
		jb3.setFont(f);
		jb4.setFont(f);
		jb5.setFont(f);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		
		//radio buttons
		jr1 = new JRadioButton();
		jr2 = new JRadioButton();
		
		jr1.setText("Button");
		jr2.setText("Return");
		
		jr1.setFont(f);
		jr2.setFont(f);
		
		jr1.doClick();
		
		jr1.addActionListener(this);
		jr2.addActionListener(this);
		
		//text fields
		tf1 = new JTextField();
		tf2 = new JTextField();
		
		tf1.setFont(f);
		tf2.setFont(f);
		
		tf2.setEditable(false);
		tf1.addActionListener(this);
		
		//panels
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jp1.setLayout(new GridLayout(2,1));
		jp1.add(jr1);
		jp1.add(jr2);
		
		jp2.setLayout(new GridLayout(1,3));
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jp1);
		
		jp3.setLayout(new GridLayout(1,3));
		jp3.add(jb3);
		jp3.add(jb4);
		jp3.add(jb5);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(4,1));
		
		c.add(tf1);
		c.add(tf2);
		c.add(jp2);
		c.add(jp3);
		//c.setPreferredSize(new Dimension(350,400));
		
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String equation = tf1.getText();
		
		if (ae.getSource()==jb1) {
			equation = tf1.getText()+"+";
			tf1.setText(equation);
		}
		
		if (ae.getSource()==jb2) {
			equation = tf1.getText()+"-";
			tf1.setText(equation);
		}
		
		if (ae.getSource()==jb3) {
			equation = tf1.getText()+"/";
			tf1.setText(equation);
		}
	
		if (ae.getSource()==jb4) {
			equation = tf1.getText()+"*";
			tf1.setText(equation);
		}
		
		if (ae.getSource()==jb5 || ae.getSource()==tf1) {
			System.out.println(equation + " = " + Double.toString(calc.calculate(equation)));
			tf2.setText(equation + " = " + Double.toString(calc.calculate(equation)));
		}
		
		if (ae.getSource()==jr1) {
			
			if (jr2.isSelected()) {
				jr2.setSelected(false);
			}
		
			jb1.setEnabled(true);
			jb2.setEnabled(true);
			jb3.setEnabled(true);
			jb4.setEnabled(true);
			jb5.setEnabled(true);
			
		}

		if (ae.getSource()==jr2) {
	
			if (jr1.isSelected()) {
				jr1.setSelected(false);
			}
			
			jb1.setEnabled(false);
			jb2.setEnabled(false);
			jb3.setEnabled(false);
			jb4.setEnabled(false);
			jb5.setEnabled(false);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		GUI gooey = new GUI();
		
	}

}



