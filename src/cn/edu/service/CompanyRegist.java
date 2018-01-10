package cn.edu.service;

import cn.edu.dao.TbCompanyDAO;
import cn.edu.entity.TbCompany;
import com.opensymphony.xwork2.ActionContext;

public class CompanyRegist {
	private ActionContext ctx;
	private TbCompanyDAO tbCompanyDao;

	public boolean checkCompanyRegist(String compUsername,String compName,String compProperty,String compSize, String compPwd) {
		
		tbCompanyDao = new TbCompanyDAO();
		try {			
			System.out.println("1����ע��Service��" + compUsername);
			TbCompany tbCompany=new TbCompany();
			
			tbCompany.setCompUsername(compUsername);
			
			tbCompany.setCompName(compName);
			
			tbCompany.setCompProperty(compProperty);
			
			tbCompany.setCompSize(compSize);
			
			tbCompany.setCompPwd(compPwd);
			
			tbCompanyDao.save(tbCompany);
			
			ctx=ActionContext.getContext();
			ctx.getSession().put("session_compID", tbCompany.getCompId());
			System.out.println("ע����֤+"+tbCompany.getCompId());
			ctx.getSession().put("session_compID",tbCompany.getCompId());
			ctx.getSession().put("session_compName",tbCompany.getCompName());
			ctx.getSession().put("session_compPwd", tbCompany.getCompPwd());
			System.out.println("2����ע��Service��" + compUsername);	
			
			return true;

		} catch (Exception e) {
			//e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		
	}
}
