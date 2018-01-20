package components;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyDataPanel extends JScrollPane{
	public MyDataPanel(String path){
//		setLayout(new BorderLayout());
		setFont(new Font("Bitstream Vera Sans", Font.BOLD, 14));
		JTextArea jTextArea = new JTextArea(FileFlow.getContent(path));
		jTextArea.setEditable(false);
		setViewportView(jTextArea);
	}

}
