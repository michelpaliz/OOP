package Util;

import java.util.Arrays;

public class MyArr {

    /**
     * 
     * @param the       original array
     * @param implement the new array you want to merge with the previous one
     * @returns the new emerged array (int)
     */
    public int[] mergeArray(int original[], int implement[]) {
        int newLength = original.length + implement.length;
        int newArr[] = Arrays.copyOf(original, newLength);
        for (int i = 0; i < implement.length; i++) {
            newArr[original.length + i] = implement[i];
        }
        return newArr;
    }

    /**
     * 
     * @param <T>
     * @param original
     * @param implement
     * @return
     */
    public <T> T[] mergeArray(T original[], T implement[]) {
        int newLength = original.length + implement.length;
        T[] newArr = Arrays.copyOf(original, newLength);
        for (int i = 0; i < implement.length; i++) {
            newArr[original.length + i] = implement[i];
        }
        return newArr;
    }

}
