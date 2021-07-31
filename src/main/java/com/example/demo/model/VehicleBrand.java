/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author dilshan
 */
@Entity
@Table(name="vehicle_brand")
@Data
public class VehicleBrand {
    
    @Id @GeneratedValue(strategy=IDENTITY)
    private Integer id;
    @Column(name = "vehicle_brand")
    private String vehicleBrand;
    
    @OneToMany
    @JoinColumn(name="vehicle_brand_id",referencedColumnName = "id",insertable = false,updatable = false)
    private List<VehicleModel> vehicleModelList;

    public VehicleBrand(Integer id, String vehicleBrand) {
        this.id = id;
        this.vehicleBrand = vehicleBrand;
    }

    public VehicleBrand() {
    }
    
    
    
}
