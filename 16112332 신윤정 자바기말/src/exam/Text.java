package exam;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Text extends JFrame {
	Container contentPane;
	Text() {
		setTitle("Text");
		
		contentPane = getContentPane();
		contentPane.add(new MyCenterPanel(), BorderLayout.CENTER);
		setSize(500,500);
		setVisible(true);
	}
	class MyCenterPanel extends JPanel {
		JTextField tf;
		JButton btn;
		JTextArea ta;
		MyCenterPanel() {
			tf = new JTextField(30);
			btn = new JButton("�߰�");
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.append(tf.getText()+"\n");
				}
			});
			ta = new JTextArea("Text�� �Է��Ͻÿ�", 20, 40);
			add(new JLabel("�Ʒ� â�� ���ڿ��� �Է��ϰ� ��ư�� Ŭ���ϼ���"));
			add(tf);
			add(btn);
			add(new JScrollPane(ta));			
		}
	}		
	public static void main(String [] args) {
		new Text();
	}
} 
