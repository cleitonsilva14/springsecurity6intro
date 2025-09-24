package io.localhost.springsecurityintro.controller;

import io.localhost.springsecurityintro.model.Car;
import io.localhost.springsecurityintro.service.CarService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

//    private List<Car> cars = new ArrayList<>(List.of(
//            new Car(UUID.randomUUID(), "Elantra", "Hyundai", 2017, new BigDecimal("75.900")),
//            new Car(UUID.randomUUID(), "Creta", "Hyundai", 2021, new BigDecimal("95.900"))
//    ));

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        return new ResponseEntity<>(carService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }



}
