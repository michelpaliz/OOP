package Testing.array;

import java.util.HashMap;

public class myHashMap {

    public myHashMap() {
        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
        hashmap.put(1, "Value1");
        hashmap.put(2, "Value2");
        hashmap.put(3, "Value3");
        hashmap.put(4, "Value4");
        hashmap.put(5, "Value5");

        HashMap<Integer, String> hashmap1 = new HashMap<Integer, String>();

        for (Integer i : hashmap.keySet()) {
            System.out.println(i);
            if (i.getInteger() == 2) {

            }

        }
    }

}
