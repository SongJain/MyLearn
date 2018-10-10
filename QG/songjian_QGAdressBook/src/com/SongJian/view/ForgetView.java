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


public class ForgetView {
	JPanel contentPanel = new JPanel();
	//定义frame
	JFrame f = new JFrame("QG用户修改密码");
	
	Font font =new Font("宋体", Font.PLAIN, 20);//设置字体
	Font font1 =new Font("黑体", Font.PLAIN, 18);//设置字体
	
	JButton ok = new JButton("确定");
	JButton returnto = new JButton("返回");
	private JLabel namelab = new JLabel("用户名");
	private JTextField nametext = new JTextField();
	private JLabel oldpasswordlab = new JLabel("旧密码");
	private JPasswordField oldpasswordtext = new JPasswordField();
	private JLabel newpasswordlab = new JLabel("新密码");
	private JPasswordField newpasswordtext = new JPasswordField();
	
	public void init()
	{		
		Return re = new Return();
		returnto.addActionListener(re);//返回login
		
		contentPanel.setLayout(null);
		contentPanel.add(namelab);
		contentPanel.add(nametext);
		contentPanel.add(ok);
		contentPanel.add(returnto);
		contentPanel.add(oldpasswordlab);
		contentPanel.add(oldpasswordtext);
		contentPanel.add(newpasswordlab);
		contentPanel.add(newpasswordtext);
		

		namelab.setBounds(60, 35, 100, 30);
		namelab.setFont(font1);
		nametext.setBounds(130,35,200,35);
		nametext.setFont(font);
		newpasswordlab.setBounds(60, 135, 100, 30);
		newpasswordlab.setFont(font1);
		newpasswordtext.setBounds(130,135,200,35);
		newpasswordtext.setFont(font);
		oldpasswordlab.setBounds(60, 85, 100, 30);
		oldpasswordlab.setFont(font1);
		oldpasswordtext.setBounds(130,85,200,35);
		oldpasswordtext.setFont(font);
		
		ok.setBounds(100,200,80,30);
		ok.setFont(font1);
		returnto.setBounds(220,200,80,30);
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
