package Dao²ã;

import java.io.File;
import java.io.FileOutputStream;

public class BaseDao<T> {

	public void writefile(String filename,T t) {
		try {
			File file = new File("d:"+File.separator+filename);
			FileOutputStream fos = new FileOutputStream(file,true);
			byte[] bt = new byte[1024];
			bt = ((String) t).getBytes();
			int b = bt.length;
			fos.write(bt,0,b);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
