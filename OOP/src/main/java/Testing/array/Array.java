package Testing.array;

import java.util.Arrays;

import Util.Lib;

public class Array {

    public Array() {
        int[] original = { 1, 2, 3, 4 };
        int[] implement = { 50, 67, 23, 45 };
        System.out.println(Arrays.toString(mergeArray(original, implement)));
        int[] newArr = mergeArray(original, implement);
        int[] arr = mergeArray(newArr, implement);
        String[] arrStr2 = { "1", "2", "3", "4", "5" };
        System.out.println("Let's create a new array");
        System.out.println(Arrays.toString(newArray(arrStr2)));
        System.out.println("Let's get values without duplicates");

        System.out.println(Arrays.toString(arr));
        String[] arrStr = { "hello", "bye", "how are you" };
        System.out.println("GET random value");
        System.out.println(Lib.r.nextInt(arrStr.length));
        String[] arrStr1 = { "hola", "chao", "como estas" };
        System.out.println(getRndValueArr(arrStr));
        String[] rnd = mergeArray(arrStr, arrStr1);
        System.out.println(Arrays.toString(rnd));

        // String result = getRndValueArr(arrStr);
        // System.out.println(result);

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

    public <T> Object[] mergeObj(T original[], T implement[]) {
        int newLength = original.length + implement.length;
        T[] newArr = Arrays.copyOf(original, newLength);
        for (int i = 0; i < implement.length; i++) {
            newArr[original.length + i] = implement[i];
        }
        return newArr;
    }

    public <T> T getRndValueArr(T arr[]) {
        // Store the index in a variable
        // int rnd = (int) (Math.random() * arr.length);
        int rnd = (Lib.r).nextInt(arr.length);
        // Then access it using another variable
        T random = (arr[rnd]);
        return random;
    }

    public String[] newArray(String array[]) {
        String value = "";
        int index = 0;
        // Create another array of size one less
        String[] anotherArray = new String[array.length - 1];

        for (int i = 0, k = 0; i < array.length - 1; i++) {
            // do {
            index = getRndIndex(array);
            System.out.println("Index = " + index);
            if (i == index) {
                System.out.println("continue");
                continue;
            }
            anotherArray[k++] = array[i];

            // } while (anotherArray != null);

        }
        System.out.println("This is the copy");
        return anotherArray;
    }

    public int getRndIndex(String array[]) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            index = Lib.r.nextInt(array.length);
        }
        return index;
    }

    public String getRandom(String array[]) {
        String value = "";
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            index = Lib.r.nextInt(array.length);
            value = array[index];
        }
        return value;
    }
}
