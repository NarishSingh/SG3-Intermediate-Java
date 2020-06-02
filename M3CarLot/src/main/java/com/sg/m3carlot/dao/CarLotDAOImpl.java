package com.sg.m3carlot.dao;

import com.sg.m3carlot.dto.Car;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarLotDAOImpl implements CarLotDAO {

    Map<String, Car> carLot = new HashMap<>();

    /*Overrides*/
    @Override
    public Car addCar(String VIN, Car car) {
        return carLot.put(VIN, car);
    }

    @Override
    public Car getCar(String VIN) {
        return carLot.get(VIN);
    }

    @Override
    public List<Car> getCars() {
        return new ArrayList<>(carLot.values());
    }

    @Override
    public void editCar(String VIN, Car car) {
        carLot.replace(VIN, car);
    }

    @Override
    public Car removeCar(String VIN) {
        return carLot.remove(VIN);
    }

}
