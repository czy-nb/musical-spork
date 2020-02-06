package 数据结构层;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
public class Part {
public String name;
public int number=1;
public Part father;
static Map subparts =new HashMap<Part, HashMap<Part,String>>();
public Map subparts1 = new HashMap<Part,Integer>();
public static ArrayList<String> list =  new ArrayList<String>();
String s;
public Part(String n) {		
	name = n;
}
public void setsubpart(Map p) {
	this.subparts1=p;
}
public Map getsubpart() {
	return subparts1;
}
public void setfather(Part p) {
	this.father = p;
}
public Part getfather() {
	return father;
}
public void describe() {	
list.clear();
extExample s1= new extExample();

System.out.println("Part "+name+" subparts are:");
System.out.println(subparts.size());

Iterator<Map.Entry<Part, Map>> it = subparts.entrySet().iterator();

while(it.hasNext()) {
	
	Entry<Part, Map> entry = it.next();
	//System.out.println(entry.getKey().name);
	if (entry.getKey().name.equals(s1.x)) {
		Map subparts1 = entry.getValue();
		
		Iterator<Map.Entry<Part, String>> it1 = subparts1.entrySet().iterator();
		while(it1.hasNext()) {
			Entry<Part, String> entry1 = it1.next();
			System.out.println(entry1.getValue());
			list.add(entry1.getValue());
			
	}
		
	
	}
	
}
System.out.println();
}


}