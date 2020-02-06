package Dao层;

import java.io.File;
import java.io.IOException;

public class UrgentPatientDao extends BaseDao<String> {
	File file = new File("d:"+File.separator+"紧急病人.txt");
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
		
			dao.writefile("紧急病人.txt",s );
	}
}
