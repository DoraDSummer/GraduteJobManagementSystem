package cn.edu.service;

import cn.edu.dao.TbStudentDAO;
import cn.edu.entity.TbStudent;
import com.opensymphony.xwork2.ActionContext;

public class StudentRegist {
	private ActionContext ctx;
	private TbStudentDAO tbStudentDao;

	public boolean checkStudentRegist(String stuId,String stuName,String stuTelephone, String stuPwd) {
		
		tbStudentDao = new TbStudentDAO();
		try {			
			System.out.println("1����ע��Service��" + stuId);
			TbStudent tbStudent=new TbStudent();
			tbStudent.setStuId(stuId);
			tbStudent.setStuName(stuName);
			tbStudent.setStuTelephone(stuTelephone);
			tbStudent.setStuPwd(stuPwd);
			tbStudentDao.save(tbStudent);
			
			ctx=ActionContext.getContext();
			ctx.getSession().put("session_stuNum", tbStudent.getStuNum());
			System.out.println("ע����֤+"+tbStudent.getStuNum());
			ctx.getSession().put("session_stuId",tbStudent.getStuId());
			ctx.getSession().put("session_stuName",tbStudent.getStuName());
			ctx.getSession().put("session_stupw", tbStudent.getStuPwd());
			System.out.println("2����ע��Service��" + stuId);	
			
			return true;

		} catch (Exception e) {
			//e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		
	}
}
