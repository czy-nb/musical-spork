package ���ݽṹ��;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import Entity��.Records;
import Entity��.ZhenDuanInfo;

//����һ��Hashtable��

public class Hashtable {

	
public static String str="";
	//����һ���ڵ��࣬���涨����ÿһ���ڵ�����Ҫ������

	public class Node {

		Node next;//ָ����һ�ڵ�

		Object key;//��ֵ

		Object data;//������

		

		//�ڵ�Ĺ��캯��

		public Node(Object key,Object data) {

			this.key=key;

			this.data=data;

		}

	}

	

	public Node[] Headlist=new Node[10];//����һ����������

	public int size=0;//��¼��ǰhash���Ԫ�ظ���

	public float peakValue=1.7f;//����һ����ֵ�������ǰhash�洢��Ԫ�ظ������������ֵ�ͽ���rehash

        

        //���������

	public static void main(String[] args) {

		//����һ�������ļ�ֵ��

		ArrayList<String> key = new ArrayList<String>();
		ArrayList<Records> data = new ArrayList<Records>();				
		File file = new File("d://������Ϣ.txt");
		try {
			Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			String s = scanner.nextLine();
			Records p = new Records();
			String[] s1 = s.split(" ");
			p.setPatientID(s1[0]);
			p.setTime(s1[1]);
			p.setDoctorID(s1[2]);
			
			p.setMemo(s1[4]);

			key.add(s1[0]);
			data.add(p);
		}

		Hashtable table=new Hashtable();
		
		//System.out.println(table.size);
		for(int i=0;i<key.size();i++) {
			for (int j = 0; j < data.size(); j++) {
				
			if (data.get(j).getPatientID().contentEquals(key.get(i))) {
			//��ÿһ����ֵ��һһ�ӵ�����õĹ�ϣ����

			table.put(key.get(i), data.get(j));
			}
			//System.out.println("չʾ��ǰ��hash��");

			//չʾÿһ���������֮��Ĺ�ϣ����

			//table.show();
			}
		}
		
	
		System.out.println("չʾ��ǰ��hash��");
		table.show();
		for(int i=0;i<key.size();i++) {

			//���ݼ�ֵ�ӹ�ϣ���л�ȡ��Ӧ������

			String data1=table.get(key.get(i)).toString();

			System.out.print(data1+" ");

		}} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//����ϣ�������һ����ֵ��

	public void put(Object key,Object data) {

		//�жϵ�ǰ�Ĺ�ϣ�������Ƿ��Ѿ��ﵽ��ֵ������ﵽ��ֵ����hash����ع�

		if((size*1.0)/Headlist.length>peakValue) rehash();

		//����hash������ȡ��ֵ��Ӧ��hashcode���Ӷ���λ����Ӧ��ͷ���

		int index=hash(key,Headlist.length);

		//�ѵ�ǰ�Ľڵ��װ��Node�ڵ���

		Node node=new Node(key,data);

		//�����ϣ��

		input(node,Headlist,index);	

		size++;

	}

	

	//���һ����Ӻ���,ʵ�ִ���ĸ���

	private void input(Node node,Node[] list,int index) {

		//���ͷ���λ��Ϊ�գ���ѵ�ǰ�ڵ㸳ֵ��ͷ���

		if(list[index]==null) {

			list[index]=node;

		}else {

			//���򣬱������������жϸü�ֵ�Ƿ��Ѿ������ڹ�ϣ���У����û�оͽ���ӵ�����β��

			Node temp=list[index];

			//�жϱ�ͷԪ�صļ�ֵ�Ƿ�����Ǽ�������ļ�ֵһ��

			if(temp.key==node.key) {

				System.out.println(temp.key+"--�ü�ֵ�Ѵ��ڣ�");

			}else {

				while(temp.next!=null) {

					temp=temp.next;

					if(temp.key==node.key) {
						
						System.out.println(temp.key+"--�ü�ֵ�Ѵ��ڣ�");

						break;

					}

				}

				temp.next=node;

			}

		}

	}

	

	

	//hash�����������ֵ��Ӧ��hashcode��Ҳ����ͷ����λ��

	private Integer hash(Object key,int lenth) {

		Integer index=null;

		if(key!=null) {

			//�����Ŀ�����һ���ַ���������������

			//��ת��Ϊ�ַ�����

			char[] charlist=key.toString().toCharArray();

			int number=0;

			//���μ����ÿ���ַ���Ӧ��ASCII��

			for(int i=0;i<charlist.length;i++) {

				number+=charlist[i];

			}

			//�Թ�ϣ������鳤��ȡ�࣬�õ�ͷ����λ��

			index=Math.abs(number%lenth);

		}

		return index;

	}

	

	//rehash�����Ե�ǰ��hash�������չ�����¶�λ��ǰ���е�����

	public void rehash() {

		//ÿ����չ���ѵ�ǰ�Ĺ�ϣ������һ��

		Node[] newnode=new Node[Headlist.length*2];

		//����ԭ���Ĺ�ϣ�����ΰ�ÿ������������ӵ��µĹ�ϣ����

		for(int i=0;i<Headlist.length;i++) {

			if(Headlist[i]!=null) {

				//�Ȱ�ÿ���б��ͷ�������hash��ȥ

				int headposition=hash(Headlist[i].key,newnode.length);

				//����ط�һ��Ҫ��new���¹���һ���µĽڵ�������ԭ����ϣ���нڵ�ļ�ֵ�ԡ�

				Node rehashheadnode=new Node(Headlist[i].key,Headlist[i].data);

				//����������һ���ڵ�Ϊ�գ��������벻дҲ���ԣ�����Ϊ��ǿ��������Ҫ�ԣ����⽫��д�˳���

				//������������þ���ȥ��ԭ����ϣ���и����ڵ�Ĺ�����ϵ

				rehashheadnode.next=null;

				input(rehashheadnode,newnode,headposition);

				Node temp=Headlist[i];

				while(temp.next!=null) {

					temp=temp.next;

					//����һ��Node���͵�������������Ҫrehash������

					Node rehashnextnode=new Node(temp.key,temp.data);

					rehashnextnode.next=null;

					int nextposition=hash(temp.key,newnode.length);

					input(rehashnextnode,newnode,nextposition);

				}

			}

		}

		//�������ýڵ����������

		Headlist=newnode;

	}

	

	//��ʾ��ǰ��hash��

	public void show() {

		for(int i=0;i<Headlist.length;i++) {

			if(Headlist[i]!=null) {

				System.out.print(Headlist[i].key+":"+Headlist[i].data+"-->");

				Node temp=Headlist[i];

				while(temp.next!=null) {
					
					temp=temp.next;
					//str =str + temp.key+":"+temp.data+"-->"+"\r\n";
					System.out.print(temp.key+":"+temp.data+"-->");

				}
				//str =str + temp.key+":"+temp.data+"-->"+"\r\n";
				System.out.println();

			}

		}

	}

	

	//��ȡ��ֵ���Ӧ������

	public Object get(Object key) {

		//�Ȼ�ȡkey��Ӧ��hashcode

		int index=hash(key,Headlist.length);

		Node temp=Headlist[index];

		//���ж���Ӧ��ͷ����Ƿ�Ϊ��

		if(temp==null) return null;

		else {

			//�жϽڵ��е�key�ʹ����ҵ�key�Ƿ���ͬ

			if(temp.key==key) return temp.data;

			else {

				while(temp.next!=null) {

					temp=temp.next;

					if(temp.key==key) return temp.data;

				}	

			}	

		}

		return null;

	}

	

        //���ص�ǰhash��Ĵ�С

        public int length(){

                return size;

        }

 }

/*

*�޿ӣ�ԭ���Ľڵ����һ���ڵ���Ҫ��������Ϊnull

*/
