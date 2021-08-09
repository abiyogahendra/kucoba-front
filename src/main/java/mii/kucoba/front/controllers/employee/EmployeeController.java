/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.kucoba.front.controllers.employee;

import mii.kucoba.front.service.DepartmentService;
import mii.kucoba.front.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author abiyo
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {
    
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }
    
    @GetMapping
    public String getAllEmployee(Model model){
        // model.addAttribute("employees", employeeService.getAll());
        return "employee/index2";
    }
    





    // MODAL

    @GetMapping("/create-modal")
    public String getCreateModal(Model model){
        model.addAttribute("department", departmentService.getDepartmentData());
        return "layout/modal/employee/create";
    }
    
    @GetMapping("/update-modal/{id}")
    public String getUpdateModal(Model model, @PathVariable("id") Integer id){
        model.addAttribute("department", departmentService.getDepartmentData());
        model.addAttribute("emp", employeeService.getById(id));
        return "layout/modal/employee/update";
    }
    
}
