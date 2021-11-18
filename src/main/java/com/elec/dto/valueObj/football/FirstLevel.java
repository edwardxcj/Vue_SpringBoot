package com.elec.dto.valueObj.football;

import lombok.Data;

import java.io.Serializable;

@Data
public class FirstLevel<T> implements Serializable {
    private T get;
    private T parameters;
    private T errors;
    private T paging;
    private T response;

}