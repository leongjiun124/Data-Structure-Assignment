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
public interface ArrayInterface<T> {
    public void add(T newEntry);
    public T getData(int index);
    public T getAndRemoveData(int index);
    public int getIndex(T data);
    public void remove(int index);
    public boolean isEmpty();
    public boolean checkDataExist(T data);
    public int length();
    public void clear();
    public void replaceData(T newdata,int index);
}
