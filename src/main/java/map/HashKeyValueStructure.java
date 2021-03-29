package map;

import java.util.stream.IntStream;

public class HashKeyValueStructure<K,V> implements KeyValueStructure<K,V>{

    private float loadFactor = 0.75f;
    private int count;
    private int capacity = 16;
    private Entry<K,V>[] table;

    public HashKeyValueStructure(){
        this.count = 0;
        resize();
    }

    public HashKeyValueStructure(int capacity){
        this.count = 0;
        this.capacity = capacity;
        resize();
    }


    @Override
    public int size() {
        int count = 0;
        if (table != null) {
            for (int i = 0; i < capacity; i++) {
                if (table[i] != null) {
                    Entry<K, V> currentNode = table[i];
                    while (currentNode != null) {
                        currentNode = currentNode.getNext();
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(K key) {
       int index =  index(key);
       Entry<K,V> entry = table[index];
           while (entry != null){
               if(entry.getKey().equals(key)){
                   return true;
           }
       }
        return false;
    }

    @Override
    public V retrieve(K key) {
        V value = null;
        int index = index(key);
        Entry<K, V> entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }

    @Override
    public V insert(K key, V value) {
        int index = index(key);
        Entry<K,V> newEntry = new Entry<>(key, value, null);
        if(table[index] == null){
            table[index] = newEntry;
        }else {
            Entry<K, V> previousNode = null;
            Entry<K, V> currentNode = table[index];
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue(value);
                    return value;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if(previousNode != null)
                previousNode.setNext(newEntry);
        }

        return value;
    }

    @Override
    public void display() {
        if(!isEmpty()) {
            for (int i = 0; i < capacity; i++) {
                if (table[i] != null) {
                    Entry<K, V> currentNode = table[i];
                    while (currentNode != null) {
                        System.out.println(String.format("< %s %s >", currentNode.getKey(),
                                currentNode.getValue()));
                        currentNode = currentNode.getNext();
                    }
                }
            }
        }else {
            System.out.println(" Map is empty");
        }
    }

    @Override
    public void remove(K key) {
        int index = index(key);
        Entry<K,V> previous = null;
        Entry<K,V> entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)){
                if(previous == null){
                    entry = entry.getNext();
                    table[index] = entry;
                }else {
                    previous.setNext(entry.getNext());
                }
                return;
            }
            previous = entry;
            entry = entry.getNext();
        }
    }

    private int index(K key){
        if(key == null){
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }

    private void resize(){
        Entry<K,V> [] temp;
        Entry<K,V> [] newTemp;
        if(table == null){
            table = new Entry[capacity];
        }else {
            newTemp = new Entry[Math.abs(Math.round(table.length + (table.length * loadFactor)))];
            IntStream.of(0, table.length -1).forEach(value -> newTemp[value] = table[value]);
            table = newTemp;
        }
    }
}
