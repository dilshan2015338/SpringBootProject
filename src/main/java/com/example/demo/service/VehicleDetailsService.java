/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.VehicleDetails;

/**
 *
 * @author dilshan
 */
public interface VehicleDetailsService {
    
    VehicleDetails checkVehicleDetailsExistancy(VehicleDetails vehicleDetails);
    VehicleDetails saveVehicleDetails(VehicleDetails vehicleDetails);
    Integer getSumOfCountForModelName(Integer year, Integer modelId);
    
}
