package ����;


	import java.awt.BorderLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import javax.swing.JButton;
	import javax.swing.JFileChooser;
	import javax.swing.JFrame;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JScrollPane;
	import javax.swing.JTabbedPane;
	import javax.swing.JTextArea;
	import javax.swing.JToolBar;
	import javax.swing.filechooser.FileNameExtensionFilter;

import Service��.ReadPatientService;
	public class BackgroundInterface extends JFrame
	{
		
	    private static final long serialVersionUID=-9077023825514749548L;
	    private JTextArea ta_showText;    //������ʾ�ļ����Ե��ı���
	    private JTextArea ta_showProperty;    //������ʾ�ļ����ݵ��ı���
	    //Launch the application.
	    public static void main(String[] args)
	    {
	    	BackgroundInterface frame=new BackgroundInterface();
	        frame.setVisible(true);
	    }   
	    public BackgroundInterface()
	    {
	        setTitle("�ı��༭��");    //���ô������
	        setBounds(100,100,400,250);    //���ô���λ�úʹ�С
	        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);    //���ô���Ĭ�Ϲرշ�ʽ
	        final JMenuBar menuBar=new JMenuBar();    //�����˵���
	        setJMenuBar(menuBar);    //�Ѳ˵����ŵ�������
	        final JMenu mn_file=new JMenu();    //�����ļ��˵�
	        mn_file.setText("�ļ�");    //Ϊ�ļ��˵����ñ���
	        menuBar.add(mn_file);    //���ļ��˵���ӵ��˵�����
	        final JMenuItem mi_open=new JMenuItem();    //�����򿪲˵���
	        mi_open.addActionListener(new ActionListener()
	        {
	            //Ϊ�򿪲˵�����Ӽ�����
	            public void actionPerformed(final ActionEvent arg0)
	            {
	                openTextFile();    //���÷����������ļ�
	            }
	        });
	        mi_open.setText("��");    //���ô򿪲˵���ı���
	        mn_file.add(mi_open);    //�Ѵ򿪲˵�����ӵ��ļ��˵�
	        mn_file.addSeparator();    //��Ӳ˵��ָ���
	        final JMenuItem mi_exit=new JMenuItem();    //�����˳��˵���
	        mi_exit.addActionListener(new ActionListener()
	        {
	            //Ϊ�˳��˵�����Ӽ�����
	            public void actionPerformed(final ActionEvent arg0)
	            {
	                System.exit(0);    //�˳�ϵͳ
	            }
	        });
	        mi_exit.setText("�˳�");    //�����˳��˵���ı���
	        mn_file.add(mi_exit);    //���˳��˵�����ӵ��ļ��˵�
	        final JMenu mn_edit=new JMenu();    //�����༭�˵�
	        mn_edit.setText("�༭");    //Ϊ�༭�˵����ñ���
	        menuBar.add(mn_edit);    //�ѱ༭�˵���ӵ��˵�����
	        final JMenuItem mi_copy=new JMenuItem();    //�������Ʋ˵���
	        mi_copy.setText("����");    //���ø��Ʋ˵���ı���
	        mn_edit.add(mi_copy);    //�Ѹ��Ʋ˵�����ӵ��༭�˵�
	        final JMenuItem mi_cut=new JMenuItem();    //�������в˵���
	        mi_cut.setText("����");    //���ü��в˵���ı���
	        mn_edit.add(mi_cut);    //�Ѽ��в˵�����ӵ��༭�˵�
	        final JMenuItem mi_paste=new JMenuItem();    //����ճ���˵���
	        mi_paste.setText("ճ��");    //����ճ���˵���ı���
	        mn_edit.add(mi_paste);    //��ճ���˵�����ӵ��༭�˵�
	        final JToolBar toolBar=new JToolBar();    //����������
	        getContentPane().add(toolBar,BorderLayout.NORTH);    //�ѹ������ŵ������Ϸ�
	        final JButton btn_open=new JButton();    //�������߰�ť
	        btn_open.addActionListener(new ActionListener()
	        {
	            //��Ӷ���������
	            public void actionPerformed(final ActionEvent arg0)
	            {
	                openTextFile();    //���÷����������ļ�
	            }
	        });
	        btn_open.setText("  ��  ��  ");    //���ù��߰�ť�ı���
	        toolBar.add(btn_open);    //�ѹ��߰�ť��ӵ���������
	        final JButton btn_exit=new JButton();    //�������߰�ť
	        btn_exit.addActionListener(new ActionListener()
	        {
	            //��Ӷ���������
	            public void actionPerformed(final ActionEvent arg0)
	            {
	                System.exit(0);    //�˳�ϵͳ
	            }
	        });
	        btn_exit.setText("  ��  ��  ");    //���ù��߰�ť�ı���
	        toolBar.add(btn_exit);    //�ѹ��߰�ť��ӵ���������
	        final JTabbedPane tabbedPane=new JTabbedPane();    //����ѡ����
	        getContentPane().add(tabbedPane,BorderLayout.CENTER);    //��ѡ����ŵ���������
	        final JScrollPane scrollPane1=new JScrollPane();    //�����������
	        //�ѹ������ŵ�ѡ��ĵ�һ��ѡ��ҳ
	        tabbedPane.addTab("�ļ�������",null,scrollPane1,null);
	        ta_showProperty=new JTextArea();    //�����ı���
	        //���ı�����ӵ�����������ͼ��
	        scrollPane1.setViewportView(ta_showProperty);
	        final JScrollPane scrollPane2=new JScrollPane();    //�����������
	        //�ѹ������ŵ�ѡ��ĵڶ���ѡ��ҳ
	        tabbedPane.addTab("�ļ�������",null,scrollPane2,null);
	        ta_showText=new JTextArea();    //�����ı���
	        //���ı�����ӵ�����������ͼ��
	        scrollPane2.setViewportView(ta_showText);
	    }
	    public void openTextFile()
	    {
	        JFileChooser fileChooser=new JFileChooser();    //�����ļ�ѡ��Ի���
	        fileChooser.setFileFilter(new FileNameExtensionFilter("�ı��ļ�","txt"));
	        int returnValue=fileChooser.showOpenDialog(getContentPane());    //���ļ�ѡ��Ի���
	        if(returnValue==JFileChooser.APPROVE_OPTION)
	        {
	            //�ж��û��Ƿ�ѡ�����ļ�
	            File file=fileChooser.getSelectedFile();    //����ļ�����
	            //����ļ��ľ���·��
	            ta_showProperty.append("�ļ��ľ���·���ǣ�"+file.getAbsolutePath()+"\n");
	            //�Ƿ�Ϊ�����ļ�
	            ta_showProperty.append("���ļ��������ļ���"+file.isHidden()+"\n");
	            FileReader reader;    //�����ַ���
	            BufferedReader in;    //�����ַ�������
	            try
	            {
	                reader=new FileReader(file);    //�����ַ���
	                in=new BufferedReader(reader);    //�����ַ�������
	                String info=in.readLine();    //���ļ��ж�ȡһ����Ϣ
	                while(info!=null)
	                {
	                    //�ж��Ƿ��������
	                    ta_showText.append(info+"\n");    //�Ѷ�������Ϣ׷�ӵ��ı�����
	                    info=in.readLine();    //��������һ����Ϣ
	                }
	                in.close();    //�ر��ַ�������
	                reader.close();    //�ر��ַ���
	            }
	            catch(Exception ex)
	            {
	                ex.printStackTrace();    //���ջ�ټ�
	            }
	        }
	    }
	}

