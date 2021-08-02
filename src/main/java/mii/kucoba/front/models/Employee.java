/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.kucoba.front.models;

import java.util.List;
import lombok.*;

/**
 *
 * @author abiyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    
    private Integer id;
    private String name;
    private String last_name;
    private String email;
    private String address;
    private Department department;
    private List<Project> projects;
    
}
