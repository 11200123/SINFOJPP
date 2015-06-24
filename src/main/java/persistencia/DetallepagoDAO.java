/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import entidades.Alumno;
import entidades.Detallepago;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 7
 */
public class DetallepagoDAO extends GenericDAO<Detallepago>{
    public List<Detallepago> obtenerDetallesPagoPorMatricula(int matriculaId) {
        System.out.println("llegue aca al menos");
        List<Detallepago> returnList = null;
        try {
            returnList = getHibernateTemplate().createCriteria(Detallepago.class, "detallepago")
                    .createAlias("detallepago.matricula", "matricula")
                    .add(Restrictions.eq("matricula.codMatricula", matriculaId)).list();
            //session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnList;
    }
}
