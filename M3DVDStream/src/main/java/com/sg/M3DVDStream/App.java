package com.sg.M3DVDStream;

import com.sg.M3DVDStream.controller.DVDLibraryController;
import com.sg.M3DVDStream.dao.DVDLibraryDAO;
import com.sg.M3DVDStream.dao.DVDLibraryDAOImpl;
import com.sg.M3DVDStream.ui.DVDLibraryView;
import com.sg.M3DVDStream.ui.UserIO;
import com.sg.M3DVDStream.ui.UserIOImpl;

public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        DVDLibraryView v = new DVDLibraryView(io);
        DVDLibraryDAO dao = new DVDLibraryDAOImpl();
        DVDLibraryController c = new DVDLibraryController(dao, v);

        c.run();
    }

}
