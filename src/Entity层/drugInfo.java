package Entity²ã;

import java.io.Serializable;

public class drugInfo implements Serializable{
	String name;
	String guige;
	String baozhuangshuliang;
	String price;
	String danwei;
	String yaopinshuliang; 
	String functions;
	public String getFunctions() {
		return functions;
	}
	public void setFunctions(String functions) {
		this.functions = functions;
	}
	public drugInfo() {
		
	}
	public drugInfo(String name, String guige, String baozhuangshuliang, String price, String danwei,
			String yaopinshuliang) {
		super();
		this.name = name;
		this.guige = guige;
		this.baozhuangshuliang = baozhuangshuliang;
		this.price = price;
		this.danwei = danwei;
		this.yaopinshuliang = yaopinshuliang;
	}
	public String getName() {
		return name;
	}
	public String getGuige() {
		return guige;
	}
	public String getBaozhuangshuliang() {
		return baozhuangshuliang;
	}
	public String getPrice() {
		return price;
	}
	public String getDanwei() {
		return danwei;
	}
	public String getYaopinshuliang() {
		return yaopinshuliang;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGuige(String guige) {
		this.guige = guige;
	}
	public void setBaozhuangshuliang(String baozhuangshuliang) {
		this.baozhuangshuliang = baozhuangshuliang;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public void setYaopinshuliang(String yaopinshuliang) {
		this.yaopinshuliang = yaopinshuliang;
	}
	public String toString() {
		return name+" "+guige+" "+baozhuangshuliang+" "+price+" "+danwei+" "+yaopinshuliang;
	}
}

