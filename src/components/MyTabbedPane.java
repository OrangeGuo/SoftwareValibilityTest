package components;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartPanel;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class MyTabbedPane extends JTabbedPane implements ActionListener{
//	private JTabbedPane jTabbedPane;
	private JPanel jpanel;
	private JButton close;
	private ArrayList<JPanel> jPanels;
	private ArrayList<JButton> jButtons;
	private ArrayList<String> notes;
    public MyTabbedPane() {
		// TODO Auto-generated constructor stub
    	setFont(new Font("Bitstream Vera Sans", Font.BOLD, 14));
    	jButtons = new ArrayList<JButton>();
    	jPanels = new ArrayList<JPanel>();
    	notes = new ArrayList<String>();
	}
    public void  addChart(ChartPanel chartpanel,String note){
    	jpanel = new JPanel(new BorderLayout());
    	close = new JButton("close");
    	close.addActionListener(this);
    	jpanel.add(close,BorderLayout.SOUTH);
    	jpanel.add(chartpanel,BorderLayout.CENTER);
    	jPanels.add(jpanel);
    	jButtons.add(close);
    	this.add(jpanel,note);
    	this.setSelectedIndex(notes.size());
    	notes.add(note);
    }
    public void  addData(MyDataPanel myDataPanel,String note){
    	jpanel = new JPanel(new BorderLayout());
    	close = new JButton("close");
    	close.addActionListener(this);
    	jpanel.add(close,BorderLayout.SOUTH);
    	jpanel.add(myDataPanel,BorderLayout.CENTER);
    	jPanels.add(jpanel);
    	jButtons.add(close);
    	this.add(jpanel,note);
    	this.setSelectedIndex(notes.size());
    	notes.add(note);
    }
    public boolean isHave(String note){
    	boolean flag = false;
    	for(int i = 0;i < notes.size();i++)
    		if(note.equals(notes.get(i))){
    			flag = true;
    			this.setSelectedIndex(i);
    			break;
    		}
    	return flag;
    }
    public void remove(String note){
     	for(int i = 0;i < notes.size();i++)
    		if(note.equals(notes.get(i))){
				jButtons.remove(i);
				this.remove(jPanels.get(i));
				jPanels.remove(i);
				notes.remove(i);
				break;
    		}
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0;i<jButtons.size();i++)
			if(e.getSource().equals(jButtons.get(i))){
				jButtons.remove(i);
				this.remove(jPanels.get(i));
				jPanels.remove(i);
				notes.remove(i);
				break;
			}
	}

}
