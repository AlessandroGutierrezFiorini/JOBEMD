package com.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Alessandro on 08/02/17.
 */
@Entity
@Table(name = "multas")
public class Multa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_multa", length = 255)
    @NotNull
    @Size(min = 4, max = 255)
    private String tipo_multa;

    @Column(name = "monto")
    @NotNull
    private Double monto;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date fecha;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @Column(name = "inspector")
    private String inspector;

    @Column(name = "lugar", length = 50)
    private String lugar;

    @Column(name = "nroTarjeta", length = 50)
    private String nroTarjeta;

    @Column(name = "observacion", length = 80)
    private String observacion;

    @Column(name = "dni" , length = 9)
    private String dni;

    @Column(name = "marca", length = 50)
    private String marca;

    @Column(name = "dominio", length = 10)
    private String dominio;

    @Column(name = "domicilio", length = 50)
    private String domicilio;

    @Column(name = "status")
    @NotNull
    private Boolean status;

    @Column(name = "infractor", length = 50)
    private String infractor;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_multa() {
        return tipo_multa;
    }

    public void setTipo_multa(String tipo_multa) {
        this.tipo_multa = tipo_multa;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getInfractor() {
        return infractor;
    }

    public void setInfractor(String infractor) {
        this.infractor = infractor;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
