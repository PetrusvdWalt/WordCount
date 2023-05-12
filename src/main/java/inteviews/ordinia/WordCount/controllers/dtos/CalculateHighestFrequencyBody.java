package inteviews.ordinia.WordCount.controllers.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CalculateHighestFrequencyBody {
    @NonNull
    private String text;

}
