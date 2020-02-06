package 数据结构层;

import java.util.NoSuchElementException;




public class Quene<Type> {

	
		class QueueNode<E> {
    	E data;
    	QueueNode<E> link;
    
			public QueueNode(){
	  		data=null;
	  		link=null;
    	}
    	public QueueNode(E data,QueueNode link){
	  		this.data=data;
	  		this.link=link;
	   
    	}
		}
    private QueueNode<Type> front;
	  private QueueNode<Type> rear;

	  public Quene(){
	    front = rear = null;
	  }
	  public boolean isEmpty(){
	    return front == null;
	  }
	  public Type getFront( ){
	    if(isEmpty())
	      throw new NoSuchElementException();
	    return front.data;    
	  }
	  
	  public void enqueue(Type item) throws Exception{
		 
		  //Add a new item into the queue
		  if(front == null)
		    front = rear = new QueueNode<Type>(item, null);
		  else
		    rear = rear.link = new QueueNode<Type>(item, null);
		}
	  	
	  public Type dequeue(){
		  if(isEmpty())
		      throw new NoSuchElementException();
		  QueueNode<Type> p = front;		
		  Type retValue = p.data;     //保存队头的值
		  front = front.link; 	      //新队头
		  if(front == null)  
		    rear = null;
		  return retValue;				
		}
	  public int size() {
		  if (front==null) 
			  return 0;
		 
		  else {
			 QueueNode<Type> p =front;
			 int sz=0;
			 while(p != null){ p = p.link;sz++;}
		        return sz;

		  }
	  }

}