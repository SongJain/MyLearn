package com.SongJian.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class LoginViewBegin {
	JFrame f = new JFrame("qg信息系统欢迎您");
	public void init() {
		JLabel wel = new JLabel("QG学生管理系统");
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("src/images//1.jpg");//这是背景图片
		JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
		f.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//设置背景标签的位置
		Container cp=f.getContentPane();  
		cp.setLayout(new BorderLayout());  
		Font font1 =new Font("微软雅黑", Font.PLAIN, 25);//设置字体
		Font font =new Font("黑体", Font.PLAIN, 70);
		JButton log = new JButton("BEGIN NOW");
		JButton bye = new JButton("BYE  BYE ");
		bye.setFont(font1);
		bye.setBounds(500, 300, 168, 30);
		
		f.setLayout(null);
		
		Log L = new Log();
		log.addActionListener(L);
		Bye b = new Bye();
		bye.addActionListener(b);
		
		log.setFont(font1);
		log.setBorder(blackline);
		log.setBounds(250, 300, 168, 30);
		log.setBackground(Color.gray);
		log.setOpaque(false);
		bye.setBackground(Color.gray);
		bye.setOpaque(false);
		wel.setBounds(220, 10, 1200, 300);
		wel.setFont(font);
		f.add(wel);
		f.add(bye);
		f.add(log);
		  
		((JPanel)cp).setOpaque(false); //将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。  
		  
		f.setBounds(470, 250,980,590);
		f.setVisible(true);
	}
	
	class Log implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new LoginView().init();
			f.dispose();		
		}		
	}
	class Bye implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			f.dispose();
		}
		
	}	
}
