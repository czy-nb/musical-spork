package Dao²ã;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class drugDao extends BaseDao<String>{
	
	File file = new File("d:"+File.separator+"drug.txt");
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
			System.out.println("ÎÄ¼þ´æÔÚ¡£");
		}
		
			dao.writefile("drug.txt",s );

		
		
	}
}
