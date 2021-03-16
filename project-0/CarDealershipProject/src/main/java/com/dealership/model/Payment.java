package com.dealership.model;

import java.util.Objects;

public class Payment {

    private Integer id;
    private Double paymentAmount;
    private Double vehicleBalance;
    private Double purchasePrice;
    private String vehicleId;
    private Integer userId;

    public Payment() {
    }

    public Payment(Double paymentAmount, Double vehicleBalance, Double purchasePrice, String vehicleId, Integer userId) {
        this.paymentAmount = paymentAmount;
        this.vehicleBalance = vehicleBalance;
        this.purchasePrice = purchasePrice;
        this.vehicleId = vehicleId;
        this.userId = userId;
    }

    public Payment(Integer id, Double paymentAmount, Double vehicleBalance, Double purchasePrice, String vehicleId, Integer userId) {
        this.id = id;
        this.paymentAmount = paymentAmount;
        this.vehicleBalance = vehicleBalance;
        this.purchasePrice = purchasePrice;
        this.vehicleId = vehicleId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getVehicleBalance() {
        return vehicleBalance;
    }

    public void setVehicleBalance(Double vehicleBalance) {
        this.vehicleBalance = vehicleBalance;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getId(), payment.getId()) && Objects.equals(getPaymentAmount(), payment.getPaymentAmount()) && Objects.equals(getVehicleBalance(), payment.getVehicleBalance()) && Objects.equals(getPurchasePrice(), payment.getPurchasePrice()) && Objects.equals(getVehicleId(), payment.getVehicleId()) && Objects.equals(getUserId(), payment.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPaymentAmount(), getVehicleBalance(), getPurchasePrice(), getVehicleId(), getUserId());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentAmount=" + paymentAmount +
                ", vehicleBalance=" + vehicleBalance +
                ", purchasPrice=" + purchasePrice +
                ", vehicleId='" + vehicleId + '\'' +
                ", userId=" + userId +
                '}';
    }
}
