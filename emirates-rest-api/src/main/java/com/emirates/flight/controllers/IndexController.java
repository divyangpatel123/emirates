package com.emirates.flight.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author divyang.patel
 * The Class IndexController.
 */
@RestController
@RequestMapping("/")
public class IndexController {
    
    /**
     * Index.
     *
     * @return the string
     */
    @RequestMapping(method= RequestMethod.GET)
    String index(){
        return "index";
    }
}
