package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSplitPane;

import components.ChartPanelFacotry;
import components.FileFlow;
import components.MyDataPanel;
import components.MyProcessBar;
import components.MyTabbedPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.UIManager;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class MainFrame extends JFrame implements ActionListener,MouseListener{

	/**
	 * @author orange
	 *
	 */
	private JPanel contentPane;
    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenuItem exit;
    private JMenuItem loaddata;
    private JMenuItem analyse;
    private JSplitPane splitPane_1;
    private MyTabbedPane panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JLabel lblNewLabel;
    private JList list;
    private ArrayList<String> fileList,network;
    private ArrayList<JButton> jButtons;

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
//					frame.setResizable(false);
					frame.setSize(800, 600);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/img/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("SRTp");
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		network = new ArrayList<String>();
		network.add("BPnetwork");
		network.add("ELM");
		network.add("RNN");
//		network.add("Fail");
		
		jButtons = new ArrayList<JButton>();
		
		for(int i = 0;i<network.size();i++){
			JButton jButton = new JButton(network.get(i));
			jButton.setBackground(new Color(0, 255, 255));
			jButton.setFont(new Font("Bitstream Vera Sans", Font.PLAIN, 14));
			jButton.addActionListener(this);
			jButton.setEnabled(false);
			jButtons.add(jButton);
		}
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.2);
		splitPane.setForeground(Color.WHITE);
		splitPane.setBackground(Color.WHITE);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.3);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane_1, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		splitPane_1.setLeftComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Data");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 16));
		
//		this.loaddata();
		
		panel_3 = new JPanel();
		splitPane_1.setRightComponent(panel_3);
		panel_3.setLayout(new GridLayout(12, 1, 0, 0));
		
		panel_1 = new MyTabbedPane();
		splitPane.setRightComponent(panel_1);
		
	    for(int i = 0;i<network.size();i++)
	    	panel_3.add(jButtons.get(i));
	    
	    jMenuBar = new JMenuBar();
	    jMenuBar.setBackground(new Color(192, 192, 192));
	    
	    jMenu = new JMenu("option");
	    jMenu.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
	    jMenu.setForeground(Color.BLACK);
	    jMenu.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
	    
	    exit = new JMenuItem("exit");
	    exit.setBackground(new Color(255, 255, 255));
	    exit.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
	    loaddata = new JMenuItem("load");
	    loaddata.setBackground(new Color(255, 255, 255));
	    loaddata.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
	    analyse = new JMenuItem("analyse");
	    analyse.setBackground(new Color(255, 255, 255));
	    analyse.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 12));
	    
	    jMenu.add(loaddata);
	    jMenu.add(analyse);
	    jMenu.add(exit);
	    
	    loaddata.addActionListener(this);
	    loaddata.setActionCommand("load");
	    analyse.addActionListener(this);
	    analyse.setActionCommand("analyse");
	    analyse.setEnabled(false);
	    exit.addActionListener(this);
	    exit.setActionCommand("exit");
	    
	    jMenuBar.add(jMenu);
	    
	    contentPane.add(jMenuBar,BorderLayout.NORTH);
	}
    public void loaddata(){
    	for(int i = 0;fileList!=null&&i<fileList.size();i++)
    		panel_1.remove(fileList.get(i));
    	panel_2.removeAll();
    	panel_2.add(lblNewLabel, BorderLayout.NORTH);
		fileList = FileFlow.getDirectory();
		list = new JList((String [])fileList.toArray(new String[fileList.size()]));
		list.setBorder(new EmptyBorder(0, 0, 0, 0));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(Color.WHITE);
		list.setVisibleRowCount(5);
		list.setFont(new Font("Bitstream Vera Sans", Font.PLAIN, 12));
		list.addMouseListener(this);
		list.setSelectedIndex(0);
		panel_2.add(list, BorderLayout.CENTER);
		panel_2.revalidate();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.revalidate();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("exit")){
			System.exit(0);
		}
		
		else if(e.getActionCommand().equals("load")){
			this.loaddata();
			if(fileList.size()!=0)
				this.analyse.setEnabled(true);
			else {
				JOptionPane.showMessageDialog(null, "No files founde,please reload!","Warnning",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getActionCommand().equals("analyse")){
			String data = fileList.get(list.getSelectedIndex());
			if(data.endsWith(".DAT")){
				MyProcessBar myProcessBar = new MyProcessBar(network,data);
				for(int i = 0;i<jButtons.size();i++)
					jButtons.get(i).setEnabled(true);
				this.loaddata();
			}
			else{
				JOptionPane.showMessageDialog(null, "file must end with DAT!","Warnning",JOptionPane.WARNING_MESSAGE);
			}
		}
		else{
			for(int i = 0;i<jButtons.size();i++){
				JButton jButton=jButtons.get(i);
				if(e.getSource().equals(jButton)&&!panel_1.isHave(network.get(i))){
					jButton.setEnabled(false);
					panel_1.addChart(ChartPanelFacotry.getChartPanel(network.get(i)), network.get(i));
					jButton.setEnabled(true);			
				}
			}

		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2){
			String filepath = fileList.get(list.getSelectedIndex());
			if(!panel_1.isHave(filepath)){
				panel_1.addData(new MyDataPanel("data/"+filepath),filepath);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
