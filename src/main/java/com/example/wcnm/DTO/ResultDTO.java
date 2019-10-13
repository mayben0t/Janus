package com.example.wcnm.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class ResultDTO<T> {

    @Tolerate
    public ResultDTO(){}
    @Builder.Default
    private Integer code=200;
    private String msg;
    private T body;

}
