/**
 * Author : PhearunPhin
 * Date : 7/26/2023
 */

package com.phearun.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String status;
    private String message;
}
