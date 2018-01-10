package cn.edu.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.entity.TbStudent;
import cn.edu.service.StudentPreviewResume;

public class CompCheckStuResume extends ActionSupport{
	TbStudent tbStudent;
	StudentPreviewResume studentPreviewResume;
	String stuId;
	

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public TbStudent getTbStudent() {
		return tbStudent;
	}

	public void setTbStudent(TbStudent tbStudent) {
		this.tbStudent = tbStudent;
	}
	
	public String execute() throws Exception{
		tbStudent=new TbStudent();
		studentPreviewResume=new StudentPreviewResume();
		System.out.println("��˾�鿴ѧ��������tbStudent����Ϣ"+tbStudent.getStuId());
		System.out.println("��˾�鿴ѧ�����������е�"+stuId);
		tbStudent=studentPreviewResume.findStuInfo(stuId);
		System.out.println("��˾�鿴ѧ������action+"+tbStudent.getStuName());
		System.out.println("��˾�鿴ѧ����������Ϣ�ǣ�"+tbStudent);
		return SUCCESS;
	}
}
