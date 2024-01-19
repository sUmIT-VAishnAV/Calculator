import java.awt.*;
import javax.script.*;
import javax.swing.*;
import java.awt.event.*;
class FDemo extends JFrame implements ActionListener
{
    JTextField tx1;
    JButton B[] = new JButton[20];
    int k=0;
    int x,y,width,height;
    int r=0,g=0,b=0;
    String arr[] = {
        "B","C","1/x","sqrt",
        "7","8","9","/",
        "4","5","6","*",
        "1","2","3","-",
        "0",".","=","+"
    };
    FDemo()
    {
        x=0;
        y=100;
        width=100;
        height=100;

        setLayout(null);

        Font f = new Font("",Font.BOLD,30);
        setFont(f);        
        tx1 = new JTextField();
        tx1.setBounds(0,0,401,100);
        add(tx1);
        tx1.setFont(f);
        tx1.setHorizontalAlignment(JTextField.RIGHT);
        for(int i=1;i<=5;i++)
        {
            for(int j=1;j<=4;j++)
            {
                B[k] = new JButton(arr[k]);
                B[k].setBounds(x,y,width,height);
                B[k].setFont(f);
                B[k].addActionListener(this);
                add(B[k]);
                k++;
                x=x+100;
            }
            x=0;
            y=y+100;
        }

        setResizable(false);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==B[0])
        {
            String s1 = tx1.getText();
            tx1.setText(s1.substring(0,s1.length()-1));
        }
        else if(e.getSource()==B[1])
        {
            tx1.setText(" ");
        }
        else if(e.getSource()==B[2])
        {
            String s2 = tx1.getText();
            double a = Double.parseDouble(s2);
            a=1/a;
            tx1.setText(""+a);
        }
        else if(e.getSource()==B[3])
        {
            
            String s3 = tx1.getText();
            double a = Double.parseDouble(s3);
            tx1.setText(""+Math.sqrt(a));
        }
        else if(e.getSource()==B[18])
        {
            String s4 = tx1.getText();
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine se = sem.getEngineByName("js");
            try
            {
                tx1.setText(" "+se.eval(s4));
            }
            catch(Exception e1){}
        }
        else
        {

            JButton b = (JButton)e.getSource();
            String s1 = tx1.getText()+b.getLabel();
            tx1.setText(s1);
        }
    }
}
class Calculator
{
    public static void main(String args[])
    {

        FDemo f1 = new FDemo();
        f1.setTitle("Calulator");
        f1.setVisible(true);
        f1.setBounds(200,10,416,640);
        f1.setDefaultCloseOperation(FDemo.EXIT_ON_CLOSE);
    }
}