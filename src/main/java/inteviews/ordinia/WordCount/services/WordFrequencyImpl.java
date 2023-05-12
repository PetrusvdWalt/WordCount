package inteviews.ordinia.WordCount.services;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WordFrequencyImpl implements WordFrequency{
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

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
