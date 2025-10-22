package com.ityj.controller;

import com.ityj.algorithm.entity.TreeNode;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    @GetMapping("/hello/{seconds}")
    public String hello(@PathVariable("seconds") int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
        return "success";
    }

    @GetMapping("/oom/heap")
    public String testOOM_heap() {
        List<TreeNode> data = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            TreeNode treeNode = new TreeNode();
            data.add(treeNode);
        }
        return "success" + new Date() + " - " + data.size();
    }

    @GetMapping("/stackOverflowError")
    public void stackOverflowError() {
        stackOverflowError();
    }

}
