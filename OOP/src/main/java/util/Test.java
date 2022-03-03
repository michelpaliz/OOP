package util;

public class Test {

    public static void main() {
//        cargarDatos();
        try{
            throw new ArithmeticException("Eerroooor!!");
        }catch(ArithmeticException ae){
            System.out.println("SE ha producido una exepcion");

        }


//
//        try{
//            byte [] data = Lib.readFile("/home/desktop/hola.txt");
//        }catch (IOException e){
//            e.printStackTrace();
//
//        }
//
//        System.out.println("Final del proyecto");
    }
//
//    public static byte[] cargarDatos(){
////        cargarImg();
////        cargarArchivos();
//        return Lib.readFile("archivo.txt");

    public Test(){

    }
}
