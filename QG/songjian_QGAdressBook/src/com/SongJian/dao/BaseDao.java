package com.SongJian.dao;

import java.sql.Connection;
import com.SongJian.util.Dbutil;


//创建一个与数据库连接的对象
public class BaseDao 
{
	public Connection con = new Dbutil().getcon();
}
