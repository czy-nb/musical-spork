package Dao��;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import ����.RegistrationInterface;


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
			System.out.println("�ļ����ڡ�");
		}
	
				dao.writefile("patient.txt", s);
				}
	}

