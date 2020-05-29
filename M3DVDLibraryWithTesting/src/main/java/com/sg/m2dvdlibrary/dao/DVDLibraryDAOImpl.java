package com.sg.m2dvdlibrary.dao;

import com.sg.m2dvdlibrary.dto.DVD;
import java.util.*;
import java.io.*;

public class DVDLibraryDAOImpl implements DVDLibraryDAO {

    private Map<String, DVD> library = new HashMap<>();
    public final String LIBRARY_FILE;
    public static final String DELIMITER = "::";

    /*CTORS*/
    //fix injection of record file so testing can happen without IO
    public DVDLibraryDAOImpl() {
        LIBRARY_FILE = "dvdlibrary.txt";
    }

    public DVDLibraryDAOImpl(String LIBRARY_FILE) {
        this.LIBRARY_FILE = LIBRARY_FILE;
    }

    /*INTERFACE IMPLEMENTATION*/
    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDAOException {
        loadLibrary();
        DVD newDVD = library.put(title, dvd);
        writeLibrary();

        return newDVD;
    }

    @Override
    public List<DVD> getLibrary() throws DVDLibraryDAOException {
        loadLibrary();

        return new ArrayList(library.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDAOException {
        loadLibrary();

        return library.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDAOException {
        loadLibrary();
        DVD removedDVD = library.remove(title);
        writeLibrary();

        return removedDVD;
    }

    /*Data Unmarshalling*/
    /**
     * Unmarshall a delimited line of text from LIBRARY_FILE into a DVD obj
     *
     * @param dvdAsText {String} delimited by ::
     * @return {DVD} obj with all fields filled
     */
    private DVD unmarshallDVD(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String dvdTitle = dvdTokens[0];
        DVD dvdFromFile = new DVD(dvdTitle);

        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setDirector(dvdTokens[2]);
        dvdFromFile.setStudio(dvdTokens[3]);
        dvdFromFile.setMpaaRating(dvdTokens[4]);
        dvdFromFile.setUserRating(dvdTokens[5]);

        return dvdFromFile;
    }

    /**
     * Read in a file and construct DVD obj from delimited lines of text
     *
     * @throws DVDLibraryDAOException if file cannot be read from
     */
    private void loadLibrary() throws DVDLibraryDAOException {
        Scanner sc;

        try {
            sc = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDAOException("Couldn't load library into memory...", e);
        }

        String currentLine;
        DVD currentDVD;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentDVD = unmarshallDVD(currentLine);

            library.put(currentDVD.getTitle(), currentDVD);
        }

        sc.close();
    }

    /**
     * Marshall data from a DVD obj to text
     *
     * @param aDVD {DVD} obj with all fields from library
     * @return {String} the DVD obj as delimited String/line of text
     */
    private String marshallDVD(DVD aDVD) {
        String dvdAsText = aDVD.getTitle() + DELIMITER;
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;
        dvdAsText += aDVD.getDirector() + DELIMITER;
        dvdAsText += aDVD.getStudio() + DELIMITER;
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;
        dvdAsText += aDVD.getUserRating();

        return dvdAsText;
    }

    /**
     * Writes all DVD's in library to LIBRARY_FILE
     *
     * @throws DVDLibraryDAOException {IOException} if cannot write to file
     */
    private void writeLibrary() throws DVDLibraryDAOException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDAOException("Could not save DVD library data...", e);
        }

        String dvdAsText;
        List<DVD> dvdList = new ArrayList(library.values());

        for (DVD currentDVD : dvdList) {
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }

        out.close();
    }
}
