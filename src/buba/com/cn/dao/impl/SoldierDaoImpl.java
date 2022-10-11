package buba.com.cn.dao.impl;

import buba.com.cn.dao.SoldierDao;
import buba.com.cn.entity.Soldier;
import buba.com.cn.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SoldierDaoImpl implements SoldierDao {
    @Override
    public int addSoldier(Soldier soldier) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "insert into t_soldier(soldier_name,soldier_weapon) values(?,?)";
        int add = jdbcTemplate.update(sql, soldier.getSoldierName(), soldier.getSoldierWeapon());
        return add;
    }

    @Override
    public int delSoldier(Integer soldierId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "delete from t_soldier where soldier_id = ?";
        int del = jdbcTemplate.update(sql, soldierId);
        return del;
    }

    @Override
    public int updateSoldier(Soldier soldier) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "update t_soldier set soldier_name = ?, soldier_weapon = ? where soldier_id = ?";
        int update = jdbcTemplate.update(sql, soldier.getSoldierName(), soldier.getSoldierWeapon(), soldier.getSoldierId());
        return update;
    }

    @Override
    public Soldier findSoldierById(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select * from t_soldier where soldier_id = ?";
        Soldier soldier = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Soldier.class), id);
        return soldier;
    }

    @Override
    public List<Soldier> findAllSoldiers() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select * from t_soldier";
        List<Soldier> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Soldier.class));
        return query;
    }
}
