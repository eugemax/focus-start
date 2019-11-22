package collections.impl;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static collections.impl.TestUtils.KEYS;
import static collections.impl.TestUtils.VALUES;
import static org.junit.Assert.fail;

public class HashMapTest {
    private HashMap<String,Integer> map=new HashMap();
    @Test
    public  void  insertTest(){
        assertEquals(true,map.insert("a",15));
    }
    @Test
    public void  getTest(){
        fillInMap();
        assertEquals(VALUES[5],map.get(KEYS[5]));
    }
    @Test
    public void deleteTest(){
        fillInMap();
        assertEquals(true,map.delete(KEYS[0]));
    }
    private void fillInMap(){
        for(int i=0;i<KEYS.length;i++){
            map.insert(KEYS[i],VALUES[i]);
        }
    }
}
