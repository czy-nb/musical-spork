package Entity层;

import java.io.Serializable;
import java.text.Collator;
import java.util.Locale;

public class PatientInfo implements Serializable{
	String cardnumber;
	
	String ID;
	String name;
	String sex;
	String birth;
	String phonenumber;
	String address;
	String idcardnumber;
	String keshi;
	String doc;
	String disease;
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	int 权值;
	public int get权值() {
		return 权值;
	}
	public void set权值(int string) {
		this.权值 = string;
	}
	public PatientInfo() {
		
	}
	public PatientInfo(String iD, String name, String sex, String birth, String phonenumber, String address,
			String idcardnumber, String keshi, String doc) {
		super();
		ID = iD;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.phonenumber = phonenumber;
		this.address = address;
		this.idcardnumber = idcardnumber;
		this.keshi = keshi;
		this.doc = doc;
		
	}
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getBirth() {
		return birth;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public String getIdcardnumber() {
		return idcardnumber;
	}
	public String getKeshi() {
		return keshi;
	}
	public String getDoc() {
		return doc;
	}

	
	public void setID(String string) {
		ID = string;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setIdcardnumber(String idcardnumber) {
		this.idcardnumber = idcardnumber;
	}
	public void setKeshi(String keshi) {
		this.keshi = keshi;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	
	@Override
	public String toString() {
		return cardnumber+" "+ID+" "+name+" "+sex+" "+birth+" "+phonenumber+" "+address+" "+idcardnumber+" "+keshi+" "+doc;
	}
	public String toString1() {
		return 权值+" "+cardnumber+" "+ID+" "+name+" "+sex+" "+birth+" "+phonenumber+" "+address+" "+idcardnumber+" "+keshi+" "+doc+" ";
	}
	public String toString2() {
		return cardnumber+" "+ID+" "+name+" "+sex+" "+birth+" "+phonenumber+" "+address+" "+idcardnumber+" "+keshi+" "+doc+" "+disease;
	}

	public int compareTo(PatientInfo o) {
		int i = Integer.valueOf(this.getCardnumber());
		int j = Integer.valueOf(o.getCardnumber());
		if (i>j) {
			return 1;
		}
		
		if (i==j) {
			return 0;
		}
		if (i<j) {
			return -1;
		}
		return j;
	}
	
}
