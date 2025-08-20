package com.josesanchez.geminiwrapper.controller.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


import com.josesanchez.geminiwrapper.controller.ApiStatusCode;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(responseCode = ApiStatusCode.INTERNAL_SERVER_ERROR,
    description = "Internal Server Error",
    content = @Content(
        mediaType = "application/json",
        schema = @Schema(ref = "#/components/schemas/WebApiErrorResponse"))

)
public @interface InternalServerErrorResponse {
}
