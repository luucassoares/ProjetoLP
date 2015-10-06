/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "Servidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servidor.findAll", query = "SELECT s FROM Servidor s"),
    @NamedQuery(name = "Servidor.findByServidorId", query = "SELECT s FROM Servidor s WHERE s.servidorId = :servidorId"),
    @NamedQuery(name = "Servidor.findByServidorNome", query = "SELECT s FROM Servidor s WHERE s.servidorNome = :servidorNome")})
public class Servidor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "servidor_id")
    private Integer servidorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "servidor_nome")
    private String servidorNome;
    @ManyToMany(mappedBy = "servidorList")
    private List<Grupos> gruposList;
    @JoinColumn(name = "servidor_jogo", referencedColumnName = "jogo_id")
    @ManyToOne(optional = false)
    private Jogo servidorJogo;

    public Servidor() {
    }

    public Servidor(Integer servidorId) {
        this.servidorId = servidorId;
    }

    public Servidor(Integer servidorId, String servidorNome) {
        this.servidorId = servidorId;
        this.servidorNome = servidorNome;
    }

    public Integer getServidorId() {
        return servidorId;
    }

    public void setServidorId(Integer servidorId) {
        this.servidorId = servidorId;
    }

    public String getServidorNome() {
        return servidorNome;
    }

    public void setServidorNome(String servidorNome) {
        this.servidorNome = servidorNome;
    }

    @XmlTransient
    public List<Grupos> getGruposList() {
        return gruposList;
    }

    public void setGruposList(List<Grupos> gruposList) {
        this.gruposList = gruposList;
    }

    public Jogo getServidorJogo() {
        return servidorJogo;
    }

    public void setServidorJogo(Jogo servidorJogo) {
        this.servidorJogo = servidorJogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servidorId != null ? servidorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servidor)) {
            return false;
        }
        Servidor other = (Servidor) object;
        if ((this.servidorId == null && other.servidorId != null) || (this.servidorId != null && !this.servidorId.equals(other.servidorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.melhor.entities.Servidor[ servidorId=" + servidorId + " ]";
    }
    
}
