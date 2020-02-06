package Service²ã;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao²ã.readPatientDao;

public class ReadPatientService {
	public  ArrayList<String[]> readFile(File file) {
		readPatientDao patientDao = new readPatientDao();
		return patientDao.readFile(file);
	}
}
