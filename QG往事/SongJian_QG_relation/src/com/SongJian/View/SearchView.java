package com.SongJian.View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.SongJian.Util.FileUtil;
import com.SongJian.Util.StringUtil;


public class SearchView {
	JFrame f = new JFrame("搜索关系");
	JButton sure = new JButton("确认");
	JButton reset = new JButton("重置");
	JButton returnto = new JButton("返回");
	JLabel name1 = new JLabel("名字1：");
	JLabel name2 = new JLabel("名字2：");
	Font font =new Font("微软雅黑", Font.PLAIN, 20);//设置字体	
	Font font1 =new Font("黑体", Font.PLAIN, 18);//设置字体
	
	JTextField textname1 = new JTextField();
	JTextField textname2 = new JTextField();
	JTextArea ad = new JTextArea(10,60);
	JPanel contentPanel = new JPanel();
	Reset res = new Reset();
	re r = new re();
	Sure su = new Sure();
	private File file = new File("FilesSave\\relation.txt");
	public void init()
	{
		contentPanel.setLayout(null);
		name1.setFont(font1);
		name2.setFont(font1);
		sure.setFont(font1);
		sure.addActionListener(su);
		reset.setFont(font1);
		reset.addActionListener(res);
		returnto.setFont(font1);
		returnto.addActionListener(r);
		textname2.setFont(font1);
		textname1.setFont(font1);
		ad.setFont(font);
		
		ad.setLineWrap(true);
		ad.setBounds(50, 160, 600, 200);
		ad.setEditable(false);
		sure.setBounds(30, 400, 100, 35);
		reset.setBounds(150, 400, 100, 35);
		returnto.setBounds(290, 400, 100, 35);
		textname2.setBounds(290, 80, 150, 35);
		textname1.setBounds(290, 30, 150, 35);
		name1.setBounds(150, 30, 100, 35);
		name2.setBounds(150, 80, 100, 35);
		
		contentPanel.add(ad);
		contentPanel.add(sure);
		contentPanel.add(returnto);
		contentPanel.add(reset);
		contentPanel.add(textname2);
		contentPanel.add(textname1);
		contentPanel.add(name1);
		contentPanel.add(name2);
		f.add(contentPanel);
		f.setBounds(600,220,700,500);
		f.setVisible(true);
	}
	
	class Reset implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			textname1.setText("");
			textname2.setText("");
		}			
	}
	class re implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			f.dispose();
			new mainView().mainView();
		}	
	}
	class Sure implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			String name1 = textname1.getText();
			String name2 = textname2.getText();
			if(StringUtil.isEmpty(name1) || StringUtil.isEmpty(name2))
			{
				JOptionPane.showMessageDialog(null,"名字栏不能为空");
			}
			else {
				new FileUtil();
				String s = FileUtil.readFileByLines(file, name1, name2);
				ad.setText(s);
			}
		}
		
	}

}
