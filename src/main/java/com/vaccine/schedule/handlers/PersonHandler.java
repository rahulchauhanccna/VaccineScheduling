package com.vaccine.schedule.handlers;

import com.vaccine.schedule.model.ApiError;
import com.vaccine.schedule.model.Person;
import com.vaccine.schedule.model.PersonHealthInfo;
import com.vaccine.schedule.model.VaccineCenterInfo;
import com.vaccine.schedule.service.PersonHealthInfoService;
import com.vaccine.schedule.service.PersonService;
import com.vaccine.schedule.service.VaccineCenterInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class PersonHandler {

    @Autowired
    PersonService personService;

    @Autowired
    PersonHealthInfoService personHealthInfoService;

    @Autowired
    VaccineCenterInfoService vaccineCenterInfoService;

	public Mono<ServerResponse> getNearestVaccineSiteInfo(ServerRequest request) {



       Mono<VaccineSlotRequest> payloadMono = request.bodyToMono(VaccineSlotRequest.class);
      return payloadMono.flatMap( slotVO -> {

         Optional<PersonHealthInfo> personHealthInfoById = personHealthInfoService.getPersonHealthInfoById(slotVO.getNationalId());
         if(personHealthInfoById.isPresent()) {
            PersonHealthInfo personHealthInfo = personHealthInfoById.get();
            if (personHealthInfo.isCovidVaccinated())
            {
                return ServerResponse.status(HttpStatus.ACCEPTED).bodyValue(ApiError.builder()
                .errorCode("402")
                .errorMessage("Person is FullyVaccinated")
                .uri(request.path()).build());
                   
            } 

            if (personHealthInfo.getAge()<18)
              {
                  return ServerResponse.status(HttpStatus.BAD_REQUEST).bodyValue(ApiError.builder()
                  .errorCode("402")
                  .errorMessage("age is less than 18 years")
                  .uri(request.path()).build());
                     
              } 

              if (personHealthInfo.isChronic())
              {
                  return ServerResponse.status(HttpStatus.BAD_REQUEST).bodyValue(ApiError.builder()
                  .errorCode("402")
                  .errorMessage("Person is Chronic more health info is needed")
                  .uri(request.path()).build());
                     
              } 
              if (personHealthInfo.isDiabetic())
              {
                  return ServerResponse.status(HttpStatus.BAD_REQUEST).bodyValue(ApiError.builder()
                  .errorCode("402")
                  .errorMessage("Person is diabetic more health info is needed")
                  .uri(request.path()).build());
                     
              } 
              List<VaccineCenterInfo> vaccineCenterInfo = vaccineCenterInfoService.getVaccineCenterInfoByZipCode(slotVO.getZipCode());
              if(!vaccineCenterInfo.isEmpty())
               {
                 return ServerResponse.ok().contentType(APPLICATION_JSON).bodyValue(vaccineCenterInfo);
               }
               else{
                return ServerResponse.status(HttpStatus.ACCEPTED).bodyValue(ApiError.builder()
                .errorCode("206")
                .errorMessage("No Vaccine Center found in your zip code")
                .uri(request.path()).build());
               }
               
        }
          return ServerResponse.status(HttpStatus.PRECONDITION_FAILED).bodyValue(ApiError.builder()
        .errorCode("ServiceError")
        .developerMessage("Error in Service")
        .uri(request.path())
        .build() );
       }).onErrorResume(error -> ServerResponse.status(HttpStatus.PRECONDITION_FAILED).bodyValue(ApiError.builder()
       .errorCode("ServiceError")
       .developerMessage(error.getMessage())
       .uri(request.path())
       .build() ));

       
      
      
    
	}
    

}
