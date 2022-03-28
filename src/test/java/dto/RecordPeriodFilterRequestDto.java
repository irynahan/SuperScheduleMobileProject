package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class RecordPeriodFilterRequestDto {
    int monthFrom;
    int monthTo;
    int yearFrom;
    int yearTo;
}
