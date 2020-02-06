package Dao层;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import 界面.AdministorInterface;



	public class ControllerDao extends BaseDao<String>{
		String name = new AdministorInterface().str1;
		
		File file = new File("d:"+name+".txt");
		
		
		BaseDao<String> dao = new BaseDao<String>();
		public void writerfile(String s) {
			System.out.println(name);
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
			
				dao.writefile(name+".txt",s );

			
			
}
}