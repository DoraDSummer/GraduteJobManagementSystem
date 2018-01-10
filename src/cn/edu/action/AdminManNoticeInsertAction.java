package cn.edu.action;
import java.awt.SystemColor;
import java.util.Date;

import cn.edu.entity.TbPolicy;
import cn.edu.service.AdminManageNoticeInsert;

import com.opensymphony.xwork2.ActionSupport;

public class AdminManNoticeInsertAction extends ActionSupport {
	private TbPolicy tbPolicy;
	private AdminManageNoticeInsert adminManageNoticeInsert;
	private Date date;
	public TbPolicy getTbPolicy() {
		return tbPolicy;
	}
	public void setTbPolicy(TbPolicy tbPolicy) {
		this.tbPolicy = tbPolicy;
	}
	public AdminManageNoticeInsert getAdminManageNoticeInsert() {
		return adminManageNoticeInsert;
	}

	public void setAdminManageNoticeInsert(
			AdminManageNoticeInsert adminManageNoticeInsert) {
		    this.adminManageNoticeInsert = adminManageNoticeInsert;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		adminManageNoticeInsert=new AdminManageNoticeInsert(); 
		System.out.println("��Ҫ����Ĺ�����Ϣ����Ϊ��"+tbPolicy.getPolicyTitle());
		System.out.println("��Ҫ����Ĺ�����Ϣ����Ϊ��"+tbPolicy.getPolicyCon());
		date=new Date();
		tbPolicy.setPolicyDate(date);
		boolean flag=adminManageNoticeInsert.ManageNoticeInsert(tbPolicy);
		if(flag)
		{
			System.out.println("�Ѿ������˹�����Ϣ��");
			return SUCCESS;
			}
		else
		return INPUT;
	}
    
}
