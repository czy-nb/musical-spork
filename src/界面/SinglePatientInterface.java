package 界面;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SinglePatientInterface {
	 static Object[][] tableDate=new Object[1][9];
	 String[] name={"挂号ID","患者姓名","性别","出生日期","电话","住址","身份证","科室","医生"};
	static JFrame frame = new JFrame("欢迎登陆HIS系统 ");
	 JTable table=new JTable(tableDate,name);
//	static JTable table;
	static Container contentPane=frame.getContentPane();
	public static void main(String[] args) {
		 frame.setSize(800,600);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        frame.setVisible(true);
	        
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.LIGHT_GRAY);
	        
	        String[] name={"挂号ID","患者姓名","性别","出生日期","电话","住址","身份证","科室","医生"};
	        JTable table=new JTable(tableDate,name);
	        tableDate[0][0]=RegistrationInterface.userText1.getText();
	        JScrollPane jScrollPane = new JScrollPane(table);
	        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        contentPane.add(new JScrollPane(table));

	}

}
