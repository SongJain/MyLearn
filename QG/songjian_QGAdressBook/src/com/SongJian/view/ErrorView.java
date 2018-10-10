package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ErrorView
{
	Font font1 =new Font("黑体", Font.PLAIN, 20);//设置字体
	JFrame f = new JFrame("登入错误");
	JButton ok = new JButton("确定");
	JPanel pan = new JPanel();
	JPanel pan1 = new JPanel();
	JLabel label = new JLabel("用户名或密码不能为空");
	JLabel label1 = new JLabel("用户名或密码错误");
	JLabel labe111 = new JLabel("两次输入密码不一致");
	
	public void LoginError()//登入错误
	{
		
		Return re = new Return();
		ok.addActionListener(re);//返回login
		
		pan.setLayout(null);
		
		pan.add(label);
		pan.add(ok);
		
		ok.setBounds(145,130,80,35);
		ok.setFont(font1);
		label.setFont(font1);
		label.setBounds(92,60,200,35);
		
		f.add(pan);
		f.setBounds(700,400,400,300);
		f.setVisible(true);	
	}
	
	public void adminError()//管理员错误
	{
		
		Return re = new Return();
		ok.addActionListener(re);//返回login
		
		pan1.setLayout(null);
		
		pan1.add(label1);
		pan1.add(ok);
		
		ok.setBounds(145,130,80,35);
		ok.setFont(font1);
		label1.setFont(font1);
		label1.setBounds(110,60,200,35);
		
		f.add(pan1);
		f.setBounds(700,400,400,300);
		f.setVisible(true);
	}
	public void resetpassword()   //重设密码
	{
		Returnto re = new Returnto();
		ok.addActionListener(re);
		pan1.setLayout(null);
		
		pan1.add(label);
		pan1.add(ok);
		
		ok.setBounds(145,130,80,35);
		ok.setFont(font1);
		label.setFont(font1);
		label.setBounds(110,60,200,35);
		
		f.add(pan1);
		f.setBounds(700,400,400,300);
		f.setVisible(true);	
	}
	public void resetpasswordwrong() //重设密码两次错误
	{
		Returnto re = new Returnto();
		ok.addActionListener(re);
		pan1.setLayout(null);
		
		pan1.add(labe111);
		pan1.add(ok);
		
		ok.setBounds(145,130,80,35);
		ok.setFont(font1);
		labe111.setFont(font1);
		labe111.setBounds(110,60,200,35);
		
		f.add(pan1);
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
	
	class Returnto implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			f.dispose();
		}
		
	}

}
