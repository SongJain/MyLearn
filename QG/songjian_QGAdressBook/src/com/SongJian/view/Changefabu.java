package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.SongJian.dao.AdminDao;
import com.SongJian.model.FaBu;
import com.SongJian.util.Stringutil;
import com.mysql.jdbc.ResultSetMetaData;

public class Changefabu {
	JFrame f = new JFrame("接受信息");
	JButton k = new JButton("查找");
	JButton c = new JButton("更改");
	JButton h = new JButton("历史发布");
	JLabel l = new JLabel("查询发布id:");
	Font font1 =new Font("黑体", Font.PLAIN, 18);//设置字体
	JButton re = new JButton("返回");
	JTextField text = new JTextField();
	JTextArea ad = new JTextArea(10,60);
	JPanel contentPanel = new JPanel();
	Re r = new Re();
	Search se = new Search();
	K s = new K();
	EDit e = new EDit();
	private int id;
	public void init()
	{
		contentPanel.setLayout(null);
		c.addActionListener(e);
		h.addActionListener(se);
		re.addActionListener(r);
		k.addActionListener(s);
		ad.setFont(font1);
		c.setFont(font1);
		re.setFont(font1);
		k.setFont(font1);
		l.setFont(font1);
		h.setFont(font1);
		text.setFont(font1);
		k.setBounds(320, 50,80,30 );
		h.setBounds(450, 50,120,30 );
		c.setBounds(400, 370,80, 30);
		text.setBounds(200, 50,80,30 );
		l.setBounds(90, 50,150,30 );
		ad.setBounds(90, 100,500,200 );
		re.setBounds(280, 370,80, 30);
		contentPanel.add(k);
		contentPanel.add(c);
		contentPanel.add(h);
		contentPanel.add(text);
		contentPanel.add(l);
		contentPanel.add(re);
		contentPanel.add(ad);
		ad.setLineWrap(true);
		f.add(contentPanel);
		f.setBounds(700,200,700,500);
		f.setVisible(true);
	}
	class Re implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			f.dispose();
		}
		
	}
	class Search implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				ResultSet rs = new AdminDao().getid();
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
				table.setFont(font1);
				JScrollPane js =new JScrollPane(table);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setRowSelectionAllowed(true);
				table.getColumnModel().getColumn(0).setPreferredWidth(300);							
				js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				jf.add(js);
				jf.setVisible(true);
				jf.setBounds(650,250,300,600);					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class K implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String texti = text.getText();
			FaBu fa = new FaBu();
			if(Stringutil.isEmpty(texti))
			{
				JOptionPane.showMessageDialog(null, "请填写id");
			}
			else
			{								
				if(isInteger(texti))
				{	
					id = Integer.parseInt(texti);
					fa = new AdminDao().getidinfo(id);	
					texti = fa.getFabu();
					ad.setText(texti);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "id必须为数字");
				}
				
			}
		}
		
	}
	public static boolean isInteger(String str)
	{  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
    }
	class EDit implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String textt = ad.getText();
			new AdminDao().updatefabu(id, textt);
		}
		
	}
	
}
