package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.SongJian.dao.AdminDao;

public class FabuView {
	JFrame f = new JFrame("发布信息");
	Font font1 =new Font("黑体", Font.PLAIN, 18);//设置字体
	JButton log = new JButton("发布");
	JButton re = new JButton("返回");
	JTextArea ad = new JTextArea(10,60);
	JPanel contentPanel = new JPanel();
	FA f1 = new FA();
	public void init()
	{
		contentPanel.setLayout(null);
		log.setFont(font1);
		log.addActionListener(f1);
		ad.setFont(font1);
		re.setFont(font1);
		log.setBounds(200, 370,80, 30);
		ad.setBounds(90, 100,500,200 );
		re.setBounds(380, 370,80, 30);
		contentPanel.add(re);
		contentPanel.add(ad);
		ad.setLineWrap(true);
		contentPanel.add(log);
		f.add(contentPanel);
		f.setBounds(700,200,700,500);
		f.setVisible(true);
	}
	class FA implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String fabu;
			fabu = ad.getText().toString();
			try {
				new AdminDao().Fabu(fabu);
				f.dispose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	class Re implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			f.dispose();
		}
		
	}
}
