/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dilshan
 */
@Repository
public interface VehicleModelRepository extends JpaRepository<VehicleModel, Integer>{
    
    VehicleModel findByVehicleModelIgnoreCase(String vehicleModel);
    VehicleModel findByVehicleBrandId(Integer vehicleBrandId);
    
}
