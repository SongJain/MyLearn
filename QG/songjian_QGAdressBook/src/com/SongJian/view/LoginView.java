package com.SongJian.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.SongJian.dao.AdminDao;
import com.SongJian.dao.StudentDao;
import com.SongJian.model.Admin;
import com.SongJian.model.Student;
import com.SongJian.util.Stringutil;

public class LoginView
{
	Admin admin = null;
	Student student = null;
	JPanel contentPanel = new JPanel();
	//定义frame
	JFrame f = new JFrame("QG信息系统");
	
	Font font =new Font("宋体", Font.PLAIN, 20);//设置字体
	Font font1 =new Font("黑体", Font.PLAIN, 18);//设置字体
	JButton log = new JButton("登入");
	JButton newuser = new JButton("新人");
	JButton resetlab = new JButton("重置");
	JButton help = new JButton("帮助");
	private JLabel namelab = new JLabel("用户名");
	private JTextField nametext = new JTextField();
	private JLabel passwordlab = new JLabel("密  码");
	private JPasswordField passwordtext = new JPasswordField();   //密码输入
	String[] users = new String[] {"管理员" ,"学生"};	
	JComboBox<String> userchoicer = new JComboBox<>(users);
	ResetListener reset = new ResetListener();
	Newuser nw = new Newuser();
	Helper hp = new Helper();
	ImageIcon icon = new ImageIcon("src/images\\登录.png");
	ImageIcon icon1 = new ImageIcon("src/images\\重置.png");
	ImageIcon icon2 = new ImageIcon("src/images\\帮助.png");
	ImageIcon icon3 = new ImageIcon("src/images\\新用户.png");
	
	public void init()                //定义init()方法，供对象调用
	{
		f.getContentPane().setBackground(Color.BLACK);
	
		
		LoginBut logi = new LoginBut();
		resetlab.setIcon(icon1);
		help.setIcon(icon2);
		newuser.setIcon(icon3);
		log.setIcon(icon);
		
		resetlab.addActionListener(reset);
		log.addActionListener(logi);
		newuser.addActionListener(nw);
		help.addActionListener(hp);
		
		//容器contentpanel
		contentPanel.setLayout(null);
		contentPanel.add(namelab);
		contentPanel.add(nametext);
		contentPanel.add(passwordlab); 
		contentPanel.add(passwordtext);
		contentPanel.add(log);
		contentPanel.add(userchoicer);
		contentPanel.add(resetlab);
		contentPanel.add(newuser);
		contentPanel.add(help);
		
		//绝对布局并且调整字体
		help.setBounds(360,100, 100, 35);
		help.setFont(font1);
		
		newuser.setBounds(360, 50, 100, 35);
		newuser.setFont(font1);
		namelab.setBounds(90, 50, 60, 35);
		namelab.setFont(font1);
		nametext.setBounds(150, 50, 200, 35);
		nametext.setFont(font);
		passwordlab.setBounds(90, 100, 60, 35);
		passwordlab.setFont(font1);
		passwordtext.setBounds(150, 100, 200, 35);
		passwordtext.setFont(font);
		log.setBounds(100, 190, 110, 30);
		log.setFont(font1);
		userchoicer.setBounds(200, 145, 90, 30);
		userchoicer.setFont(font1);
		resetlab.setBounds(280, 190, 110, 30);
		resetlab.setFont(font1);
		
		
		f.add(contentPanel);						//加入frame中
		f.setBounds(700,400,500,300);				//固定frame大小
		f.setVisible(true);							//可视化
	}
	
	class ResetListener implements ActionListener
	{
		@Override //清空密码栏
		public void actionPerformed(ActionEvent e) 
		{
			passwordtext.setText("");
		}
	}
	
	class Newuser implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null,"请联系管理员添加用户");
		}
		
	}
	
	
	class LoginBut implements ActionListener //获取名字
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String name = nametext.getText().toString();
			//password不是正常的字符串，因此要用valueof这个方法转化
			String password = String.valueOf(passwordtext.getPassword());
			
			if(Stringutil.isEmpty(name))     //用户名不能为空
			{
				new ErrorView().LoginError();
				f.dispose();
			}		
			else if(Stringutil.isEmpty(password))            //密码不能为空
			{
				new ErrorView().LoginError();
				f.dispose();
			}
			
			else               //都有填写密码和用户名
			{	
				if ("管理员" == (userchoicer.getSelectedItem()))  //管理员登陆
				{
					AdminDao admindao = new AdminDao();
					Admin admintmp = new Admin();
					
					admintmp.setName(name);
					admintmp.setPassword(password);
					admin = admindao.login(admintmp);
					if(admin == null)
					{
						new ErrorView().adminError();
						f.dispose();
					}
					else
					{
						String s = admintmp.getName();
						AdminView ad = new AdminView();
						ad.init(s);
						JOptionPane.showMessageDialog(null,"欢迎管理员   "+s+"  登入QG信息系统");
						f.dispose();
					}
				}
				else if("学生" == userchoicer.getSelectedItem())
				{
					StudentDao studentdao = new StudentDao();
					Student stu = new Student();
					
					stu.setName(name);
					stu.setPassword(password);
					student = studentdao.login(stu);
					
					if(student == null)
					{
						new ErrorView().adminError();
						f.dispose();
					}
					else
					{
						String s = stu.getName();
						new StudentView().init(s);
						JOptionPane.showMessageDialog(null,"欢迎用户   "+s+"   登入QG信息系统");
						f.dispose();
					}
				}
			}
		}	
	}
	
	class Helper implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null,"新用户密码为123");
		}
		
	}
	
}