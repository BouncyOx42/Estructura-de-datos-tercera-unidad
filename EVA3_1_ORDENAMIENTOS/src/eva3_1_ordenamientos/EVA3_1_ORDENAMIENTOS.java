//Isela Alejandra Ponce de León Carrasco   ||  18550720
package eva3_1_ordenamientos;

import java.time.Clock;
import java.util.Scanner;

public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {
        int[] datos = new int[6];

        llenar(datos);
        imprimir(datos);
        SelectionSort(datos);
        imprimir(datos);
        
        Scanner input = new Scanner(System.in);
        System.out.println("Valor a buscar");
        int iVal = input.nextInt();
        System.out.println("Posicion: " + busquedaBin(datos, iVal));
    }

//metodo que nos permite llenar un arreglo con valores aleatoreos
    public static void llenar(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 100);
        }
    }

//Imprimir arreglo
    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }

    public static void SelectionSort(int[] arreglo) {
        int min;
        //para i=1 hasta n-1
        for (int i = 0; i < arreglo.length; i++) {
            min = i;
            for (int j = i + 1; j < arreglo.length; j++) { //busca en los elementos restantes el mas pequeno
                if (arreglo[j] < arreglo[min]) {
                    min = j;
                }
            }
            //SWAP 
            int intercambio = arreglo[i];
            arreglo[i] = arreglo[min];
            arreglo[min] = intercambio;
        }
    }

    public static void insertionSort(int[] arreglo) {
        int insertP;
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i];
            for (insertP = i; insertP > 0; insertP--) { //siempre el segundo for es donde voy a comparar
                int previo = insertP - 1; //if (j-1) > se hace el cambio de elementos y se mueve a la izquierda
                if (arreglo[previo] > temp) { //23>78 //if (j-1) > se hace el cambio de elementos y se mueve a la izquierda
                    //SWAP
                    arreglo[insertP] = arreglo[previo];
                } else {
                    break;//falta detenerlo e insertarlo donde quede insertionpoint (la variable insertP se va reduciendo) 
                }
            }
            arreglo[insertP] = temp;
        }
    }

    //-----------> ORDENAMIENTO POR BURBUJA <---------------
    public static void bubbleSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arreglo) {
        //aplica el ordenamiento
        quickSortRecursivo(arreglo, 0, arreglo.length - 1);
    }

    public static void quickSortRecursivo(int[] arreglo, int ini, int fin) {
        if ((ini < fin) && (ini >= 0) && (fin < arreglo.length)) { //que se detenga 
            int pivote = ini;
            int too_big = ini + 1; //avanza
            int too_Small = fin; //retrocede
            int temp;

            //el algoritmo se detienen cuando los dos se cruzan
            while (too_big < too_Small) {
                //while porque no se sabe cuando se va a detener 
                while ((too_big < fin) && (arreglo[too_big] < arreglo[pivote])) {
                    too_big++;
                }
                while ((too_Small > (ini + 1)) && (arreglo[too_Small] > arreglo[pivote])) {
                    too_Small--;
                }

                if (too_big < too_Small) { //no hay cruce
                    temp = arreglo[too_big];
                    arreglo[too_big] = arreglo[too_Small];
                    arreglo[too_Small] = temp;
                }
            }
            temp = arreglo[pivote];
            arreglo[pivote] = arreglo[too_Small];
            arreglo[too_Small] = temp;

            //hacer llamada recursiva (quick sort a la izquierda y a la derecha)
            quickSortRecursivo(arreglo, ini, too_Small - 1); //izquierda
            quickSortRecursivo(arreglo, too_Small + 1, fin); //derecha

            // detener la llamada recursiva
        }
    }

    public static int busquedaBin(int[] arreglo, int val) {
        return busquedaBinRec(arreglo, val, 0, arreglo.length - 1);
    }

    private static int busquedaBinRec(int[] arreglo, int val, int ini, int fin) {
        if (ini <= fin) {

            int mid = ini + ((fin - ini) / 2);

            if (val == arreglo[mid]) {
                return mid;
            } else if (val > arreglo[mid]) {//MAYOR
                return busquedaBinRec(arreglo, val, mid + 1, fin);
            } else {//MENOR
                return busquedaBinRec(arreglo, val, ini, mid - 1);
            }
        } else {
            return -1;
        }
    }
}
