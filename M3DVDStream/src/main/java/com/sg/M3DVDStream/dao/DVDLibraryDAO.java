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
import java.util.List;

public interface DVDLibraryDAO {

    /**
     * Add or edit a DVD entry to library associated w title. If a DVD exists
     * with this title already, it will return that same obj, otherwise null
     *
     * @param title {String} title associated with DVD
     * @param dvd   {DVD} DVD object
     * @return {DVD} obj for the associated/added title, null otherwise
     * @throws DVDLibraryDAOException if library cannot be loaded or written to
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
    /**
     * Create a List of DVD obj's release after a given year
     *
     * @param year {int} 1888-2020
     * @return {List} All DVD's in library released in or after the year of the
     *         argument
     * @throws DVDLibraryDAOException if library cannot be loaded
     */
    List<DVD> getDVDsSince(int year) throws DVDLibraryDAOException;

    /**
     * Create a List of DVD's obj's by MPAA rating
     *
     * @param rating {String} G, PG, PG-13, R, or none for international films
     * @return {List} All DVD's with the rating of the argument
     * @throws DVDLibraryDAOException if library cannot be loaded
     */
    List<DVD> getDVDsByRating(String rating) throws DVDLibraryDAOException;

    /**
     * Create a List of DVD's obj's by studio
     *
     * @param studio {String} the production studio
     * @return {List} All DVD's from the studio specified in the argument
     * @throws DVDLibraryDAOException if library cannot be loaded
     */
    List<DVD> getDVDsByStudio(String studio) throws DVDLibraryDAOException;

    /**
     * Calculates the average age of the films in library
     *
     * @return {double} average age
     * @throws DVDLibraryDAOException if library cannot be loaded
     */
    double averageAgeOfDVDs() throws DVDLibraryDAOException;

    /**
     * Calculates and finds the newest DVD obj by release date
     *
     * @return {DVD} the DVD with the most recent release date
     * @throws DVDLibraryDAOException if library cannot be loaded
     */
    DVD getNewestDVD() throws DVDLibraryDAOException;

    /**
     * Calculates and finds the oldest DVD obj by release date
     *
     * @return {DVD the DVD with the oldest release date
     * @throws DVDLibraryDAOException if library cannot be loaded
     */
    DVD getOldestDVD() throws DVDLibraryDAOException;

    /**
     * Calculate the average amount of notes
     *
     * @return {double} basically the DVD count because each DVD has one note
     * @throws DVDLibraryDAOException
     */
    double averageNotes() throws DVDLibraryDAOException; //wtf does this even mean
}
