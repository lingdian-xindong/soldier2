package buba.com.cn.service.impl;

import buba.com.cn.dao.SoldierDao;
import buba.com.cn.dao.impl.SoldierDaoImpl;
import buba.com.cn.entity.Soldier;
import buba.com.cn.service.SoldierService;

import java.util.List;

public class SoldierServiceImpl implements SoldierService {
    private SoldierDao soldierDao = new SoldierDaoImpl();

    @Override
    public int addSoldier(Soldier soldier) {
        return soldierDao.addSoldier(soldier);
    }

    @Override
    public int delSoldier(Integer soldierId) {
        return soldierDao.delSoldier(soldierId);
    }

    @Override
    public int updateSoldier(Soldier soldier) {
        return soldierDao.updateSoldier(soldier);
    }

    @Override
    public Soldier findSoldierById(Integer id) {
        return soldierDao.findSoldierById(id);
    }

    @Override
    public List<Soldier> findAllSoldiers() {
        return soldierDao.findAllSoldiers();
    }
}
