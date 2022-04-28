package Tema11.Propios.ejercicio06.models;

public class VideoGame extends Multemedia {
    private Platform platform;

    public VideoGame() {
        super();
        platform = Platform.NINTENDO;
    }

    public VideoGame(Platform platform) {
        super();
        this.platform = platform;
    }

    @Override
    public String toString() {
        return super.toString() + " VideoGame [platform=" + platform + "]";
    }

}
