package com.example.demo.dto;

import lombok.Data;

@Data
public class SecretCreateRequest {

    private String secret;
    private Integer expireAfterViews ;
    private Integer expireAfter ;

}

