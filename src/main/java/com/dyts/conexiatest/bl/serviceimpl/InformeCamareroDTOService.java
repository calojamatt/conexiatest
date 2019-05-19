/**
 * Development and Technologies Solutions S.A.S
 * conexiatest
 * InformeCamareroDTOService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.dyts.conexiatest.bl.serviceimpl;

import com.dyts.conexiatest.bl.iservice.IInformeCamareroDTOService;
import com.dyts.conexiatest.persistence.dao.GenericDao;
import com.dyts.conexiatest.persistence.dto.InformeCamareroDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 18/05/2019 2:05 PM
 */
@Service
public class InformeCamareroDTOService implements IInformeCamareroDTOService {

    GenericDao<InformeCamareroDTO> genericDao;
    private EntityManager entityManager;

    public GenericDao<InformeCamareroDTO> getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao<InformeCamareroDTO> genericDao) {
        this.genericDao = genericDao;
        entityManager = genericDao.getSessionFactory().createEntityManager();
    }

    @Override
    public List<InformeCamareroDTO> findAll() {
        List<InformeCamareroDTO> informeCamareroDTOList;
        String query = "SELECT c.nombre, c.Apellido1, DATE_FORMAT(f.FechaFactura,'%m') as mes, SUM(d.importe) as totalFacturado "+
            "FROM camarero c "+
            "LEFT JOIN factura f ON (f.idCamarero = c.idCamarero) "+
            "LEFT JOIN detallefactura d ON (f.idFactura = d.idFactura) "+
            "GROUP BY c.Nombre, c.Apellido1, DATE_FORMAT(f.FechaFactura,'%m') ";
        List result = entityManager.createNativeQuery(query).getResultList();
        informeCamareroDTOList = new ArrayList<>();
        result.forEach(obj -> {
            if (obj != null) {
                Object[] o = (Object[]) obj;
                InformeCamareroDTO icdto = new InformeCamareroDTO();
                icdto.setNombre( (o[0] != null ? o[0].toString():"") );
                icdto.setApellido( (o[1] != null ? o[1].toString():"") );
                icdto.setMes( (o[2] != null ? o[2].toString():"") );
                icdto.setTotalFacturado( (o[3] != null ? Float.valueOf(o[3].toString()):0.0F) );
                informeCamareroDTOList.add(icdto);
            }
        });
        return informeCamareroDTOList;
    }
}
