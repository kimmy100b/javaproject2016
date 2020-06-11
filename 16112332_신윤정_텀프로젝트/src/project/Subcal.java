package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Subcal extends JFrame {
	JLabel resultLabel = new JLabel("��� ��� ���");
	Subcal() {
		super("���� ���");
			
		setLayout(new FlowLayout());
		JButton btn = new JButton("SUB");//"SUB" ���� �ϴ� ��� ��ư ����
		btn.addActionListener(new MyActionListener());
		add(btn);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.YELLOW);//����������ϴ� ��� �����
		add(resultLabel);
		setSize(250,100);//������
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

	class CalcDialog extends JDialog {//����ϴ� Ŭ���� ����
		int sum = 0;
		boolean bValid = false;
		JTextField a = new JTextField(10);
		JTextField b = new JTextField(10);
		JButton subBtn = new JButton("   Sub   ");//Sub��ư ����
		public CalcDialog(JFrame f) {
			super(f, "Calculation Dialog", true);
			setLayout(new FlowLayout());
			add(new JLabel("�� ���� ���ϴ�."));
			add(a);
			add(b);
			add(subBtn);
			subBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//�Է¹��� �μ�
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
						sum = x - y;//����
						bValid = true;
						
					}catch(NumberFormatException e2) {//������ �ƴ� �ٸ� ���� �Է¹�����
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
				return sum;//����� ����
			return 0;
		}
	}
	static public void main(String[] arg) {
		new Subcal();//���
	}
}
