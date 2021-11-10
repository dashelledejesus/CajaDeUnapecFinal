/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import cajaUnapec.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import cajaUnapec.Cliente_;
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
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "CajaDeUnapePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public boolean isFacturaFinalCollectionEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.facturaFinalCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<FacturaFinal> findFacturaFinalCollection(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        Collection<FacturaFinal> facturaFinalCollection = mergedEntity.getFacturaFinalCollection();
        facturaFinalCollection.size();
        return facturaFinalCollection;
    }
    
}
