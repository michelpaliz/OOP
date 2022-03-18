package Tema10.Explicacion;

public class MainTm10 implements Printable {

    public static void main(String[] args) {
        MainTm10 principal = new MainTm10();
        Game game = new Game("Juan", "Pedro ", principal);
        game.start(1, 100);
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

}
