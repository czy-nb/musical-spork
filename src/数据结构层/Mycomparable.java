package 数据结构层;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

import Entity层.PatientInfo;

public class Mycomparable implements Comparator<PatientInfo>{

	@Override
	public int compare(PatientInfo o1, PatientInfo o2) {
		String s1 = o1.getName();
		String s2 = o2.getName();
		Collator instance = Collator.getInstance(Locale.CHINA);
		return instance.compare(s1,s2);
		
	}

}
