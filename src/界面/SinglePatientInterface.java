package ����;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SinglePatientInterface {
	 static Object[][] tableDate=new Object[1][9];
	 String[] name={"�Һ�ID","��������","�Ա�","��������","�绰","סַ","���֤","����","ҽ��"};
	static JFrame frame = new JFrame("��ӭ��½HISϵͳ ");
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
	        
	        String[] name={"�Һ�ID","��������","�Ա�","��������","�绰","סַ","���֤","����","ҽ��"};
	        JTable table=new JTable(tableDate,name);
	        tableDate[0][0]=RegistrationInterface.userText1.getText();
	        JScrollPane jScrollPane = new JScrollPane(table);
	        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        contentPane.add(new JScrollPane(table));

	}

}
