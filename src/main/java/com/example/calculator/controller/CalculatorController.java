package com.example.calculator.controller;

import com.example.calculator.model.CalculatorRequest;
import com.example.calculator.model.CalculatorResponse;
import com.example.calculator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @PostMapping("/calculate")
    public ResponseEntity<Object> calculate(@RequestBody CalculatorRequest request) {
        try {
            double result = calculatorService.calculate(request.a(), request.b(), request.operation());
            return ResponseEntity.ok(new CalculatorResponse(result, request.operation()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
