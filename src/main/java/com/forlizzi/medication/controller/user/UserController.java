package com.forlizzi.medication.controller.user;

import com.forlizzi.medication.entity.user.User;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.List;


@Validated
@RequestMapping("/users")
@OpenAPIDefinition(info = @Info(title = "User Service"), servers = {
        @Server(url = "http://localhost:8083", description = "Local server.")})
public interface UserController {

    //    @formatter:off
    @Operation(
            summary = "Creates a user",
            description = "Returns the new user",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The created user is returned.",
                            content = @Content(
                                    mediaType="application/json",
                                    schema = @Schema(implementation = User.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The request parameters are invalid.",
                            content = @Content(
                                    mediaType="application/json")),
                    @ApiResponse(
                            responseCode = "404",
                            description = "A user component was not found with the input criteria.",
                            content = @Content(
                                    mediaType="application/json")),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error occurred.",
                            content = @Content(
                                    mediaType="application/json"))
            }
    )
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    int createUser(@Valid int userPK, String pseudoName, int age, String dateOfEval, @RequestParam(required =
            false) String dateOfDischarge, String medDxIcd, String txDxIcd);

    @Operation(
            summary = "Returns a list of user",
            description = "Returns a list of user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "A list of user is returned.",
                            content = @Content(
                                    mediaType="application/json",
                                    schema = @Schema(implementation = User.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The request parameters are invalid.",
                            content = @Content(
                                    mediaType="application/json")),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No users were found with the input criteria.",
                            content = @Content(
                                    mediaType="application/json")),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error occurred.",
                            content = @Content(
                                    mediaType="application/json"))
            },
            parameters = {
                    @Parameter(
                            name = "userPK",
                            allowEmptyValue = false,
                            required = true,
                            description = "userPK"),
            }
    )
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<User> getUsers(@RequestParam int userPK);
//    List<User> getUsers(@PathVariable int userPK);

    @Operation(
            summary = "Updates an existing user",
            description = "Returns a new/created user.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "The user has been updated.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = User.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The request parameters are invalid.",
                            content = @Content(
                                    mediaType = "application/json")),
                    @ApiResponse(
                            responseCode = "404",
                            description = "An user name was not found with the input criteria.",
                            content = @Content(
                                    mediaType = "application/json")),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error occurred.",
                            content = @Content(
                                    mediaType = "application/json"))
            }
    )
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    void updateUser(
                    String newPseudoName, int userPK);

    @Operation(
            summary = "Deletes a user",
            description = "Deletes a user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "The user was deleted.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = User.class))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "The request parameters are invalid.",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No users were found with the input criteria.",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(
                            responseCode = "500",
                            description = "An unplanned error occurred.",
                            content = @Content(mediaType = "application/json")),
            }
    )
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    void deleteUser(@RequestParam int userPK);

}