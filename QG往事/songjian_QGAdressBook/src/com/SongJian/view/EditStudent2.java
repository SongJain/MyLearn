package com.SongJian.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.SongJian.dao.AdminDao;
import com.SongJian.model.Student;
import com.SongJian.util.Stringutil;


public class EditStudent2 {
	JPanel contentPanel = new JPanel();
	JFrame f = new JFrame("修改成员");
	Font font =new Font("黑体", Font.PLAIN, 18);	
	JButton ok = new JButton("确定");
	JButton returnto = new JButton("取消");
	private JLabel namelab = new JLabel("姓名：");
	private JTextField nametext = new JTextField();
	private JLabel fangxiang = new JLabel("方向：");
	private JTextField group = new JTextField();
	private JLabel grade = new JLabel("年级：");
	private JTextField grades = new JTextField();
	private JLabel clas = new JLabel("班级：");
	private JTextField sub = new JTextField();
	private JLabel tel = new JLabel("电话：");
	private JTextField telt = new JTextField();
	private JLabel email = new JLabel("邮箱：");
	private JTextField mail = new JTextField();
	private JLabel dor = new JLabel("宿舍：");
	private JTextField dort = new JTextField();
	private JLabel address = new JLabel("家庭住址：");
	private JTextArea ad = new JTextArea(3,10);
	private int a;
	
	
	public void init(int id)                //定义init()方法，供对象调用
	{
		a = getid(id);
		Student stu = new Student();
		AdminDao admindao = new AdminDao();
		stu = admindao.getinfo(id);
		String add =stu.getAdress();
		String sname = stu.getName();
		String cla = stu.getClas();
		String telp = stu.getTel();
		String grou = stu.getGroup();
		String grad = stu.getGrade();
		String dorty = stu.getDormitory();
		String mai = stu.getEmail();

		nametext.setText(sname);
		group.setText(grou);
		grades.setText(grad);
		sub.setText(cla);
		telt.setText(telp);
		mail.setText(mai);
		ad.setText(add);
		dort.setText(dorty);
		
		ad.setLineWrap(true);
		JScrollPane pane=new JScrollPane(ad, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		//容器contentpanel
		contentPanel.setLayout(null);
		contentPanel.add(namelab);
		contentPanel.add(nametext);
		contentPanel.add(fangxiang);
		contentPanel.add(group);
		contentPanel.add(grade);
		contentPanel.add(clas);
		contentPanel.add(tel);
		contentPanel.add(email);
		contentPanel.add(dor);
		contentPanel.add(address);
		contentPanel.add(grades);
		contentPanel.add(sub);
		contentPanel.add(telt);
		contentPanel.add(mail);
		contentPanel.add(dort);
		contentPanel.add(ad);
		contentPanel.add(ok);
		contentPanel.add(returnto);
		
		
		ad.setBounds(150,400,200, 135);
		ad.setFont(font);

		
		//绝对布局并且调整字体
		grade.setBounds(90, 150, 60, 35);
		grade.setFont(font);
		grades.setBounds(150, 150, 200, 35);
		grades.setFont(font);
		clas.setBounds(90, 200, 60, 35);
		clas.setFont(font);
		sub.setBounds(150, 200,200, 35);
		sub.setFont(font);
		tel.setBounds(90, 250, 60, 35);
		tel.setFont(font);
		telt.setBounds(150, 250, 200, 35);
		telt.setFont(font);
		email.setBounds(90, 300, 60, 35);
		email.setFont(font);
		mail.setBounds(150, 300, 200, 35);
		mail.setFont(font);
		dor.setBounds(90, 350, 60, 35);
		dor.setFont(font);
		dort.setBounds(150, 350, 200, 35);
		dort.setFont(font);
		address.setBounds(55, 400,120, 35);
		address.setFont(font);
		namelab.setBounds(90, 50, 60, 35);
		namelab.setFont(font);
		nametext.setBounds(150, 50, 200, 35);
		nametext.setFont(font);
		fangxiang.setBounds(90, 100, 60, 35);
		fangxiang.setFont(font);
		group.setBounds(150,100,200,35);
		group.setFont(font);
		ok.setBounds(100,580,80,35);
		ok.setFont(font);
		returnto.setBounds(280,580,80,35);
		returnto.setFont(font);
		Return returnt = new Return();
		returnto.addActionListener(returnt);	
		Ok okk = new Ok();
		ok.addActionListener(okk);
								
		f.add(contentPanel);						//加入frame中
		f.setBounds(700,200,500,700);				//固定frame大小
		f.setVisible(true);	

	}
	class Return implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			f.dispose();
		}		
	}
	public int getid(int id)
	{
		return id;
	}
	
	
	class Ok implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = nametext.getText().toString();
			String grade = grades.getText().toString();
			String clas = sub.getText().toString();
			String tel = telt.getText().toString();
			String email = mail.getText().toString();
			String dor = dort.getText().toString();
			String address = ad.getText().toString();
			String groupt = group.getText().toString();
			
			if(Stringutil.isEmpty(name))     
			{
				JOptionPane.showMessageDialog(null, "姓名不能为空", "错误信息",JOptionPane.ERROR_MESSAGE); 
				return;
			}
			else if(Stringutil.isEmpty(grade))     
			{
				JOptionPane.showMessageDialog(null, "年级不能为空", "错误信息",JOptionPane.ERROR_MESSAGE); 
				return;
			}
			else if(Stringutil.isEmpty(clas))     
			{
				JOptionPane.showMessageDialog(null, "班级不能为空", "错误信息",JOptionPane.ERROR_MESSAGE); 
				return;
			}
			else if(Stringutil.isEmpty(tel))     
			{
				JOptionPane.showMessageDialog(null, "电话不能为空", "错误信息",JOptionPane.ERROR_MESSAGE); 
				return;
			}
			else if(Stringutil.isEmpty(email))     
			{
				JOptionPane.showMessageDialog(null, "邮箱不能为空", "错误信息",JOptionPane.ERROR_MESSAGE); 
				return;
			}
			else if(Stringutil.isEmpty(dor))     
			{
				JOptionPane.showMessageDialog(null, "宿舍不能为空", "错误信息",JOptionPane.ERROR_MESSAGE); 
				return;
			}
			else if(Stringutil.isEmpty(address))     
			{
				JOptionPane.showMessageDialog(null, "家庭地址不能为空", "错误信息",JOptionPane.ERROR_MESSAGE); 
				return;
			}
			else if(Stringutil.isEmpty(groupt))     
			{
				JOptionPane.showMessageDialog(null, "方向名称不能为空", "错误信息",JOptionPane.ERROR_MESSAGE); 
				return;
			}
			else        //全部都填写完
			{
				new AdminDao().update(a ,name, grade, groupt,clas, tel, email, dor, address);
				f.dispose();
			}
		}

	}
}
