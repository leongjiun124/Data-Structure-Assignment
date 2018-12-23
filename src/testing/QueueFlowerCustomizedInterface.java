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
public interface QueueFlowerCustomizedInterface<T> {
//  Task: Adds a new entry to the back of the queue.
    public void enqueue(T newEntry);
    
//  Task: Removes and returns the entry at the front of the queue.
    public T dequeue();
    
//    Task: Retrieves the entry at the front of the queue.
    public T getFront();
    
//    Task: Detects whether the queue is empty.
    public boolean isEmpty();
    
//    Task: Removes all entries from the queue.
    public void clear();
    
//    Task: Return the size of the queue.
    public int size();
    
//    Task: Get the item inside the queue
    public void displayItem();
    
//    Task: Get item of the selected index    
    public T getItem(int i);
}
