package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.SongJian.util.FileUtil;



public class StudentView {
	JPanel contentPanel = new JPanel();
	private static final String Desktop = null;
	  //定义frame
	JFrame f = new JFrame("QG信息系统");
	Font font =new Font("微软雅黑", Font.PLAIN, 20);//设置字体
	Font font1 =new Font("黑体", Font.PLAIN, 16);//设置字体
	  //菜单
	JMenuBar mb = new JMenuBar();
	JMenu set = new JMenu("系统设置");
	JMenu chengyuan = new JMenu("成员管理");
	JMenu more = new JMenu("更多");
	JMenuItem something = new JMenuItem("关于软件");
	JMenuItem get = new JMenuItem("接受发布");
	JMenu help = new JMenu("帮助");
	JMenuItem resetp = new JMenuItem("修改密码");
	JMenuItem out = new JMenuItem("退出系统");
	JMenu searchstu = new JMenu("搜索学生信息");
	JMenuItem changestu = new JMenuItem("查询学生信息");
	JMenuItem qiehuan = new JMenuItem("切换用户");
	JMenuItem about = new JMenuItem("关于我");
	JMenuItem search1 = new JMenuItem("按姓名搜索");
	JMenuItem search2 = new JMenuItem("按年级搜索");
	JMenuItem search3 = new JMenuItem("按班级搜索");
	JMenuItem search4 = new JMenuItem("按方向搜索");
	JMenuItem search5 = new JMenuItem("按住址搜索");
	JMenuItem search6 = new JMenuItem("按电话搜索");
	JMenuItem search7 = new JMenuItem("按邮箱搜索");
	JMenuItem search8 = new JMenuItem("按宿舍搜索");
	
	outListener outlistener = new outListener();
	resetListener resetpassword = new resetListener();
	Seaaddress ad = new Seaaddress();
	Seaclass cl = new Seaclass();
	Seador dor = new Seador();
	Seagrede grad = new Seagrede();
	Seagroup gro = new Seagroup();
	Seamail mail = new Seamail();
	Seaname na = new Seaname();
	Seatel t = new Seatel();
	Qiehuan qie = new Qiehuan();
	Aboutme aboutme = new Aboutme();
	Searchstu se =new Searchstu();
	Set geti = new Set();
	Help h = new Help();
	public int i;
	
	ImageIcon icon = new ImageIcon("src/images\\系统设置.png");
	ImageIcon icon1 = new ImageIcon("src/images\\成员管理.png");
	ImageIcon icon2 = new ImageIcon("src/images\\h.png");
	ImageIcon icon3 = new ImageIcon("src/images\\更多.png");
	ImageIcon icon4 = new ImageIcon("src/images\\修改密码.png");
	ImageIcon icon5 = new ImageIcon("src/images\\out.png");
	ImageIcon icon6 = new ImageIcon("src/images\\关于.png");
	ImageIcon icon7 = new ImageIcon("src/images\\切换用户.png");
	ImageIcon icon8 = new ImageIcon("src/images\\接收.png");
	private String username;
	public void init(String s)                   //定义init()方法，供对象调用
	{
		setUsername(s);
		out.addActionListener(outlistener);                 //事件添加位置
		resetp.addActionListener(resetpassword);
		about.addActionListener(aboutme);
		qiehuan.addActionListener(qie);
		changestu.addActionListener(se);
		get.addActionListener(geti);
		something.addActionListener(h);
		
		searchstu.add(search1);
		searchstu.add(search2);
		searchstu.add(search3);
		searchstu.add(search4);
		searchstu.add(search5);
		searchstu.add(search6);
		searchstu.add(search7);
		searchstu.add(search8);
		search1.setFont(font1);
		search2.setFont(font1);
		search3.setFont(font1);
		search4.setFont(font1);
		search5.setFont(font1);
		search6.setFont(font1);
		search7.setFont(font1);
		search8.setFont(font1);
		
		help.add(something);
		something.setFont(font1);
		set.setIcon(icon);
        chengyuan.setIcon(icon1);
        help.setIcon(icon2);
        more.setIcon(icon3);
        resetp.setIcon(icon4);
        out.setIcon(icon5);
        about.setIcon(icon6);
        qiehuan.setIcon(icon7);
        get.setIcon(icon8);
		
		search5.addActionListener(ad);
		search3.addActionListener(cl);
		search8.addActionListener(dor);
		search2.addActionListener(grad);
		search4.addActionListener(gro);
		search7.addActionListener(mail);
		search1.addActionListener(na);
		search6.addActionListener(t);
		
		chengyuan.add(searchstu);
		chengyuan.add(changestu);
		set.add(resetp);
		set.add(qiehuan);
		set.add(out);
		more.add(about);
		more.add(get);
		
		get.setFont(font1);
		set.setFont(font1);
		searchstu.setFont(font1);
		qiehuan.setFont(font1);
		changestu.setFont(font1);
		about.setFont(font1);
		more.setFont(font1);
		out.setFont(font1);
		resetp.setFont(font1);
		set.setFont(font1);
		chengyuan.setFont(font1);
		help.setFont(font1);
		
		mb.add(set);
		mb.add(chengyuan);
		mb.add(help);
		mb.add(more);
		
		f.setJMenuBar(mb);
		f.add(contentPanel);						//加入frame中
		f.setBounds(550,100,800,800);				//固定frame大小
		f.setVisible(true);							//可视化
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	class outListener implements ActionListener
	{

		@Override   
		public void actionPerformed(ActionEvent arg0) {
			//退出系统
			i = JOptionPane.showConfirmDialog(out,"退出系统","确认退出", JOptionPane.YES_NO_OPTION);
			if(i == 0)
			{
				System.exit(0);
			}
		}		
	}
	
	class resetListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// 修改密码
			 new EditView().stu(username);
		}	
	}
	
	class Aboutme implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AboutmeView().init();
		}
	}
	class Qiehuan implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new LoginView().init();
			f.dispose();
		}		
	}
	class Seaaddress implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewadressstu().init();
		}		
	}
	class Seaclass implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewclassstu().init();
		}		
	}
	class Seador implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewdorstu().init();
		}		
	}
	class Seagrede implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewgradestu().init();
		}		
	}
	class Seagroup implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewgroupstu().init();
		}		
	}
	class Seamail implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewmailstu().init();
		}		
	}
	class Seaname implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewnamestu().init();
		}		
	}
	class Seatel implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewtelstu().init();
		}		
	}
	class Searchstu implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				new SearchStu().init();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	class Set implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new JieShouView().init();
		}		
	}
	class Help implements ActionListener
	{
		

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				new FileUtil();
				FileUtil.useAWTDesktop();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
  }
}
