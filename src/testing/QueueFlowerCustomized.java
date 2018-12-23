/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author Admin
 */
public class QueueFlowerCustomized<T> implements QueueFlowerCustomizedInterface<T>{
    private T[] queueData;
    private int frontIndex = 0;
    private int backIndex;
    //private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    
    
    public QueueFlowerCustomized(int size){
        queueData = (T[])new Object[size];
        backIndex = -1;
    }
    
    public QueueFlowerCustomized(){
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    public void enqueue(T newEntry){
        if(isFull()){
            increaseArray();
        }
        backIndex++;
        queueData[backIndex] = newEntry;
    }
    
    public T dequeue(){
        T data = null;
        if(!isEmpty()){
            data = queueData[frontIndex];
            shiftPlace();
            backIndex--;
        }
       return data;
    }
    
    public T getFront(){
        T data = null;
        if(!isEmpty()){
            data = queueData[frontIndex];
        }
        return data;
    }
    
    public boolean isEmpty(){
        if(backIndex == -1){
            return true;
        }else
            return false;
    }
    
    public void clear(){
        if(!isEmpty()){
            for(int i = frontIndex; i < backIndex; i++){
                queueData[i] = null;
            }
            backIndex = -1;
        }
    }
    
    public int size(){
        int size = 1;
        if(!isEmpty()){
            for(int i = frontIndex; i < backIndex; i++){
                if(queueData[i] != null){
                    size++;
                }
            }
        }
        return size;
    }
    
    public void displayItem(){
        if(!isEmpty()){
            for(int i = frontIndex; i <= backIndex; i++){
                System.out.println(i+1 + ") " + queueData[i]);
            }
        }
    }
    
    public T getItem(int i){
        T data = null;
        if(!isEmpty()){
            data = queueData[i];
//            for(int index = i; index < backIndex; i++){
//                queueData[index] = queueData[index + 1];
//            }
//            backIndex--;
        }
        return data;
    }
    
    //Check whether the queue is full or not.
    private boolean isFull(){
        if(backIndex == queueData.length - 1){
            return true;
        }else return false;
    }
    
    private void increaseArray(){
        T[] oldData = queueData;
        int oldSize = queueData.length;
        
        queueData = (T[]) new Object[oldSize * 2];
        
        for(int i = 0; i < oldSize;  i++){
            queueData[i] = oldData[i];
        }
    }
    
    private void shiftPlace(){
        for(int i = frontIndex; i < backIndex; i++){
            queueData[i] = queueData[i+1];
        }
    }
}
