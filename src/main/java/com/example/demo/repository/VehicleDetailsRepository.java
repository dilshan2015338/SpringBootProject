/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.VehicleDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dilshan
 */
@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Integer> {

    VehicleDetails findByVehicleModelIdAndModelYear(Integer modelId,Integer modelYear);

    @Query(
            nativeQuery = true,
            value = "Select Distinct(year) From vehicle_details order by year"
    )
    List<Integer> findDistinctModelYear();

    @Query(
            nativeQuery = true,
            value = "select sum(count) from vehicle_details where year=:year group by vehicle_model_id having vehicle_model_id=:vehicleModelId")
    Integer getSumOfCountForModelName(Integer year, Integer vehicleModelId);

}
