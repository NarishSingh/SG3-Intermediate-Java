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

    /**
     * Get a car at that VIN
     *
     * @param VIN {String} the car obj's unique ID
     * @return {Car} car obj associated with that VIN key
     * @throws NoSuchCarException if car obj doesn't exist in lot HashMap
     */
    public Car getACar(String VIN) throws NoSuchCarException;

    /**
     * Get a list of all cars in lot
     *
     * @return {List} every car obj within HashMap
     */
    public List<Car> getAllCars();

    /**
     * Get a list of cars of the specified color
     *
     * @param color {String} the desired Color
     * @return {List} the car objs in HashMap that contain that color field
     */
    public List<Car> getCarsByColor(String color);

    /**
     * Get a list of cars under buyer's desired price
     *
     * @param maxPrice {BigDecimal} maximum price for a car to be pitched to a
     *                 customer
     * @return {List} the car objs in HashMap that contain that or below price
     *         field
     */
    public List<Car> getCarsInBudget(BigDecimal maxPrice);

    /**
     * Get a list of cars matching the buyer's desired make and model
     *
     * @param make  {String} the desired car brand
     * @param model {String} the desired car model in that brand
     * @return {List} the car objs in HashMap that match the arg's make and
     *         model
     */
    public List<Car> getCarByMakeAndModel(String make, String model);

    /**
     * Apply a discount to a car, updating its price field and return final sell
     * price
     *
     * @param VIN             {String} the unique ID for a car obj
     * @param percentDiscount {BigDecimal} the percentage of the discount being
     *                        applied to the car
     * @return {BigDecimal} the reduced price for the car
     * @throws NoSuchCarException if no such car exists in lot
     */
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException;

    /**
     * Sell a car in the lot
     *
     * @param VIN      {String} the unique ID for a car obj
     * @param cashPaid {BigDecimal} the amount paid by the customer
     * @return {CarKey} return the CarKey for the car obj that was sold
     * @throws NoSuchCarException      if no such car exists in lot
     * @throws OverpaidPriceException  if buyer is overpaying
     * @throws UnderpaidPriceException if buyer is no paying enough
     */
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException;
}
