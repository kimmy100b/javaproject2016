package exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class startGame extends JFrame 
{
	Container contentPane;
    int ci = 0;
    JLabel[] jl = new JLabel[12];
    startGame() 
    {
        setTitle("3.���ӽ���");
             this.setLayout(null);
        setSize(350, 350);//�� âũ��
        setVisible(true);
        long time1=System.currentTimeMillis();//���� �����ϴ� �ð� ����
        for (int i = 0; i < jl.length; i++) 
        {
            jl[i] = new JLabel("" + (i+1) + "");
            jl[i].setSize(15, 15);
            //�������� ��ġ
            int x = (int) (Math.random() * 300);
            int y = (int) (Math.random() * 300);
            jl[i].setLocation(x, y);
            jl[i].addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked(MouseEvent e) //���콺�̺�Ʈ
                {
                	    System.out.println(ci);
                	  
                    JLabel la = (JLabel) e.getSource();
                    if ( ci < 13 &&la == jl[ci])
                    {
                        jl[ci].setVisible(false);
                        ci++;
                    }
                    if(ci > 12)
                    {
                  	  long time2=System.currentTimeMillis();//���ӳ����� �ð�
                  	String time=Long.toString((time2-time1)/1000);//�� �ɸ� �ð�
    				new NewWindow("��â",time);
    				ci = 0;
                    for(int i = 0; i < jl.length; i++)//1~12���� �����ֱ�
                    {
                        jl[i].setVisible(true);
                        int x = (int) (Math.random() * 250);
                        int y = (int) (Math.random() * 250);
                        jl[i].setLocation(x, y);
                    }
                    }
                }
            });
            add(jl[i]);
        }
    }

    public static void main(String[] args) 
    {
        new startGame();
        
    }
}

//��â���� �ɸ� �ð� �����ֱ�
class NewWindow extends JFrame{
	 JLabel label = new JLabel();
	 JButton okButton = new JButton("OK");//ok��ư ����
	 public NewWindow(String title, String time) {
	  super(title);//�θ�
	  setLayout(new FlowLayout());
	  Container c = getContentPane();
	        label.setText("�ɸ��ð�: " + time + "��");
	  c.add(label);
	  c.add(okButton);
	//ok��ư�� ������ â�� �����
	  okButton.addMouseListener(new MouseAdapter() {
	   public void mousePressed(MouseEvent e) {
	    setVisible(false);
	   }
	  });
	  setSize(300,200);
	  setVisible(true);
	 }
	}
