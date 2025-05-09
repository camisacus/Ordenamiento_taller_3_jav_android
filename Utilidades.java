import java.io.*;
import java.util.*;

public class Utilidades {

    // Este método usa el contenido CSV que definimos directamente en el código
    public static List<Documento> leerCSVDesdeString() throws IOException {
        List<Documento> lista = new ArrayList<Documento>();
        // Contenido del CSV directamente en el código, parce.
        String csvContent = 
            "Apellido1;Apellido2;Nombre;Documento\n" +
            "ALTAHONA;PEREZ;VIANNY;Cartas aclaratorias y/o paz y salvo\n" +
            "NIETO;PERTUZ;EFIGENIA;Cartas aclaratorias y/o paz y salvo\n" +
            "INFANTE;CELEDON;MARIA;Cartas aclaratorias y/o paz y salvo\n" +
            "REY;PEREZ;ANGELICA;Cartas aclaratorias y/o paz y salvo\n" +
            "LARIOS;AVILET;JORGE;Cartas aclaratorias y/o paz y salvo\n" +
            "SALAS;PEREZ;MANUEL;Cartas aclaratorias y/o paz y salvo\n" +
            "MEZA;BRAVO;EFRAIN;Cartas aclaratorias y/o paz y salvo\n" +
            "LLORENTE;CERVANTES;RICARDO;Cartas aclaratorias y/o paz y salvo\n" +
            "PERTUZ;JIMENEZ;YARILYN;Cartas aclaratorias y/o paz y salvo\n" +
            "ECHEVERRIA;BARRIOS;DANY;Cartas aclaratorias y/o paz y salvo\n" +
            "GONZALEZ;ECHEVERRIA;EDINSO;Cartas aclaratorias y/o paz y salvo\n" +
            "MONTOYA;PERDOMO;GERALDINE;Cartas aclaratorias y/o paz y salvo\n" +
            "ESPINOSA;VILLAMIL;HERICA;Cartas aclaratorias y/o paz y salvo\n" +
            "VALBUENA;VASQUEZ;NUBIA;Cartas aclaratorias y/o paz y salvo\n" +
            "RODRIGUEZ;RODRIGUEZ;ANGELA;Cartas aclaratorias y/o paz y salvo\n" +
            "VILLAMARIN;GRACIA;WENDY;Cartas aclaratorias y/o paz y salvo\n" +
            "CUESTA;RODRIGUEZ;LUISA;Cartas aclaratorias y/o paz y salvo\n" +
            "VARGAS;BERNAL;GINA;Cartas aclaratorias y/o paz y salvo\n" +
            "RIVERA;ORDOVEZ;JOHANA;Cartas aclaratorias y/o paz y salvo\n" +
            "LUQUE;VILLAMIZAR;JULIETH;Cartas aclaratorias y/o paz y salvo\n" +
            "ARTAHONA;SCALZO;VANESA;Cartas aclaratorias y/o paz y salvo\n" +
            "SALCEDO;BERRIO;ASTRID;Cartas aclaratorias y/o paz y salvo\n" +
            "VALBUENA;MORALES;MERY;Cartas aclaratorias y/o paz y salvo\n" +
            "MENESES;DE SALAZAR;ANA;Cartas aclaratorias y/o paz y salvo\n" +
            "MARQUEZ;MARTINEZ;FAJID;Cartas aclaratorias y/o paz y salvo\n" +
            "VILLAMIZAR;CORREA;MARCO;Cartas aclaratorias y/o paz y salvo\n" +
            "CASTRO;CARRILLO;WILMER;Cartas aclaratorias y/o paz y salvo\n" +
            "DE LA ROSA;MARIMON;ENILSA;Cartas aclaratorias y/o paz y salvo\n" +
            "ALBAN;REALES;SILVIA;Cartas aclaratorias y/o paz y salvo\n" +
            "MARTINEZ;GARCIA;EMILSE;Cartas aclaratorias y/o paz y salvo\n" +
            "CASTELLANO;LOPEZ;LEONERIS;Cartas aclaratorias y/o paz y salvo";
        
        // Usamos StringReader para simular la apertura de un archivo.
        BufferedReader br = new BufferedReader(new StringReader(csvContent));
        // Saltamos la primera línea (encabezado)
        String linea = br.readLine();
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(";");
            if (partes.length >= 4) {
                Documento doc = new Documento(
                    partes[0].trim(),
                    partes[1].trim(),
                    partes[2].trim(),
                    partes[3].trim()
                );
                lista.add(doc);
            }
        }
        br.close();
        return lista;
    }

    // Método para mostrar la lista de documentos
    public static void mostrarLista(List<Documento> lista) {
        for (Documento doc : lista) {
            System.out.println(doc);
        }
    }
}