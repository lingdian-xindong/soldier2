package buba.com.cn.controller;

import buba.com.cn.entity.Soldier;
import buba.com.cn.service.SoldierService;
import buba.com.cn.service.impl.SoldierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SoldierServlet extends ViewBaseServlet{
    private SoldierService soldierService = new SoldierServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在获取请求参数之前调用
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        if(req.getParameter("method").equals("findAllSoldiers")){
            this.findAllSoldiers(req,resp);
        }

        if(req.getParameter("method").equals("addSoldier")){
            this.addSoldier(req,resp);
        }

        if(req.getParameter("method").equals("delSoldier")){
            this.delSoldier(req,resp);
        }

        if(req.getParameter("method").equals("updateSoldier")){
            this.updateSoldier(req,resp);
        }

        if(req.getParameter("method").equals("findSoldierById")){
            this.findSoldierById(req,resp);
        }
    }

    public void findAllSoldiers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Soldier> allSoldiers = soldierService.findAllSoldiers();
        req.setAttribute("soldierList",allSoldiers);
        processTemplate("list",req,resp);
    }

    public void addSoldier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String weapon = req.getParameter("weapon");
        Soldier soldier = new Soldier(name, weapon);
        soldierService.addSoldier(soldier);
        this.findAllSoldiers(req,resp);
    }

    public void delSoldier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        soldierService.delSoldier(Integer.valueOf(id));
        this.findAllSoldiers(req,resp);
    }

    public void updateSoldier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String soldierId = req.getParameter("soldierId");
        String soldierName = req.getParameter("soldierName");
        String soldierWeapon = req.getParameter("soldierWeapon");
        Soldier soldier = new Soldier(Integer.valueOf(soldierId), soldierName, soldierWeapon);
        soldierService.updateSoldier(soldier);
        this.findAllSoldiers(req,resp);
    }

    public void findSoldierById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Soldier soldierById = soldierService.findSoldierById(Integer.valueOf(id));
        req.setAttribute("soldier",soldierById);
        processTemplate("table",req,resp);
    }
}
