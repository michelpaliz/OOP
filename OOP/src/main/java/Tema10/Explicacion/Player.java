package Tema10.Explicacion;

import Tema10.Explicacion.Strategies.StrategyMiddle;

public class Player {
    private String nombre;
    private IStrategy strategy;

    // Constructor
    public Player(String nombre, IStrategy strategy) {
        this.nombre = nombre;
        this.strategy = strategy;
    }

    /**
     * 
     * @return
     */
    public int play() {
        return strategy.play();
    }

    public void onCheckNumber(Game.PlayResult playResult){
        Strategy.onCheckNumber(playResult);

    }


    public void 

}
