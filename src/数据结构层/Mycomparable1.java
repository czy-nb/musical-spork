package 数据结构层;

import java.text.Collator;
import java.util.Locale;

import Entity层.PatientInfo;

public class Mycomparable1 {
	public int compare(PatientInfo o1, PatientInfo o2) {
		String s1 = o1.getCardnumber();
		String s2 = o2.getCardnumber();
		Collator instance = Collator.getInstance(Locale.CHINA);
		return instance.compare(s1,s2);
		
	}
}
