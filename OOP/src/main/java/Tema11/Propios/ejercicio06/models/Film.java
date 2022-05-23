package Tema11.Propios.ejercicio06.models;

public class Film extends Multemedia {
    private double duration;
    private String maleAuthor;
    private String femaleAuthor;

    public Film() {
        super();
        this.duration = 5.0;
        this.maleAuthor = "Michael";
        this.femaleAuthor = "Sanyi";
    }

    public Film(double duration, String maleAuthor, String femaleAuthor) {
        super();
        this.duration = duration;
        this.maleAuthor = maleAuthor;
        this.femaleAuthor = femaleAuthor;
    }

    @Override
    public String toString() {
        return super.toString() + " Film [duration=" + duration + ", femaleAuthor=" + femaleAuthor + ", maleAuthor="
                + maleAuthor + "]";
    }

}
