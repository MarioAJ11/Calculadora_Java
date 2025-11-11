/**
 * Clase principal de la aplicación de calculadora
 * 
 * @author Mario Alguacil Juárez
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0) {

            limpiarConsola();

            mostrarEncabezado();
            System.out.print("Seleccione una operación (1-5), si desea salir ingrese 0: ");

            try {
                opcion = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                s.nextLine(); // Limpiar el buffer
                continue; // Volver al inicio del bucle
            }

            double num1, num2, resultado;

            limpiarConsola();

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo de la calculadora. ¡Hasta luego!");
                    break;
                case 1:
                    System.out.print("Ingrese el primer número: ");
                    num1 = entradaNumero(s);
                    System.out.print("Ingrese el segundo número: ");
                    num2 = entradaNumero(s);
                    resultado = Calculadora.sumar(num1, num2);
                    mostrarResultado(resultado);
                    break;
                case 2:
                    System.out.print("Ingrese el primer número: ");
                    num1 = entradaNumero(s);
                    System.out.print("Ingrese el segundo número: ");
                    num2 = entradaNumero(s);
                    resultado = Calculadora.restar(num1, num2);
                    mostrarResultado(resultado);
                    break;
                case 3:
                    System.out.print("Ingrese el primer número: ");
                    num1 = entradaNumero(s);
                    System.out.print("Ingrese el segundo número: ");
                    num2 = entradaNumero(s);
                    resultado = Calculadora.multiplicar(num1, num2);
                    mostrarResultado(resultado);
                    break;
                case 4:
                    try {
                        System.out.print("Ingrese el dividendo: ");
                        num1 = entradaNumero(s);
                        System.out.print("Ingrese el divisor: ");
                        num2 = entradaNumero(s);
                        resultado = Calculadora.dividir(num1, num2);
                        mostrarResultado(resultado);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la base: ");
                    num1 = entradaNumero(s);
                    System.out.print("Ingrese el exponente: ");
                    num2 = entradaNumero(s);
                    resultado = Calculadora.potencia(num1, num2);
                    mostrarResultado(resultado);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 0 al 5.");
                    break;
            }

            System.out.println("Pulse Enter para continuar...");
            s.nextLine(); // Consumir el salto de línea pendiente
            s.nextLine(); // Esperar a que el usuario pulse Enter
        }

        s.close();
    }

    /**
     * Limpia la consola
     */
    public static void limpiarConsola() {

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
                // Si falla, simplemente imprime líneas en blanco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }

    }

    /**
     * Muestra el resultado formateado
     * @param resultado el resultado a mostrar
     */
    public static void mostrarResultado(double resultado) {

        if (resultado % 1 == 0) {
            // Es un número entero, mostrar sin decimales
            System.out.printf("El resultado es: %.0f%n", resultado);
        } else {
            // Tiene decimales, mostrarlos
            System.out.printf("El resultado es: %.2f%n", resultado);
        }

    }

    /**
     * Muestra el encabezado de la calculadora
     */
    public static void mostrarEncabezado() {
        System.out.println("=================================");
        System.out.println("       CALCULADORA JAVA         ");
        System.out.println("=================================");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Potencia");
        System.out.println("=================================");
    }

    /**
     * Lee un número double del usuario con validación
     * Si el usuario ingresa algo inválido, vuelve a pedirlo
     * @param s Scanner para leer la entrada
     * @return el número ingresado por el usuario
     */
    public static double entradaNumero(Scanner s) {
        double numero;
        while (true) {
            try {
                numero = s.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Error: Debe ingresar un número válido. Intente de nuevo: ");
                s.nextLine(); // Limpiar el buffer
            }
        }
        return numero;
    }
}
