package exam;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;//������ �ҷ����� ���ؼ�

public class No1 extends JFrame {//�޴���  ����� Ŭ������ No1
 Container contentPane;
 JLabel imageLabel = new JLabel();//�̹��� ����
 JPanel MyPanel;

  
  
 No1(){//Ŭ������ ������ ����
  setTitle("16112332 ������");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� �����ϸ� ���α׷��� ����
  createMenu();//â�� �޴��� ����� �Լ�
  setSize(700,700);//â�� ������
  setVisible(true);
 }


 void createMenu() {
  JMenuBar mb = new JMenuBar();
  
  //�޴�ù����
  JMenu firstMenu = new JMenu("1������");
  	JMenuItem mi=new JMenuItem("����");
	firstMenu.add(mi);
	 mb.add(firstMenu);
	setJMenuBar(mb);
	mi.addActionListener(new MenuActionListener());
  
  	//�޴��ι�°
    JMenuItem [] menuItem = new JMenuItem [4];
    String[] itemTitle = {"New","Open","Save","SaveAs"};
    JMenu memoMenu = new JMenu("2-1��");
    for(int i=0;i<menuItem.length;i++){
  	  menuItem[i]=new JMenuItem(itemTitle[i]);
  	  menuItem[i].addActionListener(new noteActionListener());
  	  
  	  if(i==2){ memoMenu.addSeparator();}
  	  
  	  memoMenu.add(menuItem[i]);
    }
    mb.add(memoMenu);
    setJMenuBar(mb);
 
  //�޴� ����°
    JMenuItem [] menuItem2 = new JMenuItem [7];//�迭�� �̿��ؼ� �޴��������� �������
    String[] itemTitle2 = {"Color","Line","Rect","Oval","RndRect","Text","FreeLine"};
    JMenu Menu2 = new JMenu("2-2��");
    
    //���� ���� ���α׷�
    JMenuItem openItem = new JMenuItem("Open");
    setContentPane(new MyPanel());
    
	openItem.addActionListener(new OpenActionListener());	
	Menu2.add(openItem);
		mb.add(Menu2);
	setJMenuBar(mb);	
	 Menu2.addSeparator();//���м�
	
      for(int i=0;i<menuItem2.length;i++){
  	  menuItem2[i]=new JMenuItem(itemTitle2[i]);
  	  menuItem2[i].addActionListener(new drawActionListener());
  	  
  	  if(i==1){  Menu2.addSeparator();}//if�� ������ �����ϸ� ���м��� �ִ´�
  	    	  Menu2.add(menuItem2[i]);
    }
    mb.add(Menu2);
    setJMenuBar(mb);
    
 
  
//�޴� �׹���
   JMenuItem [] menuItem3 = new JMenuItem [4];
  String[] itemTitle3 = {"3.���ӽ���","4.����","5.�����׸���","6.�ڹٶ�?"};
  JMenu Menu3 = new JMenu("3,4,5,6������");
  for(int i=0;i<menuItem3.length;i++){
	  menuItem3[i]=new JMenuItem(itemTitle3[i]);
	  menuItem3[i].addActionListener(new MenuActionListener());
	  
	  Menu3.add(menuItem3[i]);
  }
  mb.add(Menu3);
  setJMenuBar(mb);
 
    
 }
 //Open �޴� �������� ���õǸ� ȣ��Ǵ� action������
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
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�", 
							"���", JOptionPane.WARNING_MESSAGE);
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
	
 
 //�ι�° �޴��� ��â�� ������ �ʱ� ������ �� �縮���� �����Ų��
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
	  {new Text();}//TextŬ���� �� â���� ��ο�
	  	  
	  else if(cmd.equals("FreeLine"))
	  {new GraphicsDraw();}  //Ŭ������ ��â���� �ҷ���
	 }
	
}	
 

 
void Line(){//������� �Լ�
		
		 setTitle("Line �׸���");
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

void Rect(){//�簢������� �Լ�
	
	 setTitle("Rect �׸���");
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

void Oval(){//���׶�� ����� �Լ�
	
	 setTitle("Oval �׸���");
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

void RndRect(){//�𼭸��� �ձ� �簢�� ����� �Լ�
	
	 setTitle("RndRect �׸���");
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

	 //MenuActionListner�� ����� �޴������۵鿡 ���� ���೻��
class MenuActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	  String cmd = e.getActionCommand();
	  if(cmd.equals("����"))
		   Play();//�� ȭ�鿡 ���̵��� ���

	  	  if(cmd.equals("3.���ӽ���"))
		    new startGame();//��â���� ����
	 if(cmd.equals("4.����"))
		    new calculator();//��â���� ����
	   if(cmd.equals("5.�����׸���"))
	   new draw();//��â���� ����
	  if(cmd.equals("6.�ڹٶ�?"))
		   new JavaEx();//��â���� ����
	 }
	
}

//���� 1-5 �� ȭ�鿡 ���� ���� �����Ͽ� ���̵��� �ϴ� �Լ�
void Play() {
	
	setTitle("1-1������ ����");
	Container c = getContentPane();
	GridLayout grid = new GridLayout(10, 5);//10x5 �׸����� GridLayout ��ġ������ ����
	grid.setVgap(5);//�׸��� ������ ���� �������� 5 �ȼ��� ����
	c.setLayout(grid);//grid�� ��þƮ���� ��ġ�����ڷ� ����


	c.add(new JLabel("�̸� : "));
	c.add(new JTextField("������"));
	c.add(new JLabel("�й�: "));
	c.add(new JTextField("16112332"));
	c.add(new JLabel("�а� : "));
	c.add(new JTextField("��ǻ�Ͱ��а�"));
	c.add(new JLabel("�巡���: "));
	c.add(new JTextField("���α׷���"));	
	c.add(new JLabel("�������� ��ȹ : "));
	c.add(new JTextField("���Ϸ� ���డ��, ���Ͱ����ϱ�, ���α׷��� �����ϱ�"));
	c.add(new JLabel("�����б� ��ȹ : "));
	c.add(new JTextField("����ð� 5�ð� ä���, 20���� ��� "));
	c.add(new JLabel("�¿�� : "));
	c.add(new JTextField("��ǰ� ��������"));
	c.add(new JLabel("�� �λ��� ���� : "));
	c.add(new JTextField("�����������"));
	
	setSize(800,700);//�� â�� ������
	setVisible(true);
}


   

 public static void main (String [] args) {
  new No1();//�Լ� ����
 }
 
}

 
 //2-1������ �ؿ� �ִ� �޴������۵��� Ŭ������ ���� ���� 
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


	 


