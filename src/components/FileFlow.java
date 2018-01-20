package components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileFlow {
	public static ArrayList<Float> loadFile(String filename){
		FileReader filereader=null;
		BufferedReader bufferedreader=null;
		ArrayList<Float> arrayList = new ArrayList<Float>();
	     try {
			filereader=new FileReader(filename);
			bufferedreader=new BufferedReader(filereader);
			String s="";
				while((s=bufferedreader.readLine())!=null)
				{   
					if(!s.equals(""))
						arrayList.add(Float.parseFloat(s));
				}	
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferedreader.close();
				filereader.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   }
	     return arrayList;
	}
	public static ArrayList<String> getDirectory(){
		ArrayList<String> directory  = new ArrayList<String>();
		File file = new File("data");
		if(!file.exists()||!file.isDirectory()){
			JOptionPane.showMessageDialog(null, "no data found in "+System.getProperty("user.dir"),"Warnning",JOptionPane.WARNING_MESSAGE);
		}
		else {
			File files[] = file.listFiles();
			for(int i = 0;i < files.length; i++)
				directory.add(files[i].getName());
		}
		return directory;
	}
	public static String getContent(String filename){
		FileReader filereader=null;
		BufferedReader bufferedreader=null;
		String content = "";
	     try {
			filereader=new FileReader(filename);
			bufferedreader=new BufferedReader(filereader);
			String s="";
				while((s=bufferedreader.readLine())!=null)
				{   
					content += s;
					content += "\r\n";
				}	
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferedreader.close();
				filereader.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   }
	     return content;
	}
}
