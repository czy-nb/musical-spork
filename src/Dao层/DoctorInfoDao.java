package Dao层;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Entity层.YiShengInfo;

public class DoctorInfoDao extends BaseDao<String>{
	 public static   ArrayList<YiShengInfo> list = new ArrayList<YiShengInfo>() ;
	public static void main(String[] args) {
		
	}
	
		
		File file = new File("d:"+File.separator+"医生信息.txt");
		BaseDao<String> dao = new BaseDao<String>();
		public void writerfile(String s) {
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("文件存在。");
			}
			
				dao.writefile("医生信息.txt",s );

			
			
		}
		public  void read() {
		File file = new File("d:"+File.separator+"employee.txt");
		
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
					YiShengInfo doc = new YiShengInfo();
					doc.setID(str[0]);
					doc.setZhanghao(str[1]);
					doc.setPasswords(str[2]);
					doc.setName(str[3]);
					list.add(doc);
				}
				System.out.println(list.size());
				
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			}
	}