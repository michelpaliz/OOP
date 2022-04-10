package Util;

import java.util.ArrayList;

public class Conversion {

    static ArrayList<Object> arrayList = new ArrayList<Object>();

    public static <T> ArrayList<Object> arrToArrList(T array[]) {

        for (T t : array) {
            arrayList.add(t);
        }
        return arrayList;

    }
}
