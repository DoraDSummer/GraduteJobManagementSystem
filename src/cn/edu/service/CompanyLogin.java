package cn.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import cn.edu.dao.TbCompanyDAO;
import cn.edu.entity.TbCompany;
import cn.edu.sessionfactory.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class CompanyLogin {

	
	private ActionContext ctx;
	private TbCompanyDAO tbCompanyDao;
	List<TbCompany> tbCompanys;

	@SuppressWarnings("unchecked")
	public boolean checkCompanyLogin(String compUsername,String compPwd){
		tbCompanyDao=new TbCompanyDAO();
		tbCompanys=new ArrayList<TbCompany>();
		Session s=null;
		
		try {
			
			s=HibernateSessionFactory.getSession();
			System.out.println("1����Service��"+compUsername);
			
			tbCompanys=tbCompanyDao.findByCompUsername(compUsername);
			
			System.out.println("2����Service��"+compUsername);
			
			if (!tbCompanys.isEmpty()) {
				System.out.println("Service��");
				for (TbCompany tbCompany:tbCompanys) {
					
					System.out.println("mima"+tbCompany.getCompPwd());
					
					if(tbCompany.getCompPwd().equals(compPwd)){
						ctx=ActionContext.getContext();
						ctx.getSession().put("session_compUsername", tbCompany.getCompId());
						System.out.println("��¼��֤:"+tbCompany.getCompId());
						System.out.println(ctx.getSession().get("session_stuNum"));
						ctx.getSession().put("session_compUsername",tbCompany.getCompUsername());
						ctx.getSession().put("session_compName",tbCompany.getCompName());
						ctx.getSession().put("session_compPwd", tbCompany.getCompPwd());
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
