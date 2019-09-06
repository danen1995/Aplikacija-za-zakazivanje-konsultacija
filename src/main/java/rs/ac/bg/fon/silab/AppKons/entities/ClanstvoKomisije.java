/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dane
 */
@Entity
@DiscriminatorValue("1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClanstvoKomisije.findByNivo", query = "SELECT d FROM ClanstvoKomisije d WHERE d.nivo = :nivo"),
    @NamedQuery(name = "ClanstvoKomisije.findByUloga", query = "SELECT d FROM ClanstvoKomisije d WHERE d.uloga = :uloga"),
    @NamedQuery(name = "ClanstvoKomisije.findByKandidat", query = "SELECT d FROM ClanstvoKomisije d WHERE d.kandidat = :kandidat"),
    @NamedQuery(name = "ClanstvoKomisije.findByTema", query = "SELECT d FROM ClanstvoKomisije d WHERE d.tema = :tema")})
public class ClanstvoKomisije extends Dogadjaj implements Serializable {

    @Column(name = "NIVO")
    private String nivo;
    @Column(name = "ULOGA")
    private String uloga;
    @Column(name = "KANDIDAT")
    private String kandidat;
    @Column(name = "TEMA")
    private String tema;

    public String getNivo() {
        return nivo;
    }

    public void setNivo(String nivo) {
        this.nivo = nivo;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public String getKandidat() {
        return kandidat;
    }

    public void setKandidat(String kandidat) {
        this.kandidat = kandidat;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
