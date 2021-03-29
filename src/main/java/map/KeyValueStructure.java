package map;

public interface KeyValueStructure<K, V> {
    /**
     * returns the size of data structure
     *
     * @return int size
     */
    int size();

    /**
     * returns if data structure's size is 0
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * returns if key of an element is part of data structure
     *
     * @param key
     * @return boolean
     */
    boolean containsKey(K key);

    /**
     * returns value against key
     *
     * @param key
     * @return V
     */
    V retrieve(K key);

    /**
     * inserts element into data structure
     *
     * @param key
     * @param value
     * @return V
     */
    V insert(K key, V value);

    /**
     * displays current state o structure
     */
    void display();

    /**
     * removes element from data structure
     *
     * @param key
     */
    void remove(K key);
}
