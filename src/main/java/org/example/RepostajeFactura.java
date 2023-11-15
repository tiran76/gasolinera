package org.example;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity

public class RepostajeFactura extends Repostaje {
    private String dniCliente;
    private String matriculaVehiculo;

    public RepostajeFactura() {
        super(0.0);
    }
    public RepostajeFactura( double importe, String dniCliente, String matriculaVehiculo) {
        super(importe);
        this.dniCliente = dniCliente;
        this.matriculaVehiculo = matriculaVehiculo;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    public void setMatriculaVehiculo(String matriculaVehiculo) {
        this.matriculaVehiculo = matriculaVehiculo;
    }

    @Override
    public String toString() {
        return "RepostajeFactura{" +
                "dniCliente='" + dniCliente + '\'' +
                ", matriculaVehiculo='" + matriculaVehiculo + '\'' +
                '}';
    }
}
