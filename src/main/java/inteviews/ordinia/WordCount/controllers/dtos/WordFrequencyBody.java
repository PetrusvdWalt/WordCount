package inteviews.ordinia.WordCount.controllers.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class WordFrequencyBody {
    @NonNull
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
