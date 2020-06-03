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
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author naris
 */
public class CarLotServiceImplTest {

    private CarLotService testService;
    private CarLotDAO testDAO;

    Car highendGray911_001;
    Car highendBlackGTR_002;
    Car lowendBlueCorolla_003;
    Car midendWhiteLC_004;
    Car midendBlackSupra_005;
    Car highendBlack911_007;
    Car highendGrayGTR_006;

    public CarLotServiceImplTest() {
        testDAO = new CarLotDAOImpl();
        testService = new CarLotServiceImpl(testDAO);
    }

    @BeforeEach
    public void setUp() {
        testDAO = new CarLotDAOImpl();

        //highendGray911_001
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

        //expensive 002
        String testVIN2 = "002";
        CarKey key2 = new CarKey(testVIN2);
        key2.setLaserCut(true);

        Car test2 = new Car(testVIN2, key2);
        test2.setMake("Mercedes Benz-AMG");
        test2.setModel("GT-R Coupe");
        test2.setColor("Black");
        BigDecimal testPrice2 = new BigDecimal("162900.00");
        testPrice2.setScale(2, RoundingMode.HALF_UP);
        test2.setPrice(testPrice2);
        test2.setOdometerMiles(115);

        //affordable 003
        String testVIN3 = "003";
        CarKey key3 = new CarKey(testVIN3);
        key3.setLaserCut(true);

        Car test3 = new Car(testVIN3, key3);
        test3.setMake("Toyota");
        test3.setModel("Corolla");
        test3.setColor("Blue");
        BigDecimal testPrice3 = new BigDecimal("19600.00");
        testPrice3.setScale(2, RoundingMode.HALF_UP);
        test3.setPrice(testPrice3);
        test3.setOdometerMiles(100);

        //Mid 004
        String testVIN4 = "004";
        CarKey key4 = new CarKey(testVIN4);
        key4.setLaserCut(true);

        Car test4 = new Car(testVIN4, key4);
        test4.setMake("Lexus");
        test4.setModel("LC");
        test4.setColor("White");
        BigDecimal testPrice4 = new BigDecimal("92950.00");
        testPrice4.setScale(2, RoundingMode.HALF_UP);
        test4.setPrice(testPrice4);
        test4.setOdometerMiles(100);

        //mid 005
        String testVIN5 = "005";
        CarKey key5 = new CarKey(testVIN5);
        key5.setLaserCut(true);

        Car test5 = new Car(testVIN5, key5);
        test5.setMake("Toyota");
        test5.setModel("GR Supra");
        test5.setColor("Black");
        BigDecimal testPrice5 = new BigDecimal("49990.00");
        testPrice5.setScale(2, RoundingMode.HALF_UP);
        test5.setPrice(testPrice5);
        test5.setOdometerMiles(100);

        //gray GT-R
        String testVIN6 = "006";
        CarKey key6 = new CarKey(testVIN6);
        key6.setLaserCut(true);

        Car test6 = new Car(testVIN6, key6);
        test6.setMake("Mercedes Benz-AMG");
        test6.setModel("GT-R Coupe");
        test6.setColor("Gray");
        BigDecimal testPrice6 = new BigDecimal("162900.00");
        testPrice6.setScale(2, RoundingMode.HALF_UP);
        test6.setPrice(testPrice6);
        test6.setOdometerMiles(115);

        //black 911
        String testVIN7 = "007";
        CarKey key7 = new CarKey(testVIN7);
        key7.setLaserCut(true);

        Car test7 = new Car(testVIN7, key7);
        test7.setMake("Porsche");
        test7.setModel("911 Turbo S");
        test7.setColor("Black");
        BigDecimal testPrice7 = new BigDecimal("161800.00");
        testPrice7.setScale(2, RoundingMode.HALF_UP);
        test7.setPrice(testPrice7);
        test7.setOdometerMiles(125);

        //obj
        testDAO.addCar(testVIN, test1);
        highendGray911_001 = testDAO.getCar(testVIN);

        testDAO.addCar(testVIN2, test2);
        highendBlackGTR_002 = testDAO.getCar(testVIN2);

        testDAO.addCar(testVIN3, test3);
        lowendBlueCorolla_003 = testDAO.getCar(testVIN3);

        testDAO.addCar(testVIN4, test4);
        midendWhiteLC_004 = testDAO.getCar(testVIN4);

        testDAO.addCar(testVIN5, test5);
        midendBlackSupra_005 = testDAO.getCar(testVIN5);

        testDAO.addCar(testVIN6, test6);
        highendGrayGTR_006 = testDAO.getCar(testVIN6);

        testDAO.addCar(testVIN7, test7);
        highendBlack911_007 = testDAO.getCar(testVIN7);

        testService = new CarLotServiceImpl(testDAO); //attach populated dao to servive
    }

    @Test
    public void testGetACar() throws NoSuchCarException {
        final String testVIN = "001";

        try {
            assertEquals(highendGray911_001, testService.getACar(testVIN), "Car 001 should've been added");
        } catch (NoSuchCarException e) {
            fail("Valid car, shouldn't throw any exceptions");
        }
    }
    
    @Test
    public void testGetAllCars() throws NoSuchCarException {
        final String testVIN = "001";
        final String testVIN2 = "002";
        final String testVIN3 = "003";
        final String testVIN4 = "004";
        final String testVIN5 = "005";
        final String testVIN6 = "006";
        final String testVIN7 = "007";

        List<Car> allCars = testService.getAllCars();
        assertNotNull(allCars, "List shouldn't be empty");
        assertEquals(7, allCars.size(), "List should have 7 cars");

        try {
            assertEquals(testService.getACar(testVIN), highendGray911_001, "Car 001 should be gray 911 Turbo S");
            assertTrue(allCars.contains(testService.getACar(testVIN)), "Car 001 should be in lot");

            assertEquals(testService.getACar(testVIN2), highendBlackGTR_002, "Car 002 should be black GT-R");
            assertTrue(allCars.contains(testService.getACar(testVIN2)), "Car 002 should be in lot");

            assertEquals(testService.getACar(testVIN3), lowendBlueCorolla_003, "Car 003 should be blue Corolla");
            assertTrue(allCars.contains(testService.getACar(testVIN3)), "Car 003 should be in lot");

            assertEquals(testService.getACar(testVIN4), midendWhiteLC_004, "Car 004 should be white LC");
            assertTrue(allCars.contains(testService.getACar(testVIN4)), "Car 004 should be in lot");

            assertEquals(testService.getACar(testVIN5), midendBlackSupra_005, "Car 005 should be black Supra");
            assertTrue(allCars.contains(testService.getACar(testVIN5)), "Car 005 should be in lot");

            assertEquals(testService.getACar(testVIN6), highendGrayGTR_006, "Car 006 should be black 911");
            assertTrue(allCars.contains(testService.getACar(testVIN6)), "Car 006 should be in lot");

            assertEquals(testService.getACar(testVIN7), highendBlack911_007, "Car 007 should be gray GT-R");
            assertTrue(allCars.contains(testService.getACar(testVIN7)), "Car 007 should be in lot");
        } catch (NoSuchCarException e) {
            fail("All valid cars, shouldn't throw exceptions");
        }
    }

    @Test
    public void testGetCarsByColor() {
        final String COLOR_1 = "Gray";
        final String COLOR_2 = "Black";

        List<Car> grayCars = testService.getCarsByColor(COLOR_1);
        List<Car> blackCars = testService.getCarsByColor(COLOR_2);

        assertNotNull(grayCars, "Gray car list shouldn't be empty");
        assertEquals(2, grayCars.size(), "Gray car list should have 2 entries");
        assertTrue(grayCars.contains(highendGray911_001), "Gray cars should include a 911 Turbo S");
        assertTrue(grayCars.contains(highendGrayGTR_006), "Gray cars should include a GT-R");

        assertNotNull(blackCars, "Black car list shouldn't be empty");
        assertEquals(3, blackCars.size(), "Black car list should have 3 entries");
        assertTrue(blackCars.contains(highendBlack911_007), "Black cars should include a 911 Turbo S");
        assertTrue(blackCars.contains(highendBlackGTR_002), "Black cars should include a GTR");
        assertTrue(blackCars.contains(midendBlackSupra_005), "Black cars should include a Supra");
    }

    @Test
    public void testGetCarsInBudget() {
        final BigDecimal LOW_BUDGET = new BigDecimal("20000");
        final BigDecimal MID_BUDGET = new BigDecimal("100000");
        final BigDecimal HIGH_BUDGET = new BigDecimal("200000");

        List<Car> lowEnd = testService.getCarsInBudget(LOW_BUDGET);
        List<Car> midEnd = testService.getCarsInBudget(MID_BUDGET);
        List<Car> highEnd = testService.getCarsInBudget(HIGH_BUDGET);

        assertNotNull(lowEnd, "Low end car list shouldn't be empty");
        assertEquals(1, lowEnd.size(), "Should be 1 low end car");
        assertTrue(lowEnd.contains(lowendBlueCorolla_003), "Low end list should only be the Corolla");

        assertNotNull(midEnd, "Mid end car list shouldn't be empty");
        assertEquals(3, midEnd.size(), "Should be 3 total, 2 mid end cars and 1 low end");
        assertTrue(midEnd.contains(midendWhiteLC_004), "Mid end list must contain the LC");
        assertTrue(midEnd.contains(midendBlackSupra_005), "Mid end list must contain the Supra");

        assertNotNull(highEnd, "High end car list shouldn't be empty");
        assertEquals(7, highEnd.size(), "Should be 7 total, 4 high end cars, and the rest of the vehicles");
        assertTrue(highEnd.contains(highendBlack911_007), "High end list must contain a black 911");
        assertTrue(highEnd.contains(highendBlackGTR_002), "High end list must contain a black GT-R");
        assertTrue(highEnd.contains(highendGray911_001), "High end list must contain a gray 911");
        assertTrue(highEnd.contains(highendGrayGTR_006), "High end list must contain a gray GT-R");
    }

    /*
    @Test
    public void testGetCarsByMakeAndModel() {
        final String MAKE_P = "Porsche";
        final String MODEL_P = "911 Turbo S";
        final String MAKE_MM = "Mercedes Benz-AMG";
        final String MODEL_MM = "GT-R Coupe";

        String testVIN = "001";
        CarKey key1 = new CarKey(testVIN);
        key1.setLaserCut(true);

        Car test1 = new Car(testVIN, key1);
        test1.setMake(MAKE_P);
        test1.setModel(MODEL_P);
        test1.setColor("Gray");
        BigDecimal testPrice = new BigDecimal("161800.00");
        testPrice.setScale(2, RoundingMode.HALF_UP);
        test1.setPrice(testPrice);
        test1.setOdometerMiles(125);

        String testVIN2 = "002";
        CarKey key2 = new CarKey(testVIN2);
        key2.setLaserCut(true);

        Car test2 = new Car(testVIN2, key2);
        test2.setMake(MAKE_MM);
        test2.setModel(MODEL_MM);
        test2.setColor("Gray");
        BigDecimal testPrice2 = new BigDecimal("162900.00");
        testPrice2.setScale(2, RoundingMode.HALF_UP);
        test2.setPrice(testPrice2);
        test2.setOdometerMiles(115);

        String testVIN3 = "003";
        CarKey key3 = new CarKey(testVIN3);
        key3.setLaserCut(true);

        Car test3 = new Car(testVIN3, key3);
        test3.setMake(MAKE_MM);
        test3.setModel(MODEL_MM);
        test3.setColor("Black");
        BigDecimal testPrice3 = new BigDecimal("162900.00");
        testPrice3.setScale(2, RoundingMode.HALF_UP);
        test3.setPrice(testPrice3);
        test3.setOdometerMiles(115);

        String testVIN4 = "004";
        CarKey key4 = new CarKey(testVIN4);
        key4.setLaserCut(true);

        Car test4 = new Car(testVIN4, key4);
        test4.setMake(MAKE_P);
        test4.setModel(MODEL_P);
        test4.setColor("Black");
        BigDecimal testPrice4 = new BigDecimal("161800.00");
        testPrice4.setScale(2, RoundingMode.HALF_UP);
        test4.setPrice(testPrice4);
        test4.setOdometerMiles(125);

        Car gray911 = testDAO.addCar(testVIN, test1);
        Car grayGTR = testDAO.addCar(testVIN2, test2);
        Car black911 = testDAO.addCar(testVIN3, test3);
        Car blackGTR = testDAO.addCar(testVIN4, test4);

        //service
        List<Car> porscheCars = testService.getCarByMakeAndModel(MAKE_P, MODEL_P);
        List<Car> benzAMGCars = testService.getCarByMakeAndModel(MAKE_MM, MODEL_MM);

        assertNotNull(porscheCars, "Porsche list shouldn't be empty");
        assertEquals(2, porscheCars.size(), "Porsche list should have 2 cars");
        assertTrue(porscheCars.contains(gray911), "Porsche list should have a gray 911");
        assertTrue(porscheCars.contains(black911), "Porsche list should have a black 911");

        assertNotNull(benzAMGCars, "Mercedes Benz list shouldn't be empty");
        assertEquals(2, benzAMGCars.size(), "Mercedes Benz list should have 2 cars");
        assertTrue(benzAMGCars.contains(grayGTR), "Mercedes Benz list should have a gray GT-R");
        assertTrue(benzAMGCars.contains(blackGTR), "Mercedes Benz list should have a black GT-R");
    }

    @Test
    public void testDiscountCar() throws NoSuchCarException {
        final BigDecimal TEST_DISCOUNT = new BigDecimal("7.5");

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

        Car addedCar = testDAO.addCar(testVIN, test1);

        BigDecimal discounted911 = testService.discountCar(testVIN, TEST_DISCOUNT);
        int salePrice = discounted911.intValue(); //$149,665

        assertEquals(addedCar.getPrice(), salePrice, "The sale price of a $161,800.00 Porsche should be $149,665");
    }

    @Test
    public void testSellCar() {

    }
     */
}
