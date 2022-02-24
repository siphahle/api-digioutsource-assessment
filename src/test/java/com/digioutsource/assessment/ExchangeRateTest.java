package com.digioutsource.assessment;

import com.absa.assessment.RestAssuredCore.BaseAssertion;
import com.absa.assessment.RestAssuredCore.RESTCalls;
import com.absa.assessment.utils.EndPoint;
import com.absa.assessment.utils.TestUtils;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;


public class ExchangeRateTest {
    private static Logger log = LogManager.getLogger(ExchangeRateTest.class.getName());
    Response response;

    @Test
    public void listAllCurrencies() {
        log.info("Verify the HTTP status is 200");
        String URI = EndPoint.getEndPoint("?results");
        response = RESTCalls.GETRequest(URI);
        System.out.println(TestUtils.getStatusMessage(response));
        System.out.println("*******************************");
        BaseAssertion.verifyStatusCode(response, 200);
        System.out.println(TestUtils.getResponseString(response));
    }
    @Test(priority = 1)
    public void verifyGbpCurrency() {
        log.info("Starting Create Issue Test");
        String URI = EndPoint.getEndPoint("?conversion_rates");
        response = RESTCalls.GETRequest(URI);
        String strResponse = TestUtils.getResponseString(response);
        BaseAssertion.verifyTrue(strResponse.contains("GBP"));
        System.out.println(TestUtils.getResponseString(response));
    }
    public void countTotalNumberOfCurrencies(){

    }

}
