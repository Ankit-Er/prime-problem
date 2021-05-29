package com.prime.controller;

import com.prime.RestPrimeApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prime")
public class HomeController {

    /*
        => here i'm creating only one get-request which will give you all updated
           prime numbers.

        => manger and worker execution hidden so here i am not creating any handler for that

        NOTE:
       ======
        -> this get-method will give you prime no. when you hit from URL or Postman
        -> it will not give you all prime no. in one time because execution
           going on backend when it complete all the 5 million numbers
        -> then this handler provide you all the prime no. in b/w [1 to 5 million]
           using same handler url : http://localhost:8080/prime/
        -> followed producer & consumer approach...
    **/

    // [ URL : http://localhost:8080/prime/ ]

    @GetMapping("/")
    public List<Integer> getPrimeNumbers(){
        return RestPrimeApplication.primeNumbers;
    }
}
