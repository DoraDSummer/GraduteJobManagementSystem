package cn.edu.service;


import cn.edu.dao.TbPolicyDAO;
import cn.edu.entity.TbPolicy;

public class AdminManageNoticeInsert {
        private TbPolicyDAO tbPolicyDAO;
        private TbPolicy tbPolicy;
		public TbPolicyDAO getTbPolicyDAO() {
			return tbPolicyDAO;
		}
		public void setTbPolicyDAO(TbPolicyDAO tbPolicyDAO) {
			this.tbPolicyDAO = tbPolicyDAO;
		}
		public TbPolicy getTbPolicy() {
			return tbPolicy;
		}
		public void setTbPolicy(TbPolicy tbPolicy) {
			this.tbPolicy = tbPolicy;
		}
		public boolean ManageNoticeInsert(TbPolicy Policy){
			    tbPolicyDAO=new TbPolicyDAO();
			    tbPolicy =new TbPolicy();
			try{
				System.out.println("����Ĺ�����Ϣ����Ϊ��"+Policy.getPolicyTitle());
				System.out.println("����Ĺ�����Ϣ����Ϊ��"+Policy.getPolicyCon());
				tbPolicyDAO.save(Policy);
				return true;
			}catch(Throwable te){
				System.err.println("error:++++++++");
				te.printStackTrace();
				return false;
			}
			
		}
        
}
