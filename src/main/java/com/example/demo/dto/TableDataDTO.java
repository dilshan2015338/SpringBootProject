/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dto;

import java.util.List;
import lombok.Data;

/**
 *
 * @author dilshan
 */
@Data
public class TableDataDTO {
    private List<String> vehicleBrandsAndModels;
    private List<CountDTO> countDTOList ;
}
