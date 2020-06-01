package com.sg.m3dvdv2;

import com.sg.m3dvdv2.controller.DVDLibraryController;
import com.sg.m3dvdv2.dao.DVDLibraryDAO;
import com.sg.m3dvdv2.dao.DVDLibraryDAOImpl;
import com.sg.m3dvdv2.ui.DVDLibraryView;
import com.sg.m3dvdv2.ui.UserIO;
import com.sg.m3dvdv2.ui.UserIOImpl;

public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        DVDLibraryView v = new DVDLibraryView(io);
        DVDLibraryDAO dao = new DVDLibraryDAOImpl();
        DVDLibraryController c = new DVDLibraryController(dao, v);

        c.run();
    }

}
