package com.kodlamaio.core.utilities.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    boolean success;
    String message;

    public Result (boolean success){
        this.success=success;
    }

    public Result(String message){
        this.message=message;
    }

}
