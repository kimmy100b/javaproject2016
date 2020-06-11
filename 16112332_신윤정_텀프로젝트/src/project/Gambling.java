package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gambling extends JFrame {//JFrame���� ��ӹ��� �׺� ����
	//�Ű� ���� ���� ������ 
	Gambling() {
		super("0-4 �׺�");
		setContentPane(new GamePanel()); // GamePanel�� ����Ʈ������ ����Ѵ�. 

		setSize(550,300);//â ������
		setVisible(true);		
	}
	// ����Ʈ���� ���Ǵ� �г� Ŭ����
	class GamePanel extends JPanel {
		JLabel [] label = new JLabel [3]; // 3 ���� ���� ǥ���ϴ� ���̺� �迭
		JLabel result = new JLabel("���ӽ���"); // ����� ����ϴ� ���̺�
		GamblingThread thread = new GamblingThread(label, result); // ���� ������
			
		public GamePanel() {
			setLayout(null); // ��ġ�����ڸ� ������� �ʰ� ���� ��ġ�� ������Ʈ�� ��ġ�Ѵ�.
			
			// 3 ���� ���̺��� �����Ͽ� �����̳ʿ� �ܴ�.
			for(int i=0; i<label.length; i++) {
					   
			label[i] = new JLabel("0"); // ���̺� ����
				label[i].setSize(100, 50); // ���̺� ũ��
				label[i].setLocation(i*150+50, 50); // ���̺� ��ġ
				label[i].setHorizontalAlignment(JLabel.CENTER); // ���̺� ��µǴ� ���� ���͸�
				label[i].setOpaque(true); // ���̺� ���� ������ �����ϵ��� �Ѵ�.
				label[i].setBackground(Color.MAGENTA); // ���̺��� ������ �����Ѵ�.
				label[i].setForeground(Color.YELLOW); //���̺��� ���� ���� �����Ѵ�.				
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 40)); // ���̺� ������ ��Ʈ�� �����Ѵ�.	
				add(label[i]); // ���̺��� �����Ѵ�.
			}
			
			// ����� ����� ���̺��� �����ϰ� �����̳ʿ� �����Ѵ�.
			result.setHorizontalAlignment(JLabel.CENTER);
			result.setFont(new Font("", Font.BOLD, 30));
			result.setSize(300, 100);
			result.setLocation(120, 150);
			add(result);
			thread.start();
			
						
			// ���콺 �����ʸ� �����Ѵ�.
			addMouseListener(new MouseAdapter() { // MouseAdapter �̿�
				public void mousePressed(MouseEvent e) {
					if(thread.isReady()) // �����尡 ���� ���̸� �׳� ����
						thread.startGambling();
				}
			});
		}
	}
	
	class GamblingThread extends Thread {
		JLabel [] label; //���� ���ڸ� ����ϴ� ���̺�
		JLabel result; // ����� ����ϴ� ���̺�
		long delay = 200; // ���� �ð��� �ʱ갪 = 200
		boolean gambling = false; // ������ �� ������. �ʱ갪 = false
		
		public GamblingThread(JLabel [] label, JLabel result) {
			this.label = label;
			this.result = result;
		}
		
		boolean isReady() {
			return !gambling; // ���� ���̸� �غ���� �ʾ���
		}
		
		synchronized public void waitForGambling() {
			if(!gambling) // ���콺 Ŭ���� ���� gambling�� true�� �ƴϸ� ��ٸ�
				try {
					this.wait();
				} catch (InterruptedException e) { return; }
		}
		
		synchronized public void startGambling() {
			gambling = true; // ���콺 Ŭ������ �����尡 ������ �����ϵ��� ����
			this.notify(); // ��ٸ��� �����带 ����
		}		
		
		public void run() {
			while(true) {
				waitForGambling(); // ���콺 Ŭ���� ���� ���� ���� ���ø� ��ٸ�
				try {
					int x1 = (int)(Math.random()*5); // 0~4������ ������
					int x2 = (int)(Math.random()*5); // 0~4������ ������
					int x3 = (int)(Math.random()*5); // 0~4������ ������
					
					// ù��° �� ����
					label[0].setForeground(Color.pink); // ���ڰ� �ٲ�� ���� ����ȭ�ϱ� ����
					sleep(delay);
					label[0].setForeground(Color.white);
					label[0].setText(Integer.toString(x1));
					
					// �ι�° �� ����					
					label[1].setForeground(Color.pink); // ���ڰ� �ٲ�� ���� ����ȭ�ϱ� ����
					sleep(delay);
					label[1].setForeground(Color.white);					
					label[1].setText(Integer.toString(x2));
					
					// ����° �� ����
					label[2].setForeground(Color.pink); // ���ڰ� �ٲ�� ���� ����ȭ�ϱ� ����
					sleep(delay);
					label[2].setForeground(Color.white);					
					label[2].setText(Integer.toString(x3));	
					
					// ������ �����Ͽ����� �Ǻ�
					if(x1 == x2 && x2 == x3)
						result.setText("�����մϴ�!!");
					else 
						result.setText("�ƽ�����");
					gambling = false; // ���� ���� ������ �����ϵ��� ����
				} catch (InterruptedException e) { return; }
			}
		}	
	}
	
	public static void main(String[] args) {
		new Gambling();//���
	}
}