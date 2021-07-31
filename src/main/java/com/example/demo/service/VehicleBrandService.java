/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.VehicleBrand;
import java.util.List;

/**
 *
 * @author dilshan
 */
public interface VehicleBrandService {
    
    VehicleBrand checkVehicleBrandExistance(String brand);
    VehicleBrand saveVehicleBrand(VehicleBrand vehicleBrand); 
    List<VehicleBrand> findAll();
    
}
