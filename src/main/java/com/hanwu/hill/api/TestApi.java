package com.hanwu.hill.api;

import java.util.ArrayList;
import java.util.List;

import com.hanwu.hill.response.ApiResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TestApi.java
 *
 * @author Stefan
 */
@Controller
@RequestMapping(value="/test/api")
public class TestApi {

    @ResponseBody
    @GetMapping(value = "/get.json")
    public ApiResponse<?> testGetApi() {
        List<String> testList = new ArrayList<>();
        testList.add("test1");
        testList.add("test2");
        testList.add("test3");
        return ApiResponse.triggerSuccess(testList);
    }

    @ResponseBody
    @PutMapping(value = "/put.json")
    public ApiResponse<?> testPutApi() {
        // TODO
        return null;
    }

    @ResponseBody
    @PostMapping(value = "/post.json")
    public ApiResponse<?> testPostApi() {
        // TODO
        return null;
    }

    @ResponseBody
    @DeleteMapping(value = "/delete.json")
    public ApiResponse<?> testDeleteApi() {
        // TODO
        return null;
    }
}
