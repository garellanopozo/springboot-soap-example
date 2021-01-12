package com.serendipiaTechnology.springbootsoapexample.endpoint;

import com.serendipiaTechnology.spring_boot_soap_example.GetUserRequest;
import com.serendipiaTechnology.spring_boot_soap_example.GetUserResponse;
import com.serendipiaTechnology.springbootsoapexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    @Autowired
    private UserService userService;

    private RestTemplate restTemplate;


    @PayloadRoot(namespace = "http://serendipiaTechnology.com/spring-boot-soap-example",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        GetUserResponse getUserResponse = restTemplate.getForEntity("http://lolcalhost:8080/User/authenticate", GetUserResponse.class, request).getBody();
        return response;
    }
}
