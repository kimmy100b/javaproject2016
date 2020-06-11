package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyLabel extends JLabel {
	int barSize = 0; // ���� ũ��
	int maxBarSize;
	
	MyLabel(int maxBarSize) { 
		this.maxBarSize = maxBarSize;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);//ä�� ���� ����
		int width = (int)(((double)(this.getWidth()))/maxBarSize*barSize);
		if(width==0) return; 
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized void fill() {//�ٸ� ä��� �Ϳ� ���� �Լ�
		if(barSize == maxBarSize) {
			try {
				long time2=System.currentTimeMillis();
               	String time=Long.toString((time2-time1)/1000);
 				new NewWindow("��â",time);
				wait(); 
			} catch (InterruptedException e) { return; }
		}
		barSize++;
		repaint(); // �� �ٽ� �׸���
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
		repaint(); // �� �ٽ� �׸���
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
			 { return; }//����ġ���� ��Ȳ�� �߻��ϸ� catch�� ���� �����Ѵ�
		}
	}
}
public class TabAndThreadEx  extends JFrame {
		MyLabel bar = new MyLabel(100); 	
	
		
	TabAndThreadEx(String title) {
		super(title);
		
		//ó���� �����ϴ� �ٿ� ���� ũ��,����,��ġ � ���� ����
		Container c = getContentPane();
		c.setLayout(null);
		bar.setBackground(Color.YELLOW);
		bar.setLocation(20,  50);
		bar.setSize(300, 20); 
		c.add(bar);
		
		//�ƹ�Ű�� ������ �ٰ� ä������
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
		th.start(); // ������ ����
	}

	public static void main(String[] args) {
		new TabAndThreadEx("�ƹ�Ű�� ���� ���� �� ä���");
	}
}

//�ð��� ����ϴ� �� â
class NewWindow extends JFrame{
	 JLabel label = new JLabel();
	 JButton okButton = new JButton("OK");//ok��ư ����
	 public NewWindow(String title, String time) {
	  super(title);
	  setLayout(new FlowLayout());
	  //â�� ������ ����
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


