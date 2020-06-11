package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyLabel extends JLabel {
	int barSize = 0; // 바의 크기
	int maxBarSize;
	
	MyLabel(int maxBarSize) { 
		this.maxBarSize = maxBarSize;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);//채울 때의 색깔
		int width = (int)(((double)(this.getWidth()))/maxBarSize*barSize);
		if(width==0) return; 
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized void fill() {//바를 채우는 것에 대한 함수
		if(barSize == maxBarSize) {
			try {
				long time2=System.currentTimeMillis();
               	String time=Long.toString((time2-time1)/1000);
 				new NewWindow("새창",time);
				wait(); 
			} catch (InterruptedException e) { return; }
		}
		barSize++;
		repaint(); // 바 다시 그리기
		notify(); 
	}
	
	synchronized void consume() {
		if(barSize == 0) {
			try {
				wait(); 
			} catch (InterruptedException e)
				 { return; }
		}
		barSize--;
		repaint(); // 바 다시 그리기
		notify(); 
	}	
}

class ConsumerThread extends Thread {
	MyLabel bar;
		
	ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}
	public void run() {
		while(true) {
			try {
				 long time1=System.currentTimeMillis();  
				
				sleep(200);
				bar.consume(); 
			} catch (InterruptedException e)
			 { return; }//예기치못한 상황이 발생하면 catch로 가서 리턴한다
		}
	}
}
public class TabAndThreadEx  extends JFrame {
		MyLabel bar = new MyLabel(100); 	
	
		
	TabAndThreadEx(String title) {
		super(title);
		
		//처음에 등장하는 바에 대한 크기,색깔,위치 등에 대한 정도
		Container c = getContentPane();
		c.setLayout(null);
		bar.setBackground(Color.YELLOW);
		bar.setLocation(20,  50);
		bar.setSize(300, 20); 
		c.add(bar);
		
		//아무키나 누르면 바가 채워진다
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				bar.fill(); 
			}
		});
		setSize(350,200);
		setVisible(true);
		
		c.requestFocus(); 
		ConsumerThread th = new 
			ConsumerThread(bar); 
		th.start(); // 스레드 시작
	}

	public static void main(String[] args) {
		new TabAndThreadEx("아무키나 빨리 눌러 바 채우기");
	}
}

//시간을 출력하는 새 창
class NewWindow extends JFrame{
	 JLabel label = new JLabel();
	 JButton okButton = new JButton("OK");//ok버튼 생성
	 public NewWindow(String title, String time) {
	  super(title);
	  setLayout(new FlowLayout());
	  //창에 나오는 문자
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


