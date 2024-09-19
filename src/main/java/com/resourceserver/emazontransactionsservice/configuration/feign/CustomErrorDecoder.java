package com.resourceserver.emazontransactionsservice.configuration.feign;

import com.resourceserver.emazontransactionsservice.configuration.exceptionhandler.exceptions.*;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        return switch (response.status()) {
            case 400 -> new BadRequestException();
            case 403 -> new AccessDeniedExceptions();
            case 401 -> new UnauthorizedException();
            case 404 -> new NotFoundException();
            case 500 -> new InternalServerErrorException();
            default -> new GenericException();
        };
    }
}
