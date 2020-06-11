package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//원의 넓이와 원을 그리는 클래스
public class Circlecal extends JFrame {
	JLabel resultLabel = new JLabel("넓이 출력");
	 Container contentPane;
	 int radius;
	 
	 Circlecal() {//매개변수 없는 생성자
				super("원 계산");
		
			
		setLayout(new FlowLayout());
		JButton btn = new JButton("Circle");//Circle이라는 원 버튼 생성
		btn.addActionListener(new MyActionListener());//버튼에다가 액션 리스너를 붙여준다
		add(btn);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.YELLOW);//결과값도출하는 배경 노란색
		add(resultLabel);

		setSize(400,300);//창 사이즈
		setVisible(true);
	}
	
	 //Circle이라는 버튼 클릭하면 어떤 행동을 하는 가
	class MyActionListener implements  ActionListener {
		CalcDialog dialog;
		public MyActionListener() {
			dialog = new CalcDialog(Circlecal.this);			
		}
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
			if(dialog.isValid())
			{	resultLabel.setText(Double.toString(dialog.getResult()));
			
		}}
	}

	
	class CalcDialog extends JDialog {
		double n= 0;//n는 넓이
		boolean bValid = false;
		JTextField a = new JTextField(10);//반지름을 입력받음
		
		JButton addBtn = new JButton("   Circle   ");//Circle이라는 버튼 생성
		public CalcDialog(JFrame f) {
			super(f, "Calculation Dialog", true);
			setLayout(new FlowLayout());
			add(new JLabel("원의 반지름"));
			add(a);
			add(addBtn);
			
			//두번째 Circle 버튼을 클릭하면 실행되는 결과
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int r = Integer.parseInt(a.getText());
					
					radius=r;//반지름
				
						n = r*r*3.14;//반지름의 넓이를 구하는 문제
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
			Circle();
			return bValid;
		}
		public double getResult() {
			if(bValid)
				{return n; }
			return 0;
		}
	}
	
	//입력받은 반지름으로 원그리기
	void Circle(){
		
		 setTitle("Circle 그리기");
			contentPane = getContentPane();
			MyPanel2 p = new MyPanel2();
			contentPane.add(p, BorderLayout.CENTER);
			setContentPane(p);
			validate();
		
			} 

	class MyPanel2 extends JPanel {
		public void paintComponent(Graphics b) {
			super.paintComponent(b);
			b.setColor(Color.BLACK);//색깔은 검정
			b.drawOval(40,40, radius, radius);//(40,40) 위치에 반지름이 radius인 원 그리기
		}
	}

	//출력
	static public void main(String[] arg) {
		new Circlecal();
	}
}

