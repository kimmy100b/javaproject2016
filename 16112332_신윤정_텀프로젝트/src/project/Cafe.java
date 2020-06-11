package project;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;


class MyLabel extends JLabel {
 int MaxSize;
 int Max;
 int num;
 
 //�ʱ�ȭ�ϱ� ���ؼ� �Ű����� �ִ� ������
 MyLabel(int MaxSize){
  this.MaxSize = MaxSize;
    num=0;
 }

 
 //ĥ�ϱ� ���ؼ�
 protected void paintComponent(Graphics g) {
  
  super.paintComponent(g);
  g.setColor(Color.white);
  int height = (int)(((double)(this.getHeight()))/MaxSize*Max);
                                                      
  g.fillRect(0, 0, this.getWidth(), height);
  System.out.println(height);
  System.out.println(this.getHeight());
 }
 
 
}


public class Cafe extends JFrame {
 Container contentPane;
 JLabel title = new JLabel("Welcome, YoonjungCoffee", JLabel.CENTER);//���� ����� ����� ����
 String [] text = {"BlackCoffee","SugarCoffee","DabangCoffee", "Reset"};//�ؿ� ��ư ����
 JButton[] btn = new JButton[4];//������ ���� ��ư 4��
 JPanel coffeename = new JPanel();
 JPanel menu = new JPanel();
 JPanel coffee = new JPanel();
 MyLabel[] bar = new MyLabel[5];
 JLabel[] num = new JLabel[10];//����� �뷮
 String [] bar_name = {"Cup","Coffee","Water","Sugar", "Cream"};//����� �� ��� �տ� �ִ� ����
 String menuname;

 
 //�Ű����� ���� ������ ����
Cafe() {
   
  
  setTitle("Ŀ�� ���Ǳ�");
  //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  contentPane = getContentPane();
  contentPane.setLayout(new BorderLayout());
  
 
  coffeename.setBackground(Color.PINK);//ī�� ��� ��ȫ��
  coffeename.add(title);
  contentPane.add(coffeename, BorderLayout.NORTH);
  
  //�޴� �̸��� ��ư�� ���̰� �׼Ǹ����ʵ� �Բ� 
  for(int i=0;i<btn.length;i++){
   btn[i] = new JButton(text[i]);
   btn[i].setSize(100,50);
   btn[i].addActionListener(new MyActionListener());
   menu.add(btn[i]);
   
  }
  
  int width=60;
  Border border = BorderFactory.createLineBorder(Color.black, 1);
  
  //�ٿ� ���� ������ for�� �̿��Ͽ� 
  for(int i=0;i<bar.length;i++){

   bar[i] = new MyLabel(100);
   bar[i].setBorder(border);
   bar[i].setBackground(Color.LIGHT_GRAY);
   bar[i].setOpaque(true);
   bar[i].setLocation(width,50);
   
   num[i] = new JLabel(bar_name[i]);
  num[i].setSize(100,70);
   num[i].setLocation(width+40, 280);
   bar[i].setSize(100,254);
   width+=140;
   coffee.add(bar[i]);
   coffee.add(num[i]);
   
  }
  


  coffee.setLayout(null);
  
  //��ġ ����
  contentPane.add(menu, BorderLayout.SOUTH);
  contentPane.add(coffee, BorderLayout.CENTER);
  

  //â ������ ����
  setVisible(true);
  setSize(830, 500);
 }
 
 
 class MyActionListener implements ActionListener{
  
	 //Ŀ�ǰ� �ϼ��Ǹ� ������ ��Ʈ
  void message() {
   JOptionPane.showMessageDialog(null, "�ֹ��Ͻ� "+menuname+" ���Խ��ϴ�.\n ���ְ� �弼��.","Ŀ�� �ϼ�", JOptionPane.INFORMATION_MESSAGE);
  }
 
  
  public void actionPerformed(ActionEvent e) {

   JButton jb = (JButton)e.getSource();
   
   int message=0;
   
   //���¹�ư���� ��Ḧ �ٽ� ä�� ����
   if(jb.equals(btn[3])){
    bar[0].Max = 0; bar[0].num = 0;
    bar[1].Max= 0; bar[1].num = 0;
    bar[2].Max = 0; bar[2].num = 0;
    bar[3].Max = 0; bar[3].num = 0;
    bar[4].Max = 0; bar[4].num = 0;
  
    repaint();
    }
   
   
   //��ᰡ �ִ� �� ���� �� Ȯ���ϰ� ��ᰡ ������ ���â�߱� ��ᰡ ������ Ŀ�� ������
   for(int i=0;i<bar.length;i++){
    if(bar[i].num == 10) {
    	JOptionPane.showMessageDialog(null, "��ᰡ �����մϴ�!", "Ŀ�� ���Ǳ� ������", 
				JOptionPane.WARNING_MESSAGE); 
    
     message=1;
     
    }
    break;
   }
   
   //��ᰡ ���� ���
   if(message==0){
    
   //BlackCoffee �ֹ�
   if(jb.equals(btn[0])){
        
    bar[0].Max += 10; bar[0].num++;
    bar[1].Max += 10; bar[1].num++;
    bar[2].Max += 10; bar[2].num++;
    repaint();
    menuname="BlackCoffee";
    message();
    
    
     }
   
   //SugerCoffee �ֹ�
   else if(jb.equals(btn[1])){
    bar[0].Max += 10; bar[0].num++;
    bar[1].Max+= 10; bar[1].num++;
    bar[2].Max += 10; bar[2].num++;
    bar[3].Max += 10; bar[3].num++;
    repaint();
    
    menuname="SugerCoffee";
    message();
   }
   
   //Dabang Coffee �ֹ�
   else if(jb.equals(btn[2])){
    bar[0].Max += 10;  bar[0].num++;
    bar[1].Max += 10;  bar[1].num++;
    bar[2].Max += 10;  bar[2].num++;
    bar[3].Max += 10;  bar[3].num++;
    bar[4].Max += 10;  bar[4].num++;
    repaint();
    menuname="DabangCoffee";
      message();
    
   }
  }

  }
 }
 //���
 public static void main(String[] args) {
  
  new Cafe();
 }

}
 