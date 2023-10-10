package com.multipolar.bootcamp.kyc.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "kyc-customer")
public class Kyc implements Serializable {

    @Id
    private String id;

    @NotEmpty(message = "NIK must be filled")
    private String nik;

    @NotEmpty(message = "First Name must be filled")
    private String firstName;

    @NotEmpty(message = "Last Name must be filled")
    private String lastName;

    @NotEmpty(message = "Email must be filled")
    private String email;

    @NotEmpty(message = "Phone Number must be filled")
    private String phoneNumber;

    private LocalDate birthDate;
}
