package ma.sir.rh.service.impl.admin;

import ma.sir.rh.bean.core.Pointage;
import ma.sir.rh.bean.history.PointageHistory;
import ma.sir.rh.dao.criteria.core.PointageCriteria;
import ma.sir.rh.dao.criteria.history.PointageHistoryCriteria;
import ma.sir.rh.dao.facade.core.PointageDao;
import ma.sir.rh.dao.facade.history.PointageHistoryDao;
import ma.sir.rh.dao.specification.core.PointageSpecification;
import ma.sir.rh.service.facade.admin.PointageAdminService;
import ma.sir.rh.zynerator.service.AbstractServiceImpl;
import ma.sir.rh.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.rh.service.facade.admin.EmployeeAdminService ;


import java.util.List;
@Service
public class PointageAdminServiceImpl extends AbstractServiceImpl<Pointage,PointageHistory, PointageCriteria, PointageHistoryCriteria, PointageDao,
PointageHistoryDao> implements PointageAdminService {


    public Pointage findByReferenceEntity(Pointage t){
        return  dao.findByCode(t.getCode());
    }

    public List<Pointage> findByEmployeeId(Long id){
        return dao.findByEmployeeId(id);
    }
    public int deleteByEmployeeId(Long id){
        return dao.deleteByEmployeeId(id);
    }



    public void configure() {
        super.configure(Pointage.class,PointageHistory.class, PointageHistoryCriteria.class, PointageSpecification.class);
    }

    @Autowired
    private EmployeeAdminService employeeService ;

    public PointageAdminServiceImpl(PointageDao dao, PointageHistoryDao historyDao) {
        super(dao, historyDao);
    }

}