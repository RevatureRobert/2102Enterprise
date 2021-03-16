package com.dealership.model;

import java.util.Objects;

public class Offer {

    private Integer id;
    private Double offerAmount;
    private Integer userId;
    private String vehicleId;

    public Offer() {
    }

    public Offer(Double offerAmount, Integer userId, String vehicleId) {
        this.offerAmount = offerAmount;
        this.userId = userId;
        this.vehicleId = vehicleId;
    }

    public Offer(Integer id, Double offerAmount, Integer userId, String vehicleId) {
        this.id = id;
        this.offerAmount = offerAmount;
        this.userId = userId;
        this.vehicleId = vehicleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(Double offerAmount) {
        this.offerAmount = offerAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;
        Offer offer = (Offer) o;
        return Double.compare(offer.getOfferAmount(), getOfferAmount()) == 0 && Objects.equals(getId(), offer.getId()) && Objects.equals(getUserId(), offer.getUserId()) && Objects.equals(getVehicleId(), offer.getVehicleId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOfferAmount(), getUserId(), getVehicleId());
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", offerAmount=" + offerAmount +
                ", userId=" + userId +
                ", vehicleId=" + vehicleId +
                '}';
    }
}
