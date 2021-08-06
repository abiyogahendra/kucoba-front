/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.kucoba.front.controllers.department;

import java.util.List;
import mii.kucoba.front.models.Department;
import mii.kucoba.front.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author abiyo
 */
@Controller
@RequestMapping("/department")
public class ConfigurationController {
    
    private DepartmentService departmentService;

    @Autowired
    public ConfigurationController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    @GetMapping("/create-modal")
    public String createModal(Model model){
        return ("layout/modal/department/create");
    }
    
    @GetMapping("/update-modal/{id}")
    public String updateModal(Model model,@PathVariable("id") Integer id){
        Department d = departmentService.getDepartmentById(id);
        model.addAttribute("dept",d);
        return ("layout/modal/department/update");
    }
    
    @GetMapping("/get-data-department")
    public @ResponseBody List<Department> getAllDataDepartment(Model model){
        List<Department> data = departmentService.getDepartmentData();
        return data;
    }
    
}
