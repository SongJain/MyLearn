package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class RegistView {
	JPanel contentPanel = new JPanel();
	//定义frame
	JFrame f = new JFrame("QG用户注册");
	
	Font font =new Font("宋体", Font.PLAIN, 20);//设置字体
	Font font1 =new Font("黑体", Font.PLAIN, 18);//设置字体
	
	JButton ok = new JButton("确定");
	JButton returnto = new JButton("返回");
	private JLabel namelab = new JLabel("用户名");
	private JTextField nametext = new JTextField();
	private JLabel passwordlab = new JLabel("密  码");
	private JPasswordField passwordtext = new JPasswordField();
	
	public void init()
	{
		Return re = new Return();
		returnto.addActionListener(re);//返回login
		
		contentPanel.setLayout(null);
		contentPanel.add(namelab);
		contentPanel.add(nametext);
		contentPanel.add(ok);
		contentPanel.add(returnto);
		contentPanel.add(passwordlab);
		contentPanel.add(passwordtext);

		namelab.setBounds(60, 50, 100, 30);
		namelab.setFont(font1);
		nametext.setBounds(130,50,200,35);
		nametext.setFont(font);
		passwordlab.setBounds(60, 110, 100, 30);
		passwordlab.setFont(font1);
		passwordtext.setBounds(130,110,200,35);
		passwordtext.setFont(font);
		ok.setBounds(100,175,80,30);
		ok.setFont(font1);
		returnto.setBounds(220,175,80,30);
		returnto.setFont(font1);
		
		
		f.add(contentPanel);
		f.setBounds(700,400,400,300);
		f.setVisible(true);
	}
	class Return implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new LoginView().init();
			f.dispose();
		}
	}
}