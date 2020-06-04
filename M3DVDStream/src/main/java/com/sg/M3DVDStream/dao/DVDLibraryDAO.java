/*
New Stream API implementations
-Find all movies released in the last N years
-Find all the movies with a given MPAA rating
-Find all the movies by a given director
--When searching by director, the movies should be sorted into separate data structures by MPAA rating.
-Find all the movies released by a particular studio
-Find the average age of the movies in the collection
-Find the newest movie in your collection
-Find the oldest movie in your collection
-Find the average number of notes associated with movies in your collection
*/

package com.sg.M3DVDStream.dao;

import com.sg.M3DVDStream.dto.DVD;
import java.math.BigDecimal;
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
     * @return {DVD} the DVD objected associated with title
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
    
    /*new stream methods*/
    
    List<DVD> getDVDsSince(int year) throws DVDLibraryDAOException;
    
    List<DVD> getDVDsByRating(String rating) throws DVDLibraryDAOException; //TODO may need to revise return type, must list DVD's by rating
    
    List<DVD> getDVDsByStudio(String studio) throws DVDLibraryDAOException;
    
    int averageAgeOfDVDs() throws DVDLibraryDAOException;
    
    DVD getNewestDVD() throws DVDLibraryDAOException;
    
    DVD getOldestDVD() throws DVDLibraryDAOException;
    
    BigDecimal averageNotes() throws DVDLibraryDAOException; //wtf does this even mean
}
