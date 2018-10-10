package com.SongJian.View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class mainView {
	JPanel contentPanel = new JPanel();
	 //定义frame
	JFrame f = new JFrame("人物关系系统");
	Font font =new Font("微软雅黑", Font.PLAIN, 20);//设置字体
	Font font1 =new Font("黑体", Font.PLAIN, 16);//设置字体
	  //菜单
	JMenuBar mb = new JMenuBar();
	JMenu caozuo = new JMenu("操作");
	JMenu add = new JMenu("新建关系");
	JMenuItem search = new JMenuItem("查询关系");
	JMenuItem exit = new JMenuItem("退出");	
	JMenuItem m1 = new JMenuItem("模式1");	
	JMenuItem m2 = new JMenuItem("模式2");	
	JMenuItem m3 = new JMenuItem("模式3");	
	 //按钮
	JButton sure = new JButton("确定");
	JButton cancel = new JButton("取消");
	JButton returnto = new JButton("返回");
	private int i;
	JLabel mm1 = new JLabel("模式1：<名字>是<名字>的<关系>");	
	JLabel mm2 = new JLabel("模式2：<名字>的<关系>是<名字>");	
	JLabel mm3 = new JLabel("模式3：<名字>的<关系>是<名字>的<关系>");	
	outListener out = new outListener();
	Mm1 mmm1 = new Mm1();
	Mm2 mmm2 = new Mm2();
	Mm3 mmm3 = new Mm3();
	Search s= new Search();
	
	public void mainView()
	{
		Add a = new Add();
		add.addActionListener(a);
		add.add(m1);
		m1.setFont(font);
		m1.addActionListener(mmm1);
		m2.addActionListener(mmm2);
		m3.addActionListener(mmm3);
		m2.setFont(font);
		m3.setFont(font);
		add.add(m2);
		add.add(m3);
		search.addActionListener(s);
		
		mm1.setFont(font);		
		mm1.setBounds(260, 30, 500, 35);
		mm2.setFont(font);		
		mm2.setBounds(260, 70, 500, 35);
		mm3.setFont(font);		
		mm3.setBounds(260, 110, 500, 35);
		search.setFont(font);
		mb.add(caozuo);
		mb.setFont(font);
		caozuo.setFont(font);
		caozuo.add(search);
		caozuo.add(exit);
		exit.setFont(font);
		exit.addActionListener(out);
		add.setFont(font);
		caozuo.add(add);
		contentPanel.setLayout(null);
		contentPanel.add(mm1);
		contentPanel.add(mm2);
		contentPanel.add(mm3);
		f.setJMenuBar(mb);
		f.add(contentPanel);
		f.setBounds(600,220,700,500);
		f.setVisible(true);
		
	}
	class Add implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new AddRelation().init();
		}
		
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
	class Mm1 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new AddRelation().init();
		}	
	}
	class Mm2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new AddRelation2().init();
		}	
	}
	class Mm3 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new AddRelation3().init();
		}	
	}
	class Search implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			f.dispose();
			new SearchView().init();
		}	
	}
}

