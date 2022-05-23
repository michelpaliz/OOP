package Tema10.Explicacion.Strategies;

import java.util.Random;

import Tema10.Explicacion.Game.PlayResult;
import Tema10.Explicacion.Game;
import Tema10.Explicacion.IStrategy;

public class StrategyMiddle implements IStrategy {
    private int maxNumber;
    private int minNumber;
    private Random r;
    private int number;

    public StrategyMiddle() {
        this.r = new Random();
    }

    @Override
    public int play() {
        number = (maxNumber - minNumber) / 2;
        return number;
    }

    @Override
    public void onCheckNumber(Game.PlayResult playResult) {
        switch (playResult) {
            case MAJOR:
                minNumber = number + 1;
                break;
            case MINOR:
                maxNumber = number - 1;
                break;
            case EQUALS:
                break;
            default:
                break;
        }

    }

    @Override
    public void init(int min, int max) {
        this.minNumber = min;
        this.maxNumber = max;

    }

}
