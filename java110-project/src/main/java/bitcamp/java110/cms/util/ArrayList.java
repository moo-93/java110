package bitcamp.java110.cms.util;

public class ArrayList<T> {
     private Object[] list = new Object[5];
     private int index = 0;
    
    public void add(T t) {
        if(index == list.length) {
            increaseStorage();
        }
        list[index++] = t;
    }
    
    private void increaseStorage() {
        Object[] newList = new Object[list.length+3];
        for(int i = 0; i< list.length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }
    
    public void remove(int num) {   
        if(num < 0 || num > index) {
            return;
        }
        
        for(int i = num; i < index - 1; i++) {
            list[i] = list[i+1];
        }
        index--;
    }
    
    public int size() {
        return index; 
    }
    
    @SuppressWarnings("unchecked")
    public T get(int num) {
        if(num < 0 || num > index ) {
            return null;
        }
        return (T)list[num];
    }
}
