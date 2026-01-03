package com.project.Hospital_Management.dto.request;

import com.project.Hospital_Management.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RegisterRequest(
     @NotBlank String firstName,
     @NotBlank String lastName,
     @Email @NotBlank String email,
     @NotBlank String password,
     @NotNull Role role
){}


//Because request data should:
//✔ Not change after creation
//✔ Be validated
//✔ Be simple
//
//Records enforce immutability, which is secure by design.



//@NotBlank (String-only)
//📌 What it checks
//✔ Not null
//✔ Not empty
//✔ Not whitespace only
//🧠 Meaning
//“Meaningful text is required”

//@NotNull
//📌 What it checks
//✔ Value must NOT be null
//❌ Allows empty values
//🧠 Meaning
//“Something must be provided, but I don’t care if it’s empty”