package ���ݽṹ��;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedSet;

import Entity��.PatientInfo;

public class PriorityQuene<E> {
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private static final int MAX_ARRAY_SIZE = DEFAULT_INITIAL_CAPACITY;
	//Ԫ�صĴ洢��ʽ������
	private transient Object[] queue;
	//������Ԫ�صĸ���
	private int size = 0;
	//�Ƚ���
	private final Comparator<? super E> comparator; 
	//�����޸ĵĴ���
	private transient int modCount = 0;
	 public PriorityQuene() {      
		 this(DEFAULT_INITIAL_CAPACITY, null);   
		 }    
	 
	/**     * ���캯��������һ��ָ����������Ȼ˳��Ķ���    
	  *  * @param initialCapacity     */   
	 public PriorityQuene(int initialCapacity) {    
		 this(initialCapacity, null);  
		 }     /**     * ���캯��������һ��ָ��������ָ��˳��Ķ���     * @param initialCapacity     * @param comparator     */ 
	 public PriorityQuene(int initialCapacity,                      
			 Comparator<? super E> comparator) {    
		 if (initialCapacity < 1)        
			 throw new IllegalArgumentException();   
		 this.queue = new Object[initialCapacity];     
		 this.comparator = comparator;    }     
	 /**     * ���캯��������ָ�����ϴ���һ������     
	  * * ���c������ļ��ϣ����ݼ��ϻ�ȡ����Ӧ�ıȽ���comparator���������е�Ԫ��     * @param c     
	 * @return */ 
	 @SuppressWarnings("unchecked") 
	 public PriorityQuene(Collection<? extends E> c) {   
		 if (c instanceof SortedSet<?>) {       
			 SortedSet<? extends E> ss = (SortedSet<? extends E>) c;     
			 this.comparator = (Comparator<? super E>) ss.comparator();        
			 initElementsFromCollection(ss);       
			 }    
		 else if (c instanceof PriorityQueue<?>) {        
			 PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;         
			 this.comparator = (Comparator<? super E>) pq.comparator();         
			 initFromPriorityQueue(pq);  
			 }       
		 else {          
			 this.comparator = null;   
			 initFromCollection(c);      
			 }   
		 }       
	 /**     * ���캯��������һ��ָ�����ȼ��ļ����е�Ԫ�صĶ���     * @param c     *  */  
	 @SuppressWarnings("unchecked")    
	  public PriorityQuene(PriorityQueue<? extends E> c) {        
		  this.comparator = (Comparator<? super E>) c.comparator();    
		  initFromPriorityQueue(c);    }       
	  @SuppressWarnings("unchecked")   
	  public PriorityQuene(SortedSet<? extends E> c) {    
		  this.comparator = (Comparator<? super E>) c.comparator();       
		  initElementsFromCollection(c);    }    
	  /**     * ��ʼ��һ������     * @param c     */ 
	  private void initFromPriorityQueue(PriorityQueue<? extends E> c) {  
		  if (c.getClass() == PriorityQueue.class) {       
			  this.queue = c.toArray();         
			  
			  this.size = c.size();      
			  
		  
		  } else {       
			  initFromCollection(c);   
			  }   
		  }     /**     * �Ӽ����г�ʼ�����ݵ�������     * @param c     */   
	  private void initElementsFromCollection(Collection<? extends E> c) {
		  //������ת��������      
		  Object[] a = c.toArray();     
		  //������鲻��Object���ͣ�ת����Object����    
		  if (a.getClass() != Object[].class)         
			  a = Arrays.copyOf(a, a.length, Object[].class);   
		  int len = a.length;      
		  //�������ĳ���Ϊ1���߱Ƚ�����Ϊ�գ���������е�Ԫ��   
		  if (len == 1 || this.comparator != null)         
			  for (int i = 0; i < len; i++)             
				  if (a[i] == null)                 
					  throw new NullPointerException();   
		  this.queue = a;        this.size = a.length;    }  
	  private void initFromCollection(Collection<? extends E> c) {    
		  initElementsFromCollection(c);    
		  heapify();  
		  
	  
	  }       
	  private void heapify() {   
		  for (int i = (size >>> 1) - 1; i >= 0; i--)  
			  siftDown(i, (E) queue[i]); 
		  }

	  /**

	    * ������в���һ��Ԫ��

	    */

	    public boolean add(E e) {

	        return offer(e);

	    }

	 

	    /**

	     * ������в���һ��Ԫ��

	     * 1.���Ԫ��Ϊ�գ��׳��쳣

	     */

	    public boolean offer(E e) {

	        if (e == null)

	            throw new NullPointerException();

	        modCount++;

	        int i = size;

	        //��������е�Ԫ�ظ������ڻ���ڶ��еĳ���

	        if (i >= queue.length)

	            grow(i + 1);

	        size = i + 1;

	        //��������е�Ԫ��Ϊ�գ���ô�¼����Ԫ��Ϊ��һ��Ԫ�أ�ֱ�Ӹ�ֵ��[0]λ��

	        if (i == 0)

	            queue[0] = e;

	        else

	            siftUp(i, e);  //����Ԫ�����Ͻ��е���

	        return true;

	    }

	    

	    /**

	     * �������������������

	     * @param minCapacity

	     */

	    private void grow(int minCapacity) {

	        int oldCapacity = queue.length;

	        //���ݵĵĴ�СҪô�Ƿ���Ҫô������50%

	        int newCapacity = oldCapacity + ((oldCapacity < 64) ?

	                                         (oldCapacity + 2) :

	                                         (oldCapacity >> 1));

	        //������ĳ��ȳ����������ʱ�����е���

	        if (newCapacity - MAX_ARRAY_SIZE > 0)

	            newCapacity = hugeCapacity(minCapacity);

	        queue = Arrays.copyOf(queue, newCapacity);

	    }

	    

	  //��������ĳ����Ƿ񳬹����ƣ���������˽��е������׳��쳣

	    private static int hugeCapacity(int minCapacity) {

	        if (minCapacity < 0) // overflow

	            throw new OutOfMemoryError();

	        return (minCapacity > MAX_ARRAY_SIZE) ?

	            Integer.MAX_VALUE :

	            MAX_ARRAY_SIZE;

	    }

	    

	    /**

	     * ��kλ�ò���Ԫ��x��ͬʱ�������е�Ԫ�ؽ��е�����ʹ��������е�Ҫ��

	     * @param k

	     * @param x

	     */

	    private void siftUp(int k, E x) {

	        if (comparator != null)

	            siftUpUsingComparator(k, x);

	        else

	            siftUpComparable(k, x);

	    }

	 

	    /**

	     * �����Ĭ�ϱȽ���������Ԫ��ʱ�ĵ�������

	     * @param k

	     * @param x

	     */

	    private void siftUpComparable(int k, E x) {

	        Comparable<? super E> key = (Comparable<? super E>) x;

	        //k����0ʱ��ѭ������k

	        while (k > 0) {

	        	//��ȡk�ĸ��ڵ�

	            int parent = (k - 1) >>> 1;

	            //��ȡ���ڵ��Ԫ��e

	            Object e = queue[parent];

	            //���key��ֵ���ڵ����丸�ڵ��Ԫ�أ���ô����Ҫ���е�������������

	            if (key.compareTo((E) e) >= 0)

	                break;

	            //����Ļ�������ֵ���жԻ���ͬʱ��k��ֵΪ�丸�ڵ��λ��

	            queue[k] = e;

	            k = parent;

	        }

	        queue[k] = key;

	    }

	 

	    /**

	     * �����ָ���ıȽ���������Ԫ��֮��ĵ�������

	     * @param k

	     * @param x

	     */

	    private void siftUpUsingComparator(int k, E x) {

	        while (k > 0) {

	            int parent = (k - 1) >>> 1;

	            Object e = queue[parent];

	            if (comparator.compare(x, (E) e) >= 0)

	                break;

	            queue[k] = e;

	            k = parent;

	        }

	        queue[k] = x;

	    }

/**

     * ɾ��ĳһ��Ԫ��

     */

    public boolean remove(Object o) {

    	//���Ȼ�ȥԪ���������е�����λ��

        int i = indexOf(o);

        if (i == -1)

            return false;

        else {

            removeAt(i);

            return true;

        }

    }

    

    /**

     * ��ȡĳ��Ԫ�ص�����λ�ã���������б���

     * @param o

     * @return

     */

    private int indexOf(Object o) {

        if (o != null) {

            for (int i = 0; i < size; i++)

                if (o.equals(queue[i]))

                    return i;

        }

        return -1;

    }

    

    /**

     * ɾ��ĳ��λ�õ�Ԫ��

     * @param i

     * @return

     */

    private E removeAt(int i) {

        assert i >= 0 && i < size;

        modCount++;

        //sΪ�����е����һ��Ԫ�ص�λ��

        int s = --size;

        //���ɾ���������һ��Ԫ�أ������һ��λ�õ�Ԫ����Ϊnull

        if (s == i) // removed last element

            queue[i] = null;

        else {

        	//��ȡ���һ��Ԫ��ֵ

            E moved = (E) queue[s];

            //�����һ��λ�õ�Ԫ����Ϊnull

            queue[s] = null;

            siftDown(i, moved);

            //��������һ��Ԫ���滻����ɾ����Ԫ�ص�λ�ã���ô��Ҫ��Ԫ�ؽ������ϱȽϣ�ʹ���������ȼ����е�����

            if (queue[i] == moved) {

                siftUp(i, moved);

                if (queue[i] != moved)

                    return moved;

            }

        }

        return null;

    }

    

    /**

     * ���µ��������е�Ԫ��

     * @param k

     * @param x

     */

    private void siftDown(int k, E x) {

        if (comparator != null)

            siftDownUsingComparator(k, x);

        else

            siftDownComparable(k, x);

    }

 

    /**

     * ���ޱȽ���ʱ�����Ʋ�����ʵ��

     * @param k

     * @param x

     */

    private void siftDownComparable(int k, E x) {

        Comparable<? super E> key = (Comparable<? super E>)x;

        //halfΪ���е��м�һ��λ��

        int half = size >>> 1;        // loop while a non-leaf

        //ѭ������k��kС���м�λ������ֵʱѭ��

        while (k < half) {

        	//��ȡk����������ֵ

            int child = (k << 1) + 1; // assume left child is least

            //��ȡ���ӵ�ֵ

            Object c = queue[child];

            //��ȡk���Һ�������ֵ

            int right = child + 1;

            //��������Һ��ӣ������Һ��ӵ�ֵС�����ӵ�ֵ����ô��cֵ��ֵΪ�Һ��ӵ�ֵ��Ҳ����ȡ���Һ�����ֵ��С����λ

            if (right < size &&

                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)

                c = queue[child = right];

            //���keyֵС�ڵ��ں��ӽ���е�ֵ������Ҫ����������ѭ��

            if (key.compareTo((E) c) <= 0)

                break;

            //���keyֵ���ں��ӽ���е���Сֵ����ô������

            queue[k] = c;

            k = child;

        }

        queue[k] = key;

    }

 

    private void siftDownUsingComparator(int k, E x) {

        int half = size >>> 1;

        while (k < half) {

            int child = (k << 1) + 1;

            Object c = queue[child];

            int right = child + 1;

            if (right < size &&

                comparator.compare((E) c, (E) queue[right]) > 0)

                c = queue[child = right];

            if (comparator.compare(x, (E) c) <= 0)

                break;

            queue[k] = c;

            k = child;

        }

        queue[k] = x;

    }
    
    public E peek() {

        return (size == 0) ? null : (E) queue[0];

}



public E poll() {

        if (size == 0)

            return null;

        int s = --size;

        modCount++;

        E result = (E) queue[0];

        E x = (E) queue[s];

        queue[s] = null;

        if (s != 0)

            siftDown(0, x);

        return result;

}



}
	 
		

