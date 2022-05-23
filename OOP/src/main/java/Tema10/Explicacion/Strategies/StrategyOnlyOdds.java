package Tema10.Explicacion.Strategies;

import java.util.Random;

import Tema10.Explicacion.Game.PlayResult;
import Tema10.Explicacion.IStrategy;

public class StrategyOnlyOdds implements IStrategy {
    private int maxNumber;
    private int minNumber;
    private Random r;

    public StrategyOnlyOdds() {
        this.r = new Random();
    }

    @Override
    public int play() {
        int result = (r.nextInt(maxNumber - minNumber + 1) + minNumber);
        if (result % 2 == 0) {
            result += 1;
        }
        return result;
    }

    @Override
    public void onCheckNumber(PlayResult playResult) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void init(int min, int max) {
        // TODO Auto-generated method stub
        
    }

    

}
