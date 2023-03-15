package ru.itis.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.domain.Page;
import ru.itis.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Builder
public class UserResponseDto {
    private Integer id;

    private String name;

    private String secondname;

    private String email;

    private LocalDate birth;

    public static UserResponseDto fromEntity(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .secondname(user.getSecondName())
                .name(user.getName())
                .email(user.getEmail())
                .birth(user.getBirth())
                .build();
    }

    public static List<UserResponseDto> fromEntity(List<User> users) {
       return users.stream()
               .map(UserResponseDto::fromEntity)
               .collect(Collectors.toList());
    }


}