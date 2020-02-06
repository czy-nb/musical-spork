package Dao²ã;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

public class readPatientDao {
	static ArrayList<String[]> list = new ArrayList<String[]>();
	static File file = new File("d:"+File.separator+"patient.txt");

 public static void main(String[] args) {
	readFile(file);
}
public static  ArrayList<String[]> readFile(File file) {
	try {
		 //ArrayList<String[]> list = new ArrayList<String[]>();
		Scanner in =new Scanner(file);
		FileReader fileReader = new FileReader(file);
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
        lineNumberReader.skip(Long.MAX_VALUE);
       int lines = lineNumberReader.getLineNumber();
        
		while(in.hasNext()) {
			//for (int i=0;i<lines;i++) {
				String s = in.nextLine();
				String[] str = s.split(" ");
				list.add(str);
			//}
		}

		
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block	
		e.printStackTrace();		
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	//return list;
	return list;


}
}
