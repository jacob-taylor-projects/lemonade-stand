package com.cooksys.lemonadestand.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
@AllArgsConstructor
@Getter
@Setter
public class BadRequestException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 8717524765921018451L;

    private String message;
}
