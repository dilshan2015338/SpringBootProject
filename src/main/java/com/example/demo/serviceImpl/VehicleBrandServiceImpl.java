/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.serviceImpl;

import com.example.demo.model.VehicleBrand;
import com.example.demo.repository.VehicleBrandRepository;
import com.example.demo.service.VehicleBrandService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dilshan
 */
@Service
public class VehicleBrandServiceImpl implements VehicleBrandService{
    
    @Autowired
    private VehicleBrandRepository vehicleBrandRepository;
    
    public VehicleBrand checkVehicleBrandExistance(String brand){
        return vehicleBrandRepository.findByVehicleBrandIgnoreCase(brand);
    }
    
    public VehicleBrand saveVehicleBrand(VehicleBrand vehicleBrand){
        return vehicleBrandRepository.save(vehicleBrand);
    }
    
    public List<VehicleBrand> findAll(){
        return vehicleBrandRepository.findAll();
    }
    
}
