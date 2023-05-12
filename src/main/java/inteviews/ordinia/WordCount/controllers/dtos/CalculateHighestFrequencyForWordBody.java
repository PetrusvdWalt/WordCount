package inteviews.ordinia.WordCount.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CalculateHighestFrequencyForWordBody extends CalculateHighestFrequencyBody {
    @NonNull
    private String word;
}