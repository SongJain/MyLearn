package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.SongJian.dao.AdminDao;
import com.mysql.jdbc.ResultSetMetaData;

public class SelectViewclassstu {
	JPanel contentPanel = new JPanel();
	JFrame f = new JFrame("查找成员");
	JTextField text = new JTextField(45);
	JButton search = new JButton("查询");
	JButton returnto = new JButton("返回");
	JButton rewrite = new JButton("重新输入");
	JLabel label = new JLabel("输入关键字：");
	Font font =new Font("微软雅黑", Font.PLAIN, 18);
	Font font1 =new Font("微软雅黑", Font.PLAIN, 20);
	public void init()
	{
		Rewrite rew = new Rewrite();
		rewrite.addActionListener(rew);
		Search se = new Search();
		search.addActionListener(se);
		Return re = new Return();
		returnto.addActionListener(re);
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
	
	class Search implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String searchtext = text.getText();
			try {
				ResultSet rs = new AdminDao().selectstuclass(searchtext);
				ResultSetMetaData rd = (ResultSetMetaData) rs.getMetaData();
				Vector<String> colname = new Vector<>();
				Vector<Vector<String>> data = new Vector<>();
				for(int i = 0 ;i < rd.getColumnCount() ; i++)
				{
					colname.add(rd.getColumnName(i+1));
				}
				while(rs.next())
				{
					Vector<String> v = new Vector<>();
					for(int i = 0 ;i<rd.getColumnCount();i++)
					{
						v.add(rs.getString(i+1));
					}
					data.add(v);
				}				
				JFrame jf = new JFrame();								
				JTable table = new JTable(data , colname);
				table.setFont(font);
				JScrollPane js =new JScrollPane(table);
				table.setFont(font);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setRowSelectionAllowed(true);
				table.getColumnModel().getColumn(0).setPreferredWidth(150);
				table.getColumnModel().getColumn(1).setPreferredWidth(150);
				table.getColumnModel().getColumn(2).setPreferredWidth(150);
				table.getColumnModel().getColumn(3).setPreferredWidth(150);
				table.getColumnModel().getColumn(4).setPreferredWidth(250);
				table.getColumnModel().getColumn(5).setPreferredWidth(250);
				table.getColumnModel().getColumn(6).setPreferredWidth(250);
				table.getColumnModel().getColumn(7).setPreferredWidth(250);
				table.getColumnModel().getColumn(8).setPreferredWidth(250);
				table.getColumnModel().getColumn(9).setPreferredWidth(180);								
				js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				jf.add(js);
				jf.setVisible(true);
				jf.setBounds(650,250,600,600);					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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

}
