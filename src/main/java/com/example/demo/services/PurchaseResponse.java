package com.example.demo.services;

import lombok.*;
import com.example.demo.entities.Cart;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class PurchaseResponse {

    private final String orderTrackingNumber;
}
