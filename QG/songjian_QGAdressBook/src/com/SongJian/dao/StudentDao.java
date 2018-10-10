package com.SongJian.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.SongJian.model.Student;

public class StudentDao extends BaseDao
{
	Student student1 = null;
	public Student login (Student student)
	{
		String sql = "select * from qg_stu where stuname = ? and stupassword = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1,student.getName());
			prst.setString(2,student.getPassword());
			ResultSet rs = prst.executeQuery();
			if(rs.next())
			{
				student1 = new Student();
				student1.setId(rs.getInt("id"));
				student1.setName(rs.getString("stuname"));
				student1.setPassword(rs.getString("stupassword"));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return student1;	
	}
	
	//学生修改密码
	public void reset(String username,String oldpassword,String newpassword)
	{
		int num;
		boolean cmp = compare(username ,oldpassword);
		if(cmp)
		{
			String sql = "update qg_stu set stupassword=\""+ newpassword +"\"where stuname=\""+username+"\""; 

			try {
				PreparedStatement prst = con.prepareStatement(sql);
				num = prst.executeUpdate(sql);
				if(num == 1) 
				{
					JOptionPane.showMessageDialog(null,"密码修改成功！");
					return;
				}
				con.close();
			}catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null, "密码修改失败！");
		        e.printStackTrace();
			}	
		}
	}
	
	public boolean compare(String name , String oldpassword)
	{
		boolean judge = false;
		String sql = "select stupassword from qg_stu where stuname=\""+name+"\"";
		try
		{
			PreparedStatement prst = con.prepareStatement(sql);
			ResultSet rs = prst.executeQuery();
			rs = prst.executeQuery(sql);
			if(rs.next())
			{
				String comp = rs.getString(1);
				if(comp.equals(oldpassword))
				{
					judge = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "密码错误！");
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "用户不存在");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return judge;
	}
}
		