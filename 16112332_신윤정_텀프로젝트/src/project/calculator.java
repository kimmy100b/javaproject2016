package project;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//���⸦ �����ϴ� ���α׷���
public class calculator extends JFrame implements ActionListener {
JTextField T1, T2;
int j=0;
int oldnum,temp;//oldnum�� �� ���� �Է��� ��, temp�� ���� �Է��� ���̴�
double result;

String tempFun,tempInput="";
boolean finish = false;
JButton Button [] = new JButton[16];//16���� ��ư ����

public void actionPerformed(ActionEvent e) {
String input = e.getActionCommand();

//���ϱ⸦ ������ ��
if(input.equals("+")){
oldnum = temp;
tempFun = "+";
tempInput = "";
T2.setText("���ϱ�");
}

//���ϱ⸦ ��������
else if(input.equals("x")){
oldnum = temp;
tempFun = "x";
tempInput = "";
T2.setText("���ϱ�");
}

//�����⸦ ������ ��
else if(input.equals("��")){
oldnum = temp;
tempFun = "��";
tempInput = "";
T2.setText("������");
}

//�ʱ�ȭ�� ������ ��
else if(input.equals("C")){
tempInput = "";
temp = 0;
oldnum = 0;
T1.setText("");
T2.setText("�ʱ�ȭ");
}

//���⸦ ������ ��
else if(input.equals("-")){
oldnum = temp;
tempFun = "-";
tempInput = "";
T2.setText("����");
}

//����ϱ� ���� "=" ������ ��
else if(input.equals("=")){
	
if (tempFun.equals("+")){
result = oldnum+temp;
T1.setText(String.valueOf((int)result));
finish = true;
}

else if(tempFun.equals("-")){
result = oldnum - temp;
T1.setText(String.valueOf(result));
finish = true;
}

else if(tempFun.equals("x")){
result = oldnum*temp;
T1.setText(String.valueOf((int)result));
finish = true;
}
else if (tempFun.equals("��")){
result = oldnum/(double)temp;
T1.setText(String.valueOf(result));
finish = true;
}

}
else{
if(finish){
T1.setText("0");
finish = false;
temp = 0;
oldnum = 0;
tempInput = "";
}

tempInput += e.getActionCommand();
System.out.println(tempInput);
T1.setText(tempInput);
temp = Integer.parseInt(tempInput);
}
}

//�Ű����� ���� ������ 
calculator(){
super("4.����");
setLayout(new BorderLayout());

setSize(400,500);//â ������
T1 = new JTextField("",15);
T2 = new JTextField("",5);
T2.setEnabled(false);
JPanel P1 = new JPanel();
JPanel P2 = new JPanel();
P1.add(T1);
P1.add(T2);
P2.setLayout(new GridLayout(4,4,10,10));
String btnValue[] = {"7","8","9","��","4","5","6","x","1","2","3","-","0","C","=","+"};
for(int i=0; i <=15; i++){
Button[i] = new JButton(btnValue[i]);
P2.add(Button[i]);
Button[i].addActionListener(this);
Button[i].setBackground(new Color(150,150,150));

Button[i].setForeground(Color.YELLOW);
if(i==3|| i==7|| i==11 || i==13||i==14||i==15) {
Button[i].setBackground(new Color (50,50,50));

Button[i].setForeground(Color.WHITE);
}
}

add(P1,BorderLayout.NORTH);
add(P2,BorderLayout.CENTER);
setVisible(true);
}

public static void main(String [] args){
	 
new calculator();

}
}

