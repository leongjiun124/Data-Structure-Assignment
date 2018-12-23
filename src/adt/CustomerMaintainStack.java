/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Admin
 */
public class CustomerMaintainStack<T> implements CustomerMaintainInterface<T> {
        private T[] stackData;    
        private int topIndex;
        private static final int DEFAULT_INITIAL_CAPACITY = 50;

  public CustomerMaintainStack() {
    this(DEFAULT_INITIAL_CAPACITY);
  } 

  public CustomerMaintainStack(int initialCapacity) {
    stackData = (T[]) new Object[initialCapacity];
    topIndex = -1;
  } 

  public void push(T newEntry) {
    topIndex++;

    if (topIndex >= stackData.length) 
    {
      doubleArray(); //Expand the array             
    }
    stackData[topIndex] = newEntry;
  } // end push

  public T peek() {
    T top = null;

    if (!isEmpty()) {
      top = stackData[topIndex];
    }

    return top;
  }

  public T pop() {
    T top = null;

    if (!isEmpty()) {
      top = stackData[topIndex];
      stackData[topIndex] = null;
      topIndex--;
    } 

    return top;
  } 

  public boolean isEmpty() {
    return topIndex < 0;
  } 

  public void clear() {
      stackData = null;
  } 

  /**
   * Task: Doubles the size of the array of stack entries
   */
  private void doubleArray() {
    T[] oldStack = stackData;                
    int oldSize = oldStack.length;       

    stackData = (T[]) new Object[2 * oldSize]; 

    // copy entries from old array to new, bigger array
    for(int i = 0; i < oldSize;  i++){
            stackData[i] = oldStack[i];
        }
  }
  
  public T getItem(int i){
        T data = null;
        if(!isEmpty()){
            data = stackData[i];
        }
        return data;
  }
  
  public int getLength(){
      int size = 1;
      if(!isEmpty()){
        for(int i = 0; i< topIndex; i++){
            if(stackData[i] != null){
                size++;
}
        }
      }
      return size;
  }
}
