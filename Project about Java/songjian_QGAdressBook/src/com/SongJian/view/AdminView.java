package com.SongJian.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.SongJian.util.FileUtil;



public class AdminView {
	
	
	JPanel contentPanel = new JPanel();
	  //定义frame
	JFrame f = new JFrame("QG信息系统");
	Font font =new Font("微软雅黑", Font.PLAIN, 20);//设置字体
	Font font1 =new Font("黑体", Font.PLAIN, 16);//设置字体
	  //菜单
	JMenuBar mb = new JMenuBar();
	JMenu set = new JMenu("系统设置");
	JMenu chengyuan = new JMenu("成员管理");
	JMenu more = new JMenu("更多");
	JMenuItem fabu = new JMenuItem("发布推送");
	JMenuItem sefabu = new JMenuItem("搜索发布");
	JMenuItem mafabu = new JMenuItem("更改发布");
	JMenu help = new JMenu("帮助");
	JMenuItem something = new JMenuItem("关于软件");
	JMenuItem resetp = new JMenuItem("修改密码");
	JMenuItem out = new JMenuItem("退出系统");
	JMenuItem addstu = new JMenuItem("增加学生信息");
	JMenuItem deletefabu = new JMenuItem("删除发布");
	JMenuItem deletestu = new JMenuItem("删除学生信息");
	JMenu searchstu = new JMenu("搜索学生信息");
	JMenuItem search = new JMenuItem("全部显示");
	JMenuItem search1 = new JMenuItem("按姓名搜索");
	JMenuItem search2 = new JMenuItem("按年级搜索");
	JMenuItem search3 = new JMenuItem("按班级搜索");
	JMenuItem search4 = new JMenuItem("按方向搜索");
	JMenuItem search5 = new JMenuItem("按住址搜索");
	JMenuItem search6 = new JMenuItem("按电话搜索");
	JMenuItem search7 = new JMenuItem("按邮箱搜索");
	JMenuItem search8 = new JMenuItem("按宿舍搜索");
	JMenuItem changestu = new JMenuItem("更改学生信息");
	JMenuItem about = new JMenuItem("关于我");
	Addstu ad = new Addstu();
	outListener outlistener = new outListener();
	resetListener resetpassword = new resetListener();
	Aboutme aboutme = new Aboutme();
	public int i;
	JDesktopPane desktopPane = new JDesktopPane();
	Seaname searchname = new Seaname();
	Seagrade searchgrade = new Seagrade();
	Seagroup searchgroup = new Seagroup();
	Seaaddress searchaddress = new Seaaddress();
	Seaclass searchclass = new Seaclass();
	Seatel searchtel = new Seatel();
	Seamail searchmail = new Seamail();
	Seador searchdor = new Seador();
	Deletestu de = new Deletestu();
	Editstu ed = new Editstu();
	Searchall se = new Searchall();
	FABU fa = new FABU();
	Set get = new Set();
	delefabu del = new delefabu();
	changefabu changefa = new changefabu();
	Help h = new Help();
	ImageIcon icon = new ImageIcon("src/images\\系统设置.png");
	ImageIcon icon1 = new ImageIcon("src/images\\成员管理.png");
	ImageIcon icon2 = new ImageIcon("src/images\\h.png");
	ImageIcon icon3 = new ImageIcon("src/images\\更多.png");
	ImageIcon icon4 = new ImageIcon("src/images\\修改密码.png");
	ImageIcon icon5 = new ImageIcon("src/images\\out.png");
	ImageIcon icon6 = new ImageIcon("src/images\\关于.png");
	ImageIcon icon7 = new ImageIcon("src/images\\发布.png");
	ImageIcon icon8 = new ImageIcon("src/images\\删除筛选项.png");
	ImageIcon icon9 = new ImageIcon("src/images\\搜索--1.png");
	ImageIcon icon10 = new ImageIcon("src/images\\更改.png");
	private String username;

	public void init(String s)                   //定义init()方法，供对象调用
	{
		setUsername(s);
		desktopPane.setBackground(Color.LIGHT_GRAY);
        f.setContentPane(desktopPane);
        search1.addActionListener(searchname);
        search2.addActionListener(searchgrade);
        search3.addActionListener(searchclass);
        search4.addActionListener(searchgroup);
        search5.addActionListener(searchaddress);
        search6.addActionListener(searchtel);
        search7.addActionListener(searchmail);
        search8.addActionListener(searchdor);
        deletestu.addActionListener(de);
        changestu.addActionListener(ed);
        sefabu.addActionListener(get);
        mafabu.addActionListener(changefa);
        deletefabu.setIcon(icon8);
        sefabu.setIcon(icon9);
        mafabu.setIcon(icon10);
        
        
        more.add(fabu);
        more.add(deletefabu);
        more.add(sefabu);
        more.add(mafabu);
        sefabu.setFont(font1);
        mafabu.setFont(font1);
        fabu.addActionListener(fa);
        fabu.setIcon(icon7);
        set.setIcon(icon);
        chengyuan.setIcon(icon1);
        help.setIcon(icon2);
        more.setIcon(icon3);
        resetp.setIcon(icon4);
        out.setIcon(icon5);
        about.setIcon(icon6);
        search.setFont(font1);		
		addstu.addActionListener(ad);
		out.addActionListener(outlistener);                 //事件添加位置
		resetp.addActionListener(resetpassword);
		about.addActionListener(aboutme);
		search.addActionListener(se);
		
		chengyuan.add(addstu);
		chengyuan.add(deletestu);
		chengyuan.add(searchstu);
		chengyuan.add(changestu);
		set.add(resetp);
		set.add(out);
		more.add(about);
		searchstu.add(search1);
		searchstu.add(search2);
		searchstu.add(search3);
		searchstu.add(search4);
		searchstu.add(search5);
		searchstu.add(search6);
		searchstu.add(search7);
		searchstu.add(search8);
		searchstu.add(search);
		help.add(something);
		something.setFont(font1);
		something.addActionListener(h);
		
		deletefabu.addActionListener(del);
		deletefabu.setFont(font1);
		fabu.setFont(font1);
		search1.setFont(font1);
		search2.setFont(font1);
		search3.setFont(font1);
		search4.setFont(font1);
		search5.setFont(font1);
		search6.setFont(font1);
		search7.setFont(font1);
		search8.setFont(font1);
		addstu.setFont(font1);
		deletestu.setFont(font1);
		searchstu.setFont(font1);
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
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			i = JOptionPane.showConfirmDialog(null, "退出系统","确认退出", JOptionPane.YES_NO_OPTION,JOptionPane.CLOSED_OPTION);
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
			 new EditView().admin(username);
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
	class Addstu implements ActionListener  //
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new AddStuView().init();
		}
	}
	class Seaname implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewname().init();
		}		
	}
	class Seagrade implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewgrade().init();
		}		
	}
	class Seagroup implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewgroup().init();
		}		
	}
	class Seaclass implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewclass().init();
		}		
	}
	class Seaaddress implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewadress().init();
		}		
	}
	class Seatel implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewtel().init();
		}		
	}
	class Seador implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewdor().init();
		}		
	}
	class Seamail implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new SelectViewmail().init();
		}		
	}
	class Deletestu implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new DeleteView().init();
		}
		
	}
	class Editstu implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new EditStudent().init();
		}	
	}
	class Searchall implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				new SearchStu().init();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	class FABU implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new FabuView().init();
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
	class delefabu implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new DeleteFabu().init();
		}	
	}
	class changefabu implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Changefabu().init();
		}	
	}
	class Help implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				new FileUtil();
				FileUtil.useAWTDesktop();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
