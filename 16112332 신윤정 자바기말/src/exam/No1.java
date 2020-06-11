package exam;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;//파일을 불러오기 위해서

public class No1 extends JFrame {//메뉴를  만드는 클래스명 No1
 Container contentPane;
 JLabel imageLabel = new JLabel();//이미지 파일
 JPanel MyPanel;

  
  
 No1(){//클래스의 생성자 생성
  setTitle("16112332 신윤정");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을 종료하면 프로그램이 종료
  createMenu();//창의 메뉴를 만드는 함수
  setSize(700,700);//창의 사이즈
  setVisible(true);
 }


 void createMenu() {
  JMenuBar mb = new JMenuBar();
  
  //메뉴첫번제
  JMenu firstMenu = new JMenu("1번문제");
  	JMenuItem mi=new JMenuItem("실행");
	firstMenu.add(mi);
	 mb.add(firstMenu);
	setJMenuBar(mb);
	mi.addActionListener(new MenuActionListener());
  
  	//메뉴두번째
    JMenuItem [] menuItem = new JMenuItem [4];
    String[] itemTitle = {"New","Open","Save","SaveAs"};
    JMenu memoMenu = new JMenu("2-1번");
    for(int i=0;i<menuItem.length;i++){
  	  menuItem[i]=new JMenuItem(itemTitle[i]);
  	  menuItem[i].addActionListener(new noteActionListener());
  	  
  	  if(i==2){ memoMenu.addSeparator();}
  	  
  	  memoMenu.add(menuItem[i]);
    }
    mb.add(memoMenu);
    setJMenuBar(mb);
 
  //메뉴 세번째
    JMenuItem [] menuItem2 = new JMenuItem [7];//배열을 이용해서 메뉴아이템을 만들었다
    String[] itemTitle2 = {"Color","Line","Rect","Oval","RndRect","Text","FreeLine"};
    JMenu Menu2 = new JMenu("2-2번");
    
    //파일 여는 프로그램
    JMenuItem openItem = new JMenuItem("Open");
    setContentPane(new MyPanel());
    
	openItem.addActionListener(new OpenActionListener());	
	Menu2.add(openItem);
		mb.add(Menu2);
	setJMenuBar(mb);	
	 Menu2.addSeparator();//구분선
	
      for(int i=0;i<menuItem2.length;i++){
  	  menuItem2[i]=new JMenuItem(itemTitle2[i]);
  	  menuItem2[i].addActionListener(new drawActionListener());
  	  
  	  if(i==1){  Menu2.addSeparator();}//if의 조건이 성립하면 구분선을 넣는다
  	    	  Menu2.add(menuItem2[i]);
    }
    mb.add(Menu2);
    setJMenuBar(mb);
    
 
  
//메뉴 네번쨰
   JMenuItem [] menuItem3 = new JMenuItem [4];
  String[] itemTitle3 = {"3.게임시작","4.계산기","5.도형그리기","6.자바란?"};
  JMenu Menu3 = new JMenu("3,4,5,6번문제");
  for(int i=0;i<menuItem3.length;i++){
	  menuItem3[i]=new JMenuItem(itemTitle3[i]);
	  menuItem3[i].addActionListener(new MenuActionListener());
	  
	  Menu3.add(menuItem3[i]);
  }
  mb.add(Menu3);
  setJMenuBar(mb);
 
    
 }
 //Open 메뉴 아이템이 선택되면 호출되는 action리스너
 class OpenActionListener implements ActionListener {
		JFileChooser chooser;
		OpenActionListener() {
			chooser= new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			 FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG Images", "jpg");
		    chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", 
							"경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			MyPanel p = (MyPanel)getContentPane();
			ImageIcon icon = new ImageIcon(filePath);
			p.setBgImage(icon.getImage());
		}
	}

	class MyPanel extends JPanel {
		private Image bgImg = null;
		
		public void setBgImage(Image bgImg) {
			this.bgImg = bgImg;
			repaint();
		}
		public void paintComponent(Graphics g) {
			if(bgImg == null) // initially bgImg is null
				return;
			g.drawImage(bgImg, 0,0,this.getWidth(), this.getHeight(), this);
		}
	}
	
 
 //두번째 메뉴는 새창을 만들지 않기 때문에 그 사리에서 실행시킨다
 class drawActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	  String cmd = e.getActionCommand();
	  	  if(cmd.equals("Color"))
	   { new MenuAndColorChooserEx();}
	  else if(cmd.equals("Line"))
	   {Line();  }
	  else if(cmd.equals("Rect"))
		   {Rect();} 
	  else if(cmd.equals("Oval"))
	  {Oval();} 
	  else if(cmd.equals("RndRect"))
	  {RndRect();} 
	  else if(cmd.equals("Text"))
	  {new Text();}//Text클래스 새 창으로 블로옴
	  	  
	  else if(cmd.equals("FreeLine"))
	  {new GraphicsDraw();}  //클래스를 새창으로 불러옴
	 }
	
}	
 

 
void Line(){//선만드는 함수
		
		 setTitle("Line 그리기");
			contentPane = getContentPane();
			MyPanel1 p = new MyPanel1();
			contentPane.add(p, BorderLayout.CENTER);
		
			setContentPane(p);
			validate();
		
			} 

class MyPanel1 extends JPanel {
	public void paintComponent(Graphics a) {
		super.paintComponent(a);
		a.setColor(Color.BLACK);
		a.drawLine(40,40, 400, 400);
	}
}

void Rect(){//사각형만드는 함수
	
	 setTitle("Rect 그리기");
		contentPane = getContentPane();
		MyPanel2 p = new MyPanel2();
		contentPane.add(p, BorderLayout.CENTER);
		setContentPane(p);
		validate();
	
		} 

class MyPanel2 extends JPanel {
	public void paintComponent(Graphics b) {
		super.paintComponent(b);
		b.setColor(Color.BLACK);
		b.drawRect(40,40, 400, 400);
	}
}

void Oval(){//동그라미 만드는 함수
	
	 setTitle("Oval 그리기");
		contentPane = getContentPane();
		MyPanel3 p = new MyPanel3();
		contentPane.add(p, BorderLayout.CENTER);
		setContentPane(p);
		validate();
		} 

class MyPanel3 extends JPanel {
	public void paintComponent(Graphics c) {
		super.paintComponent(c);
		c.setColor(Color.BLACK);
		c.drawOval(40,40, 400, 400);
	}
}

void RndRect(){//모서리가 둥근 사각형 만드는 함수
	
	 setTitle("RndRect 그리기");
		contentPane = getContentPane();
		MyPanel4 p = new MyPanel4();
		contentPane.add(p, BorderLayout.CENTER);
		setContentPane(p);
		validate();
	
		} 

class MyPanel4 extends JPanel {
	public void paintComponent(Graphics d) {
		super.paintComponent(d);
		d.setColor(Color.BLACK);
		d.drawRoundRect (120,120,500,300,300,150);
	}
}

	 //MenuActionListner를 사용한 메뉴아이템들에 대한 실행내용
class MenuActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	  String cmd = e.getActionCommand();
	  if(cmd.equals("실행"))
		   Play();//한 화면에 보이도록 출력

	  	  if(cmd.equals("3.게임시작"))
		    new startGame();//새창으로 실행
	 if(cmd.equals("4.계산기"))
		    new calculator();//새창으로 실행
	   if(cmd.equals("5.도형그리기"))
	   new draw();//새창으로 실행
	  if(cmd.equals("6.자바란?"))
		   new JavaEx();//새창으로 실행
	 }
	
}

//문제 1-5 한 화면에 나의 정보 정리하여 보이도록 하는 함수
void Play() {
	
	setTitle("1-1번문제 실행");
	Container c = getContentPane();
	GridLayout grid = new GridLayout(10, 5);//10x5 그리드의 GridLayout 배치관리자 생성
	grid.setVgap(5);//그리드 사이의 수직 간ㄱㄱ을 5 픽셀로 설정
	c.setLayout(grid);//grid를 컨첸트팬의 배치관리자로 지정


	c.add(new JLabel("이름 : "));
	c.add(new JTextField("신윤정"));
	c.add(new JLabel("학번: "));
	c.add(new JTextField("16112332"));
	c.add(new JLabel("학과 : "));
	c.add(new JTextField("컴퓨터공학과"));
	c.add(new JLabel("장래희망: "));
	c.add(new JTextField("프로그래머"));	
	c.add(new JLabel("여름방학 계획 : "));
	c.add(new JTextField("내일로 여행가기, 토익공부하기, 프로그래밍 공부하기"));
	c.add(new JLabel("다음학기 계획 : "));
	c.add(new JTextField("봉사시간 5시간 채우기, 20학점 듣기 "));
	c.add(new JLabel("좌우명 : "));
	c.add(new JTextField("헛되게 살지말자"));
	c.add(new JLabel("내 인생의 멘토 : "));
	c.add(new JTextField("김미혜교수님"));
	
	setSize(800,700);//새 창의 사이즈
	setVisible(true);
}


   

 public static void main (String [] args) {
  new No1();//함수 실행
 }
 
}

 
 //2-1번문제 밑에 있는 메뉴아이템들을 클릭했을 때의 실행 
 class noteActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
		 String cmd = e.getActionCommand();
		 if(cmd.equals("New"))
		   { }
		  else if(cmd.equals("Open"))
		   {  }
		  else if(cmd.equals("Save"))
			   {} 
		  else if(cmd.equals("SaveAs"))
		  {} 
		  
	  }
		 
	  }


	 


