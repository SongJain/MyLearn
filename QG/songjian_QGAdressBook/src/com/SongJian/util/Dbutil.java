package com.SongJian.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//与数据库建立连接   BaseDao获取建立的连接   然后传给每个交互的model
public class Dbutil {
    static String URL ="jdbc:mysql://gz-cdb-0ymb7ubq.sql.tencentcdb.com:62736/qg_stu";//腾讯云数据库
	
    
    //private String dburl = "jdbc:mysql://localhost:3306/qg_addressbook?useUnicode=true&characterEncoding=utf8";
	private String dbUsername = "root";//用户
	private String dbPassword = "weiwei1216";//密码
	private String jdbcname = "com.mysql.jdbc.Driver";//驱动名称

	
	//获取数据库连接
	public Connection getcon()
	{
		try {
			Class.forName(jdbcname);      //加载驱动
		}catch(Exception e) {
			e.printStackTrace();    //打印异常
		}
		Connection con = null;
		
		try {//获取连接
			con = DriverManager.getConnection(URL, dbUsername, dbPassword);
		}catch(SQLException e) {
			e.printStackTrace();   //打印异常
		}
		return con;           //这个con是代表着连接对象，连接对话，
	}
	
	
	//关闭数据库连接
	public void closecon(Connection con)throws Exception
	{
		if(con != null)
		{
			con.close();          //关闭数据库
		}
	}
	
	//测试
	/*public static void main(String[] args)
	{
		Dbutil dbutil = new Dbutil();
		try {
			dbutil.getcon();
			System.out.println("数据库连接成功");
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println("数据库连接失败");
		}
		System.exit(0);                  //解决重定向错误，运行debug出错
	}*/
}