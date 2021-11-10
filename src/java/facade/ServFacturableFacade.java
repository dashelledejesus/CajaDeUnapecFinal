/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import cajaUnapec.ServFacturable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import cajaUnapec.ServFacturable_;
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
public class ServFacturableFacade extends AbstractFacade<ServFacturable> {

    @PersistenceContext(unitName = "CajaDeUnapePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServFacturableFacade() {
        super(ServFacturable.class);
    }

    public boolean isFacturaFinalCollectionEmpty(ServFacturable entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<ServFacturable> servFacturable = cq.from(ServFacturable.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(servFacturable, entity), cb.isNotEmpty(servFacturable.get(ServFacturable_.facturaFinalCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<FacturaFinal> findFacturaFinalCollection(ServFacturable entity) {
        ServFacturable mergedEntity = this.getMergedEntity(entity);
        Collection<FacturaFinal> facturaFinalCollection = mergedEntity.getFacturaFinalCollection();
        facturaFinalCollection.size();
        return facturaFinalCollection;
    }
    
}
