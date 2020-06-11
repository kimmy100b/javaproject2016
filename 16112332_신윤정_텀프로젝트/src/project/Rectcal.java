package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Rectcal extends JFrame {
	JLabel resultLabel = new JLabel("넓이 출력");
	 Container contentPane;
	 int width,height;//가로, 세로
	 
	Rectcal() {
				super("사각형 계산");
		
			
		setLayout(new FlowLayout());
		JButton btn = new JButton("Rect");//Rect버튼 생성
		btn.addActionListener(new MyActionListener());
		add(btn);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.YELLOW);//결과값도출하는 배경 노란색
		add(resultLabel);

		setSize(400,300);//크기
		setVisible(true);
	}
	
	//Rect버튼 클릭했을 때
	class MyActionListener implements  ActionListener {
		CalcDialog dialog;
		public MyActionListener() {
			dialog = new CalcDialog(Rectcal.this);			
		}
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
			if(dialog.isValid())
			{	resultLabel.setText(Integer.toString(dialog.getResult()));
			
		}}
	}

	
	class CalcDialog extends JDialog {
		int n= 0;//n는 넓이
		boolean bValid = false;
		JTextField a = new JTextField(10);
		JTextField b = new JTextField(10);
		JButton addBtn = new JButton("   Rect   ");//Rect버튼 생성
		public CalcDialog(JFrame f) {
			super(f, "Calculation Dialog", true);
			setLayout(new FlowLayout());
			add(new JLabel("사각형의 넓이"));
			//입력받을 두 수
			add(a);
			add(b);
			add(addBtn);
			
			//addBtn-Rect버튼을 입력받았을 때
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//두 입력 값
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
					width=x;//가로
					height=y;//높이
						n=x*y;//넓이
						bValid = true;
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "정수가 아닌 키가 있습니다", "오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CalcDialog.this.setVisible(false);
				}
			});
			
			setSize(200,200);
		}
		
		public boolean isValid() {
			Rect();
			return bValid;
		}
		public int getResult() {
			if(bValid)
				{return n; }//넓이로 리턴
			return 0;
		}
	}
	//받은 입력값으로 사각형 그리기
	void Rect(){
		
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
			b.drawRect(40,40, width, height);
		}
	}

	//출력
	static public void main(String[] arg) {
		new Rectcal();
	}
}
