package com.surya.kafka;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentProducer paymentProducer;

    private final PatientClient patientClient;
    
    @PostMapping
    public Payment makePayment(@RequestBody Payment payment) {
        Patient patient = patientClient.getPatientById(payment.getPatientId());
        payment.setUserEmail(patient.getEmail());

        if(payment.getAmount() <= 0) {
            payment.setStatus("FAIL");
            payment.setMessage("Payment failed! Invalid amount: " + payment.getAmount());
        } else {
            payment.setStatus("SUCCESS");
            payment.setMessage("Your payment of " + payment.getAmount() + " is successful!");
        }

        paymentProducer.sendPayment(payment); // send Kafka message
        return payment;
    }

}
