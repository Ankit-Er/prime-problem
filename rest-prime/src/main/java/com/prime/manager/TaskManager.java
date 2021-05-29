package com.prime.manager;

import com.prime.RestPrimeApplication;
import com.prime.VO.Range;
import com.prime.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

//it will create task(range) for workers
public class TaskManager  extends Thread {

    private ServiceLayer serviceLayer;

    public TaskManager() {
        this.serviceLayer = new ServiceLayer();
    }
    @Override
    public void run() {

        Random random = new Random();

        while (RestPrimeApplication.TOTAL_RANGE > -1) {

            synchronized (RestPrimeApplication.range) {
                if (RestPrimeApplication.range.size() < 2) {
                    Range range= serviceLayer.getRandomNumber();
                    RestPrimeApplication.range.add(range.getStart());
                    RestPrimeApplication.range.add(range.getEnd());
                    //notify worker to do your task (i know notifyAll doesn't able to identify which one is worker or manager thread that will decide by JVM but i wrote that because of understanding)
                    RestPrimeApplication.range.notifyAll();
                    System.out.println("Range Created...");
                }
                else{
                    try {
                        RestPrimeApplication.range.wait(); //thread will be in waiting
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
