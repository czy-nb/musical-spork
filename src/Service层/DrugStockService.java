package Service��;

import Dao��.DrugStockDao;

public class DrugStockService {
	public void writerfile(String s) {
		DrugStockDao drug = new DrugStockDao();
		drug.writerfile(s);
	}
}
