/*
implement this
 */
package com.sg.m3carlot.service;

import com.sg.m3carlot.dto.Car;
import com.sg.m3carlot.dto.CarKey;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author naris
 */
public interface CarLotService {

    public Car getACar(String VIN);

    public List<Car> getAllCars();

    public List<Car> getCarsByColor(String color);

    public List<Car> getCarsInBudget(BigDecimal maxPrice);

    public List<Car> getCarByMakeAndModel(String make, String model);

    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException;

    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException;
}
