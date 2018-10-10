package com.SongJian.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

import com.SongJian.model.Admin;
import com.SongJian.model.FaBu;
import com.SongJian.model.Student;

public class AdminDao extends BaseDao {
	public Admin login(Admin admin)
	{
		Admin admin1 = null;
		String sql = "select * from qg_admin where name = ? and password = ?";
		try {
			//把SQL语句全给对象
			PreparedStatement prst = con.prepareStatement(sql);   //通过connection对象创建statement对象
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet rs = prst.executeQuery();  //使用statement执行sql语句,返回查询到的结果集
			if(rs.next())
			{
				admin1 = new Admin();
				admin1.setId(rs.getInt("id"));
				admin1.setName(rs.getString("name"));
				admin1.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return admin1;		
	}
	
	public void reset(String username,String oldpassword,String newpassword)
	{
		int num;
		boolean cmp = compare(username ,oldpassword);
		if(cmp)
		{
			String sql = "update qg_admin set password=\""+ newpassword +"\"where name=\""+username+"\""; 

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
		String sql = "select password from qg_admin where name=\""+name+"\"";
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
	
	public void addstu(String name,String grade,String group,String clas,String tel,String email,String dor,String address )
	{
		int num;
		String sql = "insert into qg_stu (id,stuname,stutel,stuaddress,studormitory,stuemail,stugroup,stugrade,stuclass,stupassword) values (null,'"+name+"','"+tel+"','"+address+"','"+dor+"','"+email+"','"+group+"','"+grade+"','"+clas+"','123')";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			num = prst.executeUpdate(sql);
			if(num == 1) 
			{
				JOptionPane.showMessageDialog(null,"添加成功！");
				return;
			}
			con.close();
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "添加失败！");
	        e.printStackTrace();
		}
	}
	
	public ResultSet selectstuname (String text) throws SQLException
	{
		String sqlname = "SELECT * FROM qg_stu WHERE Stuname like '%"+text+"%'";		
		PreparedStatement prst1 = con.prepareStatement(sqlname);
		ResultSet rsname = prst1.executeQuery(sqlname);
		return rsname;
}
	public ResultSet selectstugrade (String text) throws SQLException
	{
		String sqlgrade = "SELECT * FROM qg_stu WHERE Stugrade like '%"+text+"%'";
		PreparedStatement prst2 = con.prepareStatement(sqlgrade);
		ResultSet rsgrade = prst2.executeQuery(sqlgrade);
		return rsgrade;
	}
	public ResultSet selectstugroup (String text) throws SQLException
	{
		String sqlgroup = "SELECT * FROM qg_stu WHERE Stugroup like '%"+text+"%'";
		PreparedStatement prst2 = con.prepareStatement(sqlgroup);
		ResultSet rsgroup = prst2.executeQuery(sqlgroup);
		return rsgroup;
	}
	public ResultSet selectstuaddress (String text) throws SQLException
	{
		String sqladdress = "SELECT * FROM qg_stu WHERE Stuaddress like '%"+text+"%'";
		PreparedStatement prst2 = con.prepareStatement(sqladdress);
		ResultSet rsaddress = prst2.executeQuery(sqladdress);
		return rsaddress;
	}
	public ResultSet selectstumail (String text) throws SQLException
	{
		String sqlmail = "SELECT * FROM qg_stu WHERE Stuemail like '%"+text+"%'";
		PreparedStatement prst2 = con.prepareStatement(sqlmail);
		ResultSet rsmail = prst2.executeQuery(sqlmail);
		return rsmail;
	}
	public ResultSet selectstutel (String text) throws SQLException
	{
		String sqltel = "SELECT * FROM qg_stu WHERE Stutel like '%"+text+"%'";
		PreparedStatement prst2 = con.prepareStatement(sqltel);
		ResultSet rstel = prst2.executeQuery(sqltel);
		return rstel;
	}
	public ResultSet selectstudor (String text) throws SQLException
	{
		String sqldor = "SELECT * FROM qg_stu WHERE Studormitory like '%"+text+"%'";
		PreparedStatement prst2 = con.prepareStatement(sqldor);
		ResultSet rsdor = prst2.executeQuery(sqldor);
		return rsdor;
	}
	public ResultSet selectstuclass (String text) throws SQLException
	{
		String sqlclass = "SELECT * FROM qg_stu WHERE Stuclass like '%"+text+"%'";
		PreparedStatement prst2 = con.prepareStatement(sqlclass);
		ResultSet rsclass = prst2.executeQuery(sqlclass);
		return rsclass;
	}
	
	public void Deletestudent(String text) throws SQLException
	{
		int num;
		int a = Integer.parseInt(text);   //转换整数
		boolean cmp = compareid(a);
		String sql = "delete FROM qg_stu WHERE id ='"+a+"'";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			num = prst.executeUpdate(sql);
			if(cmp) 
			{
				if(num == 1) 
				{
					JOptionPane.showMessageDialog(null,"删除成功！");
					return;
				}
				con.close();
			}
			}catch(SQLException e)
			{
				JOptionPane.showMessageDialog(null, "删除失败！");
		        e.printStackTrace();
			}
		}
	public boolean compareid(int id) throws SQLException
	{
		boolean judge = false;
		String sql = "select * from qg_stu where id=\""+id+"\"";
		PreparedStatement prst = con.prepareStatement(sql);
		ResultSet rs = prst.executeQuery();
		rs = prst.executeQuery(sql);
		if(rs.next())
		{
			judge = true;
			return judge;
		}
		else
		{
			JOptionPane.showMessageDialog(null,"该id不存在！");
			return judge;
		}
	}
	
	public Student getinfo(int id)
	{
		Student student1 = null;
		String sql = "select stuname,stutel,stuaddress,studormitory,stuemail,stuclass,stugrade,stugroup from qg_stu where id=\""+id+"\"";
		try {
			//把SQL语句全给对象
			PreparedStatement prst = con.prepareStatement(sql);   //通过connection对象创建statement对象			
			ResultSet rs = prst.executeQuery();  //使用statement执行sql语句,返回查询到的结果集
			if(rs.next())
			{
				student1 = new Student();
				student1.setName(rs.getString("stuname"));
				student1.setAdress(rs.getString("stuaddress"));
				student1.setDormitory(rs.getString("studormitory"));
				student1.setEmail(rs.getString("stuemail"));
				student1.setClas(rs.getString("stuclass"));
				student1.setGrade(rs.getString("stugrade"));
				student1.setGroup(rs.getString("stugroup"));
				student1.setTel(rs.getString("stutel"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return student1;		
	}
	
	
	public void update(int id ,String name,String grade,String group,String clas,String tel,String email,String dor,String address )
	{
		int num;
		String sql = "update qg_stu set stuname = '"+name+"',stugrade = '"+grade+"',stugroup = '"+group+"',stuclass = '"+clas+"',stutel = '"+tel+"',stuemail = '"+email+"',studormitory = '"+dor+"',stuaddress = '"+address+"'where id = '"+id+"'";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			num = prst.executeUpdate(sql);
			if(num == 1) 
			{
				JOptionPane.showMessageDialog(null,"修改成功！");
				return;
			}
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "修改失败！");
	        e.printStackTrace();
		}
	}
	public boolean judgeid(int id)          //修改用户检测id
	{
		boolean j = false;
		String sql = "select * from qg_stu where id = \""+id+"\"";
		try
		{
			PreparedStatement prst = con.prepareStatement(sql);
			ResultSet rs = prst.executeQuery();
			rs = prst.executeQuery(sql);
			if(rs.next())
			{
					j = true;
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "用户不存在");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return j;
	}
	public ResultSet searchStu () throws SQLException
	{
		String sql = "SELECT * FROM qg_stu";
		PreparedStatement prst2 = con.prepareStatement(sql);
		ResultSet rsdor = prst2.executeQuery(sql);
		return rsdor;
	}
	public void Fabu(String fabu) throws SQLException
	{
		int num;
		String sql = "insert into qg_fabu (id,fabu) values (null, '"+fabu+"')";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			num = prst.executeUpdate(sql);
			if(num == 1) 
			{
				JOptionPane.showMessageDialog(null,"发布成功！");
				return;
			}
			con.close();
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "发布失败！");
	        e.printStackTrace();
		}
	}
	public ResultSet getid() throws SQLException
	{
		String sql = "select id from qg_fabu";
		PreparedStatement prst = con.prepareStatement(sql);
		ResultSet rs = prst.executeQuery(sql);
		return rs;
	}
	public FaBu getidinfo(int id)
	{
		FaBu Fa = new FaBu();
		String sql = "select * from qg_fabu where id=\""+id+"\"";
		try {
			//把SQL语句全给对象
			PreparedStatement prst = con.prepareStatement(sql);   //通过connection对象创建statement对象			
			ResultSet rs = prst.executeQuery();  //使用statement执行sql语句,返回查询到的结果集			
			
			if(rs.next())
			{
				Fa.setFabu(rs.getString("fabu"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return Fa;		
	}
	
	public void Deletefabu(String text) throws SQLException
	{
		int num;
		int a = Integer.parseInt(text);   //转换整数
		String sql = "delete FROM qg_fabu WHERE id ='"+a+"'";
		PreparedStatement prst = con.prepareStatement(sql);
		num = prst.executeUpdate(sql);
		if(num == 1) 
		{
			JOptionPane.showMessageDialog(null,"删除成功！");
			return;
		}
		else 
		{
			JOptionPane.showMessageDialog(null,"删除失败！");
			return;
		}
	}	
	
	public void updatefabu(int id,String text )
	{
		int num;
		String sql = "update qg_fabu set fabu = '"+text+"' where id = '"+id+"'";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			num = prst.executeUpdate(sql);
			if(num == 1) 
			{
				JOptionPane.showMessageDialog(null,"修改成功！");
				return;
			}
		}catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "修改失败！");
	        e.printStackTrace();
		}
	}
}


