/**
 * Clase que contiene las operaciones matemáticas básicas
 * Todos los métodos son estáticos para facilitar su uso
 * 
 * @author Mario Alguacil Juárez
 */
public class Calculadora {
    
    /**
     * Suma dos números
     * @param a primer número
     * @param b segundo número
     * @return resultado de la suma
     */
    public static double sumar(double a, double b) {
        return a + b;
    }
    
    /**
     * Resta dos números
     * @param a primer número
     * @param b segundo número
     * @return resultado de la resta
     */
    public static double restar(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dos números
     * @param a primer número
     * @param b segundo número
     * @return resultado de la multiplicación
     */
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide dos números
     * @param a dividendo
     * @param b divisor
     * @return resultado de la división
     * @throws IllegalArgumentException si el divisor es cero
     */
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }
        return a / b;
    }

    /**
     * Eleva un número a la potencia de otro
     * @param base la base
     * @param exponente el exponente
     * @return resultado de la potencia
     */
    public static double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    /**
     * Calcula la raíz cuadrada de un número
     * @param a el número
     * @return resultado de la raíz cuadrada
     * @throws IllegalArgumentException si el número es negativo
     */
    public static double raizCuadrada(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(a);
    }

    /**
     * Calcula el módulo de dos números
     * @param a el dividendo
     * @param b el divisor
     * @return resultado del módulo
     * @throws IllegalArgumentException si el divisor es cero
     */
    public static double modulo(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }
        return a % b;
    }
}