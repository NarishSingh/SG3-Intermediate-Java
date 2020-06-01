package com.sg.m3dvdv2.dao;

import com.sg.m3dvdv2.dto.DVD;
import java.util.List;

public interface DVDLibraryDAO {

    /**
     * Add or edit a DVD entry to library associated w title. If a DVD exists
     * with this title already, it will return that same obj, otherwise null
     *
     * @param title {String} title associated with DVD
     * @param dvd   {DVD} DVD object
     * @return {DVD} obj for the associated/added title, null otherwise
     * @throws DVDLibraryDAOException
     */
    DVD addDVD(String title, DVD dvd) throws DVDLibraryDAOException;

    /**
     * List DVD's in library
     *
     * @return {List} library of DVD objects
     * @throws DVDLibraryDAOException if cannot load LIBRARY_FILE
     */
    List<DVD> getLibrary() throws DVDLibraryDAOException;

    /**
     * Gets DVD obj associated with title
     *
     * @param title {String} title of DVD object to retrieve
     * @return {DVD} the DVD objected associated with totle
     * @throws DVDLibraryDAOException if cannot load LIBRARY_FILE
     */
    DVD getDVD(String title) throws DVDLibraryDAOException;

    /**
     * Removes DVD obj associated with title, returns null if no such DVD is in
     * library
     *
     * @param title {String} the title of DVD to be removed from library
     * @return {DVD} DVD obj removed, or null if nothing could be removed
     * @throws DVDLibraryDAOException if library cannot be loaded or written to
     */
    DVD removeDVD(String title) throws DVDLibraryDAOException;
}
