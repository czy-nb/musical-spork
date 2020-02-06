 package Entity²ã;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DiseaseType {
	
	 public String name;
	 public String child;
	 public ArrayList<String> sub_diseases;
	 public ArrayList<String> patients;
	public DiseaseType() {
		
	}
	public DiseaseType(String str) {
		name = str;
		
	}
	public DiseaseType(String str,String str1) {
		name = str1;
		child = str;
	}
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getSub_diseases() {
		return sub_diseases;
	}
	public ArrayList<String> getPatients() {
		return patients;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSub_diseases(ArrayList<String> sub_diseases) {
		this.sub_diseases = sub_diseases;
	}
	public void setPatients(ArrayList<String> patients) {
		this.patients = patients;
	}
	
}
