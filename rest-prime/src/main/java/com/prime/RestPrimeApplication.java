package com.prime;

import com.prime.VO.Range;
import com.prime.manager.TaskManager;
import com.prime.worker.TaskWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class RestPrimeApplication {

	public static List<Integer> primeNumbers = new CopyOnWriteArrayList<>();	//treated as repo...
	public static List<Integer> range = new ArrayList<>(2);
	public static Integer TOTAL_RANGE = 5000000;

	public static void main(String[] args) {
		SpringApplication.run(RestPrimeApplication.class, args);


		TaskManager manager1  = new TaskManager();
		TaskWorker worker1 = new TaskWorker();
		TaskWorker worker2 = new TaskWorker();

		manager1.start();
		worker1.start();
		worker2.start();

	}

}
