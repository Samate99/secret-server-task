package com.example.demo.service;

import com.example.demo.dto.SecretCreateRequest;
import com.example.demo.dto.SecretResponse;



public interface SecretService {

    SecretResponse createSecret(SecretCreateRequest secretCreateRequest);
    SecretResponse readSecret(String hash);

}
