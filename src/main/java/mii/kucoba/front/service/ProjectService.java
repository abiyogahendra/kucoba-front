/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.kucoba.front.service;

import java.util.List;
import mii.kucoba.front.models.Employee;
import mii.kucoba.front.models.Project;
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
public class ProjectService {
   
    private RestTemplate restTemplate;
    
    @Value("${api.backend}/project")
    private String baseUrl;

    public ProjectService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<Project> getAllProject(){
        ResponseEntity<List<Project>> res = restTemplate.exchange(baseUrl, 
                HttpMethod.GET, null,new ParameterizedTypeReference<List<Project>>(){});
        return res.getBody();
    }
    
    public Project createDataProject(Project project){
        ResponseEntity<Project> proj = restTemplate.postForEntity(baseUrl, project, Project.class);
        return proj.getBody();
    }
    
    public String deleteDataProject(Integer projectId){
        restTemplate.delete(baseUrl +"/"+ projectId, Project.class);
        return "done";
    }
    
    public Project getProjectById(Integer projectId){
        ResponseEntity<Project> proj = restTemplate.getForEntity(baseUrl + "/" + projectId, Project.class);
        return proj.getBody();
    }
    
    public String updateDataProject(Integer idProject, Project project){
        restTemplate.put(baseUrl + "/" + idProject, project, Project.class);
        return "done";
    }
    
    
    
    
    
}
