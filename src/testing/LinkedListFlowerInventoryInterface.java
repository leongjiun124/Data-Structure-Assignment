/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author User
 */
public interface LinkedListFlowerInventoryInterface<T> {
    
    
    public boolean add(T newEntry);
     public T remove(int Position);
     public T getEntry(int Position);
     public int getNumberOfEntries();
     public boolean isEmpty();
     public void clear();

    
}
