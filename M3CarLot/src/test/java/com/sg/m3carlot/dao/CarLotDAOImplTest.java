package com.sg.m3carlot.dao;

import com.sg.m3carlot.dto.Car;
import com.sg.m3carlot.dto.CarKey;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author naris
 */
public class CarLotDAOImplTest {

    CarLotDAO testDAO;

    public CarLotDAOImplTest() {

    }

    @BeforeEach
    public void setUp() {
        testDAO = new CarLotDAOImpl();
    }

    @Test
    public void testAddGetCar() {
        //ARRANGE
        String testVIN = "001";
        CarKey key1 = new CarKey(testVIN);
        key1.setLaserCut(true);

        Car test1 = new Car(testVIN, key1);
        test1.setMake("Porsche");
        test1.setModel("911 Turbo S");
        test1.setColor("Gray");
        BigDecimal testPrice = new BigDecimal("1618000.00");
        testPrice.setScale(2, RoundingMode.HALF_UP);
        test1.setPrice(testPrice);
        test1.setOdometerMiles(125);

        //ACT
        testDAO.addCar(testVIN, test1);
        Car addedCar = testDAO.getCar(testVIN);

        //ASSERT
        assertEquals(addedCar, testDAO.getCar(testVIN), "Car #001 should've been added");
    }

    @Test
    public void testGetAllCars() {
        //ARRANGE
        //car 1
        String testVIN = "001";
        CarKey key1 = new CarKey(testVIN);
        key1.setLaserCut(true);

        Car test1 = new Car(testVIN, key1);
        test1.setMake("Porsche");
        test1.setModel("911 Turbo S");
        test1.setColor("Gray");
        BigDecimal testPrice = new BigDecimal("161800.00");
        testPrice.setScale(2, RoundingMode.HALF_UP);
        test1.setPrice(testPrice);
        test1.setOdometerMiles(125);

        //car 2
        String testVIN2 = "002";
        CarKey key2 = new CarKey(testVIN2);
        key2.setLaserCut(true);

        Car test2 = new Car(testVIN2, key2);
        test2.setMake("Mercedes Benz-AMG");
        test2.setModel("GT-R Coupe");
        test2.setColor("Black");
        BigDecimal testPrice2 = new BigDecimal("162900.00");
        testPrice.setScale(2, RoundingMode.HALF_UP);
        test2.setPrice(testPrice2);
        test2.setOdometerMiles(115);

        //ACT
        testDAO.addCar(testVIN, test1);
        Car addedCar = testDAO.getCar(testVIN);
        testDAO.addCar(testVIN2, test2);
        Car addedCar2 = testDAO.getCar(testVIN2);

        List<Car> testCatalouge = testDAO.getCars();

        //ASSERT
        assertEquals(addedCar, testDAO.getCar(testVIN), "Car #001 should've been added");
        assertEquals(addedCar2, testDAO.getCar(testVIN2), "Car #001 should've been added");

        assertNotNull(testCatalouge, "Catalouge should not be null");
        assertEquals(2, testCatalouge.size(), "Should be 2 cars in catalouge");
        assertTrue(testCatalouge.contains(test1), "Catalouge should contain car #001");
        assertTrue(testCatalouge.contains(test2), "Catalouge should contain car #002");
    }

    @Test
    public void testEditCar() {
        //ARRANGE
        String testVIN = "001";
        CarKey key1 = new CarKey(testVIN);
        key1.setLaserCut(true);

        Car test1 = new Car(testVIN, key1);
        test1.setMake("Porsche");
        test1.setModel("911 Turbo S");
        test1.setColor("Gray");
        BigDecimal testPrice = new BigDecimal("1618000.00");
        testPrice.setScale(2, RoundingMode.HALF_UP);
        test1.setPrice(testPrice);
        test1.setOdometerMiles(125);

        //ACT
        testDAO.addCar(testVIN, test1);
        Car originalCar = testDAO.getCar(testVIN);

        //replacement car
        CarKey key2 = new CarKey(testVIN);
        key2.setLaserCut(true);
        Car test2 = new Car(testVIN, key2);
        test2.setMake("Mercedes Benz-AMG");
        test2.setModel("GT-R Coupe");
        test2.setColor("Black");
        BigDecimal testPrice2 = new BigDecimal("162900.00");
        testPrice.setScale(2, RoundingMode.HALF_UP);
        test2.setPrice(testPrice2);
        test2.setOdometerMiles(115);

        testDAO.editCar(testVIN, test2);
        Car editedCar = testDAO.getCar(testVIN);

        List<Car> testCatalouge = testDAO.getCars();

        //ASSERT
        assertFalse(testCatalouge.contains(originalCar), "911 Turbo S should not be in catalouge");
        assertTrue(testCatalouge.contains(editedCar), "GT-R should be in catalouge");
        assertEquals(testDAO.getCar(testVIN), editedCar, "Car #001 should be GT-R");
        assertNotEquals(testDAO.getCar(testVIN), originalCar, "Car #001 should not be 911 Turbo S");
    }

    @Test
    public void testRemoveCar() {
        //ARRANGE
        //car 1
        String testVIN = "001";
        CarKey key1 = new CarKey(testVIN);
        key1.setLaserCut(true);

        Car test1 = new Car(testVIN, key1);
        test1.setMake("Porsche");
        test1.setModel("911 Turbo S");
        test1.setColor("Gray");
        BigDecimal testPrice = new BigDecimal("161800.00");
        testPrice.setScale(2, RoundingMode.HALF_UP);
        test1.setPrice(testPrice);
        test1.setOdometerMiles(125);

        //car 2
        String testVIN2 = "002";
        CarKey key2 = new CarKey(testVIN2);
        key2.setLaserCut(true);

        Car test2 = new Car(testVIN2, key2);
        test2.setMake("Mercedes Benz-AMG");
        test2.setModel("GT-R Coupe");
        test2.setColor("Black");
        BigDecimal testPrice2 = new BigDecimal("162900.00");
        testPrice.setScale(2, RoundingMode.HALF_UP);
        test2.setPrice(testPrice2);
        test2.setOdometerMiles(115);

        //ACT & ASSERT
        testDAO.addCar(testVIN, test1);
        Car addedCar = testDAO.getCar(testVIN);
        testDAO.addCar(testVIN2, test2);
        Car addedCar2 = testDAO.getCar(testVIN2);

        List<Car> testCatalouge = testDAO.getCars();
        assertNotNull(testCatalouge, "Catalouge should not be null");
        assertEquals(2, testCatalouge.size(), "Should be 2 cars in catalouge");
        assertTrue(testCatalouge.contains(test1), "Catalouge should contain car #001");
        assertTrue(testCatalouge.contains(test2), "Catalouge should contain car #002");

        testDAO.removeCar(testVIN);
        testCatalouge = testDAO.getCars();
        assertNotNull(testCatalouge, "Catalouge should not be null");
        assertEquals(1, testCatalouge.size(), "Should be only 1 car in catalouge");
        assertFalse(testCatalouge.contains(test1), "Catalouge should not contain car #001");
        assertTrue(testCatalouge.contains(test2), "Catalouge should contain car #002");

        testDAO.removeCar(testVIN2);
        testCatalouge = testDAO.getCars();
        assertTrue(testCatalouge.isEmpty(), "Catalouge should be empty");
        assertFalse(testCatalouge.contains(test1), "Catalouge should not contain car #001");
        assertFalse(testCatalouge.contains(test2), "Catalouge should not contain car #002");
    }
}
