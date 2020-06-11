package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Subcal extends JFrame {
	JLabel resultLabel = new JLabel("계산 결과 출력");
	Subcal() {
		super("빼기 계산");
			
		setLayout(new FlowLayout());
		JButton btn = new JButton("SUB");//"SUB" 빼기 하는 계산 버튼 생성
		btn.addActionListener(new MyActionListener());
		add(btn);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.YELLOW);//결과값도출하는 배경 노란색
		add(resultLabel);
		setSize(250,100);//사이즈
		setVisible(true);
	}
	
	class MyActionListener implements  ActionListener {
		CalcDialog dialog;
		public MyActionListener() {
			dialog = new CalcDialog(Subcal.this);			
		}
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
			if(dialog.isValid())
				resultLabel.setText(Integer.toString(dialog.getResult()));
		}
	}

	class CalcDialog extends JDialog {//계산하는 클래스 구현
		int sum = 0;
		boolean bValid = false;
		JTextField a = new JTextField(10);
		JTextField b = new JTextField(10);
		JButton subBtn = new JButton("   Sub   ");//Sub버튼 생성
		public CalcDialog(JFrame f) {
			super(f, "Calculation Dialog", true);
			setLayout(new FlowLayout());
			add(new JLabel("두 수를 뺍니다."));
			add(a);
			add(b);
			add(subBtn);
			subBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//입력받은 두수
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
						sum = x - y;//뺄셈
						bValid = true;
						
					}catch(NumberFormatException e2) {//정수가 아닌 다른 수를 입력받으면
						JOptionPane.showMessageDialog(null, "정수가 아닌 키가 있습니다", "오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CalcDialog.this.setVisible(false);
				}
			});
			
			setSize(200,200);
		}
		
		public boolean isValid() {
			return bValid;
		}
		public int getResult() {
			if(bValid)
				return sum;//결과값 리턴
			return 0;
		}
	}
	static public void main(String[] arg) {
		new Subcal();//출력
	}
}
