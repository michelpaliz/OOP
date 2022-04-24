package Testing.array;

import java.util.Arrays;

public class Array {

    public Array() {
        int[] original = { 1, 2, 3, 4 };
        int[] implement = { 50, 67, 23, 45 };
        System.out.println(Arrays.toString(mergeArray(original, implement)));
        int[] newArr = mergeArray(original, implement);
        int[] arr = mergeArray(newArr, implement);
        System.out.println(Arrays.toString(arr));

    }

    public int[] mergeArray(int original[], int implement[]) {
        int newLength = original.length + implement.length;
        int newArr[] = Arrays.copyOf(original, newLength);
        for (int i = 0; i < implement.length; i++) {
            newArr[original.length + i] = implement[i];
        }
        return newArr;
    }

    public <T> T[] mergeArray(T original[], T implement[]) {
        int newLength = original.length + implement.length;
        T[] newArr = Arrays.copyOf(original, newLength);
        for (int i = 0; i < implement.length; i++) {
            newArr[original.length + i] = implement[i];
        }
        return newArr;
    }

}
