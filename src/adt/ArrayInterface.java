/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author han wen
 */
public interface ArrayInterface<T> {
    public void add(T newEntry);    //add data in to array
    public T getData(int index);    //get the specific data
    public T getAndRemoveData(int index); //get and remove the specific data
    public int getIndex(T data); //get the place of the data in the array
    public void remove(int index); //remove the specific data from array
    public boolean isEmpty(); //check whether is empty or not
    public boolean checkDataExist(T data); //check whether the specific data is exist or not
    public int length(); //check the length of the array
    public void clear(); //make the array become empty
    public void replaceData(T newdata,int index); //replace the specific data with the new data
}
