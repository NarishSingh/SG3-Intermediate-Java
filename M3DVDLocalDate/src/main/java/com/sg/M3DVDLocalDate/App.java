package com.sg.M3DVDLocalDate;

import com.sg.M3DVDLocalDate.controller.DVDLibraryController;
import com.sg.M3DVDLocalDate.dao.DVDLibraryDAO;
import com.sg.M3DVDLocalDate.dao.DVDLibraryDAOImpl;
import com.sg.M3DVDLocalDate.ui.DVDLibraryView;
import com.sg.M3DVDLocalDate.ui.UserIO;
import com.sg.M3DVDLocalDate.ui.UserIOImpl;

public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        DVDLibraryView v = new DVDLibraryView(io);
        DVDLibraryDAO dao = new DVDLibraryDAOImpl();
        DVDLibraryController c = new DVDLibraryController(dao, v);

        c.run();
    }

}
