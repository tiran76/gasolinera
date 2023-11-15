package org.example;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity

public class RepostajeNormal extends Repostaje {
    public RepostajeNormal() {
        super(0.0);
    }

    public RepostajeNormal( double importe) {
        super(importe);
    }



}
