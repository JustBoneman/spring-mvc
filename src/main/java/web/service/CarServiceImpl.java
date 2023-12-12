package web.service;

import org.springframework.ui.ModelMap;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService{
    @Override
    public List<Car> CarListOutput(List<Car> cars, int carsNumber){
        List<Car> carsListByNumber = new ArrayList<>();
        if (carsNumber > cars.size()) {
            carsListByNumber = cars;
        } else {
            carsListByNumber = cars.subList(0, carsNumber);
        }
        return carsListByNumber;
    }
}
