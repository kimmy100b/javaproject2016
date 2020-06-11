package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Divcal extends JFrame {
	JLabel resultLabel = new JLabel("��� ��� ���");
	Divcal() {
		super("������ ���");
			
		setLayout(new FlowLayout());
		JButton btn = new JButton("DIV");//"DIV" ������ �ϴ� ��� ��ư ����
		btn.addActionListener(new MyActionListener());
		add(btn);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.YELLOW);//����������ϴ� ��� �����
		add(resultLabel);
		setSize(250,100);//â ������
		setVisible(true);
	}
	
	//DIV�ϴ� ��ư�� ������ �� ��Ⱦ �Ǵ� ��
	class MyActionListener implements  ActionListener {
		CalcDialog dialog;
		public MyActionListener() {
			dialog = new CalcDialog(Divcal.this);			
		}
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
			if(dialog.isValid())
				resultLabel.setText(Integer.toString(dialog.getResult()));
		}
	}

	class CalcDialog extends JDialog {
		int sum = 0;
		boolean bValid = false;
		JTextField a = new JTextField(10);
		JTextField b = new JTextField(10);
		JButton divBtn = new JButton("   Div   ");
		public CalcDialog(JFrame f) {
			super(f, "Calculation Dialog", true);
			setLayout(new FlowLayout());
			add(new JLabel("�� ���� �����ϴ�."));
			add(a);
			add(b);
			add(divBtn);
			
			//Div ��ư ������ �� ������
			divBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//�Է¹޴� �� ��
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
						sum = x / y;//������
						bValid = true;
					}catch(NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "������ �ƴ� Ű�� �ֽ��ϴ�", "����", JOptionPane.ERROR_MESSAGE);
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
				return sum;
			return 0;
		}
	}
	//���
	static public void main(String[] arg) {
		new Divcal();
	}
}
