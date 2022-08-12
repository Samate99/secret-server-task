package com.example.demo.rest;

import com.example.demo.dto.SecretCreateRequest;
import com.example.demo.dto.SecretResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/secret")
public interface SecretRest {

    @PostMapping
    ResponseEntity<SecretResponse> postCreateSecret(@RequestBody SecretCreateRequest secretCreateRequest);

    @GetMapping("/{hash}")
    ResponseEntity<SecretResponse> getSecret(@PathVariable String hash);
}
