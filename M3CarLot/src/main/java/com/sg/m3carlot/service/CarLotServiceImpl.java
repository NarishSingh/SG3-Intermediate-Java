/*
The above has several business based methods that must be defined!

-Given a VIN, it should be able to get a single Car.
-It should be able to get all the Cars and return them in a List.
-Given a color, it should be able to return all the available Cars of that color in a List.
-Given a max Price, it should be able to return a List of all available Cars at or under that price.
-Given a make and model, it should be able to return a List of all the available Cars.
-Given a VIN and a discount amount (i.e. 15%), this method should discount the car's price (updating the official price records of that car), 
    and then return the new final price.
--If there is no car that matches, it should throw a NoSuchCarException
-Given a VIN and a cash Amount, it should 'buy' - checking if the price matches, removing the car from the lot, and returning the associated CarKey.
--If there is no car that matches, it should throw a NoSuchCarException
--If they gave too much money, it should throw an OverpaidPriceException
--If they gave too little money, it should throw an UnderpaidPriceException
 */
package com.sg.m3carlot.service;

import com.sg.m3carlot.dao.CarLotDAO;
import com.sg.m3carlot.dao.CarLotDAOImpl;
import com.sg.m3carlot.dto.Car;
import com.sg.m3carlot.dto.CarKey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarLotServiceImpl implements CarLotService {

    private CarLotDAO dao;

    public CarLotServiceImpl(CarLotDAO dao) {
        this.dao = dao;
    }

    @Override
    public Car getACar(String VIN) throws NoSuchCarException {
        return dao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() {
        return dao.getCars();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        List<Car> fullLot = dao.getCars();
        List<Car> colorCars = new ArrayList<>();

        for (Car car : fullLot) {
            if (car.getColor().equals(color)) {
                colorCars.add(car);
            }
        }

        return colorCars;
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        List<Car> fullLot = dao.getCars();
        List<Car> budgetCars = new ArrayList<>();

        for (Car car : fullLot) {
            if (car.getPrice().compareTo(maxPrice) <= 0) {
                budgetCars.add(car);
            }
        }

        return budgetCars;
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        List<Car> fullLot = dao.getCars();
        List<Car> makeAndModelCars = new ArrayList<>();

        for (Car car : fullLot) {
            if (car.getMake().equals(make) && car.getModel().equals(model)) {
                makeAndModelCars.add(car);
            }
        }

        return makeAndModelCars;
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
        Car couponCar;
        if (dao.getCar(VIN) != null) {
            couponCar = dao.getCar(VIN);
        } else {
            throw new NoSuchCarException("No existing car in lot matches VIN");
        }

        BigDecimal listPrice = couponCar.getPrice();
        BigDecimal discount = listPrice.subtract(listPrice.multiply(percentDiscount.divide(new BigDecimal("100"))));

        couponCar.setPrice(discount);

        return discount;
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        CarKey sold = null;

        Car sale;
        if (dao.getCar(VIN) != null) {
            sale = dao.getCar(VIN);
        } else {
            throw new NoSuchCarException("No existing car in lot matches VIN");
        }

        BigDecimal salePrice = sale.getPrice();

        switch (cashPaid.compareTo(salePrice)) {
            case 1: {
                //>
                throw new OverpaidPriceException("Buyer is paying too much");
            }
            case -1: {
                //<
                throw new UnderpaidPriceException("Buyer doesn't have enough money");
            }
            default: {
                //sale successful
                Car soldCar = dao.removeCar(VIN);
                sold = soldCar.getKey();
                break;
            }
        }

        return sold;
    }

}
