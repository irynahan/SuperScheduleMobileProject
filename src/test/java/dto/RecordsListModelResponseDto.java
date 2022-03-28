package dto;

import lombok.*;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class RecordsListModelResponseDto {
    List<RecordDto> listOfRecords = new ArrayList<RecordDto>();
}
