
package maquinatragamonedas;

import java.util.Random;
import java.util.Scanner;

public class MaquinaTragamonedas {

    public static void main(String[] args) {
        
        //Generar nombre del usuario
        String nombre = ingresarUsuario();

        //Consultar hasta cuándo jugar.
        jugarTragamonedas();
    }
    
    private static int premioAcumulado = 0;
    private static int contadorTiradas = 1;
    private static int jugadasGanadoras = 0;
    
    public static String ingresarUsuario() {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        String nombre = "";
        boolean nombreValido = false;

        while (!nombreValido) {
            System.out.print("Bienvenido/a. Por favor, ingresa tu nombre > ");
            nombre = teclado.next();

            // Validar que el nombre no esté vacío
            if (nombre.isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío.");
            }
            // Validar que el nombre no contenga números
            else if (nombre.matches(".*\\d.*")) {
                System.out.println("Error: El nombre no puede contener números.");
            }
            // Validar que el nombre tenga al menos 2 letras
            else if (nombre.length() < 2) {
                System.out.println("Error: El nombre debe tener al menos 2 letras.");
            }
            // Si pasa todas las validaciones, marcar como válido
            else {
                nombreValido = true;
                System.out.println("Bienvenido/a " + nombre + "!");
            }
        }
        return nombre;
    }
    
    public static void jugarTragamonedas() {

        Scanner scanner = new Scanner(System.in);

        boolean continuarJugando = true;

            while (continuarJugando) {
                System.out.print("¿Deseas tirar la palanca? (si/no): ");
                String respuesta = scanner.nextLine().toLowerCase();

                if (!respuesta.equals("si")) {
                    continuarJugando = false;
                } else {
                    tirarPalanca();
                    contadorTiradas++;
                }
            }
            

        System.out.println("Tu juego ha terminado!");
        System.out.println("Tu premio acumulado es de: $" + premioAcumulado);
        System.out.println("Has ganado a lo largo de: " + jugadasGanadoras + " jugadas.");
    }

    private static void tirarPalanca() {
        Random random = new Random();

        // Generar tres números aleatorios entre 1 y 9
        int num1 = random.nextInt(9) + 1;
        int num2 = random.nextInt(9) + 1;
        int num3 = random.nextInt(9) + 1;

        // Mostrar los símbolos obtenidos en la tirada
        System.out.println("Esta es tu tirada número: " + contadorTiradas);
        System.out.println("Los numeros son: " + num1 + " - " + num2 + " - " + num3);

        // Verificar las combinaciones resultantes
        if (num1 == num2 && num2 == num3) { // Los tres números son iguales
            premioAcumulado += 10;
            jugadasGanadoras++;
            System.out.println("Tres números iguales! Sumas $10 a tu premio acumulado.");
        } else if (num1 == num2 || num1 == num3 || num2 == num3) { // Dos números son iguales
            premioAcumulado += 1;
            jugadasGanadoras++;
            System.out.println("Dos números iguales!. Sumas $1 a tu premio acumulado.");
        } else { // No hay coincidencias
            System.out.println("No hay coincidencias! Por lo que no sumas nada a tu premio acumulado!");
        }

        // Mostrar el premio acumulado después de cada tirada
        System.out.println("Hasta el momento tenés: $" + premioAcumulado);
        System.out.println();
    }
    
}

