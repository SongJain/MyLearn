package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutmeView {
	JFrame f = new JFrame("关于开发者");
	JLabel label = new JLabel("物联网三班    宋健");
	JButton ok = new JButton("返回");
	JPanel pan = new JPanel();
	Font font1 =new Font("黑体", Font.PLAIN, 20);//设置字体
	public void init()
	{
		Return re = new Return();
		ok.addActionListener(re);
		
		
		pan.add(ok);
		pan.add(label);
		label.setFont(font1);
		ok.setFont(font1);
		pan.setLayout(null);
		ok.setBounds(120,100,80,35);
		label.setBounds(80,40,200,35);
		f.add(pan);
		f.setBounds(700,400,350,200);
		f.setVisible(true);		
	}
	
	class Return implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			f.dispose();
		}
		
	}
}
