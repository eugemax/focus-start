package collections.impl;
import org.junit.Test;
import java.util.Iterator;
import static collections.impl.TestUtils.ARR;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    private LinkedList<String> list=new LinkedList<>();
@Test
    public void addTest(){
        assertEquals(true,list.add(ARR[0]));
}
@Test
    public void removeTest(){
        fillList();
        assertEquals(ARR[1],list.remove(1));
}
@Test
    public void getTest(){
         fillList();
         assertEquals(ARR[2],list.get(2));
    }
    @Test
    public void nextTest(){
        fillList();
        Iterator iterator=list.iterator();
        assertEquals(ARR[0],iterator.next());
        assertEquals(ARR[1],iterator.next());
        assertEquals(ARR[2],iterator.next());
        assertEquals(ARR[3],iterator.next());
        assertEquals(ARR[4],iterator.next());
    }

    private void fillList(){
        for(int i=0;i<ARR.length;i++)
            list.add(ARR[i]);
    }


}
