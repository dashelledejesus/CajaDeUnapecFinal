/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajaUnapec;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByNombreEmpleado", query = "SELECT e FROM Empleado e WHERE e.nombreEmpleado = :nombreEmpleado")
    , @NamedQuery(name = "Empleado.findByCedulaEmpleado", query = "SELECT e FROM Empleado e WHERE e.cedulaEmpleado = :cedulaEmpleado")
    , @NamedQuery(name = "Empleado.findByTandaEmpleado", query = "SELECT e FROM Empleado e WHERE e.tandaEmpleado = :tandaEmpleado")
    , @NamedQuery(name = "Empleado.findByFechaIngresoEmpleado", query = "SELECT e FROM Empleado e WHERE e.fechaIngresoEmpleado = :fechaIngresoEmpleado")
    , @NamedQuery(name = "Empleado.findByEstadoEmpleado", query = "SELECT e FROM Empleado e WHERE e.estadoEmpleado = :estadoEmpleado")
    , @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 40)
    @Column(name = "NOMBRE_EMPLEADO")
    private String nombreEmpleado;
    @Column(name = "CEDULA_EMPLEADO")
    private Integer cedulaEmpleado;
    @Size(max = 10)
    @Column(name = "TANDA_EMPLEADO")
    private String tandaEmpleado;
    @Column(name = "FECHA_INGRESO_EMPLEADO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoEmpleado;
    @Size(max = 20)
    @Column(name = "ESTADO_EMPLEADO")
    private String estadoEmpleado;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO")
    private Integer idEmpleado;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<FacturaFinal> facturaFinalCollection;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Integer getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(Integer cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getTandaEmpleado() {
        return tandaEmpleado;
    }

    public void setTandaEmpleado(String tandaEmpleado) {
        this.tandaEmpleado = tandaEmpleado;
    }

    public Date getFechaIngresoEmpleado() {
        return fechaIngresoEmpleado;
    }

    public void setFechaIngresoEmpleado(Date fechaIngresoEmpleado) {
        this.fechaIngresoEmpleado = fechaIngresoEmpleado;
    }

    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cajaUnapec.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
