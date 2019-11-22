package collections.impl;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static collections.impl.TestUtils.INTARR;
import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {
    private BinarySearchTree tree=new BinarySearchTree();
    @Test
    public void nextTest(){
        tree.add(5); tree.add(90); tree.add(4); tree.add(12); tree.add(79);tree.add(1); tree.add(38);
        Iterator iterator=tree.iterator();
        assertEquals(1,tree.iterator().next());
    }
    @Test
    public void reverseTest(){
        tree.add(5); tree.add(90); tree.add(4); tree.add(12); tree.add(79);tree.add(1); tree.add(38);
        tree.reverse();
        Iterator iterator=tree.iterator();
        assertEquals(90,tree.iterator().next());
    }
}
