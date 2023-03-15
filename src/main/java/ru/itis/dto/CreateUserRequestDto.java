package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDto {

    @NotBlank(message = "Name shouldn't be blank")
    @Pattern(regexp = "[a-zA-Z]{1,15}")
    private String name;

    @NotBlank(message = "Second name shouldn't be blank")
    @Pattern(regexp = "[a-zA-Z]{1,18}")
    private String secondname;

    @Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    private String email;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @Size(min = 8, max = 63, message = "Password should contains from 8 to 63 symbols")
    private String password;
}