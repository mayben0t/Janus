package com.example.wcnm.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class Roles {

    @Tolerate
    public Roles(){}

    private Integer id;
    private String roleName;
    private String roleDesc;

}
