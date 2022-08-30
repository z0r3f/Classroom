package me.fernando.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetDataIn {

    //Defino dos constantes con el valor de los nombres que espero luego introduzcan
    static final String CARLOS = "Carlos";
    static final String ANTONIA = "Antonia";

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Utilizo print en vez de println para que el cursor se quede después de la frase y quede más natural
        System.out.print("What is your name? ");
        // Declaro y asigno la variable name con el valor que introduzcan
        String name = scanner.nextLine();

        System.out.print("How old are you? ");
        double age = getDoubleFromUser(scanner);

        // Compruebo los valores por método ya que si lo hago así `name = "Carlos"` y `name = "Antonia"`
        // lo que estoy haciendo es comparar las propias valores, no su contenido
        if (name.equalsIgnoreCase(CARLOS)) {
            System.out.println("Hello Carlos");
            System.out.println("Carlos, 76 años, le gustan los toros y el Pasapalabra");
        } else if (name.equalsIgnoreCase(ANTONIA)) {
            System.out.println("Hello Antonia");
            System.out.println("Antonia, va a cumplir 81 años, le gusta las series de la 1 y el Pasapalabra");
        } else {
            System.out.println("Hello " + name + ". I don't know you");
        }
        System.out.printf("You are %s years old", age);
    }

    private static double getDoubleFromUser(Scanner scanner) {
        double number = 0;
        boolean isNumber = false;
        do {
            try {
                number = scanner.nextDouble();
                isNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("You must enter a number");
                scanner.next();
            }
        } while (!isNumber);
        return number;
    }
}
