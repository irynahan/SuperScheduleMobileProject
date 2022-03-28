package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class DateDto {
    int dayOfMonth;
    String dayOfWeek;
    int month;
    int year;
}
