package Tema10.Explicacion.Strategies;

import java.util.Random;

import Tema10.Explicacion.Game.PlayResult;
import Tema10.Explicacion.Game;
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
    public int play() {
        int result = random.nextInt(maxNumber - minNumber + 1) + minNumber;
        int limit = maxNumber - minNumber+1;
        if ( result < limit) {
            result = 2;
        }
        return result;
    }

    @Override
    public void onCheckNumber(Game.PlayResult playResult) {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(int min, int max) {
        this.minNumber = min;
        this.maxNumber = max;

    }

}
