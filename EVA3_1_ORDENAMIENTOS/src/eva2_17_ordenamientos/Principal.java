package eva2_17_ordenamientos;

public class Principal {

    public static void main(String[] args) {
        
        int [] datos = new int[20];
        llenar(datos);
        imprimir(datos);
        
        
    }

    public static void llenar(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 100);

        }
    }

    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }
    
    public static void selectionSort(int [] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            int iMin = i;
            for (int j = i+1; j < arreglo.length; j++) {
                
            }
        }
    }
}
