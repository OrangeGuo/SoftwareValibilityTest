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
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 20));
		progressBar.setString("ready for ...");
		add(progressBar);
		this.setSize(300, 100);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void process() {
		progressBar.setString("finished ,wait ...");
		jPanel.revalidate();
	}

	public void run() {
		new Thread() {
			public void run() {
				for (int i = 0; i <= 100; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					progressBar.setValue(i);
				}
				progressBar.setString("right now");
			}
		}.start();
	}
	
}
