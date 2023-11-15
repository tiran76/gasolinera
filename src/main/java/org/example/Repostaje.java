package org.example;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Repostaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Temporal(TemporalType.TIME)
    private Date hora;

    private double importe;

    public Repostaje() {

    }
    public Repostaje(double importe) {
        this.fecha = new Date();
        this.hora = new Date();
        this.importe = importe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Repostaje{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", importe=" + importe +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repostaje repostaje = (Repostaje) o;
        return Objects.equals(id, repostaje.id) && Objects.equals(fecha, repostaje.fecha) && Objects.equals(hora, repostaje.hora) && Objects.equals(importe, repostaje.importe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, hora, importe);
    }
}
