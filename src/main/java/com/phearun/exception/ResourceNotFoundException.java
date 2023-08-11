/**
 * Author : PhearunPhin
 * Date : 7/26/2023
 */

package com.phearun.exception;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends ApiException{

    private Integer resourceId;
    private String resourceName;

    public ResourceNotFoundException(String resourceName, Integer resourceId){
        super(HttpStatus.NOT_FOUND, String.format("%s not found for id=%d",resourceName, resourceId));
    }
}
