package cn.edu.action;

import cn.edu.entity.TbJob;
import cn.edu.entity.TbStudent;
import cn.edu.service.StudentJobContent;
import cn.edu.service.StudentPreviewResume;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class StudentJobContentAction  extends ActionSupport{
	int jobId;
	StudentJobContent studentJobContent;
	private TbJob tbJob=new TbJob();
	
	private TbStudent tbStudent;
	String stuId;
	
	
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
	
	public TbJob getTbJob() {
		return tbJob;
	}
	public void setTbJob(TbJob tbJob) {
		this.tbJob = tbJob;
	}
	public StudentJobContent getStudentJobContent() {
		return studentJobContent;
	}
	public void setStudentJobContent(StudentJobContent studentJobContent) {
		this.studentJobContent = studentJobContent;
	}
	
	public String execute() throws Exception{
		tbStudent=new TbStudent();
		StudentPreviewResume studentPreviewResume;
		studentPreviewResume=new StudentPreviewResume();
		System.out.println("�鿴������Ƹҳ���е�tbStudent����Ϣ"+tbStudent.getStuId());
		System.out.println("�鿴������Ƹҳ����"+stuId);
		tbStudent=studentPreviewResume.findStuInfo(stuId);
		
		studentJobContent=new StudentJobContent();
		System.out.println("���뵽action��"+jobId);
		tbJob=studentJobContent.searchJobContent(jobId);
		System.out.println("action+"+tbJob.getJobCon());
		System.out.println("��Ҫ��ȡ����Ϣ�ǣ�"+tbJob);
		return SUCCESS;
	}
}
