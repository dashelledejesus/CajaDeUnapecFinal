/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajaUnapec;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author user
 */
@Entity
@Table(name = "TIPO_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")
    , @NamedQuery(name = "TipoDocumento.findByDescripcionDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.descripcionDocumento = :descripcionDocumento")
    , @NamedQuery(name = "TipoDocumento.findByEstadoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.estadoDocumento = :estadoDocumento")
    , @NamedQuery(name = "TipoDocumento.findByIdDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.idDocumento = :idDocumento")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 60)
    @Column(name = "DESCRIPCION_DOCUMENTO")
    private String descripcionDocumento;
    @Size(max = 20)
    @Column(name = "ESTADO_DOCUMENTO")
    private String estadoDocumento;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCUMENTO")
    private Integer idDocumento;
    @OneToMany(mappedBy = "idDocumento")
    private Collection<FacturaFinal> facturaFinalCollection;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDescripcionDocumento() {
        return descripcionDocumento;
    }

    public void setDescripcionDocumento(String descripcionDocumento) {
        this.descripcionDocumento = descripcionDocumento;
    }

    public String getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(String estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    @XmlTransient
    public Collection<FacturaFinal> getFacturaFinalCollection() {
        return facturaFinalCollection;
    }

    public void setFacturaFinalCollection(Collection<FacturaFinal> facturaFinalCollection) {
        this.facturaFinalCollection = facturaFinalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cajaUnapec.TipoDocumento[ idDocumento=" + idDocumento + " ]";
    }
    
}
