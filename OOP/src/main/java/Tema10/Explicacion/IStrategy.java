package Tema10.Explicacion;

public interface IStrategy {
    //si anyadimos mas metodos tendriamos que anyadirlos a los demas
    int play();
    void onCheckNumber(Game.PlayResult playResult);
    void init(int min, int max);
    


}
