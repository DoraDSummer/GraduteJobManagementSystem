package cn.edu.service;

import java.util.ArrayList;
import java.util.List;
import cn.edu.dao.TbStujobDAO;
import cn.edu.entity.TbJob;
import cn.edu.entity.TbStudent;
import cn.edu.entity.TbStujob;
import cn.edu.entity.TbStujobId;

//ѧ���鿴����Ͷ�ݵ�action
public class StuResumeJobList {
	private TbStujobDAO tbStujobDao;
	private List<TbJob> tbJobs;
	private List<TbStujob> tbStujobs;

	@SuppressWarnings("unchecked")
	public List<TbJob> LoadJobList(TbStudent tbStudent) {
		tbJobs = new ArrayList<TbJob>();
		tbStujobDao = new TbStujobDAO();
		tbStujobs = new ArrayList<TbStujob>();
		TbStujobId tbStujobId = new TbStujobId();
		try {

			tbStujobs = (List<TbStujob>) tbStujobDao.findAll();
			System.out.println("��ѯѧ������Ͷ�ݵ�Service�� ѧ��������ĳ���" + tbStujobs.size());
			for (int i = 0; i < tbStujobs.size(); i++) {
				tbStujobId = tbStujobs.get(i).getId();
				TbStudent comTbStudent = new TbStudent();
				comTbStudent = tbStujobId.getTbStudent();
				System.out.println("�鿴ѧ������Ͷ��service����ѧ��������"
						+ comTbStudent.getStuId() + comTbStudent.getStuName()
						+ "���" + comTbStudent.getStuNum());
				System.out.println("�鿴ѧ������Ͷ��service���д������ѧ��������"
						+ tbStudent.getStuName());
				if (comTbStudent.equals(tbStudent)) {
					try {
						if (tbStujobId.getTbJob().getJobTitle() != null) {
							tbJobs.add(tbStujobId.getTbJob());
						}
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			}
			return tbJobs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
