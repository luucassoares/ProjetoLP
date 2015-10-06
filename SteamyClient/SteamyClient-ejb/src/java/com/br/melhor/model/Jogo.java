/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author felipemramos
 */
@Entity
@Table(name = "jogo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jogo.findAll", query = "SELECT j FROM Jogo j"),
    @NamedQuery(name = "Jogo.findByJogoId", query = "SELECT j FROM Jogo j WHERE j.jogoId = :jogoId"),
    @NamedQuery(name = "Jogo.findByJogoNome", query = "SELECT j FROM Jogo j WHERE j.jogoNome = :jogoNome"),
    @NamedQuery(name = "Jogo.findByJogoAppid", query = "SELECT j FROM Jogo j WHERE j.jogoAppid = :jogoAppid")})
public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jogo_id")
    private Integer jogoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "jogo_nome")
    private String jogoNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jogo_appid")
    private int jogoAppid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servidorJogo")
    private List<Servidor> servidorList;

    public Jogo() {
    }

    public Jogo(Integer jogoId) {
        this.jogoId = jogoId;
    }

    public Jogo(Integer jogoId, String jogoNome, int jogoAppid) {
        this.jogoId = jogoId;
        this.jogoNome = jogoNome;
        this.jogoAppid = jogoAppid;
    }

    public Integer getJogoId() {
        return jogoId;
    }

    public void setJogoId(Integer jogoId) {
        this.jogoId = jogoId;
    }

    public String getJogoNome() {
        return jogoNome;
    }

    public void setJogoNome(String jogoNome) {
        this.jogoNome = jogoNome;
    }

    public int getJogoAppid() {
        return jogoAppid;
    }

    public void setJogoAppid(int jogoAppid) {
        this.jogoAppid = jogoAppid;
    }

    @XmlTransient
    public List<Servidor> getServidorList() {
        return servidorList;
    }

    public void setServidorList(List<Servidor> servidorList) {
        this.servidorList = servidorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jogoId != null ? jogoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogo)) {
            return false;
        }
        Jogo other = (Jogo) object;
        if ((this.jogoId == null && other.jogoId != null) || (this.jogoId != null && !this.jogoId.equals(other.jogoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.melhor.entities.Jogo[ jogoId=" + jogoId + " ]";
    }
    
}
