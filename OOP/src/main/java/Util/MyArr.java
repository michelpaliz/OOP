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
     * @return the new implement obj array
     */
    public <T> T[] mergeArray(T original[], T implement[]) {
        int newLength = original.length + implement.length;
        T[] newArr = Arrays.copyOf(original, newLength);
        for (int i = 0; i < implement.length; i++) {
            newArr[original.length + i] = implement[i];
        }
        return newArr;
    }

    /**
     * 
     * @param <T>
     * @param arr
     * @return the random obj selected
     */
    public <T> T getRndValueArr(T arr[]) {
        // Store the index in a variable
        // int rnd = (int) (Math.random() * arr.length);
        int rnd = (Lib.r).nextInt(arr.length);
        // Then access it using another variable
        T random = (arr[rnd]);
        return random;
    }

}
