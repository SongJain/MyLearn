package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.SongJian.dao.AdminDao;
import com.SongJian.util.Stringutil;


public class EditStudent {
	JPanel contentPanel = new JPanel();
	JFrame f = new JFrame("修改成员信息");
	Font font1 =new Font("黑体", Font.PLAIN, 20);
	JLabel idtext = new JLabel("请输入学生id：");
	JButton ok = new JButton("确定");
	JButton returnto = new JButton("返回");
	JButton rewrite = new JButton("重新输入");
	JTextField text = new JTextField();
	private int id;
	public void init()
	{
		Return re =new Return();
		Rewrite rew = new Rewrite();
		Ok o = new Ok();
		ok.addActionListener(o);
				
		returnto.addActionListener(re);
		rewrite.addActionListener(rew);
		idtext.setFont(font1);
		text.setFont(font1);
		ok.setFont(font1);
		returnto.setFont(font1);
		rewrite.setFont(font1);
		
		contentPanel.setLayout(null);
		idtext.setBounds(50, 50, 500, 35);
		rewrite.setBounds(300, 100, 130, 35);
		text.setBounds(200, 50, 200, 35);
		ok.setBounds(80, 100, 80, 35);
		returnto.setBounds(190, 100, 80, 35);
		contentPanel.add(rewrite);
		contentPanel.add(returnto);
		contentPanel.add(text);
		contentPanel.add(ok);
		contentPanel.add(idtext);
		f.add(contentPanel);
		f.setBounds(700,400,500,210);
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
	class Rewrite implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			text.setText("");
		}		
	}
	class Ok implements ActionListener            //确认按键！！！！！！！！！
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String texti = text.getText();
			if(Stringutil.isEmpty(texti))
			{
				JOptionPane.showMessageDialog(null, "请填写id");
			}
			else
			{								
				if(isInteger(texti))
				{	
					id = Integer.parseInt(texti);
					boolean j = new AdminDao().judgeid(id);
					if(j)
					{	
					new EditStudent2().init(id);
					f.dispose();
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "id必须为数字");
				}
				
			}		
		}		
	}
	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
  }
}
	
