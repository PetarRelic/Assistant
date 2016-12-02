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
@Table(name = "Imenik")
public class Imenik implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idImenik")
    private Integer idImenik;
    
    @NotNull
    @Column(name = "imePrezime")
    private String imePrezime;
    
    @NotNull
    @Column(name = "brojTelefona")
    private Integer brojTelefona;
    
    @JoinColumn(name = "fkKorisnik", referencedColumnName = "idKorisnik")
    @ManyToOne(fetch = FetchType.EAGER)
    private Integer fkKorisnik;

    public Imenik() {
    }

    public Imenik(Integer idImenik, String imePrezime, Integer brojTelefona, Integer fkKorisnik) {
        this.idImenik = idImenik;
        this.imePrezime = imePrezime;
        this.brojTelefona = brojTelefona;
        this.fkKorisnik = fkKorisnik;
    }

    public Imenik(String imePrezime, Integer brojTelefona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Imenik(Integer idImenik, String imePrezime, Integer brojTelefona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Imenik(Integer idImenik) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public Integer getIdImenik() {
        return idImenik;
    }

    public void setIdImenik(Integer idImenik) {
        this.idImenik = idImenik;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Integer getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(Integer brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public Integer getFkKorisnik() {
        return fkKorisnik;
    }

    public void setFkKorisnik(Integer fkKorisnik) {
        this.fkKorisnik = fkKorisnik;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idImenik);
        hash = 89 * hash + Objects.hashCode(this.imePrezime);
        hash = 89 * hash + Objects.hashCode(this.brojTelefona);
        hash = 89 * hash + Objects.hashCode(this.fkKorisnik);
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
        final Imenik other = (Imenik) obj;
        if (!Objects.equals(this.imePrezime, other.imePrezime)) {
            return false;
        }
        if (!Objects.equals(this.idImenik, other.idImenik)) {
            return false;
        }
        if (!Objects.equals(this.brojTelefona, other.brojTelefona)) {
            return false;
        }
        if (!Objects.equals(this.fkKorisnik, other.fkKorisnik)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imenik{" + "idImenik=" + idImenik + ", imePrezime=" + imePrezime + ", brojTelefona=" + brojTelefona + ", fkKorisnik=" + fkKorisnik + '}';
    }

    
    
    
}
