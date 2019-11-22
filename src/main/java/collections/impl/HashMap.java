package collections.impl;

import collections.Map;

public class HashMap<K, V> implements Map<K, V> {
    private Object[]hashArray;
    private int arraySize;
    public HashMap(){
        arraySize=27;
        hashArray=new Object[arraySize];
    }
    class DataItem{
        private K key;
        private V value;
        public DataItem(K key,V value){
            this.key=key;
            this.value=value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
    private int hashFunc(K key){
        String string=key.toString();
        int hash=string.charAt(0);
        for (int i=1;i<string.length();i++){
            int letter=string.charAt(i);
            hash+=letter;
        }
        return hash%arraySize;
    }
    @Override
    public boolean insert(K key, V value) {
        DataItem dataItem=new DataItem(key, value);
        int hash=hashFunc(key);
        hashArray[hash]=dataItem;
        return true;
    }

    @Override
    public V get(K   key) {
        int hash=hashFunc(key);
        DataItem dataItem= (DataItem) hashArray[hash];
        return dataItem.getValue();
    }

    @Override
    public boolean delete(K key) {
        int hash=hashFunc(key);
        DataItem dataItem= (DataItem) hashArray[hash];
        dataItem=null;
        return true;
    }
}
