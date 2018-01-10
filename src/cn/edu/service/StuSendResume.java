package cn.edu.service;

import cn.edu.dao.TbJobDAO;
import cn.edu.dao.TbStujobDAO;
import cn.edu.entity.TbJob;
import cn.edu.entity.TbStudent;
import cn.edu.entity.TbStujob;
import cn.edu.entity.TbStujobId;

public class StuSendResume {
	TbStujobDAO tbStujobDao;
	TbJobDAO tbJobDao;
	TbStujobId tbStujobId;

	public boolean senResume(TbStudent tbStudent, int tbJobId) {
		System.out.println("��ѧ������Ͷ�ݵ�Service���У�ѧ����Ϣ" + tbStudent.getStuNum()
				+ tbStudent.getStuName() + tbStudent.getStuId());

		TbJob tbJob = new TbJob();
		tbJobDao = new TbJobDAO();
		tbJob = tbJobDao.findById(tbJobId);
		System.out.println("��ѧ������Ͷ�ݵ�Service���У�������Ϣ" + tbJob.getJobId()
				+ tbJob.getJobTitle());

		tbStujobId = new TbStujobId();
		tbStujobId.setTbJob(tbJob);
		tbStujobId.setTbStudent(tbStudent);
		try {
			TbStujob tbStujob = new TbStujob();// ����Ҫ�洢����Ϣ
			tbStujob.setId(tbStujobId);
			tbStujobDao = new TbStujobDAO();
			tbStujobDao.save(tbStujob);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
	}
}
