package exam;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;




public class draw extends JFrame {

Container contentPane;

int [][] x = new int[10][4];

int [][] y = new int[10][4];

PaintPanel panel;



draw () {//생성자

setTitle("기하학적인 모양그리기");
setSize(400, 400);//새창 사이즈

contentPane = getContentPane();

panel = new PaintPanel();




contentPane.add(panel);


setVisible(true);//새창 보이ㅣㄱ

}

class PaintPanel extends JPanel {

public void paintComponent(Graphics g) {

super.paintComponent(g);

for(int i = 0; i < x.length; i++)

for(int j = 0; j < x[i].length; j++) 

if(j % 2 == 0) {

x[i][j] = this.getWidth() / 2;

if(j == 0)

y[i][j] = 0 + i * 10;

else if(j == 2)

y[i][j] = this.getHeight() - i * 10;

}

else if(j % 2 == 1) {

if(j == 1)

x[i][j] = 0 + i * 10;

else if(j == 3) 

x[i][j] = this.getWidth() - i * 10;

y[i][j] = this.getHeight() / 2;

}

for(int i = 0; i < x.length; i++)

g.drawPolygon(x[i], y[i], 4);

}

}

public static void main(String [] args) {

new draw ();//실행

}

}
