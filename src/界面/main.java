package 界面;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Service层.DrugStockService;
import Service层.YiKaTongInfoService;
import Service层.DoctorService;

public class main {
      public static void main(String[] args) {
    	  File file = new File("d://医生信息.txt");
  		String s = "红霉素"+" "+"10";
  		System.out.println(file.getName());
  		DrugStockService ser = new DrugStockService ();
  		
  		ser.writerfile(s+"\r\n");
//  		try {
//  			Scanner in = new Scanner(file);
//  			while(in.hasNext()) {
//  				String l = in.nextLine();
//  				System.out.println(l);
////  				String[] temp = l.split(" ");
////  				String drug1 = temp[0];
////  				int num1 = Integer.parseInt(temp[1].trim());
////  				System.out.println(num1);
//  		}} catch (FileNotFoundException e) {
//  			// TODO Auto-generated catch block
//  			e.printStackTrace();
//  		}
	}
}
