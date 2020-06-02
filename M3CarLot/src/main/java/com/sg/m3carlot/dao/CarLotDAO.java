package com.sg.m3carlot.dao;

import com.sg.m3carlot.dto.Car;
import java.util.List;

public interface CarLotDAO {

    /**
     * Add a new car object to the car lot
     *
     * @param VIN {String} ID string for a car
     * @param car {Car} fully constructed obj
     * @return {Car|Null} if valid return the newly added car, null otherwise
     */
    public Car addCar(String VIN, Car car);

    /**
     * Get car obj from car lot
     *
     * @param VIN {String} car's unique ID
     * @return {Car|Null} the car obj associated with VIN, null otherwise
     */
    public Car getCar(String VIN);

    /**
     * Get list of all cars in the lot
     *
     * @return {List} all car obj's
     */
    public List<Car> getCars();

    /**
     * Replace car obj at a pre-existing VIN
     *
     * @param VIN {String} ID for a car currently in the lot
     * @param car {Car|Null} the newly edited car obj
     */
    public void editCar(String VIN, Car car);

    /**
     * Remove a car from the lot
     *
     * @param VIN {String} ID for a car currently in the lot
     * @return {Car|Null} the removed car, null otherwise
     */
    public Car removeCar(String VIN);
}
