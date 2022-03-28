package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class ErrorDto {

    int code;
    String details;
    String message;
}
