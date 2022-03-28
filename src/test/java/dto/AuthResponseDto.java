package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class AuthResponseDto {
    boolean registration;
    String status;
    String token;
}
