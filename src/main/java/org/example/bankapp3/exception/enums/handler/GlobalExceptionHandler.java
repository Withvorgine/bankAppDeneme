package org.example.bankapp3.exception.enums.handler;

import org.example.bankapp3.exception.enums.FriendlyMessageCodes;
import org.example.bankapp3.exception.enums.exceptions.CustomerNotCreatedException;
import org.example.bankapp3.exception.enums.utils.FriendlyMessageUtils;
import org.example.bankapp3.response.FriendlyMessage;
import org.example.bankapp3.response.InternalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomerNotCreatedException.class)
    public InternalApiResponse<String> handleCreatedNotException(CustomerNotCreatedException exception){
        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), exception.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessage(Collections.singletonList(exception.getMessage()))
                .build();


    }
}
