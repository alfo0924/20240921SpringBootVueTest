package org.example._20240921springbootvuetest.controller;

import org.example._20240921springbootvuetest.model.RandomNumber;
import org.example._20240921springbootvuetest.repository.RandomNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class RandomNumberController {

    @Autowired
    private RandomNumberRepository repository;

    @GetMapping("/random")
    public List<Integer> getRandomNumbers() {
        Random random = new Random();
        return IntStream.range(0, 3)
                .map(i -> random.nextInt(10) + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public void saveRandomNumbers(@RequestBody List<Integer> numbers) {
        numbers.forEach(number -> repository.save(new RandomNumber(number)));
    }

    @GetMapping("/all")
    public List<RandomNumber> getAllNumbers() {
        return repository.findAll();
    }
}
