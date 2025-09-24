package io.localhost.springsecurityintro.service;

import io.localhost.springsecurityintro.model.Car;
import io.localhost.springsecurityintro.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.findAll();
    }

    public Car save(Car car){
        return carRepository.save(car);
    }

}
