package com.prime.worker;

import com.prime.RestPrimeApplication;
import com.prime.VO.Range;
import com.prime.service.ServiceLayer;

import java.util.List;

//it will process and check prime all primeNumbers which will be created by manager's task(range)
public class TaskWorker extends Thread {

    private ServiceLayer serviceLayer;

    public TaskWorker() {
        this.serviceLayer = new ServiceLayer();
    }

    @Override
    public void run() {

        while (RestPrimeApplication.TOTAL_RANGE > -1) {

            synchronized (RestPrimeApplication.range) {
                if (!RestPrimeApplication.range.isEmpty()) {
                    serviceLayer.checkPrimeNumber(prepareRange(RestPrimeApplication.range));
                    RestPrimeApplication.range.clear();
                    RestPrimeApplication.range.notifyAll();     //notify manager to create range
                    System.out.println("Added Prime Num...");
                    //System.out.println(RestPrimeApplication.primeNumbers);
                }else{
                    try {
                        RestPrimeApplication.range.wait();      //range is there then thread will be in waiting
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
    }

    private Range prepareRange(List<Integer> r){
        Range range = new Range();
        range.setStart(r.get(0));
        range.setEnd(r.get(1));
        return range;
    }
}
