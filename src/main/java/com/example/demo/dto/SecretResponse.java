package com.example.demo.dto;

import lombok.Data;


import java.time.LocalDateTime;


@Data
public class SecretResponse {

    private String hash;
    private String secretText;
    private LocalDateTime createdAt    ;
    private LocalDateTime expiresAt;
    private Integer remainingViews;

}



