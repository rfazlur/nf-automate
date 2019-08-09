package com.utils;

import gurock.testrail.APIClient;
import gurock.testrail.APIException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestResult {

    public static String TESTRAIL_USERNAME = "fazlur.faiz.rahman@gmail.com";
    public static String TESTRAIL_PASSWORD = "C0b4d1b4c4123";
    public static String RAILS_ENGINE_URL = "https://kolamrenang.testrail.io";

    public static void addResultForTestCase(String testCaseId, int status, String error, String projId, String testRunId) throws IOException, APIException {
        APIClient client = new APIClient(RAILS_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);

        Map data = new HashMap();
        data.put("status_id", status);
        data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
        client.sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"", data);
    }
}
