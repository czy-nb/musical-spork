package Dao层;

import java.io.File;
import java.io.IOException;

public class DiagnoseMessageDao {
File file = new File("d:"+File.separator+"诊断信息.txt");
	
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
		dao.writefile("诊断信息.txt", s);

}
}