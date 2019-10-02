package com.hanwu.hill.api;

import java.util.ArrayList;
import java.util.List;

import com.hanwu.hill.response.ApiResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TestApi.java
 *
 * @author Stefan
 */
@Controller
@RequestMapping(value="/test")
public class TestApi {

    @ResponseBody
    @GetMapping(value = "/api")
    public ApiResponse<?> testGetApi() {
        List<String> testList = new ArrayList<>();
        testList.add("test1");
        testList.add("test2");
        testList.add("test3");
        return ApiResponse.triggerSuccess(testList);
    }
}
