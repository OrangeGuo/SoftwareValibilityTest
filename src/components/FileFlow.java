package components;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
}
