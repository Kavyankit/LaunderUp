package com.launderup.LaunderUp_Backend.services;

import com.launderup.LaunderUp_Backend.dtos.CreateOrderDTO;
import com.launderup.LaunderUp_Backend.dtos.OrderResponseDTO;
import com.launderup.LaunderUp_Backend.models.Order;
import com.launderup.LaunderUp_Backend.models.OrderStatus;
import com.launderup.LaunderUp_Backend.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Mono<OrderResponseDTO> createOrder(CreateOrderDTO createOrderDTO) {
        Order order = new Order();
        order.setCustomerId(createOrderDTO.getCustomerId());
        order.setPartnerId(createOrderDTO.getPartnerId());
        order.setStatus(OrderStatus.PENDING); // Assuming an enum for statuses
        order.setTotalCost(createOrderDTO.getTotalCost());
        order.setOrderCreatedAt(LocalDateTime.now());
        order.setOrderUpdatedAt(LocalDateTime.now());
        order.setPickupAddress(createOrderDTO.getPickupAddress());
        order.setDeliveryAddress(createOrderDTO.getDeliveryAddress());
        order.setWashingServiceNeeded(createOrderDTO.isWashingServiceNeeded());
        order.setIroningServiceNeeded(createOrderDTO.isIroningServiceNeeded());
        order.setDryCleaningServiceNeeded(createOrderDTO.isDryCleaningServiceNeeded());
        order.setSteamingServiceNeeded(createOrderDTO.isSteamingServiceNeeded());
        order.setWashingAndIroningServiceNeeded(createOrderDTO.isWashingAndIroningServiceNeeded());
        order.setWashingQuantity(createOrderDTO.getWashingQuantity());
        order.setIroningQuantity(createOrderDTO.getIroningQuantity());
        order.setDryCleaningQuantity(createOrderDTO.getDryCleaningQuantity());
        order.setSteamingQuantity(createOrderDTO.getSteamingQuantity());
        order.setWashingAndIroningQuantity(createOrderDTO.getWashingAndIroningQuantity());

        return orderRepository.save(order)
                .map(this::mapToOrderResponseDTO);
    }

    public Mono<OrderResponseDTO> getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .map(this::mapToOrderResponseDTO);
    }

    public Flux<OrderResponseDTO> getCustomerOrderHistory(Long customerId) {
        return orderRepository.findByCustomerIdOrderByOrderCreatedAtDesc(customerId)
                .map(this::mapToOrderResponseDTO);
    }

    public Flux<OrderResponseDTO> getPartnerOrderHistory(Long partnerId) {
        return orderRepository.findByPartnerIdOrderByOrderCreatedAtDesc(partnerId)
                .map(this::mapToOrderResponseDTO);
    }

    public Mono<OrderResponseDTO> updateOrderStatus(Long orderId, String status) {
        return orderRepository.findById(orderId)
                .flatMap(order -> {
                    order.setStatus(OrderStatus.valueOf(status)); // Assuming an enum for statuses
                    order.setOrderUpdatedAt(LocalDateTime.now());
                    return orderRepository.save(order);
                })
                .map(this::mapToOrderResponseDTO);
    }

    private OrderResponseDTO mapToOrderResponseDTO(Order order) {
        OrderResponseDTO responseDTO = new OrderResponseDTO();
        responseDTO.setOrderId(order.getOrderId());
        responseDTO.setCustomerId(order.getCustomerId());
        responseDTO.setPartnerId(order.getPartnerId());
        responseDTO.setStatus(order.getStatus().name()); // Converting enum to string
        responseDTO.setScheduledPickupTime(order.getScheduledPickupTime());
        responseDTO.setScheduledDeliveryTime(order.getScheduledDeliveryTime());
        responseDTO.setTotalCost(order.getTotalCost());
        responseDTO.setPaymentStatus(order.getPaymentStatus().name()); // Assuming PaymentStatus is an enum
        responseDTO.setPickupAddress(order.getPickupAddress());
        responseDTO.setDeliveryAddress(order.getDeliveryAddress());
        responseDTO.setOrderCreatedAt(order.getOrderCreatedAt());
        responseDTO.setOrderUpdatedAt(order.getOrderUpdatedAt());
        responseDTO.setWashingServiceNeeded(order.isWashingServiceNeeded());
        responseDTO.setIroningServiceNeeded(order.isIroningServiceNeeded());
        responseDTO.setDryCleaningServiceNeeded(order.isDryCleaningServiceNeeded());
        responseDTO.setSteamingServiceNeeded(order.isSteamingServiceNeeded());
        responseDTO.setWashingAndIroningServiceNeeded(order.isWashingAndIroningServiceNeeded());
        responseDTO.setWashingQuantity(order.getWashingQuantity());
        responseDTO.setIroningQuantity(order.getIroningQuantity());
        responseDTO.setDryCleaningQuantity(order.getDryCleaningQuantity());
        responseDTO.setSteamingQuantity(order.getSteamingQuantity());
        responseDTO.setWashingAndIroningQuantity(order.getWashingAndIroningQuantity());
        return responseDTO;
    }
}