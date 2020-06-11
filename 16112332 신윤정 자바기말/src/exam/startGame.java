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
        setTitle("3.게임시작");
             this.setLayout(null);
        setSize(350, 350);//새 창크기
        setVisible(true);
        long time1=System.currentTimeMillis();//게임 시작하는 시간 측정
        for (int i = 0; i < jl.length; i++) 
        {
            jl[i] = new JLabel("" + (i+1) + "");
            jl[i].setSize(15, 15);
            //랜덤으로 위치
            int x = (int) (Math.random() * 300);
            int y = (int) (Math.random() * 300);
            jl[i].setLocation(x, y);
            jl[i].addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked(MouseEvent e) //마우스이벤트
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
                  	  long time2=System.currentTimeMillis();//게임끝나는 시간
                  	String time=Long.toString((time2-time1)/1000);//총 걸린 시간
    				new NewWindow("새창",time);
    				ci = 0;
                    for(int i = 0; i < jl.length; i++)//1~12까지 보여주기
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

//새창으로 걸린 시간 보여주기
class NewWindow extends JFrame{
	 JLabel label = new JLabel();
	 JButton okButton = new JButton("OK");//ok버튼 생성
	 public NewWindow(String title, String time) {
	  super(title);//부모
	  setLayout(new FlowLayout());
	  Container c = getContentPane();
	        label.setText("걸린시간: " + time + "초");
	  c.add(label);
	  c.add(okButton);
	//ok버튼을 누르면 창이 사라짐
	  okButton.addMouseListener(new MouseAdapter() {
	   public void mousePressed(MouseEvent e) {
	    setVisible(false);
	   }
	  });
	  setSize(300,200);
	  setVisible(true);
	 }
	}
