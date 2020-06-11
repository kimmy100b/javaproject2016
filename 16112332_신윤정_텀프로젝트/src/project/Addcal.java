package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Addcal extends JFrame {
	JLabel resultLabel = new JLabel("계산 결과 출력");//라벨 
	Addcal() {
		super("더하기 계산");
			
		setLayout(new FlowLayout());
		JButton btn = new JButton("ADD");//"ADD" 더하기 하는 계산 버튼 생성
		btn.addActionListener(new MyActionListener());
		add(btn);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.YELLOW);//결과값도출하는 배경 노란색
		add(resultLabel);
		setSize(250,100);//창 사이즈
		setVisible(true);
	}
	
	//ADD버튼을 눌렀을 때 실행되는 것
	class MyActionListener implements  ActionListener {
		CalcDialog dialog;
		public MyActionListener() {
			dialog = new CalcDialog(Addcal.this);			
		}
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
			if(dialog.isValid())
				resultLabel.setText(Integer.toString(dialog.getResult()));
		}
	}

	//ADD버튼 누르면 실행되는 클래스
	class CalcDialog extends JDialog {
		int sum = 0;
		boolean bValid = false;
		JTextField a = new JTextField(10);
		JTextField b = new JTextField(10);
		JButton addBtn = new JButton("   Add   ");//Add라는 버튼 생성
		public CalcDialog(JFrame f) {
			super(f, "Calculation Dialog", true);
			setLayout(new FlowLayout());
			add(new JLabel("두 수를 더합니다."));
			add(a);
			add(b);
			add(addBtn);
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//입력받은 두 수
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
						sum = x + y;//두 수의 합
						bValid = true;
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "정수가 아닌 키가 있습니다", "오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					CalcDialog.this.setVisible(false);
				}
			});
			
			setSize(200,200);//창사이즈
		}
		
		public boolean isValid() {
			return bValid;
		}
		public int getResult() {
			if(bValid)
				return sum;
			return 0;
		}
	}
	static public void main(String[] arg) {
		new Addcal();
	}
}
