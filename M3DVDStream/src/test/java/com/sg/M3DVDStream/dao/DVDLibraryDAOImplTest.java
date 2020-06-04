package com.sg.M3DVDStream.dao;

import com.sg.M3DVDStream.dto.DVD;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author naris
 */
public class DVDLibraryDAOImplTest {

    DVDLibraryDAO testDAO;

    public DVDLibraryDAOImplTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testlibrary.txt";
        new FileWriter(testFile);
        testDAO = new DVDLibraryDAOImpl(testFile);
    }

    /**
     * Test of addDVD() and getDVD() of DAO - add DVD and verify is obj was
     * added properly
     *
     * @throws Exception
     */
    @Test
    public void testAddGetDVD() throws Exception {
        //Arrange
        String movieTitle = "testing, the movie";
        DVD dvd = new DVD(movieTitle);
        LocalDate releaseDate = LocalDate.parse("05-29-2020", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        dvd.setReleaseDate(releaseDate);
        dvd.setDirector("Narish");
        dvd.setStudio("Singh Studios");
        dvd.setMpaaRating("0/5");
        dvd.setUserRating("0/10 what is this");

        //Act
        testDAO.addDVD(movieTitle, dvd);
        DVD addedDVD = testDAO.getDVD(movieTitle);

        //Assert
        assertEquals(dvd.getTitle(), addedDVD.getTitle());
        assertEquals(dvd.getReleaseDate(), addedDVD.getReleaseDate());
        assertEquals(dvd.getDirector(), addedDVD.getDirector());
        assertEquals(dvd.getStudio(), addedDVD.getStudio());
        assertEquals(dvd.getMpaaRating(), addedDVD.getMpaaRating());
        assertEquals(dvd.getUserRating(), addedDVD.getUserRating());
    }

    /**
     * Test of getLibrary() of DAO - get 2 DVD's and verify that both are in
     * test library
     *
     * @throws Exception
     */
    @Test
    public void testGetLibrary() throws Exception {
        //Arrange
        String movieTitle = "testing, the movie";
        DVD dvd = new DVD(movieTitle);
        LocalDate releaseDate = LocalDate.parse("05-29-2020", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        dvd.setReleaseDate(releaseDate);
        dvd.setDirector("Narish");
        dvd.setStudio("Singh Studios");
        dvd.setMpaaRating("0/5");
        dvd.setUserRating("0/10 what is this");

        String movieTitle2 = "testing, the movie part II";
        DVD dvd2 = new DVD(movieTitle2);
        LocalDate releaseDate2 = LocalDate.parse("05-30-2020", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        dvd2.setReleaseDate(releaseDate2);
        dvd2.setDirector("Not Narish");
        dvd2.setStudio("Singh & Singh Studios");
        dvd2.setMpaaRating("2/5");
        dvd2.setUserRating("1/10 cool");

        //Act
        testDAO.addDVD(movieTitle, dvd);
        testDAO.addDVD(movieTitle2, dvd2);

        List<DVD> allDVDs = testDAO.getLibrary();

        //Assert
        assertNotNull(allDVDs, "List shouldn't be null");
        assertEquals(2, allDVDs.size(), "List should have 2 DVD's exactly");

        assertTrue(testDAO.getLibrary().contains(dvd), "List should include \"testing, the movie\"");
        assertTrue(testDAO.getLibrary().contains(dvd2), "List should include \"testing, the movie part II\"");
    }

    /**
     * Test removeDVD() of DAO - add 2 DVD's, remove one and check list, remove
     * other and check if list is empty, attempt to get the removed DVD's from
     * list to be sure
     *
     * @throws Exception
     */
    @Test
    public void testRemoveDVD() throws Exception {
        //Arrange
        String movieTitle = "testing, the movie";
        DVD dvd = new DVD(movieTitle);
        LocalDate releaseDate = LocalDate.parse("05-29-2020", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        dvd.setReleaseDate(releaseDate);
        dvd.setDirector("Narish");
        dvd.setStudio("Singh Studios");
        dvd.setMpaaRating("0/5");
        dvd.setUserRating("0/10 what is this");

        String movieTitle2 = "we are no longer testing";
        DVD dvd2 = new DVD(movieTitle2);
        LocalDate releaseDate2 = LocalDate.parse("05-30-2020", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        dvd2.setReleaseDate(releaseDate2);
        dvd2.setDirector("Not Narish");
        dvd2.setStudio("Singh & Singh Studios");
        dvd2.setMpaaRating("0/5");
        dvd2.setUserRating("1/10 cool");

        //Act & Assert
        testDAO.addDVD(movieTitle, dvd);
        testDAO.addDVD(movieTitle2, dvd2);

        //remove 1st
        DVD removedDVD = testDAO.removeDVD(dvd.getTitle());
        assertEquals(removedDVD, dvd, "testing should've been removed");
        List<DVD> allDVDs = testDAO.getLibrary();
        assertNotNull(allDVDs, "List shouldn't be null");
        assertTrue(testDAO.getLibrary().contains(dvd2), "List should include testing II");

        //remove 2nd
        removedDVD = testDAO.removeDVD(dvd2.getTitle());
        assertEquals(removedDVD, dvd2, "we are no longer testing should've been removed");
        allDVDs = testDAO.getLibrary();
        assertTrue(allDVDs.isEmpty(), "List should be empty");

        //verify
        DVD retrievedDvd = testDAO.getDVD(dvd.getTitle());
        assertNull(retrievedDvd, "testing removed - should be null");

        retrievedDvd = testDAO.getDVD(dvd2.getTitle());
        assertNull(retrievedDvd, "testing II removed - should be null");
    }
}
