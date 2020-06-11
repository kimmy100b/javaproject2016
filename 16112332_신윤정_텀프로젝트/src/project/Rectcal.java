package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Rectcal extends JFrame {
	JLabel resultLabel = new JLabel("���� ���");
	 Container contentPane;
	 int width,height;//����, ����
	 
	Rectcal() {
				super("�簢�� ���");
		
			
		setLayout(new FlowLayout());
		JButton btn = new JButton("Rect");//Rect��ư ����
		btn.addActionListener(new MyActionListener());
		add(btn);
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.YELLOW);//����������ϴ� ��� �����
		add(resultLabel);

		setSize(400,300);//ũ��
		setVisible(true);
	}
	
	//Rect��ư Ŭ������ ��
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
		int n= 0;//n�� ����
		boolean bValid = false;
		JTextField a = new JTextField(10);
		JTextField b = new JTextField(10);
		JButton addBtn = new JButton("   Rect   ");//Rect��ư ����
		public CalcDialog(JFrame f) {
			super(f, "Calculation Dialog", true);
			setLayout(new FlowLayout());
			add(new JLabel("�簢���� ����"));
			//�Է¹��� �� ��
			add(a);
			add(b);
			add(addBtn);
			
			//addBtn-Rect��ư�� �Է¹޾��� ��
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						//�� �Է� ��
						int x = Integer.parseInt(a.getText());
						int y = Integer.parseInt(b.getText());
					width=x;//����
					height=y;//����
						n=x*y;//����
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
			Rect();
			return bValid;
		}
		public int getResult() {
			if(bValid)
				{return n; }//���̷� ����
			return 0;
		}
	}
	//���� �Է°����� �簢�� �׸���
	void Rect(){
		
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
			b.drawRect(40,40, width, height);
		}
	}

	//���
	static public void main(String[] arg) {
		new Rectcal();
	}
}
