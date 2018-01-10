package cn.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import cn.edu.dao.TbStudentDAO;
import cn.edu.entity.TbStudent;
import cn.edu.sessionfactory.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class StudentLogin {
	private ActionContext ctx;
	private TbStudentDAO tbStudentDao;
	List<TbStudent> tbStudents;

	@SuppressWarnings("unchecked")
	public boolean checkStudentLogin(String stuId,String stuPwd){
		tbStudentDao=new TbStudentDAO();
		tbStudents=new ArrayList<TbStudent>();
		Session s=null;
		
		try {
			
			s=HibernateSessionFactory.getSession();
			System.out.println("1����Service��"+stuId);
			tbStudents= tbStudentDao.findByStuId(stuId);
			System.out.println("2����Service��"+stuId);
			
			if (!tbStudents.isEmpty()) {
				System.out.println("Service��");
				for (TbStudent tbStudent:tbStudents) {
					
					System.out.println("xueshengmima"+tbStudent.getStuPwd());
					
					if(tbStudent.getStuPwd().equals(stuPwd)){
						ctx=ActionContext.getContext();
						ctx.getSession().put("session_stuNum", tbStudent.getStuNum());
						System.out.println("��¼��֤:"+tbStudent.getStuNum());
						System.out.println(ctx.getSession().get("session_stuNum"));
						ctx.getSession().put("session_stuId",tbStudent.getStuId());
						ctx.getSession().put("session_stuName",tbStudent.getStuName());
						ctx.getSession().put("session_stupw", tbStudent.getStuPwd());
						return true;
					}
				}	
			}
			return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			if (s!=null) {
				System.out.println("��Ҫ�ر�session��");
				s.close();
			}
		}
		return false;	
	}
}
