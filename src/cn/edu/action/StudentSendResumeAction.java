package cn.edu.action;

import cn.edu.entity.TbStudent;
import cn.edu.service.StuSendResume;
import cn.edu.service.StudentPreviewResume;

import com.opensymphony.xwork2.ActionSupport;

public class StudentSendResumeAction extends ActionSupport{
	
	TbStudent tbStudent;
	String stuId;
	int jobId;
	public TbStudent getTbStudent() {
		return tbStudent;
	}
	public void setTbStudent(TbStudent tbStudent) {
		this.tbStudent = tbStudent;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	public String  execute() {
		System.out.println("��ѧ������Ͷ�ݵ�Action�е�ѧ��"+stuId);
		System.out.println("��ѧ������Ͷ�ݵ�Action�еĹ������"+jobId);
		StudentPreviewResume studentPreviewResume=new StudentPreviewResume();
		tbStudent=studentPreviewResume.findStuInfo(stuId);
		StuSendResume stuSendResume=new StuSendResume();
		
		if (stuSendResume.senResume(tbStudent, jobId)) {
			return SUCCESS;
		}else {
			return "false";
		}
		
		
	}
}
