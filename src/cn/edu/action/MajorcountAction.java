package cn.edu.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import cn.edu.dao.JobCountDAO;

import com.opensymphony.xwork2.ActionSupport;

public class MajorcountAction extends ActionSupport {
	private String search;
	private JFreeChart chart;

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String totalCount() {
		JobCountDAO c = new JobCountDAO();

		// System.out.println(c.getGraduation());
		// System.out.println(c.getJonGrad());
		HttpServletRequest request = ServletActionContext.getRequest();
		search = request.getParameter("search");
		String str = null;
		try {
			str = new String(search.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(str);
		c.total(str);
		// System.out.println(c.getTotal());
		// System.out.println("++++++++++++");
		c.getTotal1();
		DefaultPieDataset dpd = new DefaultPieDataset();
		dpd.setValue("δ��ҵ��������" + (c.getTotal() - c.getTotal1()), c.getTotal()
				- c.getTotal1());
		dpd.setValue("�Ѿ�ҵ��������" + c.getTotal1(), c.getTotal1());
		chart = ChartFactory.createPieChart3D(str, dpd, true, false, false);
		PiePlot pieplot = (PiePlot) chart.getPlot();
		java.awt.Font font = new java.awt.Font("����", 20, 15);
		pieplot.setLabelFont(font); // ���ñ�״ͼ����ĵĸ�����ǩ����
		chart.getLegend().setItemFont(font);// ����ͼ���·���ͼ��˵������
		chart.setTitle(new TextTitle(str, font));// ���ñ���
		// pieplot.setExplodePercent("�Ѿ�ҵ��������"+c.getJonGrad(), 0.5);//ȡ��һ����
		pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}({2} percent)"));
		return "success";

	}

}
