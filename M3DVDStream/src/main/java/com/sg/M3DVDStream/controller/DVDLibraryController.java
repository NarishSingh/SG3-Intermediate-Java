package com.sg.M3DVDStream.controller;

import com.sg.M3DVDStream.dao.DVDLibraryDAO;
import com.sg.M3DVDStream.dao.DVDLibraryDAOException;
import com.sg.M3DVDStream.dto.DVD;
import com.sg.M3DVDStream.ui.DVDLibraryView;
import java.util.List;

public class DVDLibraryController {

    private DVDLibraryDAO dao;
    private DVDLibraryView view;

    public DVDLibraryController(DVDLibraryDAO dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    /**
     * App's run loop
     */
    public void run() {
        boolean inProgram = true;
        boolean editingLibrary = true;
        boolean viewingLibrary = true;
        int menuSelection = 0;
        int editSubMenuSlt = 0;
        int viewSubMenuSlt = 0;

        try {
            while (inProgram) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1: {
                        while (editingLibrary) {
                            editSubMenuSlt = getEditLibrarySubMenuSelection();

                            switch (editSubMenuSlt) {
                                case 1: {
                                    createDVD();
                                    break;
                                }
                                case 2: {
                                    removeDVD();
                                    break;
                                }
                                case 3: {
                                    editDVD();
                                    break;
                                }
                                case 4: {
                                    editingLibrary = false;
                                    break;
                                }
                                default: {
                                    unknownCommand();
                                }
                            }
                        }
                        break;
                    }
                    case 2: {
                        while (viewingLibrary) {
                            viewSubMenuSlt = getViewLibrarySubMenuSelection();

                            switch (viewSubMenuSlt) {
                                case 1: { //view DVD's
                                    listLibrary();
                                    break;
                                }
                                case 2: {
                                    viewDVD();
                                    break;
                                }
                                case 3: {
                                    getSinceYear();
                                    break;
                                }
                                case 4: {
                                    getByStudio();
                                    break;
                                }
                                case 5: { //stats
                                    //average age of film
                                    break;
                                }
                                case 6: {
                                    //newest
                                    break;
                                }
                                case 7: {
                                    //oldest
                                    break;
                                }
                                case 8: {
                                    //average num of notes
                                    break;
                                }
                                case 9: {
                                    viewingLibrary = false;
                                    break;
                                }
                                default: {
                                    unknownCommand();
                                }
                            }
                        }
                        break;
                    }
                    case 3: {
                        inProgram = false;
                        break;
                    }
                    default: {
                        unknownCommand();
                    }
                }

                exitMessage();
            }
        } catch (DVDLibraryDAOException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    /**
     * Get input for menu choice
     *
     * @return {int} 1-6 for menu actions
     */
    private int getMenuSelection() {
        return view.printMenuGetSelection();
    }

    /**
     * Get input for editing sub-menu
     *
     * @return {int} 1-4 for sub-menu actions
     */
    private int getEditLibrarySubMenuSelection() {
        return view.printEditLibrarySubMenuGetSelection();
    }

    /**
     * Get input for view sub-menu
     *
     * @return {int} 1-9 for sub-menu action
     */
    private int getViewLibrarySubMenuSelection() {
        return view.printViewLibrarySubMenuGetSelection();
    }

    /**
     * Display banners for DVD entry creation. Construct new DVD obj and fill
     * fields from user inputs. Add to library
     *
     * @throws DVDLibraryDAOException if unable to write to library
     */
    private void createDVD() throws DVDLibraryDAOException {
        view.displayNewDVDInfo();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayNewDVDSuccessBanner();
    }

    /**
     * Display banners for DVD entry removal. Get title of DVD from user and
     * remove from library HashMap
     *
     * @throws DVDLibraryDAOException if unable to read from or write to library
     */
    private void removeDVD() throws DVDLibraryDAOException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitle();
        DVD removedDVD = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(removedDVD);
    }

    /**
     * Display banners for DVD entry editing. Get title of DVD, copy obj and
     * then get the new info for entry. Add edited entry to HashMap, overwriting
     * the DVD obj value at that key
     *
     * @throws DVDLibraryDAOException if unable to read from or write to library
     */
    private void editDVD() throws DVDLibraryDAOException {
        view.displayEditDVDBanner();
        String dvdTitle = view.getDVDTitle();
        if (dao.getDVD(dvdTitle) != null) {
            DVD editedDVD = dao.getDVD(dvdTitle);
            view.editDVDEntry(editedDVD);
            dao.addDVD(dvdTitle, editedDVD); //will overwrite the value in HashMap
            view.displayEditDVDSuccessBanner();
        } else {
            view.displayEditDVDFailBanner();
        }
    }

    /**
     * Display banners for DVD library titles listing. Retrieve and display
     * titles from key set of library HashMap, or feedback of library is empty
     *
     * @throws DVDLibraryDAOException if cannot read from library
     */
    private void listLibrary() throws DVDLibraryDAOException {
        view.displayDisplayLibraryBanner();
        List<DVD> dvdList = dao.getLibrary();
        if (!dvdList.isEmpty()) {
            view.displayLibrary(dvdList);
        } else {
            view.displayLibraryEmptyBanner();
        }

    }

    /*ANY VIEW DATA TYPE OF METHODS SHOULD BE PUBLIC*/
    /**
     * Display banners for DVD entry viewing. Get title from user, then retrieve
     * and display DVD obj
     *
     * @throws DVDLibraryDAOException if cannot read from library
     */
    public void viewDVD() throws DVDLibraryDAOException {
        view.displayDisplayDVDBanner();
        String dvdTitle = view.getDVDTitle();
        DVD dvd = dao.getDVD(dvdTitle);
        view.getDVDEntry(dvd);
    }

    //TODO NEW METHODS HERE
    /**
     * Display banner for Get Titles Since Year. Get year as int between 1888 to
     * 2020 from user, then retrieve list of DVD's after this year and print to
     * UI
     *
     * @throws DVDLibraryDAOException if cannot read from library
     */
    public void getSinceYear() throws DVDLibraryDAOException {
        view.displayGetSinceYearBanner();
        int minYear = view.getYearFromUser();
        List<DVD> titlesByYear = dao.getDVDsSince(minYear);
        view.displayLibrary(titlesByYear);
    }

    /**
     * Display banner for Get Titles by Studio. Get studio as String from user,
     * retrieve List of DVD's which contain this studio name as a field, and
     * print List to UI
     *
     * @throws DVDLibraryDAOException if cannot read from library
     */
    public void getByStudio() throws DVDLibraryDAOException {
        view.displayGetByStudioBanner();
        String studioName = view.getStudioFromUser();
        List<DVD> titlesByStudio = dao.getDVDsByStudio(studioName);
        view.displayLibrary(titlesByStudio);
    }

    /*error and exit*/
    /**
     * Display banner for an invalid Menu choice
     */
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    /**
     * Display banner for exiting app
     */
    private void exitMessage() {
        view.displayExitBanner();
    }
}
