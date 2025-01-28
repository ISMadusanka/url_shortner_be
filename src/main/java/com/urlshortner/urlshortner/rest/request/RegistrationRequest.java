package com.urlshortner.urlshortner.rest.request;

import jakarta.persistence.Column;
import org.hibernate.annotations.NaturalId;

public record RegistrationRequest(
         String username,
         String email,
         String password,
         String role
) {
}
