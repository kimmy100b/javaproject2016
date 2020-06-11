package exam;


import javax.swing.*;

import java.awt.*;

public class JavaEx extends JFrame {
	Container contentPane;
	JavaEx() {
		setTitle("6.자바란? ");//제목
			contentPane = getContentPane();
		JTabbedPane pane = createTabbedPane();//탭팬 생성
		contentPane.add(pane, BorderLayout.CENTER);//탭팬을 컨텐트팬에 부착

		
		
		setSize(400,400);//새창사이즈
		setVisible(true);//새창보이게 하는 것
	}
	
	//탭팬을 생성하고 3개의 탭을 생성하여 부착한다
	JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);//탭의 객체 생성
	
		
	pane.addTab("자바의 정의", new JTextField("자바는 객체지향프로그래밍 언어이다"));
		pane.addTab("자바의 특성", new JTextField("1.객체지향언어  2.간단하다  3.보안에 강하다"));
		pane.addTab("자바의 단점", new JTextField("어려움"));
		pane.addTab("자바를 개발한 사람", new JTextField("자바는 선 마이크로시스템즈(Sun Microsystems)의 제임스 고슬링(James Gosling)이 개발한 객체지향 언어이다."));
		pane.addTab("자바의 역사", new JTextField("자바는 선 마이크로시스템즈(Sun Microsystems)의 제임스 고슬링(James Gosling)이 개발한 객체지향 언어이다. 자바는 C 언어를 토대로 오브젝트-C를 거쳐 기계의 운영체제와 무관하게 실행할 수 있도록 만들어졌다. 처음에 오크(oak)로 불렸으나 이름이 같은 언어가 이미 존재해서 나중에 자바로 바뀌었다. 자바는 JVM(Java Virtual Machine: 자바 가상 머신)이라는 프로그램을 사용하기 때문에 컴파일된 코드가 각각의 플랫폼에 대해 독립적이다.그래서 자바로 개발된 프로그램은 JVM을 설치할 수 있는 시스템이라면 어디서나 실행할 수 있어 폭발적인 인기를 끌게 되었다. 2009년 4월 제작사인 선 마이크로시스템즈가 오라클에 인수 합병됨에 따라 현재 자바에 대한 권리 및 유지보수도 오라클(Oracle)로 넘어갔다."));
		
		return pane;	
	}

	

	public static void main(String [] args) {
		new JavaEx();//싫앵
	}
} 
