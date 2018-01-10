package cn.edu.action;

import cn.edu.entity.TbStudent;
import cn.edu.service.StuWriteJobInfo;
import com.opensymphony.xwork2.ActionSupport;

public class StuWriteJobInfoAction extends ActionSupport{
	private TbStudent tbStudent;
	private StuWriteJobInfo stuWriteJobInfo;
	
	
	public TbStudent getTbStudent() {
		return tbStudent;
	}

	public void setTbStudent(TbStudent tbStudent) {
		this.tbStudent = tbStudent;
	}
	public StuWriteJobInfo getStuWriteJobInfo() {
		return stuWriteJobInfo;
	}
	public void setStuWriteJobInfo(StuWriteJobInfo stuWriteJobInfo) {
		this.stuWriteJobInfo = stuWriteJobInfo;
	}
	@Override
        public String execute() throws Exception {
		System.out.println("����execute����");
		stuWriteJobInfo=new StuWriteJobInfo();
		System.out.println("����service֮ǰ��ȡ����"+tbStudent.getStuJob());
		stuWriteJobInfo.writeJobInfo(tbStudent);
		System.out.println("����service֮��");
		return SUCCESS;
	}
}
