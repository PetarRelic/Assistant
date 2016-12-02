package com.petar.asistent.data;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Korisnik")
public class Korisnik implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idKorisnik")
    private Integer idKorisnik;
    
    @NotNull
    @Column(name = "korisnickoIme")
    private String korisnicko_ime;
    
    @NotNull
    @Column(name = "lozinka")
    private String lozinka;
    
    
    private Integer fkKorisnik;

    public Korisnik() {
    }

    public Korisnik(Integer idKorisnik, String korisnicko_ime, String lozinka) {
        this.idKorisnik = idKorisnik;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
    }

    public Integer getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(Integer idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idKorisnik);
        hash = 37 * hash + Objects.hashCode(this.korisnicko_ime);
        hash = 37 * hash + Objects.hashCode(this.lozinka);
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.korisnicko_ime, other.korisnicko_ime)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        if (!Objects.equals(this.idKorisnik, other.idKorisnik)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "idKorisnik=" + idKorisnik + ", korisnicko_ime=" + korisnicko_ime + ", lozinka=" + lozinka + '}';
    }
    
    
    
}
