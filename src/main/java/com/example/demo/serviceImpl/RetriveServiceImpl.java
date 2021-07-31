/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.serviceImpl;

import com.example.demo.dto.CountDTO;
import com.example.demo.dto.TableDataDTO;
import com.example.demo.model.VehicleBrand;
import com.example.demo.model.VehicleModel;
import com.example.demo.repository.VehicleDetailsRepository;
import com.example.demo.service.RetrieveService;
import com.example.demo.service.VehicleBrandService;
import com.example.demo.service.VehicleModelService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dilshan
 */
@Service
public class RetriveServiceImpl implements RetrieveService {

    @Autowired
    private VehicleDetailsRepository vehicleDetailsRepository;
    @Autowired
    private VehicleBrandService brandService;
    @Autowired
    private VehicleModelService modelService;

    public TableDataDTO getVehicleDetails() {
        TableDataDTO tableDataDTO = new TableDataDTO();
        List<String> vehicleBrandAndModelList = new ArrayList<>();
        vehicleBrandAndModelList = this.getBrandAndModelNames();
        List<CountDTO> countDTOList = new ArrayList<>();
        for (Iterator<Integer> it = vehicleDetailsRepository.findDistinctModelYear().iterator(); it.hasNext();) {
            Integer year = it.next();
            CountDTO countDTO = new CountDTO();
            List<Integer> countList = new ArrayList<>();
            countList.add(year);
            modelService.findAll().stream().map((vehicleModel) -> vehicleDetailsRepository
                    .getSumOfCountForModelName(year, vehicleModel.getId())).map((sumOfCount) -> {
                        Integer sum = 0;
                        if (sumOfCount != null) {
                            sum = sumOfCount;
                        }
                        return sum;
                    }).forEachOrdered((sum) -> {
                        countList.add(sum);
                    });
            for (VehicleBrand vehicleBrand : brandService.findAll()) {
                Integer brandCountSum = 0;
                brandCountSum = vehicleBrand.getVehicleModelList().stream().map((vehicleModel) -> vehicleDetailsRepository
                        .getSumOfCountForModelName(year, vehicleModel.getId())).map((sumOfCount) -> {
                            Integer sum = 0;
                            if (sumOfCount != null) {
                                sum = sumOfCount;
                            }
                            return sum;
                        }).map((sum) -> sum).reduce(brandCountSum, Integer::sum);
                countList.add(brandCountSum);
            }
            countDTO.setCountList(countList);
            countDTOList.add(countDTO);
        }
        tableDataDTO.setVehicleBrandsAndModels(vehicleBrandAndModelList);
        tableDataDTO.setCountDTOList(countDTOList);
        return tableDataDTO;

    }

    private List<String> getBrandAndModelNames() {
        List<String> brandAndModelNames = new ArrayList<>();
        brandAndModelNames.add("");
        modelService.findAll().forEach((vehicleModel) -> {
            brandAndModelNames.add(vehicleModel.getVehicleModel());
        });
        brandService.findAll().forEach((vehicleBrand) -> {
            brandAndModelNames.add(vehicleBrand.getVehicleBrand());
        });
        
        return brandAndModelNames;

    }

}
