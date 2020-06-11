package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//���� ���̿� ���� �׸��� Ŭ����
public class Circlecal extends JFrame {
	JLabel resultLabel = new JLabel("���� ���");
	 Container contentPane;
	 int radius;
	 
	 Circlecal() {//�Ű����� ���� ������
				super("�� ���");
		
			
		setLayout(new FlowLayout());
		JButton btn = new JButton("Circle");//Circle�̶�� �� ��ư ����
		btn.addActionListener(new MyActionListener());//��ư���ٰ� �׼� �����ʸ� �ٿ��ش�
		add(btn);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.YELLOW);//����������ϴ� ��� �����
		add(resultLabel);

		setSize(400,300);//â ������
		setVisible(true);
	}
	
	 //Circle�̶�� ��ư Ŭ���ϸ� � �ൿ�� �ϴ� ��
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
		double n= 0;//n�� ����
		boolean bValid = false;
		JTextField a = new JTextField(10);//�������� �Է¹���
		
		JButton addBtn = new JButton("   Circle   ");//Circle�̶�� ��ư ����
		public CalcDialog(JFrame f) {
			super(f, "Calculation Dialog", true);
			setLayout(new FlowLayout());
			add(new JLabel("���� ������"));
			add(a);
			add(addBtn);
			
			//�ι�° Circle ��ư�� Ŭ���ϸ� ����Ǵ� ���
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int r = Integer.parseInt(a.getText());
					
					radius=r;//������
				
						n = r*r*3.14;//�������� ���̸� ���ϴ� ����
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
			Circle();
			return bValid;
		}
		public double getResult() {
			if(bValid)
				{return n; }
			return 0;
		}
	}
	
	//�Է¹��� ���������� ���׸���
	void Circle(){
		
		 setTitle("Circle �׸���");
			contentPane = getContentPane();
			MyPanel2 p = new MyPanel2();
			contentPane.add(p, BorderLayout.CENTER);
			setContentPane(p);
			validate();
		
			} 

	class MyPanel2 extends JPanel {
		public void paintComponent(Graphics b) {
			super.paintComponent(b);
			b.setColor(Color.BLACK);//������ ����
			b.drawOval(40,40, radius, radius);//(40,40) ��ġ�� �������� radius�� �� �׸���
		}
	}

	//���
	static public void main(String[] arg) {
		new Circlecal();
	}
}

