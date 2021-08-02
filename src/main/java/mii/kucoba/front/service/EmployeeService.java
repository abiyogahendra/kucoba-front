/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.kucoba.front.service;

import java.util.List;
import mii.kucoba.front.models.Employee;
import mii.kucoba.front.models.request.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author abiyo
 */
@Service
public class EmployeeService {
    
    private RestTemplate restTemplate;

    @Value("${api.backend}/emp")
    private String baseUrl;
    
    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<Employee> getAll() {
        ResponseEntity<List<Employee>> res = restTemplate.exchange(baseUrl, 
                HttpMethod.GET, null,new ParameterizedTypeReference<List<Employee>>(){});
        return res.getBody();
    }
    
}
