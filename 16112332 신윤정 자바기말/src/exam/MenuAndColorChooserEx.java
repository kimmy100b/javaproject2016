package exam;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuAndColorChooserEx extends JFrame {
	Container contentPane;
	JLabel label = new JLabel("Java is Hard");//Java is Hard��� �۾�

	MenuAndColorChooserEx() {
		setTitle("Color");	//���� Color
		contentPane = getContentPane();
		label.setHorizontalAlignment(SwingConstants.CENTER);//��ġ
		label.setFont(new Font("Ravie", Font.ITALIC, 30));//�۲� ũ��
		contentPane.add(label, BorderLayout.CENTER);
		createMenu();
		setSize(450,400);//������
		setVisible(true);
	}

	void createMenu() {//�޴��� ����
		JMenuBar mb = new JMenuBar();
		JMenuItem colorMenuItem = new JMenuItem("Color");
		JMenu fileMenu = new JMenu("Text");
		
		//Color �޴� �����ۿ� Action ������ ��
		colorMenuItem.addActionListener(new MenuActionListener());
		fileMenu.add(colorMenuItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	 class MenuActionListener implements ActionListener {
		JColorChooser chooser = new JColorChooser();

		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("Color"))  {
				 Color selectedColor = chooser.showDialog(null, "Color", Color.YELLOW);
				if(selectedColor != null)
					label.setForeground(selectedColor);
			}
		}
	}
//����
	public static void main(String [] args) {
		new MenuAndColorChooserEx();
	}
} 
