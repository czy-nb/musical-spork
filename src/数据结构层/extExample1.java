package 数据结构层;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import 界面.AdministorInterface;


public class extExample1 {
	
	public static String x;
	static public NameContainer1 partContainer;
   
    static public void load_definitions(String filename) throws FileNotFoundException {
       Scanner infile = new Scanner(new FileInputStream(filename));
       String part,subpart;
       
       while(infile.hasNext()) {
    	   String s = infile.nextLine();
    	   String[] str = s.split(",");
    	   part = str[0];
    	   subpart = str[1];
    	   add_part(part,subpart);
       }
   	   infile.close();
    }

    static void whatis_query(String x) {
    	Part1 xp = partContainer.lookup(x);
    	    	
    	if(xp != null)
    		
    	   xp.describe();
    }

  
    static void process_queries(String filename) throws FileNotFoundException {
        String query, x, y;
        Scanner infile = new Scanner(new FileInputStream(filename));
      
        while(infile.hasNext()) {
     	   query = infile.next();
     	   x = infile.next();
     	  // temp = x;
           if(query.equals("howmany")) {
     	       y = infile.next();
     	       //temp1 = y;
     	      
			
           }
		   else if ( query.equals("whatis") )
			   whatis_query(x);     	   
        }
    	infile.close();
    }
    
    static public void add_part(String x,  String  y) {
    	
    	Part1 p=partContainer.lookup(x);
    	Part1 m =partContainer.lookup(y);
    	
    	Map map = new HashMap<Part1, String>();
    	p.name=x;
    	map.put(p,x);
    	p.subparts.put(m,map);
    	m.setsubpart(map);
//        m.setfather(p);
    	//System.out.println(p.subparts.size());
    }
		

    public static void main(String[] args) throws FileNotFoundException{
    	partContainer = new NameContainer1();
    	load_definitions("d:/tree2.txt");
    	x = new AdministorInterface().str;
    	System.out.println(x);
    	//x = new Scanner(System.in).next();
        //x = new 问诊开药界面4().userText8.getText();
    	whatis_query(x);
//    	if (new Part("1").list.isEmpty()) {
//    		System.out.println(x);
//    	}
    	//process_queries("d://queries.txt");
    	
    }
}