package exam;


import javax.swing.*;

import java.awt.*;

public class JavaEx extends JFrame {
	Container contentPane;
	JavaEx() {
		setTitle("6.�ڹٶ�? ");//����
			contentPane = getContentPane();
		JTabbedPane pane = createTabbedPane();//���� ����
		contentPane.add(pane, BorderLayout.CENTER);//������ ����Ʈ�ҿ� ����

		
		
		setSize(400,400);//��â������
		setVisible(true);//��â���̰� �ϴ� ��
	}
	
	//������ �����ϰ� 3���� ���� �����Ͽ� �����Ѵ�
	JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);//���� ��ü ����
	
		
	pane.addTab("�ڹ��� ����", new JTextField("�ڹٴ� ��ü�������α׷��� ����̴�"));
		pane.addTab("�ڹ��� Ư��", new JTextField("1.��ü������  2.�����ϴ�  3.���ȿ� ���ϴ�"));
		pane.addTab("�ڹ��� ����", new JTextField("�����"));
		pane.addTab("�ڹٸ� ������ ���", new JTextField("�ڹٴ� �� ����ũ�νý�����(Sun Microsystems)�� ���ӽ� ����(James Gosling)�� ������ ��ü���� ����̴�."));
		pane.addTab("�ڹ��� ����", new JTextField("�ڹٴ� �� ����ũ�νý�����(Sun Microsystems)�� ���ӽ� ����(James Gosling)�� ������ ��ü���� ����̴�. �ڹٴ� C �� ���� ������Ʈ-C�� ���� ����� �ü���� �����ϰ� ������ �� �ֵ��� ���������. ó���� ��ũ(oak)�� �ҷ����� �̸��� ���� �� �̹� �����ؼ� ���߿� �ڹٷ� �ٲ����. �ڹٴ� JVM(Java Virtual Machine: �ڹ� ���� �ӽ�)�̶�� ���α׷��� ����ϱ� ������ �����ϵ� �ڵ尡 ������ �÷����� ���� �������̴�.�׷��� �ڹٷ� ���ߵ� ���α׷��� JVM�� ��ġ�� �� �ִ� �ý����̶�� ��𼭳� ������ �� �־� �������� �α⸦ ���� �Ǿ���. 2009�� 4�� ���ۻ��� �� ����ũ�νý���� ����Ŭ�� �μ� �պ��ʿ� ���� ���� �ڹٿ� ���� �Ǹ� �� ���������� ����Ŭ(Oracle)�� �Ѿ��."));
		
		return pane;	
	}

	

	public static void main(String [] args) {
		new JavaEx();//�Ⱦ�
	}
} 
