/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.VehicleModel;
import java.util.List;

/**
 *
 * @author dilshan
 */
public interface VehicleModelService {
    
    VehicleModel checkVehicleModelExistance(String model);
    VehicleModel saveVehicleModel(VehicleModel vehicleModel);
    List<VehicleModel> findAll();
}
