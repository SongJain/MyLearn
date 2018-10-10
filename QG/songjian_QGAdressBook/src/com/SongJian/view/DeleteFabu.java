package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.SongJian.dao.AdminDao;

public class DeleteFabu {
	JPanel contentPanel = new JPanel();
	JFrame f = new JFrame("删除发布");
	JTextField text = new JTextField(45);
	JButton search = new JButton("删除");
	JButton returnto = new JButton("返回");
	JButton rewrite = new JButton("重新输入");
	JLabel label = new JLabel("输入推送id：");
	Font font =new Font("微软雅黑", Font.PLAIN, 18);
	Font font1 =new Font("微软雅黑", Font.PLAIN, 20);
	private int id;
	dele d = new dele();
	public void init()
	{
		search.addActionListener(d);
		contentPanel.setLayout(null);
		contentPanel.add(search);
		contentPanel.add(label);
		contentPanel.add(rewrite);
		contentPanel.add(text);
		contentPanel.add(returnto);
		returnto.setFont(font);
		label.setFont(font);
		text.setFont(font);
		search.setFont(font);
		rewrite.setFont(font);
		search.setBounds(200, 80, 70, 35);
		text.setBounds(170, 30, 200, 35);
		label.setBounds(60, 30, 200, 35);
		returnto.setBounds(100, 80, 70, 35);
		rewrite.setBounds(300, 80, 120, 35);				
		f.add(contentPanel);
		f.setBounds(700,400,500,180);				//固定frame大小
		f.setVisible(true);	
	}
	class dele implements ActionListener  //
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String text1 = text.getText().toString();
			try {
				new AdminDao().Deletefabu(text1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
