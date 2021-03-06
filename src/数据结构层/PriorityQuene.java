package 数据结构层;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedSet;

import Entity层.PatientInfo;

public class PriorityQuene<E> {
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private static final int MAX_ARRAY_SIZE = DEFAULT_INITIAL_CAPACITY;
	//元素的存储方式是数组
	private transient Object[] queue;
	//队列中元素的个数
	private int size = 0;
	//比较器
	private final Comparator<? super E> comparator; 
	//队列修改的次数
	private transient int modCount = 0;
	 public PriorityQuene() {      
		 this(DEFAULT_INITIAL_CAPACITY, null);   
		 }    
	 
	/**     * 构造函数：创建一个指定容量和自然顺序的队列    
	  *  * @param initialCapacity     */   
	 public PriorityQuene(int initialCapacity) {    
		 this(initialCapacity, null);  
		 }     /**     * 构造函数：创建一个指定容量和指定顺序的队列     * @param initialCapacity     * @param comparator     */ 
	 public PriorityQuene(int initialCapacity,                      
			 Comparator<? super E> comparator) {    
		 if (initialCapacity < 1)        
			 throw new IllegalArgumentException();   
		 this.queue = new Object[initialCapacity];     
		 this.comparator = comparator;    }     
	 /**     * 构造函数：根据指定集合创建一个队列     
	  * * 如果c是有序的集合：根据集合获取到对应的比较器comparator，将集合中的元素     * @param c     
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
	 /**     * 构造函数：创建一个指定优先级的集合中的元素的队列     * @param c     *  */  
	 @SuppressWarnings("unchecked")    
	  public PriorityQuene(PriorityQueue<? extends E> c) {        
		  this.comparator = (Comparator<? super E>) c.comparator();    
		  initFromPriorityQueue(c);    }       
	  @SuppressWarnings("unchecked")   
	  public PriorityQuene(SortedSet<? extends E> c) {    
		  this.comparator = (Comparator<? super E>) c.comparator();       
		  initElementsFromCollection(c);    }    
	  /**     * 初始化一个队列     * @param c     */ 
	  private void initFromPriorityQueue(PriorityQueue<? extends E> c) {  
		  if (c.getClass() == PriorityQueue.class) {       
			  this.queue = c.toArray();         
			  
			  this.size = c.size();      
			  
		  
		  } else {       
			  initFromCollection(c);   
			  }   
		  }     /**     * 从集合中初始化数据到队列中     * @param c     */   
	  private void initElementsFromCollection(Collection<? extends E> c) {
		  //将集合转化成数组      
		  Object[] a = c.toArray();     
		  //如果数组不是Object类型，转换成Object类型    
		  if (a.getClass() != Object[].class)         
			  a = Arrays.copyOf(a, a.length, Object[].class);   
		  int len = a.length;      
		  //如果数组的长度为1或者比较器不为空，如果队列中的元素   
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

	    * 向队列中插入一个元素

	    */

	    public boolean add(E e) {

	        return offer(e);

	    }

	 

	    /**

	     * 向队列中插入一个元素

	     * 1.如果元素为空，抛出异常

	     */

	    public boolean offer(E e) {

	        if (e == null)

	            throw new NullPointerException();

	        modCount++;

	        int i = size;

	        //如果队列中的元素个数大于或等于队列的长度

	        if (i >= queue.length)

	            grow(i + 1);

	        size = i + 1;

	        //如果队列中的元素为空，那么新加入的元素为第一个元素，直接赋值到[0]位置

	        if (i == 0)

	            queue[0] = e;

	        else

	            siftUp(i, e);  //插入元素向上进行调整

	        return true;

	    }

	    

	    /**

	     * 对数组的容量进行扩容

	     * @param minCapacity

	     */

	    private void grow(int minCapacity) {

	        int oldCapacity = queue.length;

	        //扩容的的大小要么是翻倍要么是增长50%

	        int newCapacity = oldCapacity + ((oldCapacity < 64) ?

	                                         (oldCapacity + 2) :

	                                         (oldCapacity >> 1));

	        //当数组的长度超过最大限制时，进行调整

	        if (newCapacity - MAX_ARRAY_SIZE > 0)

	            newCapacity = hugeCapacity(minCapacity);

	        queue = Arrays.copyOf(queue, newCapacity);

	    }

	    

	  //检验数组的长度是否超过限制，如果超过了进行调整或抛出异常

	    private static int hugeCapacity(int minCapacity) {

	        if (minCapacity < 0) // overflow

	            throw new OutOfMemoryError();

	        return (minCapacity > MAX_ARRAY_SIZE) ?

	            Integer.MAX_VALUE :

	            MAX_ARRAY_SIZE;

	    }

	    

	    /**

	     * 在k位置插入元素x，同时对数组中的元素进行调整，使其满足队列的要求

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

	     * 如果是默认比较器，插入元素时的调整方法

	     * @param k

	     * @param x

	     */

	    private void siftUpComparable(int k, E x) {

	        Comparable<? super E> key = (Comparable<? super E>) x;

	        //k大于0时，循环遍历k

	        while (k > 0) {

	        	//获取k的父节点

	            int parent = (k - 1) >>> 1;

	            //获取父节点的元素e

	            Object e = queue[parent];

	            //如果key的值大于等于其父节点的元素，那么不需要进行调整，结束操作

	            if (key.compareTo((E) e) >= 0)

	                break;

	            //否则的话将两个值进行对换，同时将k赋值为其父节点的位置

	            queue[k] = e;

	            k = parent;

	        }

	        queue[k] = key;

	    }

	 

	    /**

	     * 如果有指定的比较器，插入元素之后的调整方法

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

     * 删除某一个元素

     */

    public boolean remove(Object o) {

    	//首先回去元素在数组中的索引位置

        int i = indexOf(o);

        if (i == -1)

            return false;

        else {

            removeAt(i);

            return true;

        }

    }

    

    /**

     * 获取某个元素的索引位置，对数组进行遍历

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

     * 删除某个位置的元素

     * @param i

     * @return

     */

    private E removeAt(int i) {

        assert i >= 0 && i < size;

        modCount++;

        //s为数组中的最后一个元素的位置

        int s = --size;

        //如果删除的是最后一个元素，将最后一个位置的元素置为null

        if (s == i) // removed last element

            queue[i] = null;

        else {

        	//获取最后一个元素值

            E moved = (E) queue[s];

            //将最后一个位置的元素置为null

            queue[s] = null;

            siftDown(i, moved);

            //如果是最后一个元素替换到了删除的元素的位置，那么需要将元素进行向上比较，使其满足优先级队列的特性

            if (queue[i] == moved) {

                siftUp(i, moved);

                if (queue[i] != moved)

                    return moved;

            }

        }

        return null;

    }

    

    /**

     * 向下调整队列中的元素

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

     * 当无比较器时的下移操作的实现

     * @param k

     * @param x

     */

    private void siftDownComparable(int k, E x) {

        Comparable<? super E> key = (Comparable<? super E>)x;

        //half为队列的中间一半位置

        int half = size >>> 1;        // loop while a non-leaf

        //循环调整k，k小于中间位置索引值时循环

        while (k < half) {

        	//获取k的左孩子索引值

            int child = (k << 1) + 1; // assume left child is least

            //获取左孩子的值

            Object c = queue[child];

            //获取k的右孩子索引值

            int right = child + 1;

            //如果存在右孩子，并且右孩子的值小于左孩子的值，那么将c值赋值为右孩子的值，也就是取左右孩子中值较小的那位

            if (right < size &&

                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)

                c = queue[child = right];

            //如果key值小于等于孩子结点中的值，不需要调整，结束循环

            if (key.compareTo((E) c) <= 0)

                break;

            //如果key值大于孩子结点中的最小值，那么将两个

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
	 
		

