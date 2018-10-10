package com.SongJian.Util;

import javax.swing.JOptionPane;

public class Linked {
	
	static class LinkedNode
	{
		String name;
		LinkedNode father;
		LinkedNode son;
		LinkedNode brother;
		LinkedNode grandpa;
		LinkedNode grandson;
		LinkedNode next;
		LinkedNode bigbro;
		LinkedNode littbro;
		LinkedNode teacher;
		LinkedNode classmates;
		LinkedNode stu;
		public LinkedNode(String name,LinkedNode stu,LinkedNode teacher,LinkedNode classmates,LinkedNode father,LinkedNode son,LinkedNode grandson,LinkedNode brother,LinkedNode grandpa,LinkedNode next,LinkedNode bigbro,LinkedNode littbro)
		{
			this.name = name;
			this.father = father;
			this.son = son;
			this.brother = brother;
			this.grandpa = grandpa;
			this.next = next;
			this.bigbro = bigbro;
			this.littbro = littbro;		
			this.grandson = grandson;
			this.teacher = teacher;
			this.classmates = classmates;
			this.stu = stu;
		}
		
	}
	
	public LinkedNode init(LinkedNode frist)
	{
		LinkedNode head = new LinkedNode("head" ,null,null,null,null,null,null,null,null,null,null,null);
		head.next = frist;
		return head;		
	}
	public void add(LinkedNode head ,  LinkedNode next)
	{
		while(head.next != null)
		{
			head = head.next;
		}
		head.next = next;
		next.next = null;
	}
	public String bianli(LinkedNode head , String name1 ,String name2)//查找
	{
		//名字顺序
		String ans1 = "*";
		String ans2 = "*";
		String ans3 = "*";
		String ans4 = "*";
		String ans5 = "*";
		String ans6 = "*";
		String ans7 = "*";
		String ans8 = "*";
		String ans9 = "*";
		String ans10 = "*";
		String ans11 = "*";
		String ans12 = "*";
		String ans13 = "*";
		String ans14 = "*";
		String ans15 = "*";
		String ans16 = "*";
		String ans17 = "*";
		LinkedNode name11 = head;
		LinkedNode name22 = head;
		while(name11 != null)//name11找到name1的位置
		{
			if(name11.name.equals(name1)) {
				break;
			}
			name11 = name11.next;	
		}
		while(name22 != null)//name22找到name2的位置
		{
			if(name22.name.equals(name2))
			{
				break;
			}
			name22 = name22.next;		
		}
		if(name11 == null || name22 == null)
		{
			JOptionPane.showMessageDialog(null,"不在关系文本中");
			return "错误";
		}
		//父亲哥哥，父亲弟弟，父亲兄弟循环
		if(name11.brother!=null || name11.littbro!=null || name11.bigbro!=null || name11.father != null)
		{
			if((name11.father == name22 && name11.brother == name22) || (name11.father == name22 && name11.littbro == name22) || (name11.father == name22 && name11.bigbro == name22))
			{
				JOptionPane.showMessageDialog(null,"人物关系(爸爸与兄弟，哥哥，弟弟)矛盾，请检查文件！");	
				return "错误";
			}
			else if((name11.father == name22 && name22.bigbro == name11) || (name11.father == name22 && name22.littbro == name11) || (name11.father == name22 && name22.brother == name11))
			{
				JOptionPane.showMessageDialog(null,"人物关系(爸爸与兄弟，哥哥，弟弟)矛盾，请检查文件！");	
				return "错误";
			}
			else if((name11.bigbro == name22 && name22.father == name11) || (name11.littbro == name22 && name22.father == name11) || (name11.brother == name22 && name22.father == name11))
			{
				JOptionPane.showMessageDialog(null,"人物关系(爸爸与兄弟，哥哥，弟弟)矛盾，请检查文件！");	
				return "错误";
			}
		}
		if((name11.father == name22 && name11.grandpa == name22) || (name11.grandpa == name22 && name22.father == name11))
		{
			JOptionPane.showMessageDialog(null,"人物关系(爸爸爷爷)矛盾，请检查文件！");
			return "错误";
		}
		if(name11.father == name22 && name11.grandson == name22)
		{
			JOptionPane.showMessageDialog(null,"人物关系(爸爸孙子)矛盾，请检查文件！");
			return "错误";
		}
		if(name11.father == name22 && name11.son == name22)
		{
			JOptionPane.showMessageDialog(null,"人物关系(爸爸儿子)矛盾，请检查文件！");
			return "错误";
		}
		if(name11.stu == name22 && name22.stu == name11)  // 学生循环
		{
			JOptionPane.showMessageDialog(null,"人物关系(师生)矛盾，请检查文件！");
			return "错误";
		}
		if(name11.teacher == name22 && name22.teacher == name11)  //老师循环
		{
			JOptionPane.showMessageDialog(null,"人物关系(师生)矛盾，请检查文件！");
			return "错误";
		}
		//爷爷
		if(name11.grandpa == name22 && name11.grandson == name22)
		{
			JOptionPane.showMessageDialog(null,"人物关系(爷爷孙子)矛盾，请检查文件！");
			return "错误";
		}
		if((name11.grandpa == name22 && name11.brother == name22) || (name11.grandpa == name22 && name11.littbro == name22) || (name11.grandpa == name22 && name11.bigbro == name22))
		{
			JOptionPane.showMessageDialog(null,"人物关系(爷爷与兄弟，哥哥，弟弟)矛盾，请检查文件！");
			return "错误";
		}
		/*if(name11.bigbro == name22 && name11.littbro == name22)
		{
			JOptionPane.showMessageDialog(null,"人物关系(兄弟)矛盾，请检查文件！");
			return "错误";
		}*/
		if(name11 == name22 && name11 != null && name22 != null) //自己搜自己
		{
			return "自己就是自己啦！";
		}
		
		if(name11 != null && name22 != null)
		{
			while(name11.littbro != null)
			{
				if(name11.littbro == name22)//弟弟
				{
					ans1 = name1+"的弟弟是"+name2;
				}
				if(name11.littbro.father == name22)
				{
					ans4 = name1+"的爸爸是"+name2;
				}
				if(name11.littbro.grandpa == name22)
				{
					ans5 = name1+"的爷爷是"+name2;
				}
				name11.littbro = name11.littbro.littbro;
			}
			
			while(name11.bigbro != null)
			{
				if(name11.bigbro == name22)//哥哥
				{
					ans2 = name1+"的哥哥是"+name2;
				}
				if(name11.bigbro.father == name22)
				{
					ans4 = name1+"的爸爸是"+name2;
				}
				if(name11.bigbro.grandpa == name22)
				{
					ans5 = name1+"的爷爷是"+name2;
				}
				name11.bigbro = name11.bigbro.bigbro;
			}
			while(name11.brother != null)
			{
				if(name11.brother == name22)//哥哥
				{
					ans2 = name1+"的兄弟是"+name2;
				}
				if(name11.brother.father == name22)
				{
					ans4 = name1+"的爸爸是"+name2;
				}
				if(name11.brother.grandpa == name22)
				{
					ans5 = name1+"的爷爷是"+name2;
				}
				name11.brother = name11.brother.brother;
			}
			
			if(name11.son == name22)//儿子
			{
				ans3 = name1+"的儿子是"+name2;
			}
			
			
			/*while(name11.brother != null)//兄弟的爸爸 爷爷是一样的
			{
				System.out.println("a");
				if(name11.brother.father == name22)
				{
					ans4 = name1+"的爸爸是"+name2;
				}
				else if(name11.brother.grandpa == name22)
				{
					ans5 = name1+"的爷爷是"+name2;
				}
				name11 = name11.brother;
			}
			while(name11.bigbro != null)
			{
				System.out.println("b");
				if(name11.bigbro.father == name22)
				{
					ans4 = name1+"的爸爸是"+name2;
				}
				else if(name11.bigbro.grandpa == name22)
				{
					ans5 = name1+"的爷爷是"+name2;
				}
				name11 = name11.bigbro;
			}
			while(name11.littbro != null)
			{
				System.out.println("c");
				if(name11.littbro.father == name22)
				{
					ans4 = name1+"的爸爸是"+name2;
				}
				if(name11.littbro.grandpa == name22)
				{
					ans5 = name1+"的爷爷是"+name2;
				}
				name11 = name11.littbro;
			}*/
			if(name11.grandson != null && name11.grandson.father != null)//爷爷的孙子的爸爸是爷爷的儿子
			{
				if(name11.grandson.father == name22)
				{
					ans4 = name1+"的爸爸是"+name2;
				}
			}
			if(name11.father != null && name11.father.father != null )//爸爸的爸爸是爷爷
			{
				if(name11.father.father == name22)
				{
					ans5 = name1+"的爷爷是"+name2;
				}
			}
			if(name11.father == name22)//爸爸
			{
				ans4 = name1+"的爸爸是"+name2;
			}
			if(name11.grandpa == name22)//yeye
			{
				ans5 = name1+"的爷爷是"+name2;
			}
			if(name11.grandson == name22)//sunzi
			{
				ans6 = name1+"的孙子是"+name2;
			}
			if(name11.brother == name22)//xiongdi
			{
				ans7 = name1+"的兄弟是"+name2;
			}
			if(name11.teacher == name22)
			{
				ans8 = name1 + "的老师是" +name2;
			}
			if(name11.stu == name22)
			{
				ans9 = name1 + "的学生是" + name2;
			}
			if(name11.classmates == name22)
			{
				ans10 = name1 + "的同学是" + name2;
			}
			//同一个爸爸，爷爷，孙子，兄弟都是兄弟
			if(name11.father != null && name22.father != null)
			{
				if(name11.father.name == name22.father.name)
				{
					ans11 = name1+"的兄弟是"+name2;
				}
			}
			if(name11.grandpa != null && name22.grandpa != null)
			{
				if(name11.grandpa.name == name22.grandpa.name)
				{
					ans12 = name1+"的兄弟是"+name2;
				}
			}
			if(name11.grandson != null && name22.grandson != null)
			{
				if(name11.grandson.name == name22.grandson.name )
				{
					ans13 = name1+"的兄弟是"+name2;
				}
			}
			if(name11.brother != null && name22.brother != null)
			{
				if(name11.brother.name == name22.brother.name )
				{
					ans14 = name1+"的兄弟是"+name2;
				}
			}
			//同一个老师的学生 ,同学的同学 是同学
			if(name11.teacher != null && name22.teacher != null)
			{
				if(name11.teacher.name == name22.teacher.name )
				{
					ans15 = name1+"的同学是"+name2;
				}
			}
			if(name11.classmates != null && name22.classmates != null)
			{
				if(name11.classmates.name == name22.classmates.name )
				{
					ans16 = name1+"的同学是"+name2;
				}
			}
			if(name11.grandson != null && name11.son != null ) //爷爷的孙子  是   爷爷的儿子的    儿子
			{
				if(name11.grandson.father == name11.son)
				{
					ans4 = name1+"的爸爸是"+name2;
				}				
			}
			if(name11.teacher != null && name11.teacher.stu != null)//学生的老师的学生 是 同学
			{
				if(name11.teacher.stu == name22)
				{
					ans10 = name1 + "的同学是" + name2;
				}
			}
			if(name11.father != null && name11.father.grandson != null) //爸爸的孙子 是儿子
			{
				if(name11.father.grandson == name22)
				{
					ans3 = name1+"的儿子是"+name2;
				}				
			}
			if(name11.father!=null && name11.father.father != null) //爸爸的爸爸是爷爷
			{
				if(name11.father.father == name22)
				{
					ans5 = name1+"的爷爷是"+name2;
				}
			}
		}
		else
		{
			ans17 = name1+"和"+name2+"没有关系";	
		}
		if(ans1 !="*" && ans2 != "*")
		{
			JOptionPane.showMessageDialog(null,"人物关系(哥哥弟弟)矛盾，请检查文件！");
			return "错误";
		}
		return ans1+"-*"+ans2+"-*"+ans3+"-*"+ans4+"-*"+ans5+"-*"+ans6+"-*"+ans7+"-*"+ans8+"-*"+ans9+"-*"+ans10+"-*"+ans11+"-*"+ans12+"-*"+ans13+"-*"+ans14+"-*"+ans15+"-*"+ans16+"-*"+ans17;
	}
	
	public LinkedNode isExist(LinkedNode head, String objname)  //查找名字是否存在
	{
		LinkedNode current = head;
		while(current.next != null)
		{
			if(current.name.equals(objname))
			{
				break;
			}
			current = current.next;
		}
		if(current.name.equals("unknown"))
		{
			return current;
		}
		else if(current.name.equals(objname))
		{
			return current;
		}
		else
		{
			return head;
		}
	}

}
