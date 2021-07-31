/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dto;

import lombok.Data;

/**
 *
 * @author dilshan
 */
@Data
public class VehicleDetailsDTO {
    
    private String vehicleBrand;
    private String vehicleModel;
    private Integer modelYear;
    private Integer vehicleCount;
    
}
