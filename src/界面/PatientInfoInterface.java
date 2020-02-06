package 界面;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PatientInfoInterface {
	static JFrame frame = new JFrame("欢迎登陆HIS系统 ");
//	static JTable table;
	static Container contentPane=frame.getContentPane();
//	static DefaultTableModel tableModel;
//   
	public static void main(String[] args) {
		jiemian();
	}
	
		public static void jiemian() {
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        
        
//        DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
//        tableModel.setRowCount(0);    //清空表格中的数据
//        tableModel.setColumnIdentifiers(new Object[]{"挂号ID","患者姓名","性别","出生日期","电话","住址","身份证"});    //设置表头
       
        
       Object[][] tableDate=new Object[1][9];
       String[] name={"挂号ID","患者姓名","性别","出生日期","电话","住址","身份证","科室","医生"};
       	RegistrationInterface jm = new RegistrationInterface();
//       	for (int i=0;i<9;i++) {
//       		tableDate[][j]=jm.userText1
//       	}
     String s1 = jm.userText1.getText();
     String s2 = jm.userText2.getText();
     String s3 = jm.str3;
     String s4 = jm.userText3.getText();
     String s5 = jm.userText4.getText();
     String s6 = jm.userText5.getText();
     String s7 = jm.userText6.getText();
     String s8 = jm.str1;
     String s9 = jm.str2;
    System.out.println(s8);
    System.out.println(s9);
     tableDate[0][0] = s1;
     tableDate[0][1] = s2;
     tableDate[0][2] = s3;
     tableDate[0][3] = s4;
     tableDate[0][4] = s5;
     tableDate[0][5] = s6;
     tableDate[0][6] = s7;
     tableDate[0][7] = s8;
    tableDate[0][8] = s9;

        JTable table=new JTable(tableDate,name);
        //tableDate[0][0]=挂号界面.userText1.getText();
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        
        contentPane.add(new JScrollPane(table));
//        frame.add(panel);

	}
	
		
	
}
