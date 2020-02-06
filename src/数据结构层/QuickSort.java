package 数据结构层;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Entity层.PatientInfo;

/**
 * 快速排序
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
 * 快排核心算法，递归实现
 * @param array
 * @param left
 * @param right
 */
public static void sort(ArrayList<PatientInfo> list, int left, int right) {
    if(left > right) {
        return;
    }
    // base中存放基准数
   int base = left;
    int i = left, j = right;
    while(i != j) {
        // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
        while(list.get(j).compareTo(list.get(base))>=0 && i < j) {
            j--;
        }

        // 再从左往右边找，直到找到比base值大的数
        while(list.get(i).compareTo(list.get(base))<0 && i < j) {
            i++;
        }

        // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
        if(i < j) {
            PatientInfo tmp = list.get(i);
            list.set(i, list.get(j));
           list.set(j, tmp);
          
        }
    }

    // 将基准数放到中间的位置（基准数归位）
    list.set(left, list.get(i));
   list.set(i, list.get(base));

    // 递归，继续向基准的左右两边执行和上面同样的操作
    // i的索引处为上面已确定好的基准值的位置，无需再处理
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