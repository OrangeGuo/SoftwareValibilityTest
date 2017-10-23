package components;

import javax.swing.JFrame;

public class Test extends JFrame{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        ArrayList<Float> arrayList = FileFlow.loadFile("/home/orange/Workspaces/MyEclipse 2015/SoftwareReliabilityTest/b.txt");
           Test test = new Test();
	}
	public Test(){
	     this.setTitle("进度条的使用");  
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	     this.setBounds(100, 100, 400, 400); 
	     this.add(new MyProcessBar());
	     this.setVisible(true);
	}

}
