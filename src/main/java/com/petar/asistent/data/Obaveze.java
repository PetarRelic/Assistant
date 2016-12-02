package com.petar.asistent.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Obaveze")
public class Obaveze implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idObaveze")
    private Integer idObaveze;
    
    @NotNull
    @Column(name = "nazivObaveze")
    private String nazivObaveze;
    
    @NotNull
    @Column(name = "datumObaveze")
    private String datumObaveze;
    
    @NotNull
    @Column(name = "vremeObaveze")
    private String vremeObaveze;
    
    @JoinColumn(name = "fkKorisnik", referencedColumnName = "idKorisnik")
    @ManyToOne(fetch = FetchType.EAGER)
    private Integer fkKorisnik;

    public Obaveze() {
    }

    public Obaveze(Integer idObaveze, String nazivObaveze, String datumObaveze, String vremeObaveze, Integer fkKorisnik) {
        this.idObaveze = idObaveze;
        this.nazivObaveze = nazivObaveze;
        this.datumObaveze = datumObaveze;
        this.vremeObaveze = vremeObaveze;
        this.fkKorisnik = fkKorisnik;
    }


    public Integer getIdObaveze() {
        return idObaveze;
    }

    public void setIdObaveze(Integer idObaveze) {
        this.idObaveze = idObaveze;
    }

    public String getNazivObaveze() {
        return nazivObaveze;
    }

    public void setNazivObaveze(String nazivObaveze) {
        this.nazivObaveze = nazivObaveze;
    }

    public String getDatumObaveze() {
        return datumObaveze;
    }

    public void setDatumObaveze(String datumObaveze) {
        this.datumObaveze = datumObaveze;
    }

    public String getVremeObaveze() {
        return vremeObaveze;
    }

    public void setVremeObaveze(String vremeObaveze) {
        this.vremeObaveze = vremeObaveze;
    }

    public Integer getFkKorisnik() {
        return fkKorisnik;
    }

    public void setFkKorisnik(Integer fkKorisnik) {
        this.fkKorisnik = fkKorisnik;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idObaveze);
        hash = 23 * hash + Objects.hashCode(this.nazivObaveze);
        hash = 23 * hash + Objects.hashCode(this.datumObaveze);
        hash = 23 * hash + Objects.hashCode(this.vremeObaveze);
        hash = 23 * hash + Objects.hashCode(this.fkKorisnik);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Obaveze other = (Obaveze) obj;
        if (!Objects.equals(this.nazivObaveze, other.nazivObaveze)) {
            return false;
        }
        if (!Objects.equals(this.datumObaveze, other.datumObaveze)) {
            return false;
        }
        if (!Objects.equals(this.vremeObaveze, other.vremeObaveze)) {
            return false;
        }
        if (!Objects.equals(this.idObaveze, other.idObaveze)) {
            return false;
        }
        if (!Objects.equals(this.fkKorisnik, other.fkKorisnik)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Obaveze{" + "idObaveze=" + idObaveze + ", nazivObaveze=" + nazivObaveze + ", datumObaveze=" + datumObaveze + ", vremeObaveze=" + vremeObaveze + ", fkKorisnik=" + fkKorisnik + '}';
    }

    
}
