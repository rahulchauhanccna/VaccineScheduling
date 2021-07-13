package com.vaccine.schedule.configuration;

import com.vaccine.schedule.handlers.PersonHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@Slf4j
public class RoutingConfiguration {

    private final PersonHandler personHandler;
    public RoutingConfiguration(PersonHandler personHandler){
        this.personHandler =personHandler;
    }
    

    private RouterFunction<ServerResponse> personOpenRouter(){
        return route(

        POST("api/v1"+"/getNearestVaccineInfo").and(accept(MediaType.APPLICATION_JSON)),personHandler :: getNearestVaccineSiteInfo);
    }

    @Bean
    public RouterFunction <ServerResponse> routerFunction() {
        return route()
        .add(personOpenRouter())
        .onError(e -> 
          e instanceof Exception , (e,request) -> ServerResponse.status(HttpStatus.PRECONDITION_FAILED)
          .body(BodyInserters.empty()))
        .build();
    }
}
