package Dao��;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Entity��.GuaHaoYuanInfo;
import Entity��.YaoJuRenYuanInfo;

public class OfficinaInfoDao {
	 public static   ArrayList<YaoJuRenYuanInfo> list = new ArrayList<YaoJuRenYuanInfo>() ;
		
		public static  void read() {
		File file = new File("d:"+File.separator+"ҩ����Ա��Ϣ.txt");
		
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
					YaoJuRenYuanInfo doc = new YaoJuRenYuanInfo();
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
