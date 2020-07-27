/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package octaladecimal;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import octaladecimal.cup.AnalizadorSintactico;
import octaladecimal.jflex.AnalizadorLexico;

/**
 *
 * @author sergio
 */
public class OctalADecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ingrese un Numero Octal");
            boolean opcionValida=true;
            do {
                String numero = scanner.nextLine();
                AnalizadorLexico al = new AnalizadorLexico(new StringReader(numero));
                        AnalizadorSintactico as = new AnalizadorSintactico(al);
                try {
                    as.parse();
                } catch (Exception ex) {
                    Logger.getLogger(OctalADecimal.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Deseas Ingresar Otro? Y/N");
                String opcion = scanner.nextLine();
                if (opcion.equalsIgnoreCase("y")) {
                    salir=false;
                } else if (opcion.equalsIgnoreCase("n")) {
                    salir=true;
                } else {
                    opcionValida=false;
                }
            } while (!opcionValida);

        } while (!salir);

    }

}
