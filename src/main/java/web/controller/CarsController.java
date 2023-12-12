package web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.models.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    CarService carService = new CarServiceImpl();

    Car car1 = new Car("Model 1", "Good", 1);
    Car car2 = new Car("Model 2", "Bad", 3);
    Car car3 = new Car("Model X", "Good", 7);
    Car car4 = new Car("Model S", "Perfect", 1);
    Car car5 = new Car("Model L", "Good", 4);


    @GetMapping(value = "/cars")
    public String printCars(ModelMap model){
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        model.addAttribute("cars", cars);

        return "cars";
    }

    @GetMapping(value = "/cars/count={carsNumber}")
    public String printCarsByNumber (@PathVariable("carsNumber") int carsNumber, ModelMap model){
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        List<Car> carsListByNumber = carService.CarListOutput(cars, carsNumber);

        model.addAttribute("cars", carsListByNumber);

        return "cars";
    }
}
