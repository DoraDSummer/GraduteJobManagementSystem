package cn.edu.action;

import cn.edu.entity.TbStudent;
import cn.edu.service.StuUpdateResume;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class StuUpdateResumeAction extends ActionSupport{
	private TbStudent tbStudent;
	private StuUpdateResume stuUpdateResume;
	private String[] sexs=new String[]{"��","Ů"};
	
	


	public String[] getSexs() {
		return sexs;
	}

	public void setSexs(String[] sexs) {
		this.sexs = sexs;
	}

	public TbStudent getTbStudent() {
		return tbStudent;
	}

	public void setTbStudent(TbStudent tbStudent) {
		this.tbStudent = tbStudent;
	}
	public StuUpdateResume getStuUpdateResume() {
		return stuUpdateResume;
	}
	public void setStuUpdateResume(StuUpdateResume stuUpdateResume) {
		this.stuUpdateResume = stuUpdateResume;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("����execute����");
		stuUpdateResume=new StuUpdateResume();
		System.out.println("����service֮ǰ��ȡ����"+tbStudent.getStuName());
		System.out.println("����service֮ǰ��ȡѧ��ѧ��"+tbStudent.getStuId());
		stuUpdateResume.updateStudentInfo(tbStudent);
		System.out.println("����service֮��");
		return SUCCESS;
	}
}
