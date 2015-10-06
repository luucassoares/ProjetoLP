/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "Grupos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupos.findAll", query = "SELECT g FROM Grupos g"),
    @NamedQuery(name = "Grupos.findByGrupoId", query = "SELECT g FROM Grupos g WHERE g.grupoId = :grupoId"),
    @NamedQuery(name = "Grupos.findByGrupoNome", query = "SELECT g FROM Grupos g WHERE g.grupoNome = :grupoNome")})
public class Grupos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grupo_id")
    private Integer grupoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "grupo_nome")
    private String grupoNome;
    @JoinTable(name = "grupo_servidor", joinColumns = {
        @JoinColumn(name = "grupo_id", referencedColumnName = "grupo_id")}, inverseJoinColumns = {
        @JoinColumn(name = "servidor_id", referencedColumnName = "servidor_id")})
    @ManyToMany
    private List<Servidor> servidorList;
    @ManyToMany(mappedBy = "gruposList")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "grupo_admin", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario grupoAdmin;

    public Grupos() {
    }

    public Grupos(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public Grupos(Integer grupoId, String grupoNome) {
        this.grupoId = grupoId;
        this.grupoNome = grupoNome;
    }

    public Integer getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public String getGrupoNome() {
        return grupoNome;
    }

    public void setGrupoNome(String grupoNome) {
        this.grupoNome = grupoNome;
    }

    @XmlTransient
    public List<Servidor> getServidorList() {
        return servidorList;
    }

    public void setServidorList(List<Servidor> servidorList) {
        this.servidorList = servidorList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Usuario getGrupoAdmin() {
        return grupoAdmin;
    }

    public void setGrupoAdmin(Usuario grupoAdmin) {
        this.grupoAdmin = grupoAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoId != null ? grupoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupos)) {
            return false;
        }
        Grupos other = (Grupos) object;
        if ((this.grupoId == null && other.grupoId != null) || (this.grupoId != null && !this.grupoId.equals(other.grupoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.melhor.entities.Grupos[ grupoId=" + grupoId + " ]";
    }
    
}
