package com.sg.m3vendingmachine;

import com.sg.m3vendingmachine.controller.VMController;
import com.sg.m3vendingmachine.dao.VMAuditDAO;
import com.sg.m3vendingmachine.dao.VMAuditDAOImpl;
import com.sg.m3vendingmachine.dao.VMDAO;
import com.sg.m3vendingmachine.dao.VMDAOImpl;
import com.sg.m3vendingmachine.service.VMService;
import com.sg.m3vendingmachine.service.VMServiceImpl;
import com.sg.m3vendingmachine.view.UserIO;
import com.sg.m3vendingmachine.view.UserIOImpl;
import com.sg.m3vendingmachine.view.VMView;

public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        VMView v = new VMView(io);
        
        VMDAO dao = new VMDAOImpl();
        VMAuditDAO auditDAO = new VMAuditDAOImpl();
        VMService serv = new VMServiceImpl(dao, auditDAO);
        
        VMController c = new VMController(serv, v);
        
        c.run();
    }
    
}
