package com.example.demo.service;

import com.example.demo.dto.SecretCreateRequest;
import com.example.demo.dto.SecretResponse;
import com.example.demo.modell.Secret;
import com.example.demo.repository.SecretRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class SecretServiceImpl implements SecretService {

    private SecretRepository secretRepository;

    @Override
    public SecretResponse createSecret(SecretCreateRequest secretCreateRequest) {
      Secret secret = new Secret();
      secret.setCreatedAt(LocalDateTime.now());
      secret.setSecretText(secretCreateRequest.getSecret());
      secret.setHash(UUID.randomUUID().toString());
      secret.setExpiresAt(LocalDateTime.now().plusMinutes(secretCreateRequest.getExpireAfter()));
      secret.setRemainingViews(secretCreateRequest.getExpireAfterViews());
      secret = secretRepository.save(secret);
        System.out.println(secret);
      return convert(secret);
    }

    @Override
    public SecretResponse readSecret(String hash) {

       Secret secret = secretRepository.findById(hash).get();
       if (secret.getExpiresAt().compareTo(LocalDateTime.now()) < 0 || secret.getRemainingViews() < 1){
           secretRepository.delete(secret);
           throw new RuntimeException("Expired");
       }
       secret.setRemainingViews(secret.getRemainingViews()-1);
       secret = secretRepository.save(secret);
       return convert(secret);
    }

    private SecretResponse convert(Secret secret){
        SecretResponse secretResponse = new SecretResponse();
        secretResponse.setSecretText(secret.getSecretText());
        secretResponse.setHash(secret.getHash());
        secretResponse.setExpiresAt(secret.getExpiresAt());
        secretResponse.setRemainingViews(secret.getRemainingViews());
        secretResponse.setCreatedAt(secret.getCreatedAt());

        return secretResponse;
    }

}
