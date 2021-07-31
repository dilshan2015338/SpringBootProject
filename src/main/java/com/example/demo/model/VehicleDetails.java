/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author dilshan
 */
@Entity
@Table(name="vehicle_details")
@Data
public class VehicleDetails {
    
    @Id @GeneratedValue(strategy=IDENTITY)
    private Integer id;
    @Column(name = "vehicle_model_id")
    private Integer vehicleModelId;
    @Column(name = "year")
    private Integer modelYear;
    @Column(name = "count")
    private Integer vehicleCount;
    
    @OneToOne
    @JoinColumn(name="vehicle_model_id",insertable = false,updatable = false)
    private VehicleModel vehicleModel;

    public VehicleDetails(Integer id, Integer vehicleModelId, Integer modelYear, Integer vehicleCount, VehicleModel vehicleModel) {
        this.id = id;
        this.vehicleModelId = vehicleModelId;
        this.modelYear = modelYear;
        this.vehicleCount = vehicleCount;
        this.vehicleModel = vehicleModel;
    }


    public VehicleDetails() {
    }
    
    
    
    
    
}
