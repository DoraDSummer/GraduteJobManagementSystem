package cn.edu.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.entity.TbCompany;
import cn.edu.service.CompanyCompleteInfo;

public class CompanyCompleteInfoAction extends ActionSupport{
	TbCompany tbCompany;
	CompanyCompleteInfo companyCompleteInfo;
	
	public TbCompany getTbCompany() {
		return tbCompany;
	}
	public void setTbCompany(TbCompany tbCompany) {
		this.tbCompany = tbCompany;
	}
	public CompanyCompleteInfo getCompanyCompleteInfo() {
		return companyCompleteInfo;
	}
	public void setCompanyCompleteInfo(CompanyCompleteInfo companyCompleteInfo) {
		this.companyCompleteInfo = companyCompleteInfo;
	}
	
	public String execute(){
		companyCompleteInfo=new CompanyCompleteInfo();
		System.out.println("������ҵ��Ϣaction������ҵ���û���"+tbCompany.getCompUsername());
		companyCompleteInfo.completeInfo(tbCompany);
		return SUCCESS;
		
	}
}
