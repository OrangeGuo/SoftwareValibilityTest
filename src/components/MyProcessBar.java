package components;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MyProcessBar extends JDialog {
	final JProgressBar progressBar = new JProgressBar();;
    JPanel jPanel;
	public MyProcessBar() {
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
				for (int i = 0; i <= 10; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					progressBar.setValue((i+1)*10);
				}
				process();
			}
		}.start();
		this.setSize(300, 100);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void process() {
		try {
		Process process = Runtime.getRuntime().exec("python EML.py");
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
		progressBar.setString("finished ,wait ...");
		jPanel.revalidate();
		this.dispose();
	}	
}
