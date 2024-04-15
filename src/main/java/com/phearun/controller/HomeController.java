/**
 * Author : PhearunPhin
 * Date : 8/29/2023
 */

package com.phearun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home()
    {
        return "Hello world";
    }
}
