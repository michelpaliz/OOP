package Tema10.Explicacion;

import Tema10.Explicacion.Strategies.StrategyOnlyEven;

public class Game {

    // Clase que se encarga de la logica del juego.
    private Player player1;
    private Player player2;

    public Game(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);

    }
}
