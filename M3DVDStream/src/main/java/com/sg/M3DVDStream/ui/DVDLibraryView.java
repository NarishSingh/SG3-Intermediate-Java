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
        io.print("0 | -Exit-");

        return io.readInt("Action: ", 0, 2);
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
        io.print("0 | -Return-");

        return io.readInt("Action", 0, 3);
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
        io.print("5 | Titles by MPAA Rating");
        io.print("---Library Stats---");
        io.print("6 | Average Film Age");
        io.print("7 | Newest Title");
        io.print("8 | Oldest Title");
        io.print("9 | Average Notes and comments");
        io.print("0 | -Return-");

        return io.readInt("Action", 0, 9);
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
     * Retrieve and print DVD information to UI, with validation
     *
     * @param dvd {DVD} DVD obj to be viewed
     */
    public void getDVDEntry(DVD dvd) {
        if (dvd != null) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            String dateFormatted = dvd.getReleaseDate().format(f);

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
    public void displayGetSinceYearBanner() {
        io.print("===Get Titles Since Year===");
    }

    /**
     * Get the year from user
     *
     * @return {int} an integer between 1888 to 2020
     */
    public int getYearFromUser() {
        return io.readInt("Please enter the minimum year: ", 1888, 2020); //oldest film is 1888
    }

    public void displayGetSinceYearFailBanner() {
        io.readString("No titles within range of your inputted year to now. Press ENTER to continue");
    }

    /*2-4 - TITLES BY STUDIO*/
    /**
     * Display Get Titles By Studio banner for UI
     */
    public void displayGetByStudioBanner() {
        io.print("===Get Titles By Studio===");
    }

    /**
     * Get studio name from user
     *
     * @return {String} the name of the studio
     */
    public String getStudioFromUser() {
        return io.readString("Please enter studio name: ");
    }

    /**
     * If no titles match studio name, display Get By Studio fail banner for UI
     */
    public void displayGetByStudioFailBanner() {
        io.readString("No titles from this studio in library. Press ENTER to continue");
    }

    /*2-5 - TITLES BY MPAA RATING*/
    /**
     * Get MPAA rating from user as String, with validation
     */
    public void displayGetByRatingBanner() {
        io.print("===Get Titles By Rating===");
    }

    /**
     * Get and validate an MPAA rating from user
     *
     * @return {String} G, PG, PG-13, R, or none for international films
     */
    public String getRatingFromUser() {
        String userMPAArating;

        do {
            userMPAArating = io.readString("Please enter MPAA Rating: ");
        } while (!userMPAArating.equals("G")
                && !userMPAArating.equals("PG")
                && !userMPAArating.equals("PG-13")
                && !userMPAArating.equals("R")
                && !userMPAArating.equals("none"));

        return userMPAArating;
    }

    /**
     * Display Get Titles by Rating fail banner if no titles match that rating
     */
    public void displayGetByRatingFailBanner() {
        io.readString("No titles with this rating in library. Press ENTER to continue");
    }

    /*2-6 - FILM AVG AGE*/
    /**
     * Display Average Age of Films banner for UI
     */
    public void displayGetAvgAgeBanner() {
        io.print("===Average Age of Films===");
    }

    /**
     * Display the average age of films in library for UI
     *
     * @param avg {double} average age of film
     */
    public void displayAvgFilmAge(double avg) {
        io.print("Your library has films that are on average " + avg + " years old!");
        io.readString("Press ENTER to continue");
    }

    /*2-7 - NEWEST TITLE*/
    /**
     * Display Newest Title banner for UI
     */
    public void displayNewestTitleBanner() {
        io.print("===Newest Title===");
    }

    /**
     * Display newest DVD by release date
     *
     * @param newest {DVD} newest DVD release in library
     */
    public void displayNewestTitle(DVD newest) {
        io.print("Newest title by release date is:");
        getDVDEntry(newest);
        io.readString("Press ENTER to continue");
    }

    /*2-8 - OLDEST TITLE*/
    /**
     * Display Oldest Title banner for UI
     */
    public void displayOldestTitleBanner() {
        io.print("===Oldest Title===");
    }

    /**
     * Display Oldest DVD by release date
     *
     * @param oldest {DVD} Oldest DVD release in library
     */
    public void displayOldestTitle(DVD oldest) {
        io.print("Oldest title by release date is:");
        getDVDEntry(oldest);
        io.readString("Press ENTER to continue");
    }

    /*2-9 - AVG NOTES*/
    /**
     * Display Average Notes Banner
     */
    public void displayAvgNotesBanner() {
        io.print("===Average User Notes===");
    }

    public void displayAvgUserNotes(double noteAvg) {
        io.print("You have an average of " + noteAvg + " notes in your Library.");
        io.readString("Press ENTER to continue");
    }

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
