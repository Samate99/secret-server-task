package com.example.demo.rest;

import com.example.demo.dto.SecretCreateRequest;
import com.example.demo.dto.SecretResponse;
import com.example.demo.service.SecretService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecretRestImpl implements SecretRest {

    private SecretService secretService;

    @Override
    public ResponseEntity<SecretResponse> postCreateSecret(SecretCreateRequest secretCreateRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(secretService.createSecret(secretCreateRequest));
    }

    @Override
    public ResponseEntity<SecretResponse> getSecret(String hash) {
        return ResponseEntity.status(HttpStatus.OK).body(secretService.readSecret(hash));
    }
}
