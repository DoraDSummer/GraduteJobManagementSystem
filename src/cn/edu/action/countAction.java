package cn.edu.action;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import cn.edu.dao.JobCountDAO;

import com.opensymphony.xwork2.ActionSupport;

public class countAction extends ActionSupport {
	private String path;
	private JFreeChart chart;

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String totalCount() {
		JobCountDAO c = new JobCountDAO();
		c.count();
		c.getGraduation();
		c.getJonGrad();
		DefaultPieDataset dpd = new DefaultPieDataset();
		dpd.setValue("δ��ҵ��������" + (c.getGraduation() - c.getJonGrad()),
				c.getGraduation() - c.getJonGrad());
		dpd.setValue("�Ѿ�ҵ��������" + c.getJonGrad(), c.getJonGrad());
		chart = ChartFactory.createPieChart3D("XXѧУ��ҵ�ṹͼ", dpd, true, false,
				false);
		PiePlot pieplot = (PiePlot) chart.getPlot();
		java.awt.Font font = new java.awt.Font("����", 20, 15);
		pieplot.setLabelFont(font); // ���ñ�״ͼ����ĵĸ�����ǩ����
		chart.getLegend().setItemFont(font);// ����ͼ���·���ͼ��˵������
		chart.setTitle(new TextTitle("XXѧУ��ҵ�ṹͼ", font));// ���ñ���
		// pieplot.setExplodePercent("�Ѿ�ҵ��������"+c.getJonGrad(), 0.5);//ȡ��һ����
		pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}({2} percent)"));	

		return "success";

	}

}
