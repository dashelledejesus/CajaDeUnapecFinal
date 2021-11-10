/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import cajaUnapec.FormaDePago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import cajaUnapec.FormaDePago_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cajaUnapec.FacturaFinal;
import java.util.Collection;

/**
 *
 * @author user
 */
@Stateless
public class FormaDePagoFacade extends AbstractFacade<FormaDePago> {

    @PersistenceContext(unitName = "CajaDeUnapePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormaDePagoFacade() {
        super(FormaDePago.class);
    }

    public boolean isFacturaFinalCollectionEmpty(FormaDePago entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<FormaDePago> formaDePago = cq.from(FormaDePago.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(formaDePago, entity), cb.isNotEmpty(formaDePago.get(FormaDePago_.facturaFinalCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<FacturaFinal> findFacturaFinalCollection(FormaDePago entity) {
        FormaDePago mergedEntity = this.getMergedEntity(entity);
        Collection<FacturaFinal> facturaFinalCollection = mergedEntity.getFacturaFinalCollection();
        facturaFinalCollection.size();
        return facturaFinalCollection;
    }
    
}
