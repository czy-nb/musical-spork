package ����;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Service��.DrugStockService;
import Service��.YiKaTongInfoService;
import Service��.DoctorService;

public class main {
      public static void main(String[] args) {
    	  File file = new File("d://ҽ����Ϣ.txt");
  		String s = "��ù��"+" "+"10";
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
