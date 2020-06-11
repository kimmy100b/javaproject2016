package exam;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class calculator extends JFrame implements ActionListener {
JTextField T1, T2;
int j=0;
int oldnum,temp;
double result;//나누기를 위해 결과값을 double로 지정

String tempFun,tempInput="";
boolean finish = false;
JButton Button [] = new JButton[16];//버튼 생성

//버튼을 눌렀을 때의 이벤트 정의해주는 함수
public void actionPerformed(ActionEvent e) {
String input = e.getActionCommand();

if(input.equals("+")){
oldnum = temp;
tempFun = "+";
tempInput = "";
T2.setText("더하기");
}

else if(input.equals("x")){
oldnum = temp;
tempFun = "x";
tempInput = "";
T2.setText("곱하기");
}

else if(input.equals("÷")){
oldnum = temp;
tempFun = "÷";
tempInput = "";
T2.setText("나누기");
}

else if(input.equals("C")){//초기화 해준다
tempInput = "";
temp = 0;
oldnum = 0;
T1.setText("");
T2.setText("초기화");
}

else if(input.equals("-")){
oldnum = temp;
tempFun = "-";
tempInput = "";
T2.setText("빼기");
}


else if(input.equals("=")){
	
if (tempFun.equals("+")){//더하기의 결과값
result = oldnum+temp;
T1.setText(String.valueOf((int)result));
finish = true;
}

else if(tempFun.equals("-")){//뺄셈의 결과값
result = oldnum - temp;
T1.setText(String.valueOf(result));
finish = true;
}

else if(tempFun.equals("x")){//곱하기의 결과값
result = oldnum*temp;
T1.setText(String.valueOf((int)result));
finish = true;
}
else if (tempFun.equals("÷")){//나누기의 결고ㅏ값
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

public calculator(){
super("4.계산기");
setLayout(new BorderLayout());

setSize(400,500);//계산기 사이즈
T1 = new JTextField("",15);
T2 = new JTextField("",5);
T2.setEnabled(false);
JPanel P1 = new JPanel();
JPanel P2 = new JPanel();
P1.add(T1);
P1.add(T2);
P2.setLayout(new GridLayout(4,4,10,10));
String btnValue[] = {"7","8","9","÷","4","5","6","x","1","2","3","-","0","C","=","+"};//계산기 배치 순서
for(int i=0; i <=15; i++){
Button[i] = new JButton(btnValue[i]);

//버튼에다가 이벤트를 설정, 색깔 및 크기 지정
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
	 
new calculator();//함수 출력

}
}
