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
public class PromotionLinkedStack<T> implements LinkedStackPromotion<T> {
    private int numberOfEntries;
    class Node {
    Object elem;
    Node Next;

    public Node(T data) {
      elem = data;
      Next = null;
    }
  }

  Node end;
  int size;

  public PromotionLinkedStack() {
    end = null;
    size = 0;
  }

  public void push(T data) {
    Node new_node = new Node(data);
    if (end == null)
      end = new_node;
    else {
      new_node.Next = end;
      end = new_node;
    }
    size++;
    numberOfEntries++;
  };

  public T pop() {
    if (end == null)
      return null;;
    T data = (T) end.elem;
    end = end.Next;
    size--;
    return data;
  }// Gets the object from the stack

  public boolean isEmpty() {

    return (size == 0);
  }

  public int size() {

    return size;
  }

  public Object end() {

    if (end == null)
      return null;
    else
      return end.elem;
  }
   public int getNumberOfEntries() {
        return numberOfEntries;
    }
} 
