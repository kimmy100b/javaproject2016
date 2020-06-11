package project;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//NO1로 메인 클래스 생성, JFrame에 상속을 받음
public class NO1 extends JFrame {
 Container contentPane;
 JPanel MyPanel;
  
  //매개변수 없는 클래스 생성
  NO1(){
  setTitle("16112332 신윤정");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을 닫으면 실행 종료
  createMenu();
  setSize(700,700);
  setVisible(true);
 }

//메뉴를 생성하는 함수구현
 void createMenu() {
  JMenuBar mb = new JMenuBar();//메뉴바 생성
  
  JMenuItem [] drinkItem = new JMenuItem [1];//메뉴 아이템을 배열을 이용해 1개 생성
  String[] drinkItemTitle = {"1.커피자판기"};
  JMenu drinkMenu = new JMenu("자판기");//자판기 메뉴 생성

  //2개의 메뉴아이템을 "자판기" 메뉴에 삽입
    for(int i=0;i<drinkItem.length;i++){
    	drinkItem[i]=new JMenuItem(drinkItemTitle[i]);//메뉴아이템 생성
    	drinkItem[i].addActionListener(new firstactActionListener());//메뉴 아이템을 Action 리스너 등록
	 	  
	  drinkMenu.add(drinkItem[i]);//메뉴아이템을 "자판기"에 삽입
  }
  mb.add(drinkMenu);//메뉴바에 "자판기"메뉴 삽입
  setJMenuBar(mb);//프레임에 메뉴바를 삽입

  
  JMenuItem [] GameItem = new JMenuItem [3];//메뉴 아이템을 배열을 이용해 3개 생성
  String[] GameItemTitle = {"1.빨리bar누르기게임","2.(0-4)겜블링게임","3.(0-1)겜블링게임"};
  JMenu GameMenu = new JMenu("게임");//게임 메뉴 생성

  //3개의 메뉴아이템을 "게임" 메뉴에 삽입
    for(int i=0;i<GameItem.length;i++){
    	GameItem[i]=new JMenuItem(GameItemTitle[i]);//메뉴아이템 생성
    	GameItem[i].addActionListener(new gameActionListener());//메뉴 아이템을 Action 리스너 등록
	 	  
	  GameMenu.add(GameItem[i]);//메뉴아이템을 "게임"에 삽입
  }
  mb.add(GameMenu);//메뉴바에 "게임"메뉴 삽입
  setJMenuBar(mb);//프레임에 메뉴바를 삽입
  
  
  JMenuItem [] CalItem = new JMenuItem [7];//메뉴 아이템을 배열을 이용하여서 7개 생성
String[] CalItemTitle = {"1.더하기","2.빼기","3.곱하기","4.나누기","5.사각형","6.원","7.계산기"};
JMenu CalMenu = new JMenu("계산");//"계산"메뉴 생성

//7개의 메뉴아이템을 "계산" 메뉴에 삽입한다.
for(int i=0;i<CalItem.length;i++){
	 CalItem[i]=new JMenuItem(CalItemTitle[i]);// 메뉴아이템 생성
	  CalItem[i].addActionListener(new calActionListener());//메뉴아이템에  Action 리스너 등록
	  if(i==3||i==6){  CalMenu.addSeparator();}//"계산" 메뉴에 들어있는 아이템끼리의 구분선 생성
	  CalMenu.add(CalItem[i]);// 메뉴아이템을 "계산" 메뉴에 삽입
}
mb.add(CalMenu); // 메뉴바에 "계산" 메뉴 삽입
setJMenuBar(mb);// 프레임에 메뉴바를 삽입한다.
 }
 



 public static void main (String [] args) {
  new NO1();//출력
 }
 
 
	  }

//새 창을 열어 "자판기" 메뉴에 들어있는 아이템을 실행한다
class firstactActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
		 String cmd = e.getActionCommand();
		  if(cmd.equals("1.커피자판기"))
			    new Cafe();
		
		  	 
	  }
		 
	  }


//새 창을 열어 "게임" 메뉴에 들어있는 아이템을 실행한다
class gameActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
		 String cmd = e.getActionCommand();
		 if(cmd.equals("1.빨리bar누르기게임"))
		 {}
		 else if(cmd.equals("2.(0-4)겜블링게임"))
		  new Gambling();
		 else if(cmd.equals("3.(0-1)겜블링게임"))
		  new SmallGambling();
	
		
		
	  }
		 
	  }

//새 창을 열어 "계산" 메뉴에 들어있는 아이템을 실행한다
class calActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
		 String cmd = e.getActionCommand();
		  if(cmd.equals("1.더하기"))
		  new Addcal(); 
		  else if(cmd.equals("2.빼기"))
		  new Subcal();
		  else if(cmd.equals("3.곱하기"))
		  new Mulcal();
		  else if(cmd.equals("4.나누기"))
		  new Divcal(); 
		  else if(cmd.equals("5.사각형"))
		  new Rectcal();
		  else if(cmd.equals("6.원"))
		  new Circlecal();
		  else if(cmd.equals("7.계산기"))
		  new calculator();
	  }
		 
	  }	 


	 

