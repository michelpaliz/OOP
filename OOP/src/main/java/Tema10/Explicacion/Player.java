package Tema10.Explicacion;

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
    public int jugar() {
        return strategy.jugar();
    }

}
