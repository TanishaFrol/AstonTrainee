package hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MyArrayListImpTest {
    private MyArrayListImp<String> listImp;

    @BeforeEach
    void init() {
        listImp = new MyArrayListImp<>(5);
        listImp.add("a");
        listImp.add("b");
        listImp.add("c");
        listImp.add("d");
        listImp.add("e");
    }

    @Test
    void add() {
        Assertions.assertEquals("[ a, b, c, d, e ]", listImp.toString());
    }

    @Test
    void addWithIndex() {
        listImp.add(2, "f");
        Assertions.assertEquals("[ a, b, f, c, d, e ]", listImp.toString());
    }

    @Test
    void size() {
        Assertions.assertEquals(5, listImp.size());
    }

    @Test
    void get() {
        Assertions.assertEquals("b", listImp.get(1));
    }

    @Test
    void remove() {
        listImp.remove(2);
        Assertions.assertEquals("[ a, b, d, e ]", listImp.toString());
    }

    @Test
    void clear() {
        listImp.clear();
        Assertions.assertEquals("[ ]", listImp.toString());
    }

    @Test
    void sort() {
        listImp.add("a");
        listImp.add("b");
        listImp.sort();
        Assertions.assertEquals("[ a, a, b, b, c, d, e ]", listImp.toString());
    }
}