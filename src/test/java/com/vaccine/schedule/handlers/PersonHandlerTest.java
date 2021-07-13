package com.vaccine.schedule.handlers;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.List;

import com.vaccine.schedule.model.VaccineCenterInfo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@AutoConfigureWebTestClient
@ActiveProfiles("test")
@Slf4j
public class PersonHandlerTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    public void getNearestVaccineSiteInfo(){
        VaccineSlotRequest request = new VaccineSlotRequest("132-23-322","94589");
        webTestClient.post().uri("/api/v1/getNearestVaccineInfo").contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                            .body(Mono.just(request),VaccineSlotRequest.class)
                            .exchange()
                            .expectStatus().isOk()
                            .expectBody()
                            .jsonPath("$[0].centerId").isNotEmpty()
                            .jsonPath("$[0].zipCode").isEqualTo("94589");
    }
    
}
