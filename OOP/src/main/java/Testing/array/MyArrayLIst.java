package Testing.array;

import java.util.ArrayList;

import Util.Lib;

public class MyArrayLIst {
    ArrayList<String> al = new ArrayList<String>();

    public MyArrayLIst() {

        al.add("MADRID");
        al.add("BARCELONA");
        al.add("ATLETICO");
        al.add("BETIS");
        al.add("SEVILLA");
        al.add("VALENCIA");

        System.out.println(al);
        System.out.println("Return the element");
        System.out.println(getElement(getRandom(al)));
        System.out.println("return the whole arraylist");
        System.out.println(al);

    }

    // public String getElement(int index) {
    // System.out.println("This is the index " + index);
    // al.remove(index);
    // // System.out.println(index);
    // return al.get(index);
    // }

    public String getElement(String element) {
        return (element);
    }

    public String getRandom(ArrayList<String> array) {
        int index = 0;
        index = Lib.r.nextInt(array.size());
        System.out.println("This is the index " + index);
        // array.remove(index);
        return array.get(index);

    }

}
