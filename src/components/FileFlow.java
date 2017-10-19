package components;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileFlow {
	public static String loadFile(String filename){
		FileReader filereader=null;
		BufferedReader bufferedreader=null;
		String content = "";
	     try {
			filereader=new FileReader(filename);
			bufferedreader=new BufferedReader(filereader);
			String s="";
				while((s=bufferedreader.readLine())!=null)
				{   
					s += "\t\r";
			        content += s;
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
