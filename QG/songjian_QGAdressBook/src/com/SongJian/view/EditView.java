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
import com.SongJian.dao.AdminDao;
import com.SongJian.dao.StudentDao;
import com.SongJian.util.Stringutil;

public class EditView {
	JPanel contentPanel = new JPanel();
	//定义frame
	JFrame f = new JFrame("修改密码");
	
	Font font =new Font("宋体", Font.PLAIN, 20);//设置字体
	Font font1 =new Font("黑体", Font.PLAIN, 18);//设置字体
	
	JButton ok = new JButton("确定");
	JButton returnto = new JButton("返回");
	private JLabel namelab1 = new JLabel("当前用户：");
	JTextField namet = new JTextField();
	private JLabel namelab = new JLabel("旧密码：");
	private JPasswordField nametext = new JPasswordField();
	private JLabel oldpasswordlab = new JLabel("新密码：");
	private JPasswordField oldpasswordtext = new JPasswordField();
	private JLabel newpasswordlab = new JLabel("再次确认：");
	private JPasswordField newpasswordtext = new JPasswordField();
	
	public void admin(String username)     //管理员修改密码
	{		
		Return re = new Return();
		returnto.addActionListener(re);//返回login
		Oka ok1 = new Oka();
		ok.addActionListener(ok1);
		contentPanel.setLayout(null);
		contentPanel.add(namet);
		contentPanel.add(namelab1);
		contentPanel.add(namelab);
		contentPanel.add(nametext);
		contentPanel.add(ok);
		contentPanel.add(returnto);
		contentPanel.add(oldpasswordlab);
		contentPanel.add(oldpasswordtext);
		contentPanel.add(newpasswordlab);
		contentPanel.add(newpasswordtext);
		
		namet.setEditable(false);
		namet.setText(username);
		namet.setBounds(130, 25, 200, 35);
		namet.setFont(font1);
		namelab1.setBounds(50, 25, 100, 30);
		namelab1.setFont(font1);
		namelab.setBounds(60, 70, 100, 30);
		namelab.setFont(font1);
		nametext.setBounds(130,70,200,35);
		nametext.setFont(font);
		newpasswordlab.setBounds(50, 170, 100, 30);
		newpasswordlab.setFont(font1);
		newpasswordtext.setBounds(130,170,200,35);
		newpasswordtext.setFont(font);
		oldpasswordlab.setBounds(60, 120, 100, 30);
		oldpasswordlab.setFont(font1);
		oldpasswordtext.setBounds(130,120,200,35);
		oldpasswordtext.setFont(font);
		
		ok.setBounds(100,240,80,30);
		ok.setFont(font1);
		returnto.setBounds(220,240,80,30);
		returnto.setFont(font1);
	
		
		f.add(contentPanel);
		f.setBounds(700,400,400,400);
		f.setVisible(true);
		
		
	}
	
	public void stu(String username)    //学生修改密码
	{		
		namet.setText(username);
		namet.setEditable(false);
		Return re = new Return();
		returnto.addActionListener(re);//返回login
		Oks ok1 = new Oks();
		ok.addActionListener(ok1);
		
		contentPanel.setLayout(null);
		contentPanel.add(namet);
		contentPanel.add(namelab1);
		contentPanel.add(namelab);
		contentPanel.add(nametext);
		contentPanel.add(ok);
		contentPanel.add(returnto);
		contentPanel.add(oldpasswordlab);
		contentPanel.add(oldpasswordtext);
		contentPanel.add(newpasswordlab);
		contentPanel.add(newpasswordtext);
		

		namet.setBounds(130, 25, 200, 35);
		namet.setFont(font1);
		namelab1.setBounds(50, 25, 100, 30);
		namelab1.setFont(font1);
		namelab.setBounds(60, 70, 100, 30);
		namelab.setFont(font1);
		nametext.setBounds(130,70,200,35);
		nametext.setFont(font);
		newpasswordlab.setBounds(50, 170, 100, 30);
		newpasswordlab.setFont(font1);
		newpasswordtext.setBounds(130,170,200,35);
		newpasswordtext.setFont(font);
		oldpasswordlab.setBounds(60, 120, 100, 30);
		oldpasswordlab.setFont(font1);
		oldpasswordtext.setBounds(130,120,200,35);
		oldpasswordtext.setFont(font);
		
		ok.setBounds(100,240,80,30);
		ok.setFont(font1);
		returnto.setBounds(220,240,80,30);
		returnto.setFont(font1);
	
		
		f.add(contentPanel);
		f.setBounds(700,400,400,400);
		f.setVisible(true);
		
		
	}
	
	class Return implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			f.dispose();
		}
	}
	
	class Oka implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = namet.getText().toString();
			String oldpassword = String.valueOf(nametext.getPassword());
			String newpassword = String.valueOf(oldpasswordtext.getPassword());
			String conpassword = String.valueOf(newpasswordtext.getPassword());
			
			if(Stringutil.isEmpty(oldpassword))    
			{
				new ErrorView().resetpassword();
				return;
			}
			if(Stringutil.isEmpty(newpassword))    
			{
				new ErrorView().resetpassword();
				return;
			}
			if(!newpassword.equals(conpassword))
			{
				new ErrorView().resetpasswordwrong();
				return;
			}
			else
			{
				new AdminDao().reset(name,oldpassword,newpassword);
				f.dispose();
				
			}
		}
	}
	class Oks implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = namet.getText().toString();
			String oldpassword = String.valueOf(nametext.getPassword());
			String newpassword = String.valueOf(oldpasswordtext.getPassword());
			String conpassword = String.valueOf(newpasswordtext.getPassword());
			
			if(Stringutil.isEmpty(oldpassword))    
			{
				new ErrorView().resetpassword();
				return;
			}
			if(Stringutil.isEmpty(newpassword))    
			{
				new ErrorView().resetpassword();
				return;
			}
			if(!newpassword.equals(conpassword))
			{
				new ErrorView().resetpasswordwrong();
				return;
			}
			else
			{
				new StudentDao().reset(name,oldpassword,newpassword);
				f.dispose();				
			}
		}
	}
}


