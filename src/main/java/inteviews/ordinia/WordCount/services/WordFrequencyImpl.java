package inteviews.ordinia.WordCount.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class WordFrequencyImpl implements WordFrequency {
    private final String word;
    private int frequency = 0;

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

}
