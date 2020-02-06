package Entity²ã;

public class ZhenDuanInfo {
	String ID;
	String name;
	String disease;
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getDisease() {
		return disease;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	@Override
	public String toString() {
		return disease +" "+ID+" "+name;
	}
	
}
