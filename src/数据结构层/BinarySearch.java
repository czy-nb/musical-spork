package 数据结构层;

import java.util.ArrayList;

import Entity层.Records;

public class BinarySearch {
	public int bsearchWithoutRecursion(ArrayList<Records> list, int key) {
	    int low = 0;
	    int high = list.size() - 1;
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        if (Integer.valueOf(list.get(mid).getPatientID()) > key)
	            high = mid - 1;
	        else if (Integer.valueOf(list.get(mid).getPatientID()) < key)
	            low = mid + 1;
	        else
	            return mid;
	    }
	    return -1;
	}
}
