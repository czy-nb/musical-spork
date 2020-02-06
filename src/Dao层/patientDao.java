package Dao层;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import 界面.RegistrationInterface;


public class patientDao extends BaseDao<String>{
	File file = new File("d:"+File.separator+"patient.txt");
	
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
	
				dao.writefile("patient.txt", s);
				}
	}

