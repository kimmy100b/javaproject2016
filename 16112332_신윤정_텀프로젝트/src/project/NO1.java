package project;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//NO1�� ���� Ŭ���� ����, JFrame�� ����� ����
public class NO1 extends JFrame {
 Container contentPane;
 JPanel MyPanel;
  
  //�Ű����� ���� Ŭ���� ����
  NO1(){
  setTitle("16112332 ������");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� ������ ���� ����
  createMenu();
  setSize(700,700);
  setVisible(true);
 }

//�޴��� �����ϴ� �Լ�����
 void createMenu() {
  JMenuBar mb = new JMenuBar();//�޴��� ����
  
  JMenuItem [] drinkItem = new JMenuItem [1];//�޴� �������� �迭�� �̿��� 1�� ����
  String[] drinkItemTitle = {"1.Ŀ�����Ǳ�"};
  JMenu drinkMenu = new JMenu("���Ǳ�");//���Ǳ� �޴� ����

  //2���� �޴��������� "���Ǳ�" �޴��� ����
    for(int i=0;i<drinkItem.length;i++){
    	drinkItem[i]=new JMenuItem(drinkItemTitle[i]);//�޴������� ����
    	drinkItem[i].addActionListener(new firstactActionListener());//�޴� �������� Action ������ ���
	 	  
	  drinkMenu.add(drinkItem[i]);//�޴��������� "���Ǳ�"�� ����
  }
  mb.add(drinkMenu);//�޴��ٿ� "���Ǳ�"�޴� ����
  setJMenuBar(mb);//�����ӿ� �޴��ٸ� ����

  
  JMenuItem [] GameItem = new JMenuItem [3];//�޴� �������� �迭�� �̿��� 3�� ����
  String[] GameItemTitle = {"1.����bar���������","2.(0-4)�׺�����","3.(0-1)�׺�����"};
  JMenu GameMenu = new JMenu("����");//���� �޴� ����

  //3���� �޴��������� "����" �޴��� ����
    for(int i=0;i<GameItem.length;i++){
    	GameItem[i]=new JMenuItem(GameItemTitle[i]);//�޴������� ����
    	GameItem[i].addActionListener(new gameActionListener());//�޴� �������� Action ������ ���
	 	  
	  GameMenu.add(GameItem[i]);//�޴��������� "����"�� ����
  }
  mb.add(GameMenu);//�޴��ٿ� "����"�޴� ����
  setJMenuBar(mb);//�����ӿ� �޴��ٸ� ����
  
  
  JMenuItem [] CalItem = new JMenuItem [7];//�޴� �������� �迭�� �̿��Ͽ��� 7�� ����
String[] CalItemTitle = {"1.���ϱ�","2.����","3.���ϱ�","4.������","5.�簢��","6.��","7.����"};
JMenu CalMenu = new JMenu("���");//"���"�޴� ����

//7���� �޴��������� "���" �޴��� �����Ѵ�.
for(int i=0;i<CalItem.length;i++){
	 CalItem[i]=new JMenuItem(CalItemTitle[i]);// �޴������� ����
	  CalItem[i].addActionListener(new calActionListener());//�޴������ۿ�  Action ������ ���
	  if(i==3||i==6){  CalMenu.addSeparator();}//"���" �޴��� ����ִ� �����۳����� ���м� ����
	  CalMenu.add(CalItem[i]);// �޴��������� "���" �޴��� ����
}
mb.add(CalMenu); // �޴��ٿ� "���" �޴� ����
setJMenuBar(mb);// �����ӿ� �޴��ٸ� �����Ѵ�.
 }
 



 public static void main (String [] args) {
  new NO1();//���
 }
 
 
	  }

//�� â�� ���� "���Ǳ�" �޴��� ����ִ� �������� �����Ѵ�
class firstactActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
		 String cmd = e.getActionCommand();
		  if(cmd.equals("1.Ŀ�����Ǳ�"))
			    new Cafe();
		
		  	 
	  }
		 
	  }


//�� â�� ���� "����" �޴��� ����ִ� �������� �����Ѵ�
class gameActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
		 String cmd = e.getActionCommand();
		 if(cmd.equals("1.����bar���������"))
		 {}
		 else if(cmd.equals("2.(0-4)�׺�����"))
		  new Gambling();
		 else if(cmd.equals("3.(0-1)�׺�����"))
		  new SmallGambling();
	
		
		
	  }
		 
	  }

//�� â�� ���� "���" �޴��� ����ִ� �������� �����Ѵ�
class calActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
		 String cmd = e.getActionCommand();
		  if(cmd.equals("1.���ϱ�"))
		  new Addcal(); 
		  else if(cmd.equals("2.����"))
		  new Subcal();
		  else if(cmd.equals("3.���ϱ�"))
		  new Mulcal();
		  else if(cmd.equals("4.������"))
		  new Divcal(); 
		  else if(cmd.equals("5.�簢��"))
		  new Rectcal();
		  else if(cmd.equals("6.��"))
		  new Circlecal();
		  else if(cmd.equals("7.����"))
		  new calculator();
	  }
		 
	  }	 


	 

