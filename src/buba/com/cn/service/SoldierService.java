package buba.com.cn.service;

import buba.com.cn.entity.Soldier;

import java.util.List;

public interface SoldierService {
    int addSoldier(Soldier soldier);

    int delSoldier(Integer soldierId);

    int updateSoldier(Soldier soldier);

    Soldier findSoldierById(Integer id);

    List<Soldier> findAllSoldiers();
}
