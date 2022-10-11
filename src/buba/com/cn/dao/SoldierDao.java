package buba.com.cn.dao;

import buba.com.cn.entity.Soldier;

import java.util.List;

public interface SoldierDao {
    int addSoldier(Soldier soldier);

    int delSoldier(Integer soldierId);

    int updateSoldier(Soldier soldier);

    Soldier findSoldierById(Integer id);

    List<Soldier> findAllSoldiers();
}
