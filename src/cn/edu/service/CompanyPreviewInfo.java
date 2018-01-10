package cn.edu.service;

import java.util.ArrayList;
import cn.edu.dao.TbCompanyDAO;
import cn.edu.entity.TbCompany;

public class CompanyPreviewInfo {
	TbCompany tbCompany;
	TbCompanyDAO tbCompanyDAO;
	
	@SuppressWarnings("unchecked")
	public TbCompany findCompanyInfo(String compUsername){
		tbCompany=new TbCompany();
		tbCompanyDAO=new TbCompanyDAO();
		System.out.println("��ѯ��˾��Ϣ��Service��"+compUsername);
		ArrayList<TbCompany> tbCompanys=new  ArrayList<TbCompany>();
		tbCompanys=(ArrayList<TbCompany>) tbCompanyDAO.findByCompUsername(compUsername);
		tbCompany=tbCompanys.get(0);
		System.out.println("��ѯ��˾��Ϣ��Service���й�˾���"+tbCompany.getCompId()+"�û���"+tbCompany.getCompUsername());
		
		return tbCompany;
		
	}
}
