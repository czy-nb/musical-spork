package 数据结构层;

import java.util.Map;


public class NameContainer  {
	public Map<String,Part> name_map;
	
    public NameContainer() {
    	
    }

	public Part lookup(String name) {
        Part p =new Part(name);
        return p;
	}
}