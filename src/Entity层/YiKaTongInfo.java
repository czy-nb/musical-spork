package Entity²ã;

public class YiKaTongInfo {
	String ID;
	String name;
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return ID+" "+name;
	}
	
}
