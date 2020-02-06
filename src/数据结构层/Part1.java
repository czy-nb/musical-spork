package 数据结构层;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
public class Part1 {
public String name;
public int number=1;
public Part1 father;
static Map subparts =new HashMap<Part1, HashMap<Part1,String>>();
public Map subparts1 = new HashMap<Part1,Integer>();
public static ArrayList<String> list =  new ArrayList<String>();
String s;
public Part1(String n) {		
	name = n;
}
public void setsubpart(Map p) {
	this.subparts1=p;
}
public Map getsubpart() {
	return subparts1;
}
public void setfather(Part1 p) {
	this.father = p;
}
public Part1 getfather() {
	return father;
}
public void describe() {	

extExample1 s1= new extExample1();

System.out.println("Part "+name+" subparts are:");
System.out.println(subparts.size());

Iterator<Map.Entry<Part1, Map>> it = subparts.entrySet().iterator();

while(it.hasNext()) {
	
	Entry<Part1, Map> entry = it.next();
	//System.out.println(entry.getKey().name);
	if (entry.getKey().name.equals(s1.x)) {
		Map subparts1 = entry.getValue();
		
		Iterator<Map.Entry<Part1, String>> it1 = subparts1.entrySet().iterator();
		while(it1.hasNext()) {
			Entry<Part1, String> entry1 = it1.next();
			System.out.println(entry1.getValue());
			list.add(entry1.getValue());
			
	}
		
	
	}
	
}
System.out.println();
}


}