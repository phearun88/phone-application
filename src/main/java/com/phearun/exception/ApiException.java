/**
 * Author : PhearunPhin
 * Date : 7/22/2023
 */

package com.phearun.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ApiException extends RuntimeException {

    private HttpStatus status;
    private String message;
}
