package com.prime.service;

import com.prime.RestPrimeApplication;
import com.prime.VO.Range;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ServiceLayer {

    public Range getRandomNumber(){

        Range range = new Range();
        //range is created upto 1000 that range will be processed workers
        range.setStart(RestPrimeApplication.TOTAL_RANGE-1000);
        range.setEnd(RestPrimeApplication.TOTAL_RANGE);
        RestPrimeApplication.TOTAL_RANGE=RestPrimeApplication.TOTAL_RANGE-1000;
        range.setFlag(true);
        return range;
    }

    /*
        it may take half and hour of time....

        here checking the prime number, it's not an optimize way i know it will take more time to process.
        There are some other approach like Atkin,Eraosthenes i can see those thing and copy/paste
        but till now i don't want to fool my self therefore i've just implemented simple one, Yes
        i can learn and then implement it but i thought this is not right time so
        whatever i have just go with honesty so that's why i use pretty simple way or
        you can say silly method...

     */
    public void checkPrimeNumber(Range range){

        int i;
        for(int x = range.getStart(); x<=range.getEnd(); x++){
            boolean flag = false;
            for(i=2; i<=x; i++){
                if (x % i == 0){
                    flag=true;
                    break;
                }
            }
            if(i==x){
                //System.out.println(x);
                RestPrimeApplication.primeNumbers.add(x);   // treating as repository this list otherwise we can create separate and store within DB
            }
        }

    }

}
