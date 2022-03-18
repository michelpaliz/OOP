package Tema10.Explicacion;

import java.util.Random;

import Tema10.Explicacion.Strategies.StrategyMiddle;
import Tema10.Explicacion.Strategies.StrategyOnlyEven;
import Tema10.Explicacion.Strategies.StrategyOnlyOdds;

public class Game {

    // Clase que se encarga de la logica del juego.
    private Player player1;
    private Player player2;
    private Random r;
    private Printable p;

    public Game(String player1Name, String player2Name, Printable printable) {
        StrategyOnlyEven strategyOnlyEven = new StrategyOnlyEven();
        // StrategyOnlyOdds strategyOnlyOdds = new StrategyOnlyOdds();
        StrategyMiddle strategyMiddle = new StrategyMiddle();
        player1 = new Player(player1Name, strategyOnlyEven);
        player2 = new Player(player2Name, strategyMiddle);
        // player2 = new Player(player2Name, strategyOnlyOdds);
        r = new Random();
        this.p = printable;
    }

    //
    public void start(int minValue, int maxValue) {
        int number = r.nextInt(maxValue - maxValue + 1) + minValue;
        p.print("Number " + number);
        boolean winner1 = false;
        boolean winner2 = false;
        do {
            winner1 = checkNumber(player1, number);
            winner2 = checkNumber(player2, number);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
            // winner = player1Number == number || player2Number == number;

        } while (!winner1 && !winner2); // para pasar tiene que ver un ganador
        if (winner1 && winner2) {
            p.print("Empate");
        } else if (winner1) {
            p.print("Player1");
        } else {
            p.print("Player2");
        }

    }

    public boolean checkNumber(Player player, int number) {
        int playerNumber = player.play();
        p.print("Jugador " + playerNumber);
        boolean result = false;
        if (playerNumber < number) {
            System.out.println("El numero es mayor");
            player.onCheckNumber(PlayResult.MAJOR);
        } else if (playerNumber > number) {
            System.out.println("El numero es menor");
            player.onCheckNumber(PlayResult.MINOR);
        } else {
            System.out.println("Ha ganado");
            player.onCheckNumber(PlayResult.EQUALS);
            result = true;
        }
        return result;
    }

    public enum PlayResult {
        MINOR, EQUALS, MAJOR
    }

}
