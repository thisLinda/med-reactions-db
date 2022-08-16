package com.forlizzi.medication.controller.user;

import com.forlizzi.medication.entity.user.UserMedList;
import com.forlizzi.medication.entity.user.UserMedListRequest;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

@Validated
@RequestMapping("/usermedlist")
@OpenAPIDefinition(info = @Info(title = "User Med List Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})
public interface UserMedListController {

  //    @formatter:off
  @Operation(
      summary = "Returns a user and a medication",
      description = "Returns a user and a medication.",
      responses = {
        @ApiResponse(
            responseCode = "201",
            description = "The created user/med is returned",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = UserMedList.class))),
        @ApiResponse(
            responseCode = "400",
            description = "The request parameters are invalid",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404",
            description = "A user/med component was not found with the input criteria",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "An unplanned error occurred",
            content = @Content(mediaType = "application/json"))
      })
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  UserMedList createUserMedList(@RequestBody @Valid UserMedListRequest userMedListRequest);
    //    @formatter:on

}