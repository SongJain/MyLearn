package com.SongJian.util;


import java.io.IOException;

public class FileUtil {
	public static void useAWTDesktop() throws IOException       //打开说明文档
	{
		String etCommand = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\WINWORD.EXE";  
        String filePath = "说明文档\\qg学生管理系统.docx";  
        Runtime.getRuntime().exec(etCommand + " " + filePath);
	}
	/*public static void excel() throws IOException
	{
		String etCommand = "‪C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\EXCEL.EXE";  
        String filePath = "学生信息导出表格\\QG学生信息表.xls";  
        Runtime.getRuntime().exec(etCommand + " " + filePath);
	}*/
}

