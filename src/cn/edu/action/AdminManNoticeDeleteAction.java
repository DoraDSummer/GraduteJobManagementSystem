package cn.edu.action;

import cn.edu.entity.TbPolicy;
import cn.edu.service.AdminManNoticeDelete;

import com.opensymphony.xwork2.ActionSupport;

public class AdminManNoticeDeleteAction extends ActionSupport{
	   int policyId;
       private TbPolicy tbPolicy;
       private AdminManNoticeDelete adminManNoticeDelete;
       
	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public TbPolicy getTbPolicy() {
		return tbPolicy;
	}

	public void setTbPolicy(TbPolicy tbPolicy) {
		this.tbPolicy = tbPolicy;
	}

	public AdminManNoticeDelete getAdminManNoticeDelete() {
		return adminManNoticeDelete;
	}

	public void setAdminManNoticeDelete(AdminManNoticeDelete adminManNoticeDelete) {
		this.adminManNoticeDelete = adminManNoticeDelete;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 adminManNoticeDelete=new AdminManNoticeDelete();
		 tbPolicy=adminManNoticeDelete.find(policyId);	 
		 System.out.println("��Ҫɾ���Ĺ�������:"+tbPolicy.getPolicyId());
		 System.out.println("��Ҫɾ���Ĺ��������:"+tbPolicy.getPolicyTitle());
		 boolean flag=adminManNoticeDelete.deletePolicy(tbPolicy);
		 if(flag){
			 System.out.println("ɾ���ɹ���");
			 return SUCCESS;
		 }
		 else{
			 System.out.println("ɾ��ʧ�ܣ�");
			 return INPUT;
		 }
	}
       
}
