package Dao��;

import java.io.File;
import java.io.IOException;

public class DiagnoseMessageDao {
File file = new File("d:"+File.separator+"�����Ϣ.txt");
	
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
		
		}
		dao.writefile("�����Ϣ.txt", s);

}
}