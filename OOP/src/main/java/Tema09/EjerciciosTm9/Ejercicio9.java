package Tema09.EjerciciosTm9;

public class Ejercicio9 {
 
        // TODO
        // vamos anyadir una persona, la edad esta comprendida en estos parametros
        // como tratamos si no cumple la condicion
        // El metodo que esta solicitando este exepction tendra un throws al lado
        // int userInt = Integer.parseInt(Lib.myInput.nextLine());
        // int edad = userInt;
        // if (edad < 0 && edad > 130) {
        // throw new RangeNumberException("El reagno debe de estar entre");
        // }



      /**
     * el extends sign es hija de rangenumberexpection
     * keyword super lo que hace es llamar al constructor expecion que lo llama
     */
    public class RangeNumberException extends Exception {
        public RangeNumberException(String message) {
            super(message);

        }
    }

}
