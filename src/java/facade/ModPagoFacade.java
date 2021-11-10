/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import cajaUnapec.ModPago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import cajaUnapec.ModPago_;
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
public class ModPagoFacade extends AbstractFacade<ModPago> {

    @PersistenceContext(unitName = "CajaDeUnapePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModPagoFacade() {
        super(ModPago.class);
    }

    public boolean isFacturaFinalCollectionEmpty(ModPago entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ModPago> modPago = cq.from(ModPago.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(modPago, entity), cb.isNotEmpty(modPago.get(ModPago_.facturaFinalCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<FacturaFinal> findFacturaFinalCollection(ModPago entity) {
        ModPago mergedEntity = this.getMergedEntity(entity);
        Collection<FacturaFinal> facturaFinalCollection = mergedEntity.getFacturaFinalCollection();
        facturaFinalCollection.size();
        return facturaFinalCollection;
    }
    
}
