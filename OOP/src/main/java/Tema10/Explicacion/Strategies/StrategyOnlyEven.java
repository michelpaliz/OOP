package Tema10.Explicacion.Strategies;

import java.util.Random;

import Tema10.Explicacion.IStrategy;

public class StrategyOnlyEven implements IStrategy {
    private int maxNumber;
    private int minNumber;
    private Random random;

    public StrategyOnlyEven() {
        this.random = new Random();
    }

    /** 
     * 
    */
    @Override
    public int jugar() {
        int result = random.nextInt(maxNumber - minNumber + 1) + minNumber;
        if (result % 2 != 0) {
            result += 1;
        }
        return result;
    }

}
