import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Leemos la lista de documentos directamente desde el String.
            List<Documento> listaOriginal = Utilidades.leerCSVDesdeString();
            
            System.out.println("Parce, esta es la lista original:");
            Utilidades.mostrarLista(listaOriginal);
            System.out.println("-------------------------------------------------");
            
            // Definimos dos criterios de ordenamiento sin lambdas:
            Comparator<Documento> criterio1 = new Comparator<Documento>() {
                public int compare(Documento d1, Documento d2) {
                    int cmp = d1.getNombreCompleto().compareTo(d2.getNombreCompleto());
                    if(cmp == 0) {
                        cmp = d1.getTipoDocumento().compareTo(d2.getTipoDocumento());
                    }
                    return cmp;
                }
            };
            
            Comparator<Documento> criterio2 = new Comparator<Documento>() {
                public int compare(Documento d1, Documento d2) {
                    int cmp = d1.getTipoDocumento().compareTo(d2.getTipoDocumento());
                    if(cmp == 0) {
                        cmp = d1.getNombreCompleto().compareTo(d2.getNombreCompleto());
                    }
                    return cmp;
                }
            };
            
            // Ahora ordenamos por Burbuja, QuickSort, Inserción, Selección y Mezcla, igual que antes.
            // Ordenamos por Burbuja:
            List<Documento> listaBurbuja = new ArrayList<Documento>(listaOriginal);
            long inicio = System.nanoTime();
            Ordenamiento.ordenarBurbuja(listaBurbuja, criterio1);
            long tiempoBurbuja = System.nanoTime() - inicio;
            System.out.println("Ordenado por Burbuja:");
            Utilidades.mostrarLista(listaBurbuja);
            System.out.println("Tiempo de ejecución (Burbuja): " + tiempoBurbuja + " ns");
            System.out.println("-------------------------------------------------");
            
            // Ordenamos por QuickSort:
            List<Documento> listaQuick = new ArrayList<Documento>(listaOriginal);
            inicio = System.nanoTime();
            Ordenamiento.ordenarQuicksort(listaQuick, 0, listaQuick.size() - 1, criterio2);
            long tiempoQuick = System.nanoTime() - inicio;
            System.out.println("Ordenado por QuickSort:");
            Utilidades.mostrarLista(listaQuick);
            System.out.println("Tiempo de ejecución (QuickSort): " + tiempoQuick + " ns");
            System.out.println("-------------------------------------------------");
            
            // Ordenamos por Inserción:
            List<Documento> listaInsercion = new ArrayList<Documento>(listaOriginal);
            inicio = System.nanoTime();
            Ordenamiento.ordenarInsercion(listaInsercion, criterio1);
            long tiempoInsercion = System.nanoTime() - inicio;
            System.out.println("Ordenado por Inserción:");
            Utilidades.mostrarLista(listaInsercion);
            System.out.println("Tiempo de ejecución (Inserción): " + tiempoInsercion + " ns");
            System.out.println("-------------------------------------------------");
            
            // Ordenamos por Selección:
            List<Documento> listaSeleccion = new ArrayList<Documento>(listaOriginal);
            inicio = System.nanoTime();
            Ordenamiento.ordenarSeleccion(listaSeleccion, criterio2);
            long tiempoSeleccion = System.nanoTime() - inicio;
            System.out.println("Ordenado por Selección:");
            Utilidades.mostrarLista(listaSeleccion);
            System.out.println("Tiempo de ejecución (Selección): " + tiempoSeleccion + " ns");
            System.out.println("-------------------------------------------------");
            
            // Ordenamos por Mezcla:
            List<Documento> listaMezcla = new ArrayList<Documento>(listaOriginal);
            inicio = System.nanoTime();
            Ordenamiento.ordenarMezcla(listaMezcla, criterio1);
            long tiempoMezcla = System.nanoTime() - inicio;
            System.out.println("Ordenado por Mezcla:");
            Utilidades.mostrarLista(listaMezcla);
            System.out.println("Tiempo de ejecución (Mezcla): " + tiempoMezcla + " ns");
            System.out.println("-------------------------------------------------");
            
        } catch (IOException ex) {
            System.out.println("Error, parce: " + ex.getMessage());
        }
    }
}