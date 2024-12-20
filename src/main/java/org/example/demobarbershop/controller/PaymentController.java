package org.example.demobarbershop.controller;

import org.example.demobarbershop.model.Payment;
import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable Integer id) {
        return paymentService.getById(id);
    }

    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Payment payment) {
        return paymentService.update(id, payment);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return paymentService.delete(id);
    }
}
