package com.herokuapp.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://reqres.in/";

         response =given()
                 .when()
                 .get("/api/users?page=2")
                 .then().statusCode(200);
    }



    @Test
    public void test001() {
        int page=response.extract().path("page");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of page is : "+page);
        System.out.println("------------------End of Test---------------------------");

    }


    @Test
    public void test002() {
        int per_page=response.extract().path("per_page");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of per_page is : "+per_page);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test003() {
        int date1ID=response.extract().path("data[1].id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[1].id  is : "+ date1ID);
        System.out.println("------------------End of Test---------------------------");
    }


    @Test
    public void test004() {

       String data3Name= response.extract().path("data[3].first_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[3].first_name : "+ data3Name);
        System.out.println("------------------End of Test---------------------------");

    }


    @Test
    public void test005() {
        List<Object> listOfData= response.extract().path("data");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("list of data  : " +listOfData.size());
        System.out.println("------------------End of Test---------------------------");
    }


    @Test
    public void test006() {

        String avatar= response.extract().path("data[5].avatar");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[5].avatar is : "+avatar);
        System.out.println("------------------End of Test---------------------------");
    }


    @Test
    public void test007() {
        String perpage=response.extract().path("support.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" support.url is " + perpage);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test008() {
        String text=response.extract().path("support.text");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("support.txt is : "+ text);
        System.out.println("------------------End of Test---------------------------");
    }

}
