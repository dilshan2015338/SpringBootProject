package com.example.demo.serviceImpl;

import com.example.demo.dto.VehicleDetailsDTO;
import com.example.demo.model.VehicleBrand;
import com.example.demo.model.VehicleDetails;
import com.example.demo.model.VehicleModel;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.AddService;
import com.example.demo.service.VehicleBrandService;
import com.example.demo.service.VehicleDetailsService;
import com.example.demo.service.VehicleModelService;

@Service
public class AddServiceImpl implements AddService {

    @Autowired
    private VehicleModelService modelService;
    @Autowired
    private VehicleBrandService brandService;
    @Autowired
    private VehicleDetailsService vehicleDetailsService;

    public boolean addNewVehicleDetails(VehicleDetailsDTO vehicleDetailsDTO) {
        VehicleDetails savedVehicleDetails = null;
        VehicleBrand vehicleBrand = brandService.checkVehicleBrandExistance(vehicleDetailsDTO.getVehicleBrand());
        VehicleModel vehicleModel = modelService.checkVehicleModelExistance(vehicleDetailsDTO.getVehicleModel());
        try {
            //Need to check model first
            if (vehicleModel == null) {
                //Need to check brand
                if (vehicleBrand == null) {
                    //This is a new record
                    vehicleBrand = brandService.saveVehicleBrand(new VehicleBrand(null, vehicleDetailsDTO.getVehicleBrand()));
                    vehicleModel = modelService.saveVehicleModel(new VehicleModel(null, vehicleBrand.getId(), vehicleDetailsDTO.getVehicleModel()));
                } else {
                    vehicleModel = modelService.saveVehicleModel(new VehicleModel(null, vehicleBrand.getId(), vehicleDetailsDTO.getVehicleModel()));
                }
            }
            savedVehicleDetails = this.saveVehicleDetails(vehicleDetailsDTO, vehicleModel);
            if (savedVehicleDetails != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    private VehicleDetails saveVehicleDetails(VehicleDetailsDTO vehicleDetailsDTO, VehicleModel model) {
        VehicleDetails newVehicleDetails = new VehicleDetails();
        newVehicleDetails.setModelYear(vehicleDetailsDTO.getModelYear());
        newVehicleDetails.setVehicleModelId(model.getId());
        newVehicleDetails.setVehicleCount(vehicleDetailsDTO.getVehicleCount());
        VehicleDetails existingVehicleDetails = vehicleDetailsService.checkVehicleDetailsExistancy(newVehicleDetails);
        if (existingVehicleDetails != null) {
            existingVehicleDetails.setVehicleCount(vehicleDetailsDTO.getVehicleCount() + existingVehicleDetails.getVehicleCount());
            return vehicleDetailsService.saveVehicleDetails(existingVehicleDetails);
        }
        return vehicleDetailsService.saveVehicleDetails(newVehicleDetails);
    }

}
