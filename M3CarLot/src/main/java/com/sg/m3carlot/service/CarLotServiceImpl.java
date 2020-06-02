/*
The above has several business based methods that must be defined!

Given a VIN, it should be able to get a single Car.
It should be able to get all the Cars and return them in a List.
Given a color, it should be able to return all the available Cars of that color in a List.
Given a max Price, it should be able to return a List of all available Cars at or under that price.
Given a make and model, it should be able to return a List of all the available Cars.
Given a VIN and a discount amount (i.e. 15%), this method should discount the car's price (updating the official price records of that car), 
    and then return the new final price.
If there is no car that matches, it should throw a NoSuchCarException
Given a VIN and a cash Amount, it should 'buy' - checking if the price matches, removing the car from the lot, and returning the associated CarKey.
If there is no car that matches, it should throw a NoSuchCarException
If they gave too much money, it should throw an OverpaidPriceException
If they gave too little money, it should throw an UnderpaidPriceException
*/
package com.sg.m3carlot.service;

import com.sg.m3carlot.dto.Car;
import com.sg.m3carlot.dto.CarKey;
import java.math.BigDecimal;
import java.util.List;


public class CarLotServiceImpl implements CarLotService {

    @Override
    public Car getACar(String VIN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Car> getAllCars() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
