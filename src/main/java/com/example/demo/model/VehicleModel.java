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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author dilshan
 */
@Entity
@Table(name="vehicle_model")
@Data
public class VehicleModel {
    @Id @GeneratedValue(strategy=IDENTITY)
    private Integer id;
    @Column(name = "vehicle_brand_id")
    private Integer vehicleBrandId;
    @Column(name = "vehicle_model")
    private String vehicleModel;
    
    @ManyToOne
    @JoinColumn(name="vehicle_brand_id",insertable = false,updatable = false)
    private VehicleBrand vehicleBrand;

    public VehicleModel(Integer id, Integer vehicleBrandId, String vehicleModel) {
        this.id = id;
        this.vehicleBrandId = vehicleBrandId;
        this.vehicleModel = vehicleModel;
    }

    public VehicleModel() {
    }
    
    
}
