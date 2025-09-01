package com.surya.kafka;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    private Long patientId;
    private String userEmail; // optional, can fetch from Patient Service
    private double amount;
    private String status;  // SUCCESS or FAIL
    private String message;
}
