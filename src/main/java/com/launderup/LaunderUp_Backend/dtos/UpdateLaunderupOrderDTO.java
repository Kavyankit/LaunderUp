package com.launderup.LaunderUp_Backend.dtos;

import com.launderup.LaunderUp_Backend.models.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderDTO {
    private Long orderId; // Required to identify the order
    private OrderStatus status; // Allow updates to status
    private LocalDateTime scheduledPickupTime; // Allow rescheduling
    private LocalDateTime scheduledDeliveryTime; // Allow rescheduling
    private Long partnerId; // Allow assigning or changing the partner

}
