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

public interface QueueInterface<T> {
    //public static final int DEFAULT_SIZE = 70;
    public void enqueue(T newEntry);
    public T dequeue();
    // Just to view only, no mean remove
    public T getFront();
    public boolean isEmpty();
    public void clear();
    public int totalLength();
    public void displayItem();
    public T getItem(int i);
}
