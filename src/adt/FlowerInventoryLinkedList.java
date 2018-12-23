/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author User
 */
public class FlowerInventoryLinkedList<T> implements LinkedListFlowerInventoryInterface<T> {
    private Node firstNode;
    private int numberOfEntries;
    
 public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);	// create the new node

        if (isEmpty()) // if empty list
        {
            firstNode = newNode;
        } else {                        // add to end of nonempty list
            Node currentNode = firstNode;					// traverse linked list with p pointing to the current node
            while (currentNode.next != null) {		// while have not reached the last node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; // make last node reference new node
        }

        numberOfEntries++;
        return true;
    }
    
       @Override
    public T remove(int givenPosition) {
        T result = null;                 // return value

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 1) {      // case 1: remove first entry
                result = firstNode.data;     // save entry to be removed
                firstNode = firstNode.next;
            } else {                         // case 2: givenPosition > 1
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }
                result = nodeBefore.next.data;  // save entry to be removed
                nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
            } 																// one to be deleted (to disconnect node from chain)

            numberOfEntries--;
        }

        return result;                   // return removed entry, or
        // null if operation fails
    }
    
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            result = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return result;
    }
    
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        boolean result;

        result = numberOfEntries == 0;

        return result;
    }
    
    public void displayItem(){
        for(int i = 0; i < getNumberOfEntries(); i++){
            System.out.println(i+1 + ") " + getEntry(i));
        }
    }
    
    
    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    } // end Node
    
    
  public T lastIndex()
    {
        T data=null;
       
  Node currentNode = firstNode;
            for (int i = 0; i < numberOfEntries - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            data = currentNode.data;	// currentNode is pointing to the node at givenPosition
         return data;
}
  
public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }
  

}
