package com.SongJian.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import com.SongJian.Util.Linked.LinkedNode;

public class FileUtil 
{
	private static LinkedNode head;  //头节点
	private static String name1;
	private static String name2;
	private static String rel;
	private static String result1;   //结果1
	private static String result2;   //结果
	private static Linked L = new Linked();
	private static String[] name;     //保存返回的名字
	private static int judge;         //选择角色
	private static int fuction;       //选择方程
	
	
	
	//1、新建文件到FilesSave
	public static File CreatNewFile() {
	File myFilePath = new File("FilesSave\\relation.txt");     //指定文件路径
	try {   
	    if (!myFilePath.exists()) {   
	        myFilePath.createNewFile();           //创建文件
	    }   
	    /*FileWriter resultFile = new FileWriter(myFilePath);   
	    PrintWriter myFile = new PrintWriter(resultFile);   
	    myFile.println("12sss3");   
	    resultFile.close();*/
	    return myFilePath;
	}   
	catch (Exception e) {   
	    System.out.println("新建文件操作出错");   
	    e.printStackTrace();   
		}
	return myFilePath;
	}

	//2、读取文件
	public static String readFileByLines(File file,String nameone , String nametwo) {
        //File file = new File(fileName);
		head = new Linked().init(head); 
        BufferedReader reader = null;
        try {
            //System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
            	name = null;
            	NameUtil n = new NameUtil();
        		fuction = n.judgefuction(tempString);//获取方程类型
        		judge = n.judgewho(tempString);//获取角色       		
        		Linked L = new Linked();
        		Fuction3Util f= new Fuction3Util();
        		int job = f.job(tempString);           	
        		if(line == 1)//第一行，要初始化链表
            	{          	
            			if(fuction == 1) //方程类型1
            			{
            				name = n.Name(tempString);
            				if(judge == 1)//爸爸
            				{
            					LinkedNode father = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.father = father;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, father);  
            				}
            				if(judge == 2)//爷爷
            				{
            					LinkedNode grandpa = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					grandpa.grandson = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            				}
            				if(judge == 3)//儿子
            				{
            					LinkedNode son = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					son.father = frist1;
            					frist1.son = son;
            					L.add(head, frist1);
            					L.add(head, son);  
            				}
            				if(judge == 4)//哥哥
            				{
            					LinkedNode brother = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					frist1.bigbro = brother;
            					brother.littbro = frist1;
            					L.add(head, frist1);
            					L.add(head, brother);  
            				}
            				if(judge == 5)//弟弟
            				{
            					LinkedNode brother = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					brother.bigbro = frist1;
            					frist1.littbro = brother;
            					L.add(head, frist1);
            					L.add(head, brother); 
            				}
            				if(judge == 6)//兄弟
            				{
            					LinkedNode brother = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					brother.brother = frist1;
            					frist1.brother = brother;
            					L.add(head, frist1);
            					L.add(head, brother); 
            				}
            				if(judge == 7)
            				{
            					LinkedNode teacher = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					teacher.stu = frist1;
            					frist1.teacher = teacher;
            					L.add(head, frist1);
            					L.add(head, teacher);
            				}
            				if(judge == 8)
            				{
            					LinkedNode stu = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode tea = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					tea.stu = stu;
            					stu.teacher = tea;
            					L.add(head, tea);
            					L.add(head, stu);
            				}
            				if(judge == 9)
            				{
            					LinkedNode stu0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode stu1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					stu0.classmates = stu1;
            					stu1.classmates = stu0;
            					L.add(head, stu0);
            					L.add(head, stu1);
            				}
            				if(judge == 10)
            				{
            					LinkedNode sunzi = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode yeye = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					sunzi.grandpa = yeye;
            					L.add(head, sunzi);
            					L.add(head, yeye);
            				}
            				
            			}
            			if(fuction == 2) //方程类型2
            			{
            				name = n.Name(tempString);
            				if(judge == 1)//爸爸
            				{
            					LinkedNode father = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.father = father;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, father);  
            				}
            				if(judge == 2)//爷爷
            				{
            					LinkedNode grandpa = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					grandpa.grandson = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            				}
            				if(judge == 3)//儿子
            				{
            					LinkedNode son = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					son.father = frist1;
            					frist1.son = son;
            					L.add(head, frist1);
            					L.add(head, son);  
            				}
            				if(judge == 4)//哥哥
            				{
            					LinkedNode brother = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					frist1.bigbro = brother;
            					brother.littbro = frist1;
            					L.add(head, frist1);
            					L.add(head, brother);  
            				}
            				if(judge == 5)//弟弟
            				{
            					LinkedNode brother = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					brother.bigbro = frist1;
            					frist1.littbro = brother;
            					L.add(head, frist1);
            					L.add(head, brother); 
            				}
            				if(judge == 6)//兄弟
            				{
            					LinkedNode brother = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					brother.brother = frist1;
            					frist1.brother = brother;
            					L.add(head, frist1);
            					L.add(head, brother); 
            				}
            				if(judge == 7)
            				{
            					LinkedNode teacher = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					teacher.stu = frist1;
            					frist1.teacher = teacher;
            					L.add(head, frist1);
            					L.add(head, teacher);
            				}
            				if(judge == 8)
            				{
            					LinkedNode stu = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode tea = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					tea.stu = stu;
            					stu.teacher = tea;
            					L.add(head, tea);
            					L.add(head, stu);
            				}
            				if(judge == 9)
            				{
            					LinkedNode stu0 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode stu1 = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					stu0.classmates = stu1;
            					stu1.classmates = stu0;
            					L.add(head, stu0);
            					L.add(head, stu1);
            				}
            				if(judge == 10)
            				{
            					LinkedNode sunzi = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode yeye = new LinkedNode(name[0],null,null,null, null, null, null, null, null, null, null, null);
            					sunzi.grandpa = yeye;
            					L.add(head, sunzi);
            					L.add(head, yeye);
            				}
            				
            			}
            			if(fuction == 3)
            			{
            				name = n.Name(tempString);
            				if(job == 1)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					k1.brother =k0;
            					//k1.brother = k0;
            					L.add(head, k0);
            					L.add(head, k1);
            					System.out.println("1爸爸和爸爸");
            				}
            				if(job == 2)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					k0.son =k1;
            					k1.father = k0;
            					L.add(head, k0);
            					L.add(head, k1);
            					System.out.println("1爸爸和爷爷");
            				}
            				if(job == 3)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					k0.grandpa = k1;
            					k1.grandson = k0;
            					L.add(head, k0);
            					L.add(head, k1);
            					System.out.println("1爸爸和儿子");
            				}
            				if(job == 4)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//匿名者表示未知名字的人
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.grandson = k2;
            					k2.grandpa = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1爸爸和孙子");
            				}
            				if(job == 5)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//匿名者表示未知名字的人
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.bigbro = k2;
            					k2.littbro = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1爸爸和哥哥");          					
            				}
            				if(job == 6)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//匿名者表示未知名字的人
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.littbro = k2;
            					k2.bigbro = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1爸爸和弟弟");
            				}
            				if(job == 7)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//匿名者表示未知名字的人
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.stu = k2;
            					k2.teacher = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1爸爸和学生");
            				}
            				if(job == 8) 
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//匿名者表示未知名字的人
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.teacher = k2;
            					k2.stu = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1爸爸和老师");
            				}
            				if(job == 9)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//匿名者表示未知名字的人
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.classmates = k2;
            					k2.classmates = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1爸爸和同学");
            				}
            				if(job == 10)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//匿名者表示未知名字的人
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.father = k2;
            					k2.son = k0;
            					k1.brother = k2;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1爸爸和兄弟");
            				}
            				if(job == 11)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					k0.grandson = k1;
            					k1.grandpa = k0;
            					L.add(head, k0);
            					L.add(head, k1);
            					System.out.println("1儿子和爸爸");
            				}
            				if(job == 12)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode k2 = new LinkedNode("unknown",null,null,null, null, null, null, null, null, null, null, null);
            					L.add(head, k2);
            					L.add(head, k0);
            					L.add(head, k1);
            					k0.son = k2;
            					k2.father = k0;
            					k1.grandpa = k2;
            					k2.grandson = k1;
            					System.out.println("1儿子和爷爷");
            				}
            				if(job == 13)
            				{
            					JOptionPane.showMessageDialog(null,"人物关系错误(儿子对应多个爸爸)，请检查文件！");	
            				}
            				if(job == 14)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					L.add(head, k1);
            					L.add(head, k0);
            					k0.father = k1;
            					k1.son = k0;
            					System.out.println("1儿子和孙子");
            				}
            				if(job == 15)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode k2 = new LinkedNode("unknown",null,null,null, null, null, null, null, null, null, null, null);
            					L.add(head, k2);
            					L.add(head, k0);
            					L.add(head, k1);
            					k0.son = k2;
            					k2.father = k0;
            					k1.bigbro = k2;
            					k2.littbro = k1;
            					System.out.println("1儿子和哥哥");
            				}
            				if(job == 16)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					LinkedNode k2 = new LinkedNode("unknown",null,null,null, null, null, null, null, null, null, null, null);
            					L.add(head, k2);
            					L.add(head, k0);
            					L.add(head, k1);
            					k0.son = k2;
            					k2.father = k0;
            					k1.littbro = k2;
            					k2.bigbro = k1;
            					System.out.println("1儿子和弟弟");
            				}
            				if(job == 17)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//匿名者表示未知名字的人
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.son = k2;
            					k2.father = k0;
            					k1.stu = k2;
            					k2.teacher = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1儿子和学生");
            				}
            				if(job == 18)
            				{
            					LinkedNode k0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode k1 = new LinkedNode(name[1],null,null,null, null, null, null, null, null, null, null, null);
            					//匿名者表示未知名字的人
            					LinkedNode k2 = new LinkedNode("unknown",null, null,null,null, null, null, null, null, null, null, null);
            					k0.son = k2;
            					k2.father = k0;
            					k1.teacher = k2;
            					k2.stu = k1;
            					L.add(head, k0);
            					L.add(head, k1);
            					L.add(head, k2);
            					System.out.println("1儿子和老师");
            				}
            				else
            				{
            					System.out.println("wrong!");
            				}
            				
            			}
            	}
            	
            	//除去第一行，就不用初始化了
            	else
            	{
            		if(fuction == 1) //方程类型1
        			{
            			name = n.Name(tempString);
        				if(judge == 1)//爸爸
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{       	
        						if(L.isExist(head, name[1]).father.name.equals("unknown"))//爸爸是匿名者
        						{
        							L.isExist(head, name[1]).father.name = name[0];
        						}
        						else if(L.isExist(head, name[1]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(父子)矛盾，请检查文件！");
        						}
        						L.isExist(head, name[1]).father = L.isExist(head, name[0]);
        						System.out.println("父子两个都有了");
        					}
        					else if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//爸爸已经有了
        					{
        						if(L.isExist(head, name[1]).father.name.equals("unknown"))//爸爸是匿名者
        						{
        							L.isExist(head, name[1]).father.name = name[0];
        						}
        						else
        						{
        							LinkedNode frist1 = new LinkedNode(name[1],null,null,null,null, null, null, null, null, null, null, null);
            						frist1.father = L.isExist(head, name[0]);
            						L.add(head, frist1);
            						System.out.println("爸爸已经有了");
        						}
        						
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
        					{
        						LinkedNode father = new LinkedNode(name[0],null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.father = father;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, father);  
            					System.out.println("两个都没有");
        					}  
        					else if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)
        					{
        						while(L.isExist(head, name[1]).brother != null)
        						{
        							if(L.isExist(head, name[1]).brother.father != null)
        							{
        								JOptionPane.showMessageDialog(null,"人物关系(父子)矛盾，请检查文件！");
        							}
        							L.isExist(head, name[1]).brother = L.isExist(head, name[1]).brother.brother;
        						}
        						if(L.isExist(head, name[1]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(父子)矛盾，请检查文件！");
        						}
        						else
        						{
        							LinkedNode father = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            						L.isExist(head, name[1]).father = father;
            						//father.son = L.isExist(head, name[1]);
            						L.add(head, father);
            						System.out.println("儿子已经有了");
        						}       						
        					}
        				}
        				if(judge == 2)//爷爷
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{       		
        						if(L.isExist(head, name[1]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(爷孙)矛盾，请检查文件！");
        						}
        						L.isExist(head, name[1]).grandpa = L.isExist(head, name[0]);
        						System.out.println("两个都有了");
        					}
        					else if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//爷爷已经有了
        					{
        						LinkedNode frist1 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
        						frist1.grandpa = L.isExist(head, name[0]);
        						L.add(head, frist1);
        						System.out.println("爷爷已经有了");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
        					{
        						
        						LinkedNode grandpa = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            					System.out.println("两个都没有");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
        					{
        						if(L.isExist(head, name[1]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(爷孙)矛盾，请检查文件！");
        						}
        						else
        						{
        							LinkedNode grandpa = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            						L.isExist(head, name[1]).grandpa = grandpa;
            						//grandpa.grandson = L.isExist(head, name[1]);
            						L.add(head, grandpa);
            						System.out.println("孙子已经有了");
        						}				
        					}
        				}
        				if(judge == 3)//儿子
            			{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{
        						if(L.isExist(head, name[1]).son != null)
        						{
        							if(L.isExist(head, name[1]).son.name.equals("unknown"))
        							{
        								L.isExist(head, name[1]).son.name = name[0];
        							}
        						}
        						else if(L.isExist(head, name[0]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(父子)矛盾，请检查文件！");
        						}
        						else
        						{
        							L.isExist(head, name[0]).father = L.isExist(head, name[1]);
            						System.out.println("两个都有了");
        						}			
        					}
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//儿子已经有了
            				{
            					if(L.isExist(head, name[0]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(父子)矛盾，请检查文件！");
        						}
            					else
            					{
            						LinkedNode frist1 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            						frist1.son = L.isExist(head, name[0]);
            						L.add(head, frist1);
            						System.out.println("儿子已经有了");
            					}           					
            				}
            				else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
            				{
            					LinkedNode son = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                				LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				//frist1.son = son;
                				frist1.son = son; 
                				L.add(head, frist1);
                				L.add(head, son);  
                				System.out.println("两个都没有");
            				}
            				else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
            				{
            					if(L.isExist(head, name[1]).son != null)
        						{
        							if(L.isExist(head, name[1]).son.name.equals("unknown"))
        							{
        								L.isExist(head, name[1]).son.name = name[0];
        							}
        						}
            					else
            					{
            						LinkedNode son = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                					son.father = L.isExist(head, name[1]);
                					L.add(head, son);
                					System.out.println("爸爸已经有了");
            					}
            				}
            			}
            			if(judge == 4)//哥哥
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{       		
        						System.out.println("两个都有了");
        						if(L.isExist(head, name[0]).bigbro == L.isExist(head, name[1]) || L.isExist(head, name[1]).littbro == L.isExist(head, name[0])) {
        							JOptionPane.showMessageDialog(null,"人物关系(哥哥弟弟)矛盾，请检查文件！");
            						break;//不加这个真的会死循环
        						}
            					if(L.isExist(head, name[1]).bigbro != null && L.isExist(head, name[0]).littbro == null)
            					{
            						L.isExist(head, name[0]).littbro =L.isExist(head, name[1]);
            					}
            					if(L.isExist(head, name[1]).bigbro == null && L.isExist(head, name[0]).littbro != null)
            					{
            						L.isExist(head, name[1]).bigbro =L.isExist(head, name[0]);
            					}
            					if(L.isExist(head, name[1]).bigbro != null && L.isExist(head, name[0]).littbro != null)
            					{
            						LinkedNode bro = L.isExist(head, name[0]).littbro;
            						while(bro != null)
            						{
            							bro = bro.littbro;
            						}
            						bro = L.isExist(head, name[1]);
            					}
            					else
            					{
            						L.isExist(head, name[1]).bigbro =L.isExist(head, name[0]);
            					}						
        					}
            				
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//哥哥已经有了
                			{
                				LinkedNode frist1 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                				frist1.bigbro = L.isExist(head, name[0]);
                				L.add(head, frist1);
                				System.out.println("哥哥已经有了");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
                			{
                				LinkedNode bigbro = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.bigbro = bigbro; 
                    			L.add(head, frist1);
                    			L.add(head, bigbro);  
                    			System.out.println("两个都没有");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode litt = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				litt.littbro = L.isExist(head, name[1]);
                				L.add(head, litt);
                				System.out.println("弟弟已经有了");
                			}
                		}
            			if(judge == 5)//弟弟
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{     
            					System.out.println("两个都有了");
            					if(L.isExist(head, name[0]).littbro == L.isExist(head, name[1]) || L.isExist(head, name[1]).bigbro == L.isExist(head, name[0]))
            					{
            						JOptionPane.showMessageDialog(null,"人物关系(哥哥弟弟)矛盾，请检查文件！");
            						break;//不加这个真的会死循环
            					}
        						if(L.isExist(head, name[0]).bigbro != null && L.isExist(head, name[1]).littbro == null)
        						{
        							L.isExist(head, name[1]).littbro = L.isExist(head, name[0]);
        						}
        						if(L.isExist(head, name[0]).bigbro == null && L.isExist(head, name[1]).littbro != null)
        						{
        							L.isExist(head, name[0]).bigbro = L.isExist(head, name[1]);
        						}
        						if(L.isExist(head, name[0]).bigbro != null && L.isExist(head, name[1]).littbro != null)
        						{
        							LinkedNode bro = L.isExist(head, name[0]).bigbro;
        							while(bro != null)
        							{
        								bro = bro.bigbro;
        							}
        							bro = L.isExist(head, name[1]);
        						}
        						else
        						{
        							L.isExist(head, name[0]).bigbro = L.isExist(head, name[1]);
        						}
        					}
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//弟弟已经有了
                			{
                				LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				frist1.littbro = L.isExist(head, name[0]);
                				L.add(head, frist1);
                				System.out.println("弟弟已经有了");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
                			{
                				LinkedNode litt = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.littbro = litt; 
                    			L.add(head, frist1);
                    			L.add(head, litt);  
                    			System.out.println("两个都没有");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode bigbro = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[1]).bigbro = bigbro;
                				L.add(head, bigbro);
                				System.out.println("弟弟已经有了");
                			}
                		}
            			if(judge == 6)//兄弟
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{      
            					System.out.println("两个都有了");
        						if(L.isExist(head, name[0]).brother != null && L.isExist(head, name[1]).brother == null)
        						{
        							L.isExist(head, name[1]).brother = L.isExist(head, name[0]);
        							//System.out.println("11");
        						}
        						else if(L.isExist(head, name[0]).brother == null && L.isExist(head, name[1]).brother != null)
        						{
        							L.isExist(head, name[0]).brother = L.isExist(head, name[1]);
        							//System.out.println("22");
        						}
        						else if(L.isExist(head, name[0]).brother != null && L.isExist(head, name[1]).brother != null)
        						{
        							LinkedNode bro = L.isExist(head, name[0]).brother;
        							//System.out.println("33");
        							while(bro != null)
        							{
        								bro = bro.brother;
        							}
        							bro = L.isExist(head, name[1]);
        						}
        						else
        						{
        							L.isExist(head, name[1]).brother = L.isExist(head, name[0]);
        							//System.out.println("44");
        						}
        						
        					}
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//兄弟0已经有了
                			{
                				LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				frist1.brother = L.isExist(head, name[0]);
                				L.add(head, frist1);
                				System.out.println("兄弟0已经有了");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
                			{
                				LinkedNode litt = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.brother = litt; 
                    			L.add(head, frist1);
                    			L.add(head, litt);  
                    			System.out.println("两个都没有");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode bigbro = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[1]).brother = bigbro;
                				L.add(head, bigbro);
                				System.out.println("兄弟1已经有了");
                			}                			
                		}
            			if(judge == 7)//老师
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{       
            					System.out.println("两个都有了");
        						if(L.isExist(head, name[0]).stu != null && L.isExist(head, name[1]).teacher == null)
        						{
        							L.isExist(head, name[1]).teacher = L.isExist(head, name[0]);//学生指老师
        						}
        						if(L.isExist(head, name[1]).teacher != null && L.isExist(head, name[0]).stu == null)
        						{
        							L.isExist(head, name[0]).stu = L.isExist(head, name[1]);//老师值指学生
        						}
        						if(L.isExist(head, name[1]).teacher != null && L.isExist(head, name[0]).stu != null)
        						{
        							LinkedNode classm = L.isExist(head, name[1]).classmates;
        							while(classm != null)//找到空的同学
        							{
        								classm = classm.classmates;
        							}
        							classm = L.isExist(head, name[0]).stu;//学生指老师的学生
        						}
        						else
        						{
        							L.isExist(head, name[0]).stu = L.isExist(head, name[1]);
        						}
        						System.out.println("两个都有了");
        					}
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//老师已经有了
                			{
                				LinkedNode stu = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				stu.teacher = L.isExist(head, name[0]);
                				L.add(head, stu);
                				System.out.println("老师已经有了");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
                			{
                				LinkedNode tea = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode stu = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			tea.stu = stu;
                    			stu.teacher = tea; 
                    			L.add(head, tea);
                    			L.add(head, stu);  
                    			System.out.println("两个都没有");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode tea = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[1]).teacher = tea;
                				L.add(head, tea);
                				System.out.println("学生已经有了");
                			}                			
                		}
            			if(judge == 8)//学生
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有
            				{
            					System.out.println("两个都有了");
            					if(L.isExist(head, name[0]).teacher != null && L.isExist(head, name[1]).stu == null)
        						{
        							L.isExist(head, name[1]).stu = L.isExist(head, name[0]);//老师指学生
        						}
            					if(L.isExist(head, name[0]).teacher == null && L.isExist(head, name[1]).stu != null)
        						{
        							L.isExist(head, name[0]).teacher = L.isExist(head, name[1]);//学生指老师
        						}
            					if(L.isExist(head, name[0]).teacher != null && L.isExist(head, name[1]).stu != null)
        						{
            						//学生指老师的学生
            						LinkedNode classm = L.isExist(head, name[0]).classmates;
            						while(classm != null)
            						{
            							classm = classm.classmates;
            						}
        							classm = L.isExist(head, name[0]).stu;
        						}
            					else
            					{
            						L.isExist(head, name[0]).teacher = L.isExist(head, name[1]);
            					}
            				}
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//学生已经有了
                			{
                				LinkedNode tea = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				tea.stu = L.isExist(head, name[0]);
                				L.add(head, tea);
                				System.out.println("学生已经有了");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
                			{
                				LinkedNode stu = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode tea = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			tea.stu = stu;
                    			stu.teacher = tea; 
                    			L.add(head, tea);
                    			L.add(head, stu);  
                    			System.out.println("两个都没有");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode stu = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[1]).stu = stu;
                				L.add(head, stu);
                				System.out.println("老师已经有了");
                			}                			
                		}
            			if(judge == 9)//同学
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)
            				{
            					System.out.println("两个都有了");
            					//同学0的同学指向同学1
            					LinkedNode classm = L.isExist(head, name[0]).classmates;
            					while(classm != null)
            					{
            						classm = classm.classmates;
            					}
            					classm = L.isExist(head, name[1]);
            				}
                			if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//同学0已经有了
                			{
                				LinkedNode stu1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				stu1.classmates = L.isExist(head, name[0]);
                				L.add(head, stu1);
                				System.out.println("同学0已经有了");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
                			{
                				LinkedNode stu0 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode stu1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			stu1.classmates = stu0;
                    			stu0.classmates = stu1; 
                    			L.add(head, stu1);
                    			L.add(head, stu0);  
                    			System.out.println("两个都没有");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
                			{
                				LinkedNode stu0 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[1]).classmates = stu0;
                				L.add(head, stu0);
                				System.out.println("同学1已经有了");
                			}                			
                		}
            			if(judge == 10)//孙子
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{       		
        						if(L.isExist(head, name[0]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(爷孙)矛盾，请检查文件！");
        						}
        						L.isExist(head, name[0]).grandpa = L.isExist(head, name[1]);
        						System.out.println("两个都有了");
        					}
        					else if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)//孙子已经有了
        					{
        						LinkedNode frist1 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
        						L.isExist(head, name[0]).grandpa = frist1;
        						L.add(head, frist1);
        						System.out.println("孙子已经有了");
        					}
        					else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//两个都没有
        					{
        						
        						LinkedNode grandpa = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            					System.out.println("两个都没有");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) != head)
        					{
        						/*if(L.isExist(head, name[1]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(爷孙)矛盾，请检查文件！");
        						}
        						else
        						{*/
        							LinkedNode grandson = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            						grandson.grandpa = L.isExist(head, name[1]);
            						L.add(head, grandson);
            						System.out.println("爷爷已经有了");
        						//}				
        					}
        				}
        			}//方程1
            		if(fuction == 2)
            		{
            			name = n.Name(tempString);
            			if(judge == 1)//爸爸
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{ 
        						if(L.isExist(head, name[0]).father.name.equals("unknown"))//如果爸爸存在但是是未知者
        						{
        							L.isExist(head, name[0]).father.name = name[1];
        							System.out.println("unkown爸爸");
        						}
        						else if(L.isExist(head, name[0]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(父子)矛盾，请检查文件！");
        						}
        						L.isExist(head, name[0]).father = L.isExist(head, name[1]);
        						System.out.println("父子两个都有了2");
        					}
        					else if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//爸爸已经有了
        					{
        						if(L.isExist(head, name[0]).father.name.equals("unknown"))//如果爸爸存在但是是未知者
        						{
        							L.isExist(head, name[0]).father.name = L.isExist(head, name[1]).name;
        						}
        						else
        						{
        							LinkedNode frist1 = new LinkedNode(name[0],null,null,null,null, null, null, null, null, null, null, null);
            						frist1.father = L.isExist(head, name[1]);
            						L.add(head, frist1);
        						}  					
        						System.out.println("爸爸已经有了2");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
        					{
        						LinkedNode father = new LinkedNode(name[1],null,null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.father = father;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, father);  
            					System.out.println("两个都没有2");
        					}  
        					else if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) == head)
        					{
        					
        						while(L.isExist(head, name[0]).brother != null)
        						{
        							if(L.isExist(head, name[0]).brother.father != null)
        							{
        								JOptionPane.showMessageDialog(null,"人物关系(父子)矛盾，请检查文件！");
        							}
        							L.isExist(head, name[0]).brother = L.isExist(head, name[0]).brother.brother;
        						}
        						if(L.isExist(head, name[0]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(父子)矛盾，请检查文件！");
        						}
        						else
        						{
        							LinkedNode father = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            						L.isExist(head, name[0]).father = father;
            						father.son = L.isExist(head, name[0]);
            						L.add(head, father);
            						System.out.println("儿子已经有了2");
        						}       						
        					}
        				}
            			if(judge == 2)//爷爷
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{       		
        						if(L.isExist(head, name[0]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(爷孙)矛盾，请检查文件！");
        						}
        						L.isExist(head, name[0]).grandpa = L.isExist(head, name[1]);
        						System.out.println("两个都有了2");
        					}
        					else if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//爷爷已经有了
        					{
        						LinkedNode frist1 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
        						frist1.grandpa = L.isExist(head, name[1]);
        						L.add(head, frist1);
        						System.out.println("爷爷已经有了2");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
        					{
        						
        						LinkedNode grandpa = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            					System.out.println("两个都没有2");
        					}
        					else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
        					{
        						if(L.isExist(head, name[0]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(爷孙)矛盾，请检查文件！");
        						}
        						else
        						{
        							LinkedNode grandpa = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            						L.isExist(head, name[0]).grandpa = grandpa;
            						L.add(head, grandpa);
            						System.out.println("孙子已经有了2");
        						}				
        					}
        				}
            			if(judge == 3)//儿子
            			{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{    
        						if(L.isExist(head, name[0]).son!= null)
            					{
            						if(L.isExist(head, name[0]).son.name.equals("unknown"))
            						{
            							L.isExist(head, name[0]).son.name = name[1];
            						}
            					}
        						else if(L.isExist(head, name[1]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(父子)矛盾，请检查文件！");
        						}
        						else
        						{
        							L.isExist(head, name[1]).father = L.isExist(head, name[0]);
            						System.out.println("两个都有了2");
        						}			
        					}
            				if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//儿子已经有了
            				{
            					if(L.isExist(head, name[1]).father != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(父子)矛盾，请检查文件！");
        						}
            					else
            					{
            						LinkedNode frist1 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            						frist1.son = L.isExist(head, name[1]);
            						L.add(head, frist1);
            						System.out.println("儿子已经有了2");
            					}           					
            				}
            				else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
            				{
            					LinkedNode son = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                				LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				//frist1.son = son;
                				frist1.son = son; 
                				L.add(head, frist1);
                				L.add(head, son);  
                				System.out.println("两个都没有2");
            				}
            				else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
            				{
            					if(L.isExist(head, name[0]).son!= null)
            					{
            						if(L.isExist(head, name[0]).son.name.equals("unknown"))
            						{
            							L.isExist(head, name[0]).son.name = name[1];
            						}
            					}
            					else
            					{
            						LinkedNode son = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                					son.father = L.isExist(head, name[0]);
                					//L.isExist(head, name[0]).son = son;
                					L.add(head, son);
                					System.out.println("爸爸已经有了2");
                				}           					
            				}
            			}
            			if(judge == 4)//哥哥
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{       		
        						System.out.println("两个都有了2");
            					if(L.isExist(head, name[0]).bigbro != null && L.isExist(head, name[1]).littbro == null)
            					{
            						L.isExist(head, name[1]).littbro =L.isExist(head, name[0]);
            					}
            					if(L.isExist(head, name[0]).bigbro == null && L.isExist(head, name[1]).littbro != null)
            					{
            						L.isExist(head, name[0]).bigbro =L.isExist(head, name[1]);
            					}
            					if(L.isExist(head, name[0]).bigbro != null && L.isExist(head, name[1]).littbro != null)
            					{
            						LinkedNode bro = L.isExist(head, name[1]).littbro;
            						while(bro != null)
            						{
            							bro = bro.littbro;
            						}
            						bro = L.isExist(head, name[0]);
            					}
            					else
            					{
            						L.isExist(head, name[0]).bigbro =L.isExist(head, name[1]);
            					}						
        					}
            				
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//哥哥已经有了
                			{
                				LinkedNode frist1 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
                				frist1.bigbro = L.isExist(head, name[1]);
                				L.add(head, frist1);
                				System.out.println("哥哥已经有了2");
                			}
                			else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
                			{
                				LinkedNode bigbro = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.bigbro = bigbro; 
                    			L.add(head, frist1);
                    			L.add(head, bigbro);  
                    			System.out.println("两个都没有2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode litt = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				litt.littbro = L.isExist(head, name[0]);
                				L.isExist(head, name[0]).bigbro = litt;
                				L.add(head, litt);
                				System.out.println("弟弟已经有了2");
                			}
                		}
            			if(judge == 5)//弟弟
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{     
            					System.out.println("两个都有了2");
        						if(L.isExist(head, name[1]).bigbro != null && L.isExist(head, name[0]).littbro == null)
        						{
        							L.isExist(head, name[0]).littbro = L.isExist(head, name[1]);
        						}
        						if(L.isExist(head, name[1]).bigbro == null && L.isExist(head, name[0]).littbro != null)
        						{
        							L.isExist(head, name[1]).bigbro = L.isExist(head, name[0]);
        						}
        						if(L.isExist(head, name[1]).bigbro != null && L.isExist(head, name[0]).littbro != null)
        						{
        							LinkedNode bro = L.isExist(head, name[1]).bigbro;
        							while(bro != null)
        							{
        								bro = bro.bigbro;
        							}
        							bro = L.isExist(head, name[0]);
        						}
        						else
        						{
        							L.isExist(head, name[1]).bigbro = L.isExist(head, name[0]);
        						}
        					}
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//弟弟已经有了
                			{
                				LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				frist1.littbro = L.isExist(head, name[1]);
                				L.add(head, frist1);
                				System.out.println("弟弟已经有了2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//两个都没有
                			{
                				LinkedNode litt = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.littbro = litt; 
                    			L.add(head, frist1);
                    			L.add(head, litt);  
                    			System.out.println("两个都没有2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode bigbro = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                				bigbro.bigbro = L.isExist(head, name[0]);
                				L.isExist(head, name[0]).littbro = bigbro;
                				L.add(head, bigbro);
                				System.out.println("哥哥已经有了2");
                			}
                		}
            			if(judge == 6)//兄弟
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{      
            					System.out.println("两个都有了2");
        						if(L.isExist(head, name[1]).brother != null && L.isExist(head, name[0]).brother == null)
        						{
        							L.isExist(head, name[0]).brother = L.isExist(head, name[1]);
        							//System.out.println("11");
        						}
        						else if(L.isExist(head, name[1]).brother == null && L.isExist(head, name[0]).brother != null)
        						{
        							L.isExist(head, name[1]).brother = L.isExist(head, name[0]);
        							//System.out.println("22");
        						}
        						else if(L.isExist(head, name[1]).brother != null && L.isExist(head, name[0]).brother != null)
        						{
        							LinkedNode bro = L.isExist(head, name[1]).brother;
        							//System.out.println("33");
        							while(bro != null)
        							{
        								bro = bro.brother;
        							}
        							bro = L.isExist(head, name[0]);
        						}
        						else
        						{
        							L.isExist(head, name[0]).brother = L.isExist(head, name[1]);
        							//System.out.println("44");
        						}
        						
        					}
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//兄弟0已经有了
                			{
                				LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				frist1.brother = L.isExist(head, name[1]);
                				L.add(head, frist1);
                				System.out.println("兄弟0已经有了2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//两个都没有
                			{
                				LinkedNode litt = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode frist1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			//frist1.son = son;
                    			frist1.brother = litt; 
                    			L.add(head, frist1);
                    			L.add(head, litt);  
                    			System.out.println("两个都没有2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode bigbro = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[0]).brother = bigbro;
                				L.add(head, bigbro);
                				System.out.println("兄弟1已经有了2");
                			}                			
                		}
            			if(judge == 7)//老师
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{       
            					System.out.println("两个都有了2");
        						if(L.isExist(head, name[1]).stu != null && L.isExist(head, name[0]).teacher == null)
        						{
        							L.isExist(head, name[0]).teacher = L.isExist(head, name[1]);//学生指老师
        						}
        						if(L.isExist(head, name[0]).teacher != null && L.isExist(head, name[1]).stu == null)
        						{
        							L.isExist(head, name[1]).stu = L.isExist(head, name[0]);//老师值指学生
        						}
        						if(L.isExist(head, name[0]).teacher != null && L.isExist(head, name[1]).stu != null)
        						{
        							LinkedNode classm = L.isExist(head, name[0]).classmates;
        							while(classm != null)//找到空的同学
        							{
        								classm = classm.classmates;
        							}
        							classm = L.isExist(head, name[1]).stu;//学生指老师的学生
        						}
        						else
        						{
        							L.isExist(head, name[1]).stu = L.isExist(head, name[0]);
        						}
        						System.out.println("两个都有了2");
        					}
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//老师已经有了
                			{
                				LinkedNode stu = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				stu.teacher = L.isExist(head, name[1]);
                				L.add(head, stu);
                				System.out.println("老师已经有了2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//两个都没有
                			{
                				LinkedNode tea = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode stu = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			tea.stu = stu;
                    			stu.teacher = tea; 
                    			L.add(head, tea);
                    			L.add(head, stu);  
                    			System.out.println("两个都没有2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode tea = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[0]).teacher = tea;
                				L.add(head, tea);
                				System.out.println("学生已经有了2");
                			}                			
                		}
            			if(judge == 8)//学生
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有
            				{
            					
            					
            					System.out.println("两个都有了2");
            					if(L.isExist(head, name[1]).teacher != null && L.isExist(head, name[0]).stu == null)
        						{
        							L.isExist(head, name[0]).stu = L.isExist(head, name[1]);//老师指学生
        						}
            					if(L.isExist(head, name[1]).teacher == null && L.isExist(head, name[0]).stu != null)
        						{
        							L.isExist(head, name[1]).teacher = L.isExist(head, name[0]);//学生指老师
        						}
            					if(L.isExist(head, name[1]).teacher != null && L.isExist(head, name[0]).stu != null)
        						{
            						//学生指老师的学生
            						LinkedNode classm = L.isExist(head, name[1]).classmates;
            						while(classm != null)
            						{
            							classm = classm.classmates;
            						}
        							classm = L.isExist(head, name[1]).stu;
        						}
            					else
            					{
            						L.isExist(head, name[1]).teacher = L.isExist(head, name[0]);
            					}
            				}
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//学生已经有了
                			{
                				LinkedNode tea = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				tea.stu = L.isExist(head, name[1]);
                				L.add(head, tea);
                				System.out.println("学生已经有了2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//两个都没有
                			{
                				LinkedNode stu = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode tea = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			tea.stu = stu;
                    			stu.teacher = tea; 
                    			L.add(head, tea);
                    			L.add(head, stu);  
                    			System.out.println("两个都没有2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode stu = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[0]).stu = stu;
                				L.add(head, stu);
                				System.out.println("老师已经有了2");
                			}                			
                		}
            			if(judge == 9)//同学
                		{
            				if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)
            				{
            					System.out.println("两个都有了2");
            					//同学0的同学指向同学1
            					LinkedNode classm = L.isExist(head, name[1]).classmates;
            					while(classm != null)
            					{
            						classm = classm.classmates;
            					}
            					classm = L.isExist(head, name[0]);
            				}
                			if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//同学0已经有了
                			{
                				LinkedNode stu1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                				stu1.classmates = L.isExist(head, name[1]);
                				L.add(head, stu1);
                				System.out.println("同学0已经有了2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) == head)//两个都没有
                			{
                				LinkedNode stu0 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
                    			LinkedNode stu1 = new LinkedNode(name[0], null,null,null,null, null, null, null, null, null, null, null);
                    			stu1.classmates = stu0;
                    			stu0.classmates = stu1; 
                    			L.add(head, stu1);
                    			L.add(head, stu0);  
                    			System.out.println("两个都没有2");
                			}
                			else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
                			{
                				LinkedNode stu0 = new LinkedNode(name[1],null, null,null,null, null, null, null, null, null, null, null);
                				L.isExist(head, name[0]).classmates = stu0;
                				L.add(head, stu0);
                				System.out.println("同学1已经有了2");
                			}                			
                		}
            			if(judge == 10)//孙子
        				{
        					if(L.isExist(head, name[0]) != head && L.isExist(head, name[1]) != head)//两个都有了
        					{       		
        						if(L.isExist(head, name[1]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(爷孙)矛盾，请检查文件！");
        						}
        						L.isExist(head, name[1]).grandpa = L.isExist(head, name[0]);
        						System.out.println("两个都有了2");
        					}
        					else if(L.isExist(head, name[1]) != head && L.isExist(head, name[0]) == head)//孙子已经有了
        					{
        						LinkedNode frist1 = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
        						L.isExist(head, name[1]).grandpa = frist1;
        						L.add(head, frist1);
        						System.out.println("孙子已经有了2");
        					}
        					else if(L.isExist(head, name[0]) == head && L.isExist(head, name[1]) == head)//两个都没有
        					{
        						
        						LinkedNode grandpa = new LinkedNode(name[0],null, null,null,null, null, null, null, null, null, null, null);
            					LinkedNode frist1 = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            					frist1.grandpa = grandpa;
            					//father.son = frist1;
            					L.add(head, frist1);
            					L.add(head, grandpa);  
            					System.out.println("两个都没有2");
        					}
        					else if(L.isExist(head, name[1]) == head && L.isExist(head, name[0]) != head)
        					{
        						/*if(L.isExist(head, name[1]).grandpa != null)
        						{
        							JOptionPane.showMessageDialog(null,"人物关系(爷孙)矛盾，请检查文件！");
        						}
        						else
        						{*/
        							LinkedNode grandson = new LinkedNode(name[1], null,null,null,null, null, null, null, null, null, null, null);
            						grandson.grandpa = L.isExist(head, name[0]);
            						L.add(head, grandson);
            						System.out.println("爷爷已经有了2");
        						//}				
        					}
        				}
            		}//方程2
            		
        		}
               line++; 
            }
            result1 = L.bianli(head, nameone,nametwo);
            result2 = L.bianli(head, nametwo,nameone);
            System.out.println(nameone);
            System.out.println(nametwo);
            System.out.println(result1);
            System.out.println(result2);
            reader.close();
            head = null;  //一定要把head重新赋值被null
            return result1 + "\n" + result2;   
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return result1 + "\n" + result2;
    }
	
	
	//3、写入文件
	public void Write(File f, String s) throws IOException
	{
		try {   
		    FileOutputStream fw = new FileOutputStream(f,true);   //建立可续写的文件
		    fw.write(s.getBytes());    //写入语句
		    fw.flush();    //关闭流前要清空
		    fw.close();    //关闭流
		} catch (IOException e) {   
		    e.printStackTrace();   
		}   
	}
}
