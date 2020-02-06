package 数据结构层;

import java.util.Map;


public class NameContainer1  {
	public Map<String,Part1> name_map;
	
    public NameContainer1() {
    	
    }

	public Part1 lookup(String name) {
        Part1 p =new Part1(name);
        return p;
	}
}