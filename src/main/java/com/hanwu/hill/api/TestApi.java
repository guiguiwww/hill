package com.hanwu.hill.api;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.hanwu.hill.response.ApiResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        testList.add("get1");
        testList.add("get2");
        testList.add("get3");
        return ApiResponse.triggerSuccess(testList);
    }

    @ResponseBody
    @PutMapping(value = "/put.json")
    public ApiResponse<?> testPutApi(@RequestBody JSONObject json) {
        List<String> testList = new ArrayList<>();
        testList.add("put1");
        testList.add("put2");
        testList.add("put3");
        return ApiResponse.triggerSuccess(testList);
    }

    @ResponseBody
    @PostMapping(value = "/post.json")
    public ApiResponse<?> testPostApi(@RequestBody JSONObject json) {
        List<String> testList = new ArrayList<>();
        testList.add("post1");
        testList.add("post2");
        testList.add("post3");
        return ApiResponse.triggerSuccess(testList);
    }

    @ResponseBody
    @DeleteMapping(value = "/delete.json")
    public ApiResponse<?> testDeleteApi(@RequestBody JSONObject json) {
        List<String> testList = new ArrayList<>();
        testList.add("delete1");
        testList.add("delete2");
        testList.add("delete3");
        return ApiResponse.triggerSuccess(testList);
    }
}
