package ���ݽṹ��;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Entity��.PatientInfo;

/**
 * ��������
 * @param array
 */
public class QuickSort {
public static void QuickSort(ArrayList<PatientInfo> list) {
    int len;
    if(list == null
            || (len = list.size()) == 0
            || len == 1) {
        return ;
    }
    sort(list, 0, len - 1);
}

/**
 * ���ź����㷨���ݹ�ʵ��
 * @param array
 * @param left
 * @param right
 */
public static void sort(ArrayList<PatientInfo> list, int left, int right) {
    if(left > right) {
        return;
    }
    // base�д�Ż�׼��
   int base = left;
    int i = left, j = right;
    while(i != j) {
        // ˳�����Ҫ���ȴ��ұ߿�ʼ�����ң�ֱ���ҵ���baseֵС����
        while(list.get(j).compareTo(list.get(base))>=0 && i < j) {
            j--;
        }

        // �ٴ������ұ��ң�ֱ���ҵ���baseֵ�����
        while(list.get(i).compareTo(list.get(base))<0 && i < j) {
            i++;
        }

        // �����ѭ��������ʾ�ҵ���λ�û���(i>=j)�ˣ������������������е�λ��
        if(i < j) {
            PatientInfo tmp = list.get(i);
            list.set(i, list.get(j));
           list.set(j, tmp);
          
        }
    }

    // ����׼���ŵ��м��λ�ã���׼����λ��
    list.set(left, list.get(i));
   list.set(i, list.get(base));

    // �ݹ飬�������׼����������ִ�к�����ͬ���Ĳ���
    // i��������Ϊ������ȷ���õĻ�׼ֵ��λ�ã������ٴ���
    sort(list, left, i - 1);
    sort(list, i + 1, right);
}

public int compareTo(PatientInfo o,PatientInfo o1) {
	int i = Integer.valueOf(o.getCardnumber());
	int j = Integer.valueOf(o1.getCardnumber());
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