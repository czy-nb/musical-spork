package Service��;

	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;

import Dao��.drugDao;

	
	public class drugService{
		public void writerfile(String s) {
			drugDao drug = new drugDao();
			drug.writerfile(s);
		}

	}

