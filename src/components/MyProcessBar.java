package components;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MyProcessBar extends JDialog {
	final JProgressBar progressBar = new JProgressBar();;
    JPanel jPanel;
	public MyProcessBar(final ArrayList<String> algriothm) {
		jPanel = new JPanel(new BorderLayout());
		this.setLayout(new BorderLayout());
		this.add(jPanel);
		this.setTitle("parsing data");
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 20));
		progressBar.setString("analysing...");
		add(progressBar);
		new Thread() {
			public void run() {
				for (int i = 0; i <=algriothm.size(); i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					progressBar.setValue((i+1)*100/(algriothm.size()+1));
					if(i<algriothm.size()){
						process(algriothm.get(i));
					}
					else {
						progressBar.setString("finished...");
					}
				}
			dispose();
			}
		}.start();
		this.setSize(300, 100);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setResizable(false);
		this.setVisible(true);

	}

	public void process(String codefile) {
		progressBar.setString(codefile + "is running..");
		try {
		Process process = Runtime.getRuntime().exec("python "+codefile+".py");
	    try {
			process.waitFor();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	} catch (Exception e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
		jPanel.revalidate();

	}	
}
