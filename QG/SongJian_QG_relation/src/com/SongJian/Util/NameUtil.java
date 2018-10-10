package com.SongJian.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class NameUtil {
	
	static String[] strcurrent;
	int c = 0;
	private static int count = 0;
	public String[] Name(String str)
	{
		String[] strfinally = {"a","b"};
		if(str.indexOf("的") < 0 || str.indexOf("是") < 0 )
		{
			JOptionPane.showMessageDialog(null,"含有非法语句，请检查文件！");
		}
		if(str.indexOf("爸爸") < 0 && str.indexOf("孙子") < 0 && str.indexOf("儿子") < 0 && str.indexOf("爷爷") < 0 && str.indexOf("哥哥") < 0 && str.indexOf("弟弟") < 0 && str.indexOf("兄弟") < 0 && str.indexOf("老师") < 0 && str.indexOf("学生") < 0 && str.indexOf("同学") < 0  )
		{
			JOptionPane.showMessageDialog(null,"含有非法语句，请检查文件！");
		}
		else
		{
			strcurrent = str.split("的");			
			for(int i = 0 , len = strcurrent.length ; i < len ; i++)
			{
				String strr[];
				strr = strcurrent[i].split("是");
				for(int k = 0 , lens = strr.length ; k < lens ; k++)
				{
					if(strr[k].equals("爸爸") || strr[k].equals("孙子") || strr[k].equals("儿子") || strr[k].equals("爷爷") || strr[k].equals("哥哥") || strr[k].equals("弟弟") || strr[k].equals("兄弟")|| strr[k].equals("老师")|| strr[k].equals("学生")|| strr[k].equals("同学"))
					{
						continue;
					}
					else
					{
							strfinally[c] = strr[k];
							c++;
							continue;
					}
				}
			}
		}
		return strfinally;
	}
	
				
	
	public int judgewho(String str)
	{
		strcurrent = str.split("的");
		for(int i = 0 , len = strcurrent.length ; i < len ; i++)
		{
			String strr[];
			strr = strcurrent[i].split("是");
			for(int k = 0 , lens = strr.length ; k < lens ; k++)
			{
				if(strr[k].equals("爸爸"))
				{
					return 1;
				}
				else if(strr[k].equals("爷爷"))
				{
					return 2;
				}
				else if(strr[k].equals("儿子"))
				{
					return 3;
				}
				else if(strr[k].equals("哥哥"))
				{
					return 4;
				}
				else if(strr[k].equals("弟弟"))
				{
					return 5;
				}
				else if(strr[k].equals("兄弟"))
				{
					return 6;
				}
				else if(strr[k].equals("老师"))
				{
					return 7;
				}
				else if(strr[k].equals("学生"))
				{
					return 8;
				}
				else if(strr[k].equals("同学"))
				{
					return 9;
				}
				else if(strr[k].equals("孙子"))
				{
					return 10;
				}
			}
		}
		return 10086;
	}
	
	public int judgefuction(String str)//判断类型
	{
		int de;
		int shi;
		de = str.indexOf("的");
		shi = str.indexOf("是");
		Pattern p = Pattern.compile("的",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);       
        while(m.find()){
              count ++;
        }		
        System.out.println("的 的个数："+count);
		if(de > shi && count == 1)                  //模式1：<名字>是<名字>的<关系>
		{
			count = 0;
			return 1;
		}
		else if(de < shi && count == 1)                  //模式2：<名字>的<关系>是<名字>
		{
			count = 0;
			return 2;
		}
		else if(count == 2)                          //模式3：<名字>的<关系>是<名字>的<关系>
		{
			count = 0;
			return 3;
		}
		count = 0;
		return 0;
	}
	
	/*public static void main(String args[])
	{
		String str = "小红的爸爸是小刚";
		judgefuction(str);
	}*/
}

