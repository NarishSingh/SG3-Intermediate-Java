package com.sg.m3carlot.service;

import com.sg.m3carlot.dao.CarLotDAO;
import com.sg.m3carlot.dao.CarLotDAOImpl;
import com.sg.m3carlot.dto.Car;
import com.sg.m3carlot.dto.CarKey;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author naris
 */
public class CarLotServiceImplTest {

    private CarLotService testService;

    public CarLotServiceImplTest() {
        CarLotDAO testDAO = new CarLotDAOImpl();
        testService = new CarLotServiceImpl(testDAO);
    }

    @Test
    public void testGetACar() throws NoSuchCarException {
        //add car
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

        Car addedCar = testDAO.addCar(testVIN, test1);

        //service
        assertEquals(testService.getACar(testVIN), addedCar, "Car 001 should've been added");
    }

    @Test
    public void testGetAllCars() throws NoSuchCarException {
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

        Car addedCar = testDAO.addCar(testVIN, test1);
        Car addedCar2 = testDAO.addCar(testVIN2, test2);

        //Service
        List<Car> allCars = testService.getAllCars();

        assertNotNull(allCars, "List shouldn't be empty");
        assertEquals(2, allCars.size(), "List should have 2 cars");
        assertEquals(testService.getACar(testVIN), addedCar, "Car 001 should be 911 Turbo S");
        assertTrue(allCars.contains(testService.getACar(testVIN)), "Car 001 should be in lot");
        assertEquals(testService.getACar(testVIN2), addedCar2, "Car 001 should be GT-R");
        assertTrue(allCars.contains(testService.getACar(testVIN2)), "Car 002 should be in lot");
    }

    @Test
    public void testGetCarsByColor() {
        //Gray
        final String COLOR_1 = "Gray";

        String testVIN = "001";
        CarKey key1 = new CarKey(testVIN);
        key1.setLaserCut(true);

        Car test1 = new Car(testVIN, key1);
        test1.setMake("Porsche");
        test1.setModel("911 Turbo S");
        test1.setColor(COLOR_1);
        BigDecimal testPrice = new BigDecimal("161800.00");
        testPrice.setScale(2, RoundingMode.HALF_UP);
        test1.setPrice(testPrice);
        test1.setOdometerMiles(125);

        String testVIN2 = "002";
        CarKey key2 = new CarKey(testVIN2);
        key2.setLaserCut(true);

        Car test2 = new Car(testVIN2, key2);
        test2.setMake("Mercedes Benz-AMG");
        test2.setModel("GT-R Coupe");
        test2.setColor(COLOR_1);
        BigDecimal testPrice2 = new BigDecimal("162900.00");
        testPrice2.setScale(2, RoundingMode.HALF_UP);
        test2.setPrice(testPrice2);
        test2.setOdometerMiles(115);

        //Black
        final String COLOR_2 = "Black";

        String testVIN3 = "003";
        CarKey key3 = new CarKey(testVIN3);
        key3.setLaserCut(true);

        Car test3 = new Car(testVIN3, key3);
        test3.setMake("Mercedes Benz-AMG");
        test3.setModel("GT-R Coupe");
        test3.setColor(COLOR_2);
        BigDecimal testPrice3 = new BigDecimal("162900.00");
        testPrice3.setScale(2, RoundingMode.HALF_UP);
        test3.setPrice(testPrice3);
        test3.setOdometerMiles(115);

        String testVIN4 = "004";
        CarKey key4 = new CarKey(testVIN4);
        key4.setLaserCut(true);

        Car test4 = new Car(testVIN4, key4);
        test4.setMake("Porsche");
        test4.setModel("911 Turbo S");
        test4.setColor(COLOR_2);
        BigDecimal testPrice4 = new BigDecimal("161800.00");
        testPrice4.setScale(2, RoundingMode.HALF_UP);
        test4.setPrice(testPrice4);
        test4.setOdometerMiles(125);

        Car gray911 = testDAO.addCar(testVIN, test1);
        Car grayGTR = testDAO.addCar(testVIN2, test2);
        Car black911 = testDAO.addCar(testVIN3, test3);
        Car blackGTR = testDAO.addCar(testVIN4, test4);

        //service
        List<Car> grayCars = testService.getCarsByColor(COLOR_1);
        List<Car> blackCars = testService.getCarsByColor(COLOR_2);

        assertNotNull(grayCars, "Gray car list shouldn't be empty");
        assertEquals(2, grayCars.size(), "Gray car list should have 2 entries");
        assertTrue(grayCars.contains(gray911), "Gray cars should include a 911 Turbo S");
        assertTrue(grayCars.contains(grayGTR), "Gray cars should include a GT-R");

        assertNotNull(blackCars, "Black car list shouldn't be empty");
        assertEquals(2, blackCars.size(), "Black car list should have 2 entries");
        assertTrue(blackCars.contains(black911), "Black cars should include a 911 Turbo S");
        assertTrue(blackCars.contains(blackGTR), "Black cars should include a GTR");
    }

    /*
    @Test
    public void testGetCarsInBudget() {

    }

    @Test
    public void testGetCarsByMakeAndModel() {

    }

    @Test
    public void testDiscounrtCar() {

    }

    @Test
    public void testSellCar() {

    }
     */
}
