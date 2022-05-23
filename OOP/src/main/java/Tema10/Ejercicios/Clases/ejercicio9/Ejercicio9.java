package Tema10.Ejercicios.Clases.ejercicio9;

public class Ejercicio9 {
    private final String menuMain = "Juego diccionario";
    private final String[] menuOptions = {"Añadir palabra",
            "Modificar palabra",
            "Eliminar palabra",
            "Consultar palabra",
            "Mostra diccionario",
            "Jugar",
            "Mejores puntuaciones"};
    private Practica08 extra ;
    private int playerPoints;
    private TreeMap<Integer,String> scores;

    public Practica09() throws IOException {
        extra = new Practica08(10);
        scores = new TreeMap<>();
        int opcion = 0;
        do {
            opcion = MenuBuilder.printMenu(menuOptions,menuMain);
            switch (opcion){
                case 1: extra.addWord();break;
                case 2: extra.modifyWord();break;
                case 3: extra.deleteWord();break;
                case 4: extra.showWordDefition();break;
                case 5: System.out.println(extra.toString());break;
                case 6: playerPoints = play();
                    if (playerPoints ) {

                    }
                    ;break;
                case 7: ;break;
            }
        }while (opcion != 0);
        System.out.println("Hasta pronto !!");
    }

    private int play() {
        boolean valid;
        int point = 0;
        do {
            System.out.println("Adivina que palabra es ...");
            String word = extra.showRandomWordDefition();
            String playerWord = Util.askStringRestricted("", 3,15);
            valid = word.equalsIgnoreCase(playerWord);
            if (valid){
                point++;
                System.out.println("*** Palabra adivinada *** ");
            }
        } while (valid);
        System.out.printf("Adivinaste : %d\n\n",point);
        return point;
    }
    //todo : implement positions
    private int podium(int playerScore){
        for (int i = 0; i < scores.size(); i++) {
            if ()
        }
    }


}
