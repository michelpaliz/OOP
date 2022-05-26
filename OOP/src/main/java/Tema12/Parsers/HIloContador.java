package Tema12.Parsers;

public class HIloContador extends Thread {

    private int num;
    private final String name;

    public HIloContador(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        // TODO Auto-generated method stub
        for (int i = 0; i < num; i++) {
            System.out.println("Soy el hilo " + name + ": " + i);
        }

        // cuando el hilo llege aqui muere, pero cuando salimos
    }

}
