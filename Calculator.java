import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField text;
    JButton[] numButtons = new JButton[10];
    JButton add, sub, mul, div, eq, clr;

    double num1 = 0, num2 = 0;
    char operator;

    Calculator() {

        frame = new JFrame("Java Calculator");
        frame.setSize(300,400);
        frame.setLayout(null);

        text = new JTextField();
        text.setBounds(20,20,250,40);
        frame.add(text);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        eq  = new JButton("=");
        clr = new JButton("C");

        JButton[] ops = {add,sub,mul,div,eq,clr};

        for(JButton b: ops){
            b.addActionListener(this);
        }

        int x=20,y=80;

        for(int i=0;i<10;i++){
            numButtons[i]=new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
        }

        for(int i=1;i<=9;i++){
            numButtons[i].setBounds(x,y,50,40);
            frame.add(numButtons[i]);
            x+=60;
            if(i%3==0){
                x=20;
                y+=50;
            }
        }

        numButtons[0].setBounds(20,y,50,40);

        add.setBounds(200,80,50,40);
        sub.setBounds(200,130,50,40);
        mul.setBounds(200,180,50,40);
        div.setBounds(200,230,50,40);
        eq.setBounds(200,280,50,40);
        clr.setBounds(20,280,170,40);

        frame.add(numButtons[0]);
        frame.add(add);
        frame.add(sub);
        frame.add(mul);
        frame.add(div);
        frame.add(eq);
        frame.add(clr);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        for(int i=0;i<10;i++){
            if(e.getSource()==numButtons[i]){
                text.setText(text.getText()+i);
            }
        }

        if(e.getSource()==add){
            num1=Double.parseDouble(text.getText());
            operator='+';
            text.setText("");
        }

        if(e.getSource()==sub){
            num1=Double.parseDouble(text.getText());
            operator='-';
            text.setText("");
        }

        if(e.getSource()==mul){
            num1=Double.parseDouble(text.getText());
            operator='*';
            text.setText("");
        }

        if(e.getSource()==div){
            num1=Double.parseDouble(text.getText());
            operator='/';
            text.setText("");
        }

        if(e.getSource()==eq){
            num2=Double.parseDouble(text.getText());

            switch(operator){
                case '+': text.setText(""+(num1+num2)); break;
                case '-': text.setText(""+(num1-num2)); break;
                case '*': text.setText(""+(num1*num2)); break;
                case '/': text.setText(""+(num1/num2)); break;
            }
        }

        if(e.getSource()==clr){
            text.setText("");
        }
    }

    public static void main(String[] args){
        new Calculator();
    }
}
