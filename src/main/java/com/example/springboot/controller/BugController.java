package com.example.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@Slf4j
public class BugController {
    private Integer num;

    class AddThread implements Callable<Integer> {
        private Integer num;

        public AddThread(Integer n) {
            num = n;
        }

        public Integer call() {
            for (int i=0; i<50; i++) {
                num += i;
            }
            return num;
        }
    }

    @RequestMapping("/show_bug")
    public String showBug() {
        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            List<Future<Integer>> futureList = new ArrayList<>();
            for (int i=0; i<4; i++) {
                Future<Integer> future = executor.submit(new AddThread(num));
                futureList.add(future);
            }
            int total = 0;
            for (int i=0; i<4; i++) {
                total += futureList.get(i).get();
            }
            if (total != 200) {
                return "Invalid result";
            }
            return "Success";
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
            return "Exception";
        }
    }
}
