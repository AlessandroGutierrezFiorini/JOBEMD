package com.pojo;

import java.io.Serializable;

/**
 * Created by Alessandro on 08/02/17.
 */
public class PatenteImagen implements Serializable {

    String numero;

    public PatenteImagen() {
    }

    public PatenteImagen(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "PatenteImagen{" +
                "numero='" + numero + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatenteImagen patenteImagen = (PatenteImagen) o;

        return numero != null ? numero.equals(patenteImagen.numero) : patenteImagen.numero == null;

    }

    @Override
    public int hashCode() {
        return numero != null ? numero.hashCode() : 0;
    }
}
