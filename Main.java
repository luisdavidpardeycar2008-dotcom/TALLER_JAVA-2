import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random aleatorio = new Random();
        int[] numeros = new int[100000];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = aleatorio.nextInt(1000) + 1;
        }

       
        int[] original_30 = Arrays.copyOf(numeros, 30);
        int[] ordenado_30 = original_30.clone();
        ordenar_burbuja(ordenado_30);

        System.out.println("PRUEBA CON 30 NUMEROS");
        System.out.println("Original: " + Arrays.toString(original_30));
        System.out.println("Ordenado: " + Arrays.toString(ordenado_30));
        
        System.out.print("Presiona ENTER para continuar con los tiempos...");

        Scanner entrada = new Scanner(System.in);
        entrada.nextLine();

       
        int[] ordenado_10000 = Arrays.copyOf(numeros, 10000);
        long inicio_10000 = System.nanoTime();
        ordenar_burbuja(ordenado_10000);
        long tiempo_10000 = System.nanoTime() - inicio_10000;

       
        int[] ordenado_100000 = numeros.clone();
        long inicio_100000 = System.nanoTime();
        ordenar_burbuja(ordenado_100000);
        long tiempo_100000 = System.nanoTime() - inicio_100000;

        System.out.println("\nRESULTADOS - BUBBLE SORT (BURBUJA)");
        System.out.printf("10.000 numeros: %.3f ms%n", tiempo_10000 / 1000000.0);
        System.out.printf("100.000 numeros: %.3f ms%n", tiempo_100000 / 1000000.0);
    }

    
    public static void ordenar_burbuja(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            boolean hubo_cambios = false;

            for (int j = 0; j < vector.length - 1 - i; j++) {
                if (vector[j] > vector[j + 1]) {
                    int auxiliar = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = auxiliar;
                    hubo_cambios = true;
                }
            }

            if (!hubo_cambios) {
                break;
            }
        }
    }
}
