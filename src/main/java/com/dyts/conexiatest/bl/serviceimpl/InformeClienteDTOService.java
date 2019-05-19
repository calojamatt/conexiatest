/**
 * Development and Technologies Solutions S.A.S
 * conexiatest
 * InformeClienteDTOService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.dyts.conexiatest.bl.serviceimpl;

import com.dyts.conexiatest.bl.iservice.IInformeClienteDTOService;
import com.dyts.conexiatest.persistence.dao.GenericDao;
import com.dyts.conexiatest.persistence.dto.InformeCamareroDTO;
import com.dyts.conexiatest.persistence.dto.InformeClienteDTO;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 18/05/2019 4:30 PM
 */
public class InformeClienteDTOService implements IInformeClienteDTOService<InformeClienteDTO> {

    GenericDao<InformeClienteDTO> genericDao;
    private EntityManager entityManager;

    public GenericDao<InformeClienteDTO> getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao<InformeClienteDTO> genericDao) {
        this.genericDao = genericDao;
        entityManager = genericDao.getSessionFactory().createEntityManager();
    }

    @Override
    public List<InformeClienteDTO> getInformeTotalFacturacion(Float valor) {
        List<InformeClienteDTO> informeClienteDTOList;
        String queryStatement = "SELECT Nombre, Apellido1, Apellido2, totalFactuado "+
                "FROM ( SELECT c.Nombre, c.Apellido1, c.Apellido2, SUM(d.importe) AS totalFactuado "+
                " FROM cliente c LEFT JOIN factura f ON (f.idCliente = c.idCliente) "+
                " LEFT JOIN detallefactura d ON (f.idFactura = d.idFactura) "+
                " GROUP BY c.nombre, c.Apellido1, c.Apellido2 "+
                ") ClienteFacturacion "+
                "WHERE totalFactuado >= :totalFacurado";
        Query query = entityManager.createNativeQuery(queryStatement);
        query.setParameter("totalFacurado", valor);
        List result = query.getResultList();
        informeClienteDTOList = new ArrayList<>();
        result.forEach(obj -> {
            if (obj != null) {
                Object[] o = (Object[]) obj;
                InformeClienteDTO icdto = new InformeClienteDTO();
                icdto.setNombre( (o[0] != null ? o[0].toString():"") );
                icdto.setApellido1( (o[1] != null ? o[1].toString():"") );
                icdto.setApellido2( (o[2] != null ? o[2].toString():"") );
                icdto.setTotalFacturado( (o[3] != null ? Float.valueOf(o[3].toString()):0.0F) );
                informeClienteDTOList.add(icdto);
            }
        });
        return informeClienteDTOList;
    }
}
