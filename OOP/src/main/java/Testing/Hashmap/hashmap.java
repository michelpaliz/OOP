package Testing.Hashmap;

public class hashmap {

    public hashmap() {

        Person p1 = new Person();
        Person p2 = new Person();

        Person p3 = p1; // this will give us true if we want to compare

        // for now on to me persons are the same when the got the same ID
        if (p1.equals(p2)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

        // el objetivo es saber que es hash que es un funcion matematica.

        myHashmap hashMap = new myHashmap();
        hashMap.put("hola", 4);
        hashMap.put("Pepe", 4);
        hashMap.put("Michael", 4);

        System.out.println(hashMap.get("Pepe"));
        System.out.println(hashMap.get("Michael"));

        System.out.println(hashMap);
    }

}
