package EjemplosTema8.Cajero;

public class Cajero {
    public Cajero() {
        System.out.println("*****GENERADOR DE CAJERO AUTOMATICO **************");
        //Generamos la clase objeto llamada Cajero
        Cuenta  cuenta1 = new Cuenta();
        Cuenta cuenta2 = new Cuenta("4565465465654564",45646,546);
        //Generamos la clase objeto Tarjeta funcionara como un generador de subObjetos
        Tarjeta tarjeta1 = new Tarjeta();
        Tarjeta tarjeta2 = new Tarjeta("Michael",5800, Tarjeta.Tipo.CREDITO);

        //Getter
        System.out.println("Esto es getPIN :");
        System.out.println(cuenta2.getPin());
        //Setter que pone un valor predeterminado al atributo;
        System.out.println("Esto es setTarjeta");
        tarjeta1.setTarjeta(Tarjeta.Tipo.DEBITO);
        //*Invocacion de los metodos de la clase hija Tarjeta
        System.out.println("Metodo Si el ingreso es valido o no = "+tarjeta2.ingreso(tarjeta2.getSaldo()));
        System.out.println("Metodos extaccion de saldo = " + tarjeta2.extraccion(2000, tarjeta2.getSaldo()));

        //***********//
        System.out.println("Esto es cuenta1 = " +cuenta1);
        System.out.println("Esto es cuenta2 = " +cuenta2);

        System.out.println("Esto es tarjeta1 = " + tarjeta1);
        System.out.println("Esto es tarjeta2 = " + tarjeta2);

    }
}
