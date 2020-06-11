package exam;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuAndColorChooserEx extends JFrame {
	Container contentPane;
	JLabel label = new JLabel("Java is Hard");//Java is Hard라는 글씨

	MenuAndColorChooserEx() {
		setTitle("Color");	//제목 Color
		contentPane = getContentPane();
		label.setHorizontalAlignment(SwingConstants.CENTER);//우치
		label.setFont(new Font("Ravie", Font.ITALIC, 30));//글꼴 크기
		contentPane.add(label, BorderLayout.CENTER);
		createMenu();
		setSize(450,400);//사이즈
		setVisible(true);
	}

	void createMenu() {//메뉴바 생성
		JMenuBar mb = new JMenuBar();
		JMenuItem colorMenuItem = new JMenuItem("Color");
		JMenu fileMenu = new JMenu("Text");
		
		//Color 메뉴 아이템에 Action 리스너 등
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
//실행
	public static void main(String [] args) {
		new MenuAndColorChooserEx();
	}
} 
