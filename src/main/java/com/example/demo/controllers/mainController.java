/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.dto.TableDataDTO;
import com.example.demo.dto.VehicleDetailsDTO;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.AddService;
import com.example.demo.service.RetrieveService;

/**
 *
 * @author dilshan
 */
@Controller
@RequestMapping("/home")
public class mainController {

    @Autowired
    private AddService addService;
    @Autowired
    private RetrieveService retrieveService;

    @GetMapping(value = "/view")
    public String viewAccountInfo(HttpSession session, Model model) {
        return "home/home";

    }

    @PostMapping(value = "/addVehicleDetails")
    @ResponseBody
    public boolean addVehicleDetails(VehicleDetailsDTO vehicleDetailsDTO) {
       return addService.addNewVehicleDetails(vehicleDetailsDTO);
    }

    @PostMapping(value = "/getVehicleDetails")
    @ResponseBody
    public TableDataDTO getVehicleDetails() {
        return retrieveService.getVehicleDetails();
    }

}
