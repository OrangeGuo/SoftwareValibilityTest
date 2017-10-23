package components;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MyProcessBar extends JPanel{
	final JProgressBar progressBar = new JProgressBar();;
	public MyProcessBar(){
		this.setLayout(new BorderLayout());
        progressBar.setStringPainted(true);  
        progressBar.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 20));
        add(progressBar); 
	}
	public void run(){
	    new Thread(){  
            public void run(){  
                for(int i=0;i<=100;i++){  
                    try{  
                        Thread.sleep(100);  
                    }catch(InterruptedException e){  
                        e.printStackTrace();  
                    }  
                      progressBar.setValue(i);  
                }  
                progressBar.setString("right now");  
            }  
        }.start();  
	}

}
