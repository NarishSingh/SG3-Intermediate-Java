package com.sg.M3DVDStream.ui;

import com.sg.M3DVDStream.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DVDLibraryView {

    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    /**
     * Print UI menu and get selection
     *
     * @return {int} 1-6 for menu choice
     */
    public int printMenuGetSelection() {
        io.print("***Menu***");
        io.print("1 | Edit Library");
        io.print("2 | View Library");
        io.print("3 | -Exit-");

        return io.readInt("Action: ", 1, 3);
    }

    /**
     * Print UI edit sub-menu and get selection
     *
     * @return {int} 1-4 for sub-menu choice
     */
    public int printEditLibrarySubMenuGetSelection() {
        io.print("***Library Edit***");
        io.print("1 | Add DVD");
        io.print("2 | Remove DVD");
        io.print("3 | Edit DVD Info");
        io.print("4 | -Return-");

        return io.readInt("Action", 1, 4);
    }

    /**
     * Print UI edit sub-menu and get selection
     *
     * @return {int} 1-9 for sub-menu choice
     */
    public int printViewLibrarySubMenuGetSelection() {
        io.print("***View Library Data***");
        io.print("---DVD---");
        io.print("1 | All Titles");
        io.print("2 | View by Title");
        io.print("3 | Titles Since Year");
        io.print("4 | Titles By Studio");
        io.print("---Library Stats---");
        io.print("5 | Average Film Age");
        io.print("6 | Newest Title");
        io.print("7 | Oldest Title");
        io.print("8 | Average Notes and comments");
        io.print("9 | -Return-");

        return io.readInt("Action", 1, 9);
    }

    /*1-1 - ADD DVD*/
    /**
     * Get string input to construct and fill fields of new DVD obj, ensures no
     * empty user inputs
     *
     * @return {DVD} a DVD obj with all fields filled
     */
    public DVD getNewDVDInfo() {
        String title;
        String releaseDateString;
        String director;
        String studio;
        String mpaaRating;
        String userRating;

        do {
            title = io.readString("Enter DVD title: ");
        } while (title.isBlank() || title.contains("\t"));

        do {
            releaseDateString = io.readString("Enter release date in mm-dd-yyyy format: ");
        } while (releaseDateString.isBlank() || releaseDateString.contains("\t") || !releaseDateString.contains("-"));

        do {
            director = io.readString("Enter director's name: ");
        } while (director.isBlank() || director.contains("\t"));

        do {
            studio = io.readString("Enter studio name: ");
        } while (studio.isBlank() || studio.contains("\t"));

        do {
            mpaaRating = io.readString("Enter MPAA rating: ");
        } while (mpaaRating.isBlank() || mpaaRating.contains("\t"));

        do {
            userRating = io.readString("Enter your own personal rating, or comments: ");
        } while (userRating.isBlank() || userRating.contains("\t"));

        DVD currentDVD = new DVD(title);

        LocalDate releaseDate = LocalDate.parse(releaseDateString, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        currentDVD.setReleaseDate(releaseDate);

        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setUserRating(userRating);

        return currentDVD;
    }

    /**
     * Display opening New DVD banner for UI
     */
    public void displayNewDVDInfo() {
        io.print("===Add New DVD===");
    }

    /**
     * Display closing New DVD successfully added banner for UI
     */
    public void displayNewDVDSuccessBanner() {
        io.readString("DVD added to library. Press ENTER to continue");
    }

    /*1-2 - REMOVE DVD*/
    /**
     * Display opening Remove DVD for UI
     */
    public void displayRemoveDVDBanner() {
        io.print("===Remove DVD===");
    }

    /**
     * Display closing Remove DVD banner showing success, or if there was no
     * entry to remove
     *
     * @param dvdEntry {DVD} the DVD obj to be removed
     */
    public void displayRemoveResult(DVD dvdEntry) {
        if (dvdEntry != null) {
            io.print("DVD removed from library.");
        } else {
            io.print("No such DVD.");
        }

        io.readString("Press ENTER to continue");
    }

    /*1-3 - EDIT DVD*/
    /**
     * Get input for title of DVD in library
     *
     * @return {String} title of existing DVD entry
     */
    public String getDVDTitle() {
        return io.readString("Please enter DVD title: ");
    }

    /**
     * Edit fields of a existing DVD entry in library
     *
     * @param editedDVD {DVD} copy of existing DVD entry to be edited and then
     *                  used to overwrite entry in library
     */
    public void editDVDEntry(DVD editedDVD) {
        String newReleaseDateString;
        String newDirector;
        String newStudio;
        String newMpaaRating;
        String newUserRating;

        do {
            newReleaseDateString = io.readString("Enter release date in mm-dd-yyyy format: ");
        } while (newReleaseDateString.isBlank() || newReleaseDateString.contains("\t") || !newReleaseDateString.contains("-"));

        do {
            newDirector = io.readString("Enter director's name: ");
        } while (newDirector.isBlank() || newDirector.contains("\t"));

        do {
            newStudio = io.readString("Enter studio name: ");
        } while (newStudio.isBlank() || newStudio.contains("\t"));

        do {
            newMpaaRating = io.readString("Enter MPAA rating: ");
        } while (newMpaaRating.isBlank() || newMpaaRating.contains("\t"));

        do {
            newUserRating = io.readString("Enter your own personal rating, or comments: ");
        } while (newUserRating.isBlank() || newUserRating.contains("\t"));

        LocalDate newReleaseDate = LocalDate.parse(newReleaseDateString, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        editedDVD.setReleaseDate(newReleaseDate);
        editedDVD.setDirector(newDirector);
        editedDVD.setStudio(newStudio);
        editedDVD.setMpaaRating(newMpaaRating);
        editedDVD.setUserRating(newUserRating);
    }

    /**
     * Display opening Edit DVD banner for UI
     */
    public void displayEditDVDBanner() {
        io.print("===Edit DVD===");
    }

    /**
     * Display closing Edit DVD banner for UI if DVD successfully edited
     */
    public void displayEditDVDSuccessBanner() {
        io.readString("DVD entry edited. Press ENTER to continue.");
    }

    /**
     * Display closing Edit DVD banner for UI if no DVD exists to edit
     */
    public void displayEditDVDFailBanner() {
        io.readString("Cannot edit non-existent DVD. Press ENTER to continue");
    }

    /*2-1 - LIST ALL DVD'S IN LIBRARY*/
    /**
     * Display all DVD titles in library
     *
     * @param dvdList {List} DVD library key set
     */
    public void displayLibrary(List<DVD> dvdList) {
        dvdList.forEach((currentDVD) -> {
            io.print(currentDVD.getTitle());
        });

        io.readString("Press ENTER to continue.");
    }

    /**
     * Display Display Library banner for UI
     */
    public void displayDisplayLibraryBanner() {
        io.print("===Display Library===");
    }

    /**
     * Display Library Empty banner for UI if no titles are in library
     */
    public void displayLibraryEmptyBanner() {
        io.readString("Library is currently empty. Press ENTER to continue");
    }

    /*2-2 - VIEW DVD INFO*/
    /**
     * Retrieve and print DVD information to UI
     *
     * @param dvd {DVD} DVD obj to be viewed
     */
    public void getDVDEntry(DVD dvd) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        String dateFormatted = dvd.getReleaseDate().format(f);

        if (dvd != null) {
            String dvdInfo = String.format("\"%s,\" debuted: %s, Directed by %s, %s, MPAA: %s, My Reactions: %s",
                    dvd.getTitle(), dateFormatted, dvd.getDirector(),
                    dvd.getStudio(), dvd.getMpaaRating(), dvd.getUserRating());

            io.print(dvdInfo);
        } else {
            io.print("No such DVD in library");
        }

        io.readString("Press ENTER to continue");
    }

    /**
     * Display Display DVD banner for UI
     */
    public void displayDisplayDVDBanner() {
        io.print("===Display DVD===");
    }

    /*2-3 - TITLES SINCE YEAR*/
    /**
     * Display Get Titles Since Year banner for UI
     */
    public void displayGetSinceYearBanner(){
        io.print("===Get Titles Since Year===");
    }
    
    public int getYearFromUser(){
        return io.readInt("Please enter the minimum year: ", 1888, 2020); //oldest film is 1888
    }
    
    /*2-4 - TITLES BY STUDIO*/
    public void displayGetByStudioBanner(){
        io.print("===Get Titles By Studio===");
    }
    
    public String getStudioFromUser(){
        return io.readString("Please enter studio name: ");
    }
    
    
 /*2-5 - FILM AVG AGE*/
 /*2-6 - NEWEST TITLE*/
 /*2-7 - OLDEST TITLE*/
 /*2-8 - AVG NOTES*/
 /*1-4 - EXIT*/
    /**
     * Display Exit banner in UI
     */
    public void displayExitBanner() {
        io.print("***Thank you***");
    }

    /*EXCEPTION/ERROR HANDLING*/
    /**
     * Display Unknown Command banner in UI
     */
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command...");
    }

    /**
     * Display error message for issues with IO
     *
     * @param errorMsg {String} error message to user
     */
    public void displayErrorMessage(String errorMsg) {
        io.print("===Error===");
        io.print(errorMsg);
    }
}
