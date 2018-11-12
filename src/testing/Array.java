/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author han wen
 */
public class Array<T> implements ArrayInterface<T>{
    private int lastNodeIndex = 0;
    private Node firstNode;
    private Node lastNode;
    private Node currentNode;
    
    Array(){
        firstNode = null;
        lastNode = null;
        currentNode = null;
    }
    
 //Add new node/data in the last of the Linked Array
    @Override
    public void add(T newEntry) {
        
        Node newNode = new Node(newEntry);
        
        if(isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
        }else{
            lastNode.next = newNode;
            newNode.previous = lastNode;
            lastNode = newNode;
        }
    }
    
    //Return the data of the node that specify by user
    @Override
    public T getData(int index) {
        
        T temp = null;
        currentNode = firstNode;
        
        for(int i = 0; i < lastNodeIndex;i++){
            
            if(currentNode.indexNode == index){
                temp = (T)currentNode.data;
                break;
                
            }else{               
                this.currentNode = currentNode.next;
            }           
        }      
        return temp;     
    }
    
    //Return true if this Linked Array is empty.
    @Override
    public boolean isEmpty() {      
        return length() == 0;
    }
      
    /* This function will remove one of node/data that specify by user. For 
       example, if user want delete index 1 node, then index 1 node will be deleted.*/
    @Override
    public void remove(int index) {
        currentNode = firstNode;
        Node removeNode;
        
        //Searching the node/data that specify by user.
        for(int i = 0; i < lastNodeIndex; i++){
            
            //If find the node that specify by user.
            if(currentNode.indexNode == index){
                               
                removeNode = currentNode;
                
                //If the node which will be deleted is the only one node in this Linked Aarry.
                if(removeNode == lastNode && removeNode == firstNode ){
                    firstNode = null;
                    lastNode  = null;
                    currentNode = null;
                
                /* If the node which will be deleted is the first node in this 
                   Linked Aarry. The original second node will become first node.*/
                }else if(removeNode == firstNode){
                    
                    firstNode = currentNode.next;                 
                    currentNode.next.previous = currentNode.previous;
                    
                    /* All the nodes' index after the node which will be deleted
                       will minus 1.*/
                    for(int a =  currentNode.next.indexNode; a <= lastNodeIndex ;a++){
                        
                        if(currentNode.next != null){                          
                            currentNode.next.indexNode --;
                        }
                        
                        currentNode = currentNode.next;
                    }
                    
                /* If the node which will be deleted is the last node in this 
                   Linked Aarry. The original last second node will become last node.*/           
                }else if(removeNode == lastNode){
                    currentNode.previous.next = currentNode.next;
                    lastNode = currentNode.previous;
                 
                    
                /* If the node which will be deleted is in between the first and last node 
                   in this Linked Aarry. the previous node of the node which will be deleted 
                   will link to next node of the node which will be deleted */  
                }else{
                    
                    currentNode.previous.next = currentNode.next;
                    currentNode.next.previous = currentNode.previous;
                    
                    /* All the nodes' index after the node which will be deleted
                       will minus 1*/
                    for(int a =  currentNode.next.indexNode; a <= lastNodeIndex ;a++){
                    
                        if(currentNode.next != null){
                            currentNode.next.indexNode --;
                        }
                        currentNode = currentNode.next;
                    }
                }
                
                //lastIndex will be minus 1 and delete the node which will be deleted 
                lastNodeIndex--;
                removeNode.data = null;
                removeNode = null;
                break;
            
            //If not the node that specify by user.  
            }else{
                
                currentNode = currentNode.next;
            }           
        }
    }
    
    //This function will return integer number that showing how many node/data in this Linked Array
    @Override
    public int length() {
        currentNode = firstNode;
        int total = 0;
        
        do{
            if(currentNode != null){
                total++;
                currentNode = currentNode.next;
            }
        }while(currentNode != null);
               
        return total;
    }
    
    //This function use to delete all node and data in this LinkedArray.
    @Override
    public void clear() {
        int index = length();
        for(int i = 0; i < index ;i++){
            remove(0);
        }
    }
    
    //Return and remove the data of the node that specify by user
    @Override
    public T getAndRemoveData(int index) {
        T temp = getData(index);
        remove(index);       
        return temp;
    }
    
    //Return the index of the node which stored the data that specify by user
    @Override
    public int getIndex(T data) {
        int dataIndex = -1;
        int length = length();
        
        for(int i = 0; i < length;i++){
            if(getData(i) == data){
                dataIndex = i;
                break;
            }
        }
        
        return dataIndex;
    }
    
    //This function use to check the data that specify by user is exist or not;
    @Override
    public boolean checkDataExist(T data) {
        
        boolean exist = false;
        int length = length();
        
            for(int i = 0; i < length;i++){
                if(getData(i) == data){
                exist = true;
                break;
                }
            }
        return exist;
    }
    
   
    @Override
    public void replaceData(T newdata,int index) {
         currentNode = firstNode;
        
        for(int i = 0; i < lastNodeIndex;i++){
            
            if(currentNode.indexNode == index){
                currentNode.data = newdata;
                break;
                
            }else{               
                this.currentNode = currentNode.next;
            }           
        }
    }
    
    private class Node<T>{
        T data;
        Node next;
        Node previous;
        int indexNode;
        
        public Node(T data){
            this.data = data;
            this.next = null;
            this.previous = null;
            this.indexNode = lastNodeIndex++;

        }       
    }
}

