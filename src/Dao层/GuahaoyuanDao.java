package Dao≤„;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Entity≤„.YiShengInfo;
import Entity≤„.GuaHaoYuanInfo;

public class GuahaoyuanDao {
	 public static   ArrayList<GuaHaoYuanInfo> list = new ArrayList<GuaHaoYuanInfo>() ;
		
		public static  void read() {
		File file = new File("d:"+File.separator+"π“∫≈‘±–≈œ¢.txt");
		
			try {
			//	FileInputStream fis = new FileInputStream(file);
				Scanner input = new Scanner(file);
				
				while (input.hasNext()) {
					String a = input.nextLine();
					//System.out.println(a);
					String[] str = a.split(" ");
					
					//System.out.println(str.length);
//					for (String string : str) {
						//System.out.println(string);
						
				//	}
					GuaHaoYuanInfo doc = new GuaHaoYuanInfo();
					doc.setID(str[0]);
					doc.setZhanghao(str[1]);
					doc.setPasswords(str[2]);
					doc.setName(str[3]);
					list.add(doc);
				}
				
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			}
}
