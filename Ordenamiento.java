import java.util.*;

/**
 * Ordenamiento.java
 * 
 * Acá tenemos todos los métodos de ordenamiento, paisa, para que ordenes
 * la lista de Documentos de varias formas:
 * - Burbuja (iterativo)
 * - QuickSort (recursivo)
 * - Inserción
 * - Selección
 * - Mezcla (MergeSort)
 */
public class Ordenamiento {

    // Método de Burbuja, clásico pues.
    public static void ordenarBurbuja(List<Documento> lista, Comparator<Documento> comp) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comp.compare(lista.get(j), lista.get(j + 1)) > 0) {
                    Collections.swap(lista, j, j + 1);
                }
            }
        }
    }

    // Método de QuickSort (recursivo). Esto es berraco, parce.
    public static void ordenarQuicksort(List<Documento> lista, int inicio, int fin, Comparator<Documento> comp) {
        if (inicio < fin) {
            int pivotIndex = particionar(lista, inicio, fin, comp);
            ordenarQuicksort(lista, inicio, pivotIndex - 1, comp);
            ordenarQuicksort(lista, pivotIndex + 1, fin, comp);
        }
    }

    // Método auxiliar para QuickSort.
    private static int particionar(List<Documento> lista, int inicio, int fin, Comparator<Documento> comp) {
        Documento pivot = lista.get(fin);
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (comp.compare(lista.get(j), pivot) <= 0) {
                i++;
                Collections.swap(lista, i, j);
            }
        }
        Collections.swap(lista, i + 1, fin);
        return i + 1;
    }

    // Ordenamiento por Inserción.
    public static void ordenarInsercion(List<Documento> lista, Comparator<Documento> comp) {
        int n = lista.size();
        for (int i = 1; i < n; i++) {
            Documento key = lista.get(i);
            int j = i - 1;
            while (j >= 0 && comp.compare(lista.get(j), key) > 0) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, key);
        }
    }

    // Ordenamiento por Selección.
    public static void ordenarSeleccion(List<Documento> lista, Comparator<Documento> comp) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comp.compare(lista.get(j), lista.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(lista, i, minIndex);
        }
    }

    // Ordenamiento por Mezcla (MergeSort).
    public static void ordenarMezcla(List<Documento> lista, Comparator<Documento> comp) {
        if (lista.size() < 2) return;

        int mid = lista.size() / 2;
        List<Documento> izquierda = new ArrayList<Documento>(lista.subList(0, mid));
        List<Documento> derecha = new ArrayList<Documento>(lista.subList(mid, lista.size()));

        ordenarMezcla(izquierda, comp);
        ordenarMezcla(derecha, comp);
        fusionar(lista, izquierda, derecha, comp);
    }

    // Método auxiliar para fusionar las sublistas.
    private static void fusionar(List<Documento> lista, List<Documento> izquierda, List<Documento> derecha, Comparator<Documento> comp) {
        int i = 0, j = 0, k = 0;
        while (i < izquierda.size() && j < derecha.size()) {
            if (comp.compare(izquierda.get(i), derecha.get(j)) <= 0) {
                lista.set(k++, izquierda.get(i++));
            } else {
                lista.set(k++, derecha.get(j++));
            }
        }
        while (i < izquierda.size()) {
            lista.set(k++, izquierda.get(i++));
        }
        while (j < derecha.size()) {
            lista.set(k++, derecha.get(j++));
        }
    }
}