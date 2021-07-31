/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.serviceImpl;

import com.example.demo.model.VehicleDetails;
import com.example.demo.repository.VehicleDetailsRepository;
import com.example.demo.service.VehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dilshan
 */
@Service
public class VehicleDetailsServiceImpl implements VehicleDetailsService{
    
    @Autowired
    private VehicleDetailsRepository vehicleDetailsRepository;
    
    public VehicleDetails checkVehicleDetailsExistancy(VehicleDetails vehicleDetails){
        return vehicleDetailsRepository.findByVehicleModelIdAndModelYear(vehicleDetails.getVehicleModelId(), vehicleDetails.getModelYear());
    }
    
    public VehicleDetails saveVehicleDetails(VehicleDetails vehicleDetails){
        return vehicleDetailsRepository.save(vehicleDetails);
    }
    
    public Integer getSumOfCountForModelName(Integer year, Integer modelId){
        return vehicleDetailsRepository.getSumOfCountForModelName(year, modelId);
    }
    
}
