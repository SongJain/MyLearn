package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.jar.JarFile;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.TableView;

import com.SongJian.dao.AdminDao;
import com.SongJian.util.Excel;
import com.SongJian.util.FileUtil;
import com.mysql.jdbc.ResultSetMetaData;

public class SearchStu {
	Font font =new Font("微软雅黑", Font.PLAIN, 18);
	Font font1 =new Font("微软雅黑", Font.PLAIN, 20);
	JMenuBar mb = new JMenuBar();
	JMenu k = new JMenu("操作");
	JMenuItem o = new JMenuItem("导出EXCEL");
	/*JMenuItem dao = new JMenuItem("打开EXCEL");*/
	JFrame jf = new JFrame("查找成员");	
	Dao d = new Dao();
	//open p = new open();
	public JTable table;
	public void init() throws SQLException
	{		
			ResultSet rs = new AdminDao().searchStu();
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
			JFrame jf = new JFrame("查找成员");	
			jf.setJMenuBar(mb);
			mb.add(k);
			k.add(o);
			o.addActionListener(d);
			///k.add(dao);
			//dao.addActionListener(p);
			table = new JTable(data , colname);
			table.setFont(font);
			k.setFont(font1);
			o.setFont(font1);
			//dao.setFont(font1);
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
	}
	class Dao implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			File file = new File("学生信息导出表格\\QG学生信息表.xls");
			try {
				new Excel();
				Excel.exportTable(table, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	/*class open implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new FileUtil();
			// TODO Auto-generated method stub
			try {
				FileUtil.excel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}*/
}

