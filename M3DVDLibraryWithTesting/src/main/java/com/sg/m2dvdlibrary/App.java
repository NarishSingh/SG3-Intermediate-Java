package com.sg.m2dvdlibrary;

import com.sg.m2dvdlibrary.controller.DVDLibraryController;
import com.sg.m2dvdlibrary.dao.DVDLibraryDAO;
import com.sg.m2dvdlibrary.dao.DVDLibraryDAOImpl;
import com.sg.m2dvdlibrary.ui.DVDLibraryView;
import com.sg.m2dvdlibrary.ui.UserIO;
import com.sg.m2dvdlibrary.ui.UserIOImpl;

public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        DVDLibraryView v = new DVDLibraryView(io);
        DVDLibraryDAO dao = new DVDLibraryDAOImpl();
        DVDLibraryController c = new DVDLibraryController(dao, v);

        c.run();
    }

}
