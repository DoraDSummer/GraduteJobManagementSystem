package cn.edu.service;

import java.util.ArrayList;

import cn.edu.dao.TbJobDAO;
import cn.edu.dao.TbStudentDAO;
import cn.edu.entity.TbJob;
import cn.edu.entity.TbStudent;

public class StuWriteJobInfo {
	private TbStudent tbStudent;
	private TbStudentDAO tbStudentDAO;

	@SuppressWarnings("unchecked")
	public void writeJobInfo(TbStudent student) {
		System.out.println("����service��,�������" + student.getStuId());
		tbStudent = new TbStudent();
		tbStudentDAO = new TbStudentDAO();
		try {
			ArrayList<TbStudent> tbstudents = new ArrayList<TbStudent>();
			tbstudents = (ArrayList<TbStudent>) tbStudentDAO
					.findByStuId(student.getStuId());

			tbStudent = tbstudents.get(0);
			System.out.println(" ��д��ҵ��Ϣaction�е��������" + tbStudent.getStuNum());
			tbStudent.setStuJob(student.getStuJob());
			tbStudent.setStuComp(student.getStuComp());
			System.out.println(" ��д��ҵ��Ϣaction�е��������action�еĴ���ѧ��" + student.getStuId());			
			// student���»ἶ��������������ı�������ǵ�ֵ�仯�˵Ļ�
			tbStudentDAO.merge(tbStudent);
		} finally {

		}
	}
	
}
