package Service≤„;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Dao≤„.YiZhuDao;
import Entity≤„.PatientInfo;
import ΩÁ√Ê.RegistrationInterface;

public class YiZhuService {
	public void writerfile(String s) {
		YiZhuDao yizhu = new YiZhuDao();
		yizhu.writerfile(s);
	}
}