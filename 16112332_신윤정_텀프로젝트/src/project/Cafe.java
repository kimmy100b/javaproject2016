package project;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;


class MyLabel extends JLabel {
 int MaxSize;
 int Max;
 int num;
 
 //초기화하기 위해서 매개변수 있는 생성자
 MyLabel(int MaxSize){
  this.MaxSize = MaxSize;
    num=0;
 }

 
 //칠하기 위해서
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
 JLabel title = new JLabel("Welcome, YoonjungCoffee", JLabel.CENTER);//라벨을 만들고 가운데에 문구
 String [] text = {"BlackCoffee","SugarCoffee","DabangCoffee", "Reset"};//밑에 버튼 문구
 JButton[] btn = new JButton[4];//문구를 넣을 버튼 4개
 JPanel coffeename = new JPanel();
 JPanel menu = new JPanel();
 JPanel coffee = new JPanel();
 MyLabel[] bar = new MyLabel[5];
 JLabel[] num = new JLabel[10];//재료의 용량
 String [] bar_name = {"Cup","Coffee","Water","Sugar", "Cream"};//막대기 즉 재료 앞에 있는 재료명
 String menuname;

 
 //매개변수 없는 생성자 생성
Cafe() {
   
  
  setTitle("커피 자판기");
  //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  contentPane = getContentPane();
  contentPane.setLayout(new BorderLayout());
  
 
  coffeename.setBackground(Color.PINK);//카페 배경 분홍색
  coffeename.add(title);
  contentPane.add(coffeename, BorderLayout.NORTH);
  
  //메뉴 이름을 버튼에 붙이고 액션리스너도 함께 
  for(int i=0;i<btn.length;i++){
   btn[i] = new JButton(text[i]);
   btn[i].setSize(100,50);
   btn[i].addActionListener(new MyActionListener());
   menu.add(btn[i]);
   
  }
  
  int width=60;
  Border border = BorderFactory.createLineBorder(Color.black, 1);
  
  //바에 대한 정보를 for을 이용하여 
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
  
  //위치 설정
  contentPane.add(menu, BorderLayout.SOUTH);
  contentPane.add(coffee, BorderLayout.CENTER);
  

  //창 사이즈 설정
  setVisible(true);
  setSize(830, 500);
 }
 
 
 class MyActionListener implements ActionListener{
  
	 //커피가 완성되면 나오는 멘트
  void message() {
   JOptionPane.showMessageDialog(null, "주문하신 "+menuname+" 나왔습니다.\n 맛있게 드세요.","커피 완성", JOptionPane.INFORMATION_MESSAGE);
  }
 
  
  public void actionPerformed(ActionEvent e) {

   JButton jb = (JButton)e.getSource();
   
   int message=0;
   
   //리셋버튼으로 재료를 다시 채워 넣음
   if(jb.equals(btn[3])){
    bar[0].Max = 0; bar[0].num = 0;
    bar[1].Max= 0; bar[1].num = 0;
    bar[2].Max = 0; bar[2].num = 0;
    bar[3].Max = 0; bar[3].num = 0;
    bar[4].Max = 0; bar[4].num = 0;
  
    repaint();
    }
   
   
   //재료가 있는 지 없는 지 확인하고 재료가 없으면 경고창뜨기 재료가 있으면 커피 나가기
   for(int i=0;i<bar.length;i++){
    if(bar[i].num == 10) {
    	JOptionPane.showMessageDialog(null, "재료가 부족합니다!", "커피 자판기 재료부족", 
				JOptionPane.WARNING_MESSAGE); 
    
     message=1;
     
    }
    break;
   }
   
   //재료가 있을 경우
   if(message==0){
    
   //BlackCoffee 주문
   if(jb.equals(btn[0])){
        
    bar[0].Max += 10; bar[0].num++;
    bar[1].Max += 10; bar[1].num++;
    bar[2].Max += 10; bar[2].num++;
    repaint();
    menuname="BlackCoffee";
    message();
    
    
     }
   
   //SugerCoffee 주문
   else if(jb.equals(btn[1])){
    bar[0].Max += 10; bar[0].num++;
    bar[1].Max+= 10; bar[1].num++;
    bar[2].Max += 10; bar[2].num++;
    bar[3].Max += 10; bar[3].num++;
    repaint();
    
    menuname="SugerCoffee";
    message();
   }
   
   //Dabang Coffee 주문
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
 //출력
 public static void main(String[] args) {
  
  new Cafe();
 }

}
 