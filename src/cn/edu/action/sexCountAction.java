package cn.edu.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import cn.edu.dao.JobCountDAO;

import com.opensymphony.xwork2.ActionSupport;

public class sexCountAction extends ActionSupport {
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
		// System.out.println(search);
		HttpServletRequest request = ServletActionContext.getRequest();
		search = request.getParameter("search");
		String str = null;
		try {
			str = new String(search.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.total(str);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(c.getMtotal(), "����", "����");
		dataset.addValue(c.getMtotal1(), "��ҵ����", "����");
		dataset.addValue(c.getWtotal(), "����", "Ů��");
		dataset.addValue(c.getWtotal1(), "��ҵ����", "Ů��");
		chart = ChartFactory.createBarChart3D("�С�Ůͳ��ͼ", // ͼ�����
				"�Ա�", // Ŀ¼�����ʾ��ǩ
				"����", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
				);

		CategoryPlot plot = chart.getCategoryPlot();// ��ȡͼ���������
		java.awt.Font font = new java.awt.Font("����", 20, 15);
		CategoryAxis domainAxis = plot.getDomainAxis();// (��״ͼ��x��)
		domainAxis.setTickLabelFont(font);// ����x�������ϵ�����
		domainAxis.setLabelFont(font);// ����x���ϵı��������
		ValueAxis valueAxis = plot.getRangeAxis();// (��״ͼ��y��)
		valueAxis.setTickLabelFont(font);// ����y�������ϵ�����
		valueAxis.setLabelFont(font);// ����y�������ϵı��������
		chart.getTitle().setFont(font);
		chart.getLegend().setItemFont(font);
		domainAxis.setVisible(true);
		// ChartFrame chartframe = new ChartFrame("BarChart", chart);
		// chartframe.pack();
		// chartframe.setVisible(true);
		return "success";

	}

}
