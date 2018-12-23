/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author lee3010
 */

public class ArrayQueue<T> implements QueueInterface<T>{
    private T[] queue;
    private int firstIndex, lastIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    
    public ArrayQueue(){
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    public ArrayQueue(int size){
        queue = (T[])new Object[size];
        firstIndex = 0;
        lastIndex = -1;
    }
     
    public void enqueue(T newEntry){
        lastIndex++;
        if(isFull()){
            expandArray();
        }
        queue[lastIndex] = newEntry;
    }
    
    public T dequeue(){
        T data = null;
        if(!isEmpty()){
            data = queue[firstIndex];
            shiftPlace();
            lastIndex--;
        }
       return data;
    }
    
    public T getFront(){
        T data = null;
        if(!isEmpty()){
            data = queue[firstIndex];
        }
        return data;
    }
    
    /*public boolean isEmpty(){
        if(lastIndex == -1){
            return true;
        }else
            return false;
    }*/
    
    public boolean isEmpty(){
      if(firstIndex > lastIndex){
          return true;
      }else
          return false;
    }
    
    public void clear(){
        if(!isEmpty()){
            for(int i = firstIndex; i <= lastIndex; i++){
                queue[i] = null;
            }
            lastIndex = -1;
        }
    }
    
    public int totalLength(){
        int size = 0;
        if(!isEmpty()){
            for(int i = firstIndex; i <= lastIndex; i++){
                if(queue[i] != null){
                    size++;
                }
            }
        }
        return size;
    }
    
    public void displayItem(){
        if(!isEmpty()){
            for(int i = firstIndex; i <= lastIndex; i++){
                System.out.println(i+1 + ") " + queue[i]);
            }
        }
    }
    
    public T getItem(int i){
        T data = null;
        if(!isEmpty()){
            data = queue[i];
        }
        return data;
    }
    
    private boolean isFull(){
        if(lastIndex == queue.length - 1){
            return true;
        }else 
            return false;
    }
    
    private void expandArray(){
        T[] oldQueue = queue;
        int currentLength = queue.length;
        queue = (T[]) new Object[currentLength * 2];
        for(int i = 0; i < currentLength;  i++){
            queue[i] = oldQueue[i];
        }
    }
    
    private void shiftPlace(){
        for(int i = firstIndex; i <= lastIndex; i++){
            queue[i] = queue[i+1];
        }
    }
}
