package Dao��;

import java.io.File;
import java.io.IOException;

public class StomachDao extends BaseDao<String>{
	File file = new File("d:"+File.separator+"θ��.txt");
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
			System.out.println("�ļ����ڡ�");
		}
		
			dao.writefile("θ��.txt",s );
	}
		
}
