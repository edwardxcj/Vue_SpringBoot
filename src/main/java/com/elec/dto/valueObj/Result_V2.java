package com.elec.dto.valueObj;

import lombok.Data;

import java.io.Serializable;


@Data
public final class Result_V2<T> implements Serializable {

    private int status;
    private T time;
    private T games;
    private T skip;
    private T results;

    public Result_V2() {
        status = 400;
    }

    public Result_V2(T results) {
        status = 200;
        this.results = results;
    }

    public Result_V2(int status, T results) {
        this.status = status;
        this.results = results;
    }
    public static <T> Result_V2<T> succeed() {
        return new Result_V2(200);
    }
    public static <T> Result_V2<T> succeed(T results) {
        return new Result_V2<T>(200, results);
    }

}
