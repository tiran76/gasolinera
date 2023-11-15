package org.example;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity

public class LlenadoDeposito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double cantidadLitros;
    private String tipoCombustible;
    private double importeTotal;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Temporal(TemporalType.TIME)
    private Date hora;

    public LlenadoDeposito(){

    }
    public LlenadoDeposito( double cantidadLitros, String tipoCombustible, double importeTotal) {
        this.cantidadLitros = cantidadLitros;
        this.tipoCombustible = tipoCombustible;
        this.importeTotal = importeTotal;
        this.fecha = new Date(); // Asigna la fecha actual
        this.hora = new Date();   // Asigna la hora actual
    }


    public double getCantidadLitros() {
        return cantidadLitros;
    }

    public void setCantidadLitros(double cantidadLitros) {
        this.cantidadLitros = cantidadLitros;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    @Override
    public String toString() {
        return "LlenadoDeposito{" +
                "id=" + id +
                ", cantidadLitros=" + cantidadLitros +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", importeTotal=" + importeTotal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LlenadoDeposito that = (LlenadoDeposito) o;
        return Objects.equals(id, that.id) && Objects.equals(cantidadLitros, that.cantidadLitros) && Objects.equals(tipoCombustible, that.tipoCombustible) && Objects.equals(importeTotal, that.importeTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidadLitros, tipoCombustible, importeTotal);
    }
}
