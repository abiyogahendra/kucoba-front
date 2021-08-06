/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.kucoba.front.controllers.department;

import mii.kucoba.front.models.Department;
import mii.kucoba.front.models.Project;
import mii.kucoba.front.models.request.ReturnMessage;
import mii.kucoba.front.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author abiyo
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    @GetMapping
    public String getAllDataDepartment(Model model){
        model.addAttribute("dept", departmentService.getDepartmentData());
        return "department/index2";
    }
    
    @GetMapping("/add")
    public String addDepartmentData(Model model){
        Department d = new Department();
        model.addAttribute("dept",d);
        return "department/add-department";
    }
    
    
    @PostMapping("/add")
    public @ResponseBody Department postDataDepartmentData(@ModelAttribute("dept") Department department){
        departmentService.createDataDepartment(department);
        return department;
    }
    
//    @GetMapping("/update/{id}")
//    public String updateDataDepartment(Model model, @PathVariable("id") Integer id){
//        Department d = departmentService.getDepartmentById(id);
//        model.addAttribute("dept",d);
//        return "department/update-department";
//    }
    
    @PutMapping("/update/{id}")
    public @ResponseBody ReturnMessage postDataUpdateDepartment(Department department, @PathVariable("id") Integer id){
        String dep = departmentService.UpdateDepartment(id,department);
        return new ReturnMessage("done",200);
    }
    
    @DeleteMapping("/delete/{id}")
    public @ResponseBody ReturnMessage postDataDeleteDepartment(@PathVariable("id") Integer id){
        departmentService.deleteDataDepartment(id);
        return new ReturnMessage("done",200);
    }
    
    
    
}
