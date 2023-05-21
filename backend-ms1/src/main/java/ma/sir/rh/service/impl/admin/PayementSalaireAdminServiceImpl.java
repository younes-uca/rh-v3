package ma.sir.rh.service.impl.admin;

import ma.sir.rh.bean.core.PayementSalaire;
import ma.sir.rh.bean.history.PayementSalaireHistory;
import ma.sir.rh.dao.criteria.core.PayementSalaireCriteria;
import ma.sir.rh.dao.criteria.history.PayementSalaireHistoryCriteria;
import ma.sir.rh.dao.facade.core.PayementSalaireDao;
import ma.sir.rh.dao.facade.history.PayementSalaireHistoryDao;
import ma.sir.rh.dao.specification.core.PayementSalaireSpecification;
import ma.sir.rh.service.facade.admin.PayementSalaireAdminService;
import ma.sir.rh.zynerator.service.AbstractServiceImpl;
import ma.sir.rh.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.rh.service.facade.admin.EmployeeAdminService ;


import java.util.List;
@Service
public class PayementSalaireAdminServiceImpl extends AbstractServiceImpl<PayementSalaire,PayementSalaireHistory, PayementSalaireCriteria, PayementSalaireHistoryCriteria, PayementSalaireDao,
PayementSalaireHistoryDao> implements PayementSalaireAdminService {


    public PayementSalaire findByReferenceEntity(PayementSalaire t){
        return  dao.findByCode(t.getCode());
    }

    public List<PayementSalaire> findByEmployeeId(Long id){
        return dao.findByEmployeeId(id);
    }
    public int deleteByEmployeeId(Long id){
        return dao.deleteByEmployeeId(id);
    }



    public void configure() {
        super.configure(PayementSalaire.class,PayementSalaireHistory.class, PayementSalaireHistoryCriteria.class, PayementSalaireSpecification.class);
    }

    @Autowired
    private EmployeeAdminService employeeService ;

    public PayementSalaireAdminServiceImpl(PayementSalaireDao dao, PayementSalaireHistoryDao historyDao) {
        super(dao, historyDao);
    }

}