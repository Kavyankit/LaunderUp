package com.launderup.LaunderUp_Backend.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Table("orders")
public class Order {
    @Id
    private Long orderId;
    @Column
    private Long customerId;
    @Column
    private Long partnerId; // Nullable until a partner is assigned
    @Column
    private OrderStatus status;
    @Column("scheduled_pickup_time")
    private LocalDateTime scheduledPickupTime;
    @Column("scheduled_delivery_time")
    private LocalDateTime scheduledDeliveryTime;
    @Column
    private Double totalCost;
    @Column("payment_status")
    private PaymentStatus paymentStatus;
    @Column("payment_details")
    private String paymentDetails;
    @Column
    private Address pickupAddress;
    @Column
    private Address deliveryAddress;
    @CreatedDate
    @Column
    private LocalDateTime orderCreatedAt;
    @Column
    private LocalDateTime orderUpdatedAt;
    @Column
    private boolean washingServiceNeeded;
    @Column
    private boolean ironingServiceNeeded;
    @Column
    private boolean dryCleaningServiceNeeded;
    @Column
    private boolean steamingServiceNeeded;
    @Column
    private boolean washingAndIroningServiceNeeded;

    @Column
    private Double washingQuantity;
    @Column
    private Double ironingQuantity;
    @Column
    private Double dryCleaningQuantity;
    @Column
    private Double steamingQuantity;
    @Column
    private Double washingAndIroningQuantity;

    public void reschedule(LocalDateTime newPickupTime, LocalDateTime newDeliveryTime) {
        this.scheduledPickupTime = newPickupTime;
        this.scheduledDeliveryTime = newDeliveryTime;
        this.orderUpdatedAt = LocalDateTime.now(); // Update the timestamp
    }

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
