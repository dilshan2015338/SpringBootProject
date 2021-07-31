/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.serviceImpl;

import com.example.demo.model.VehicleModel;
import com.example.demo.repository.VehicleModelRepository;
import com.example.demo.service.VehicleModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dilshan
 */
@Service
public class VehicleModelServiceImpl implements VehicleModelService{
    
    @Autowired
    private VehicleModelRepository modelRepository;
    
    public VehicleModel checkVehicleModelExistance(String model){
        return modelRepository.findByVehicleModelIgnoreCase(model);
    }
    
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel){
        return modelRepository.save(vehicleModel);
    }
    
    public List<VehicleModel> findAll(){
        return modelRepository.findAll();
    }
    
}
