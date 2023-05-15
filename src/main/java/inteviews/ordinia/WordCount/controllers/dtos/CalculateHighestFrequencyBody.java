package inteviews.ordinia.WordCount.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
public class CalculateHighestFrequencyBody {
    @NonNull
    private String text;
}
