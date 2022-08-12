package com.example.demo.modell;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
public class Secret {

    @Id
    private String hash;
    private String secretText;
    private LocalDateTime createdAt    ;
    private LocalDateTime expiresAt;
    private Integer remainingViews;

}
