/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.kucoba.front.models.request;

import lombok.*;

/**
 *
 * @author abiyo
 */
@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReturnMessage {
    
    private String response;
    
    private Integer code;

    public ReturnMessage(String response, Integer code) {
        this.response = response;
        this.code = code;
    }
    
    
}
