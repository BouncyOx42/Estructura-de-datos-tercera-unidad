
import java.util.Comparator;
import java.util.LinkedList;

public class Principal {

    public static void main(String[] args) {
        LinkedList<Integer> ListaEnla = new LinkedList();
        ListaEnla.add(12);
        ListaEnla.add(45);
        ListaEnla.add(86);
        ListaEnla.add(65);
        ListaEnla.add(26);
        ListaEnla.add(34);
        ListaEnla.add(16);
        ListaEnla.add(9);
        ListaEnla.add(78);
        ListaEnla.add(35);
        ListaEnla.add(51);
        ListaEnla.add(58);
        ListaEnla.add(42);
        ListaEnla.add(71);
        ListaEnla.add(76);
        ListaEnla.addFirst(100);

        System.out.println(ListaEnla);

        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int resu;
                //CERO --> IGUAL
                //POSITIVO --> MAYOR
                //NEGATIVO --> MENOR
                Integer val1, val2;
                val1 = (Integer) o1;
                val2 = (Integer) o2;
                resu = val1 - val2;

                return resu;
            }
        };
        ListaEnla.sort(c);
        System.out.println("Lista ordenada");
        System.out.println(ListaEnla);
        System.out.println("");

        //ordenamos una lista con Strings
        LinkedList<String> lista2 = new LinkedList<String>();
        lista2.add("hola");
        lista2.add(" ");
        lista2.add("Mundo");
        lista2.add(" ");
        lista2.add("cruel");
        lista2.add("!!");
        Comparator cmpStr = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String cad1 = (String) o1;
                String cad2 = (String) o2;
                char c1 = cad1.charAt(0);
                char c2 = cad2.charAt(0);
                return c1 - c2;
            }
        };
        System.out.println(lista2);
        lista2.sort(cmpStr);
        System.out.println(lista2);

    }
}
