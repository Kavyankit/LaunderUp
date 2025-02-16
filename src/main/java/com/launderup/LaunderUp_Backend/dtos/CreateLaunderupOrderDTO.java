package com.launderup.LaunderUp_Backend.dtos;

import com.launderup.LaunderUp_Backend.models.Address;
import com.launderup.LaunderUp_Backend.models.OrderStatus;
import com.launderup.LaunderUp_Backend.models.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDTO {
    private Long orderId;
    private Long customerId;
    private Long partnerId; // Nullable until a partner is assigned
    private OrderStatus status;
    private LocalDateTime scheduledPickupTime;
    private LocalDateTime scheduledDeliveryTime;
    private Double totalCost;
    private PaymentStatus paymentStatus;
    private Address pickupAddress;
    private Address deliveryAddress;
    private LocalDateTime orderCreatedAt;
    private LocalDateTime orderUpdatedAt;

    private boolean washingServiceNeeded;
    private boolean ironingServiceNeeded;
    private boolean dryCleaningServiceNeeded;
    private boolean steamingServiceNeeded;
    private boolean washingAndIroningServiceNeeded;

    private Double washingQuantity;
    private Double ironingQuantity;
    private Double dryCleaningQuantity;
    private Double steamingQuantity;
    private Double washingAndIroningQuantity;


    public Long getOrderId() {
        return this.orderId;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public Long getPartnerId() {
        return this.partnerId;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public LocalDateTime getScheduledPickupTime() {
        return this.scheduledPickupTime;
    }

    public LocalDateTime getScheduledDeliveryTime() {
        return this.scheduledDeliveryTime;
    }

    public Double getTotalCost() {
        return this.totalCost;
    }

    public PaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }

    public Address getPickupAddress() {
        return this.pickupAddress;
    }

    public Address getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public LocalDateTime getOrderCreatedAt() {
        return this.orderCreatedAt;
    }

    public LocalDateTime getOrderUpdatedAt() {
        return this.orderUpdatedAt;
    }

    public boolean isWashingServiceNeeded() {
        return this.washingServiceNeeded;
    }

    public boolean isIroningServiceNeeded() {
        return this.ironingServiceNeeded;
    }

    public boolean isDryCleaningServiceNeeded() {
        return this.dryCleaningServiceNeeded;
    }

    public boolean isSteamingServiceNeeded() {
        return this.steamingServiceNeeded;
    }

    public boolean isWashingAndIroningServiceNeeded() {
        return this.washingAndIroningServiceNeeded;
    }

    public Double getWashingQuantity() {
        return this.washingQuantity;
    }

    public Double getIroningQuantity() {
        return this.ironingQuantity;
    }

    public Double getDryCleaningQuantity() {
        return this.dryCleaningQuantity;
    }

    public Double getSteamingQuantity() {
        return this.steamingQuantity;
    }

    public Double getWashingAndIroningQuantity() {
        return this.washingAndIroningQuantity;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setScheduledPickupTime(LocalDateTime scheduledPickupTime) {
        this.scheduledPickupTime = scheduledPickupTime;
    }

    public void setScheduledDeliveryTime(LocalDateTime scheduledDeliveryTime) {
        this.scheduledDeliveryTime = scheduledDeliveryTime;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPickupAddress(Address pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setOrderCreatedAt(LocalDateTime orderCreatedAt) {
        this.orderCreatedAt = orderCreatedAt;
    }

    public void setOrderUpdatedAt(LocalDateTime orderUpdatedAt) {
        this.orderUpdatedAt = orderUpdatedAt;
    }

    public void setWashingServiceNeeded(boolean washingServiceNeeded) {
        this.washingServiceNeeded = washingServiceNeeded;
    }

    public void setIroningServiceNeeded(boolean ironingServiceNeeded) {
        this.ironingServiceNeeded = ironingServiceNeeded;
    }

    public void setDryCleaningServiceNeeded(boolean dryCleaningServiceNeeded) {
        this.dryCleaningServiceNeeded = dryCleaningServiceNeeded;
    }

    public void setSteamingServiceNeeded(boolean steamingServiceNeeded) {
        this.steamingServiceNeeded = steamingServiceNeeded;
    }

    public void setWashingAndIroningServiceNeeded(boolean washingAndIroningServiceNeeded) {
        this.washingAndIroningServiceNeeded = washingAndIroningServiceNeeded;
    }

    public void setWashingQuantity(Double washingQuantity) {
        this.washingQuantity = washingQuantity;
    }

    public void setIroningQuantity(Double ironingQuantity) {
        this.ironingQuantity = ironingQuantity;
    }

    public void setDryCleaningQuantity(Double dryCleaningQuantity) {
        this.dryCleaningQuantity = dryCleaningQuantity;
    }

    public void setSteamingQuantity(Double steamingQuantity) {
        this.steamingQuantity = steamingQuantity;
    }

    public void setWashingAndIroningQuantity(Double washingAndIroningQuantity) {
        this.washingAndIroningQuantity = washingAndIroningQuantity;
    }
}
