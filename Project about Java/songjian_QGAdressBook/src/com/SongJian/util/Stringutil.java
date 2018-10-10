package com.SongJian.util;

public class Stringutil
{
	public static boolean isEmpty(String str) //检测用户名输入
	{
		if(null == str || "".equals(str))
		{
			return true;
		}
		else 
			return false;
	}

}
