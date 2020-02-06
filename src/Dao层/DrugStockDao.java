package Dao²ã;

import java.io.File;
import java.io.IOException;

public class DrugStockDao extends BaseDao<String>{
	
	File file = new File("d:"+File.separator+"drug¿â´æ.txt");
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
		
			dao.writefile("drug¿â´æ.txt",s );

		
		
	}
}