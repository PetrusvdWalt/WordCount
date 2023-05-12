package inteviews.ordinia.WordCount.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CalculateHighestFrequencyForWordBody {
    @NonNull
    private String text;

    @NonNull
    private String word;
}
