package ���ݽṹ��;

import java.util.ArrayList;
import java.util.List;

import Entity��.PatientInfo;

public class RadixSort{
	
public void radixSort(ArrayList<PatientInfo> array){

            

             PatientInfo max = array.get(0);

             for(int i=0;i<array.size();i++){  //�ҵ������е����ֵ

                    if(array.get(i).compareTo(max)>0){

                           max = array.get(i);

                    }

             }

            

             int keysNum = 0;  //�ؼ��ֵĸ���������ʹ�ø�λ��ʮλ����λ...�����ؼ��֣����Թؼ��ֵĸ����������ֵ��λ��
             int key = Integer.valueOf(max.getCardnumber().trim());
             while(key>0){

                    key /= 10;

                    keysNum++;

             }

                          

             List<ArrayList<PatientInfo>> buckets = new ArrayList<ArrayList<PatientInfo>>();

             for(int i=0;i<10;i++){  //ÿλ���ܵ�����Ϊ0~9����������10��Ͱ

                    buckets.add(new ArrayList<PatientInfo>());  //Ͱ��ArrayList<Integer>����

             }

            

             for(int i=0;i<keysNum;i++){  //����ιؼ��ֿ�ʼ�����ΰ��չؼ��ֽ��з���

                   

                    for(int j=0;j<array.size();j++){  //ɨ����������Ԫ�أ���Ԫ�ط��䵽��Ӧ��Ͱ��

                           //ȡ����Ԫ�ض�Ӧ��i+1λ�ϵ����֣�����258������Ҫȡ��ʮλ�ϵ����֣�258%100=58,58/10=5
                    		//int num = Integer.valueOf(array.get(j));
                           int key1 =Integer.valueOf(array.get(j).getCardnumber().trim())%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);

                           buckets.get(key1).add(array.get(j));  //����Ԫ�ط���ؼ���Ϊkey��Ͱ��

                    }

                   

                    //������֮�󣬽�Ͱ�е�Ԫ�����θ��ƻ�����

                    int counter = 0;  //Ԫ�ؼ�����

                    for(int j=0;j<10;j++){

                            ArrayList<PatientInfo> bucket =buckets.get(j);  //�ؼ���Ϊj��Ͱ

                            while(bucket.size()>0){

                                   array.set(counter++, bucket.remove(0));  //��Ͱ�еĵ�һ��Ԫ�ظ��Ƶ����飬���Ƴ�

                            }

                    }

                    System.out.print("��"+(i+1)+"������");

                 //   display();

             }


      }

}