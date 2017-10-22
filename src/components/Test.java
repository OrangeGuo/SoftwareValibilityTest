package components;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        ArrayList<Float> arrayList = FileFlow.loadFile("/home/orange/Workspaces/MyEclipse 2015/SoftwareReliabilityTest/b.txt");
//        for(int i=0;i<arrayList.size();i++)
//        	System.out.println(arrayList.get(i));
		try {
			Process process = Runtime.getRuntime().exec("python2 /home/orange/PycharmProjects/machinelearning/BPnetwork.py");
//		    Process process = Runtime.getRuntime().exec("python2  BPnetwork.py");
			try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
