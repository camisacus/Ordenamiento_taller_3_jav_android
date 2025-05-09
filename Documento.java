/**
 * Documento.java
 * 
 * Parce, esta clase representa el registro de un cliente,
 * que viene desde el CSV, con sus apellidos, nombre y tipo de documento.
 * 
 * Nota: Usa toString() para una salida bonita en consola.
 */
public class Documento {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String tipoDocumento;

    // Constructor principal: recibe apellido1, apellido2, nombre y tipo de documento.
    public Documento(String apellido1, String apellido2, String nombre, String tipoDocumento) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tipoDocumento = tipoDocumento;
    }

    // Método para obtener el nombre completo – parrando la vaina.
    public String getNombreCompleto() {
        return apellido1 + " " + apellido2 + " " + nombre;
    }

    // Devuelve el tipo de documento.
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    // Conversión a cadena para poder imprimir la info.
    @Override
    public String toString() {
        return getNombreCompleto() + " - " + tipoDocumento;
    }
}