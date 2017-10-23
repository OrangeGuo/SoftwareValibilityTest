package components;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartPanelFacotry {

	public static ChartPanel  getChartPanel() {
		// TODO Auto-generated method stub
	    StandardChartTheme mChartTheme = new StandardChartTheme("CN");
	    mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
	    mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
	    mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
	    ChartFactory.setChartTheme(mChartTheme);		
	    CategoryDataset mDataset = GetDataset();
	    JFreeChart mChart = ChartFactory.createLineChart(
	        "折线图",//图名字
	        "迭代次数(百次)",//横坐标
	        "误差",//纵坐标
	        mDataset,//数据集
	        PlotOrientation.VERTICAL,
	        true, // 显示图例
	        true, // 采用标准生成器 
	        false);// 是否生成超链接
	    
	    CategoryPlot mPlot = (CategoryPlot)mChart.getPlot();
	    mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
	    mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
	    mPlot.setOutlinePaint(Color.RED);//边界线
	    
	    ChartPanel mChartFrame = new ChartPanel(mChart);
	    return mChartFrame;

	}
	  public static CategoryDataset GetDataset()
	  {
	    DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
	    ArrayList<Float> arrayList = FileFlow.loadFile("data/BPnetwork.txt");
	    for(int i =0;i<arrayList.size();i++){
	    	if(i%10==0)
	    		mDataset.addValue(arrayList.get(i), "BPN", String.valueOf(i/10));
	    	else 
	    		mDataset.addValue(arrayList.get(i), "BPN","");
	    }
	    return mDataset;
	  }
}
