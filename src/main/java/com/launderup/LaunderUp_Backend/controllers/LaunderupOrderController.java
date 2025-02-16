package com.launderup.LaunderUp_Backend.controllers;

import com.launderup.LaunderUp_Backend.dtos.CreateOrderDTO;
import com.launderup.LaunderUp_Backend.dtos.OrderResponseDTO;
import com.launderup.LaunderUp_Backend.models.PaymentStatus;
import com.launderup.LaunderUp_Backend.services.LaunderupOrderService;
import com.launderup.LaunderUp_Backend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private LaunderupOrderService launderupOrderService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OrderResponseDTO> createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        return launderupOrderService.createOrder(createOrderDTO);
    }

    @GetMapping("/{orderId}")
    public Mono<OrderResponseDTO> getOrderById(@PathVariable Long orderId) {
        return launderupOrderService.getOrderById(orderId);
    }

    @GetMapping("/history/customer/{customerId}")
    public Flux<OrderResponseDTO> getCustomerOrderHistory(@PathVariable Long customerId) {
        return launderupOrderService.getCustomerOrderHistory(customerId);
    }

    @GetMapping("/history/partner/{partnerId}")
    public Flux<OrderResponseDTO> getPartnerOrderHistory(@PathVariable Long partnerId) {
        return launderupOrderService.getPartnerOrderHistory(partnerId);
    }

    @PutMapping("/{orderId}/status")
    public Mono<ResponseEntity<OrderResponseDTO>> updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        return launderupOrderService.updateOrderStatus(orderId, status)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/{orderId}/pay")
    public Mono<ResponseEntity<?>> initiatePayment(@PathVariable String orderId, @RequestParam double amount) {
        return paymentService.createPaymentOrder(orderId, amount)
                .map(order -> ResponseEntity.ok("Payment initiated. LaunderupOrder ID: " + order.getPaymentDetails()))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("LaunderupOrder not found")));
    }

    @PostMapping("/{orderId}/verify-payment")
    public Mono<ResponseEntity<?>> verifyPayment(@PathVariable String orderId,
                                                 @RequestParam String razorpayPaymentId,
                                                 @RequestParam String razorpaySignature) {
        return paymentService.verifyPayment(orderId, razorpayPaymentId, razorpaySignature)
                .map(order -> {
                    if (order.getPaymentStatus() == PaymentStatus.PAID) {
                        return ResponseEntity.ok("Payment verified successfully.");
                    } else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment verification failed.");
                    }
                });
    }

}
