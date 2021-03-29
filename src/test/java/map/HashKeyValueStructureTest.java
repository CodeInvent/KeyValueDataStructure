package map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashKeyValueStructureTest {
    KeyValueStructure<String, Integer> map;

    @BeforeEach
    void init(){
        map = new HashKeyValueStructure<>();
    }

    @Test
    void size() {
        map.insert("One", 1);
        map.insert("two", 2);
        map.insert("three", 3);
        assertEquals(3, map.size(), "Insert operation failed");
    }

    @Test
    void isEmpty() {
        map.insert("One", 1);
        map.insert("two", 2);
        assertFalse(map.isEmpty(), "isEmpty operation failed");

        map.remove("One");
        map.remove("two");
        assertTrue(map.isEmpty(),"isEmpty operation failed");
    }

    @Test
    void containsKey() {
        map.insert("One", 1);
        map.insert("two", 2);
        map.display();
        assertTrue(map.containsKey("One"), "entry is not present");
        assertFalse(map.containsKey("Three"), "containsKey operation failed");
    }

    @Test
    void retrieve() {
        map.insert("One", 1);
        map.insert("two", 2);
        assertEquals(1, map.retrieve("One"), "retrieve operation fails");
        assertNull(map.retrieve("Three"), "retrieve operation fails");
    }

    @Test
    void insert() {
        for(int i=0; i< 50; i++){
            map.insert(String.valueOf(i), i);
        }
        assertNotNull(map, "insertion operation fails" );
        assertEquals(50, map.size(), "insertion operation fails");
    }

    @Test
    void remove() {
        map.insert("One", 1);
        map.insert("two", 2);
        map.display();
        map.remove("One");
        map.remove("two");
        map.display();
        //assertTrue(map.isEmpty(),"isEmpty operation failed");
    }
}