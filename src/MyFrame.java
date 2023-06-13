import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{

	JTextField textfield;
	JPanel panel;
	JButton[] functionButton = new JButton[9];
	JButton[] numberButton = new JButton[10];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	char operator;
	double num1, num2, result;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(375, 525);
		this.setTitle("Calculator");
		this.setLayout(null);
		this.setResizable(false);
		
		textfield = new JTextField();
		textfield.setBounds(28, 20, 300, 60);
		textfield.setFont(new Font("Ink Free", Font.BOLD, 30));
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("delete");
		clrButton = new JButton("clr scn");
		negButton = new JButton("(-)");
		
		functionButton[0] = addButton;
		functionButton[1] = subButton;
		functionButton[2] = mulButton;
		functionButton[3] = divButton;
		functionButton[4] = decButton;
		functionButton[5] = equButton;
		functionButton[6] = delButton;
		functionButton[7] = clrButton;
		functionButton[8] = negButton;
		
		for(int i = 0; i < 9; i++) {
			functionButton[i].addActionListener(this);
			functionButton[i].setFocusable(false);
			functionButton[i].setFont(new Font("Ink Free", Font.BOLD, 20));
		}
		
		for(int i = 0; i < 10; i++) {
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFocusable(false);
			numberButton[i].setFont(new Font("Ink Free", Font.BOLD, 20));
		}
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBounds(28, 100, 300, 300);
		
		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(addButton);
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(subButton);
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButton[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		delButton.setBounds(28, 425, 80, 50);
		clrButton.setBounds(138, 425, 80, 50);
		negButton.setBounds(248, 425, 80, 50);
		
		this.add(textfield);
		this.add(panel);
		this.add(delButton);
		this.add(clrButton);
		this.add(negButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource()==numberButton[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		if(e.getSource()==equButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			}
			
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length()-1; i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		
		if(e.getSource()==negButton) {
			Double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
			}
		}
	}
}
