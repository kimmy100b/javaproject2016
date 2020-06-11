package project;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//계산기를 동작하는 프로그래밍
public class calculator extends JFrame implements ActionListener {
JTextField T1, T2;
int j=0;
int oldnum,temp;//oldnum은 그 전에 입력한 값, temp는 현재 입력한 값이다
double result;

String tempFun,tempInput="";
boolean finish = false;
JButton Button [] = new JButton[16];//16개의 버튼 생성

public void actionPerformed(ActionEvent e) {
String input = e.getActionCommand();

//더하기를 눌렀을 때
if(input.equals("+")){
oldnum = temp;
tempFun = "+";
tempInput = "";
T2.setText("더하기");
}

//곱하기를 눌렀을때
else if(input.equals("x")){
oldnum = temp;
tempFun = "x";
tempInput = "";
T2.setText("곱하기");
}

//나누기를 눌렀을 때
else if(input.equals("÷")){
oldnum = temp;
tempFun = "÷";
tempInput = "";
T2.setText("나누기");
}

//초기화를 눌렀을 때
else if(input.equals("C")){
tempInput = "";
temp = 0;
oldnum = 0;
T1.setText("");
T2.setText("초기화");
}

//빼기를 눌렀을 때
else if(input.equals("-")){
oldnum = temp;
tempFun = "-";
tempInput = "";
T2.setText("빼기");
}

//출력하기 위해 "=" 눌렀을 때
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
else if (tempFun.equals("÷")){
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

//매개변수 없는 생성자 
calculator(){
super("4.계산기");
setLayout(new BorderLayout());

setSize(400,500);//창 사이즈
T1 = new JTextField("",15);
T2 = new JTextField("",5);
T2.setEnabled(false);
JPanel P1 = new JPanel();
JPanel P2 = new JPanel();
P1.add(T1);
P1.add(T2);
P2.setLayout(new GridLayout(4,4,10,10));
String btnValue[] = {"7","8","9","÷","4","5","6","x","1","2","3","-","0","C","=","+"};
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

