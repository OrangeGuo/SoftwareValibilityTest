package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JSplitPane;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;

import components.ChartPanelFacotry;
import components.MyProcessBar;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.UIManager;

import java.awt.Font;
import java.io.IOException;
import java.awt.CardLayout;

public class MainFrame extends JFrame implements ActionListener {

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
    private JTabbedPane panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JButton bpnetButton;
    

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/img/526902e1154de.jpg")));
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
		
		bpnetButton = new JButton("bpnet");
		bpnetButton.setBackground(new Color(0, 255, 255));
		bpnetButton.setFont(new Font("Bitstream Vera Sans", Font.PLAIN, 14));
		bpnetButton.addActionListener(this);
		
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
		splitPane_1.setLeftComponent(panel_2);
		
		panel_3 = new JPanel();
		splitPane_1.setRightComponent(panel_3);
		panel_3.setLayout(new GridLayout(12, 1, 0, 0));
		
		panel_1 = new JTabbedPane();
		panel_1.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 14));
		splitPane.setRightComponent(panel_1);
//		panel_1.setLayout(new CardLayout(0, 0));
//		panel_1.add(ChartPanelFacotry.getChartPanel(),"bp");
		
	    panel_3.add(bpnetButton);
	    
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
	    exit.addActionListener(this);
	    exit.setActionCommand("exit");
	    
	    jMenuBar.add(jMenu);
	    
	    contentPane.add(jMenuBar,BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("exit")){
			System.exit(0);
		}
		else if(e.getSource().equals(bpnetButton)){
			bpnetButton.setEnabled(false);
//			try {
//				Process process = Runtime.getRuntime().exec("python2 BPnetwork.py");
//			    try {
//					process.waitFor();
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			} catch (IOException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
			ChartPanel chartPanel = ChartPanelFacotry.getChartPanel();
			panel_1.add(chartPanel,"bpnet");
			panel_1.revalidate();
			bpnetButton.setEnabled(true);
		}
	}
}
