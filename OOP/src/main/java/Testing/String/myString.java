package Testing.String;

import java.util.Arrays;

import Lib.Util;
import OtrosEjercicios.Campeonato.Collection.numeric.tCoach;

public class myString {
    public myString() {
        String str1 = "hola";
        String str2 = "bye";
        // System.out.println(str1.equalsIgnoreCase(str1));
        // System.out.println(Util.checkAnswer(str1, str2));
        // tCoach tCoach;
        // selectEnum(tCoach.values());

        // System.out.println(selectEnum1(tCoach.values()));
        String[] option = { "hello", "bye", "ciao" };
        String result = checkOptions(option);
        System.out.println("This is the result " + result);

        // printEnum(tCoach.values());

    }

    public <T> T checkOptions(String[] option) {
        boolean correct = true;
        do {
            System.out.println("Introduce one answer for the avaliable options " + Arrays.toString(option));
            String usr = Util.myInput.nextLine();
            for (int i = 0; i < option.length; i++) {
                if (option[i].equalsIgnoreCase(usr)) {
                    return (T) usr;
                } else {
                    correct = false;
                }
            }
            System.out.println("Please insert a valid option");
        } while (!correct);
        return null;
    }

    private void printEnum(tCoach tCoach) {
    }

    private void selectEnum(tCoach tCoach) {
    }

    public <T extends Enum<T>> void printEnum(T[] values) {
        for (T t : values) {
            System.out.println(t);
        }
    }

    // public <T extends Enum<T>> int selectEnum1(T[] values) {
    // System.out.println("These are the options avaliable.\nPlease select one of
    // these.");
    // for (int i = 0; i < values.length; i++) {
    // System.out.println(i + " " + values[i]);
    // }

    // return 0;

    // }

    public <T extends Enum<T>> Enum<T> selectEnum1(T[] values) {
        System.out.println("These are the options avaliable.\nPlease select one of these.");
        for (int i = 0; i < values.length; i++) {
            System.out.println(i + " " + values[i]);
        }
        String message = "Select a number ";
        int choice = Util.validateInt(message, 0, values.length);
        for (int i = 0; i < values.length; i++) {
            if (i == choice) {
                return values[i];
            }
        }
        return null;

    }

    // public <T extends Enum<T>> void printEnum(Class<T> aEnum) {
    // System.out.println(java.util.Arrays.asList(aEnum.getEnumConstants()));
    // }

}
