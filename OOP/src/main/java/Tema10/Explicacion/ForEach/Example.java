package Tema10.Explicacion.ForEach;


public class Example {
        
        public static void main(String[] args) {
            MyRandom myRandom = new MyRandom(10);
            for(int random : myRandom){
                System.out.println(random);
            }


        }


}
