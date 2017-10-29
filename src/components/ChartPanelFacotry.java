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

	public static ChartPanel  getChartPanel(String net) {
		// TODO Auto-generated method stub
	    StandardChartTheme mChartTheme = new StandardChartTheme("CN");
	    mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
	    mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
	    mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
	    ChartFactory.setChartTheme(mChartTheme);		
	    CategoryDataset mDataset = GetDataset(net);
	    JFreeChart mChart = ChartFactory.createLineChart(
	        "折线图",//图名字
	        "迭代次数",//横坐标
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
	  public static CategoryDataset GetDataset(String net)
	  {
	    DefaultCategoryDataset mDataset = new DefaultCategoryDataset();
	    ArrayList<Float> arrayList = FileFlow.loadFile("data/"+net+".txt");
	    int index=0;
	    float temp =0;
	    for(int i =0;i<arrayList.size();i++){
	    	    temp = arrayList.get(i);
	    	    index =index+i+1;
	    		mDataset.addValue(temp,net,  String.valueOf(i+1));
	    }
	    return mDataset;
	  }
}
