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
public interface CustomerMaintainInterface<T> {
    
      /**
   * Task: Add newEntry into the top of the stack.
   */
  public void push(T newEntry);

  /**
   * Task: Removes and returns the stack's top entry.
   */
  public T pop();

  /**
   * Task: Retrieves the stack's top entry.
   */
  public T peek();

  /**
   * Task: Detects whether the stack is empty.
   */
  public boolean isEmpty();

  /**
   * Task: Removes all entries from the stack
   */
  public void clear();
  
    /**
   * Task: get the selected item
   */
  public T getItem(int id);
  
      /**
   * Task: return size of the stack
   */
  public int getLength();
}
