package org.example.demobarbershop.service;

import org.example.demobarbershop.model.Payment;
import org.example.demobarbershop.model.Result;
import org.example.demobarbershop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getById(Integer id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Result update(Integer id, Payment updatedPayment) {
        Payment existingPayment = paymentRepository.findById(id).orElse(null);
        if (existingPayment == null) {
            return new Result(false, "Payment not found");
        }
        existingPayment.setAmount(updatedPayment.getAmount());
        paymentRepository.save(existingPayment);
        return new Result(true, "Payment updated successfully");
    }

    public Result delete(Integer id) {
        if (!paymentRepository.existsById(id)) {
            return new Result(false, "Payment not found");
        }
        paymentRepository.deleteById(id);
        return new Result(true, "Payment deleted successfully");
    }

}
