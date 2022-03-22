package ejercicio1;

import java.util.Objects;

public class Mail {
    String nombre;
    Character prefijo;
    String dominio;
    Boolean estado;

    public Mail(){}

    public Mail(String nombre, Character prefijo, String dominio, Boolean estado) {
        this.nombre = nombre;
        this.prefijo = prefijo;
        this.dominio = dominio;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Correo: " + nombre + prefijo + dominio + " [Enviado: " + estado + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail = (Mail) o;
        return Objects.equals(nombre, mail.nombre) && Objects.equals(prefijo, mail.prefijo) && Objects.equals(dominio, mail.dominio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, prefijo, dominio);
    }
}
