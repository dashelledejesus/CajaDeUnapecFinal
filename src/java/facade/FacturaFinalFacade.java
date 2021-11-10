/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import cajaUnapec.FacturaFinal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import cajaUnapec.FacturaFinal_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cajaUnapec.Cliente;
import cajaUnapec.Empleado;
import cajaUnapec.FormaDePago;
import cajaUnapec.ModPago;
import cajaUnapec.ServFacturable;
import cajaUnapec.TipoDocumento;

/**
 *
 * @author user
 */
@Stateless
public class FacturaFinalFacade extends AbstractFacade<FacturaFinal> {

    @PersistenceContext(unitName = "CajaDeUnapePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFinalFacade() {
        super(FacturaFinal.class);
    }

    public boolean isIdClienteEmpty(FacturaFinal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<FacturaFinal> facturaFinal = cq.from(FacturaFinal.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(facturaFinal, entity), cb.isNotNull(facturaFinal.get(FacturaFinal_.idCliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findIdCliente(FacturaFinal entity) {
        return this.getMergedEntity(entity).getIdCliente();
    }

    public boolean isIdEmpleadoEmpty(FacturaFinal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<FacturaFinal> facturaFinal = cq.from(FacturaFinal.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(facturaFinal, entity), cb.isNotNull(facturaFinal.get(FacturaFinal_.idEmpleado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Empleado findIdEmpleado(FacturaFinal entity) {
        return this.getMergedEntity(entity).getIdEmpleado();
    }

    public boolean isIdFormaDePagoEmpty(FacturaFinal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<FacturaFinal> facturaFinal = cq.from(FacturaFinal.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(facturaFinal, entity), cb.isNotNull(facturaFinal.get(FacturaFinal_.idFormaDePago)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public FormaDePago findIdFormaDePago(FacturaFinal entity) {
        return this.getMergedEntity(entity).getIdFormaDePago();
    }

    public boolean isIdModPagoEmpty(FacturaFinal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<FacturaFinal> facturaFinal = cq.from(FacturaFinal.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(facturaFinal, entity), cb.isNotNull(facturaFinal.get(FacturaFinal_.idModPago)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public ModPago findIdModPago(FacturaFinal entity) {
        return this.getMergedEntity(entity).getIdModPago();
    }

    public boolean isIdServFacturableEmpty(FacturaFinal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<FacturaFinal> facturaFinal = cq.from(FacturaFinal.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(facturaFinal, entity), cb.isNotNull(facturaFinal.get(FacturaFinal_.idServFacturable)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public ServFacturable findIdServFacturable(FacturaFinal entity) {
        return this.getMergedEntity(entity).getIdServFacturable();
    }

    public boolean isIdDocumentoEmpty(FacturaFinal entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<FacturaFinal> facturaFinal = cq.from(FacturaFinal.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(facturaFinal, entity), cb.isNotNull(facturaFinal.get(FacturaFinal_.idDocumento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoDocumento findIdDocumento(FacturaFinal entity) {
        return this.getMergedEntity(entity).getIdDocumento();
    }
    
}
