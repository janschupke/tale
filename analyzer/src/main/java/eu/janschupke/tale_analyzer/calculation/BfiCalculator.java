package eu.janschupke.tale_analyzer.calculation;

import eu.janschupke.tale_analyzer.entity.measurement.data.BfiAnswers;
import eu.janschupke.tale_analyzer.entity.measurement.model.BfiModel;
import eu.janschupke.tale_analyzer.entity.measurement.model.BfiQuestion;
import eu.janschupke.tale_analyzer.entity.personality.Traits;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculator of the FFM personality model based on provided BFI data.
 *
 * @author jan.schupke@gmail.com
 */
public class BfiCalculator {
    /**
     * Calculates FFM personality based on provided data.
     *
     * @param bfiAnswers User's answers.
     * @param bfiModel BFI calculation model.
     * @return Map of traits and their values.
     */
    public static Map<Traits, Double> calculate(BfiAnswers bfiAnswers, BfiModel bfiModel) {
        Map<Traits, Double> personality = new HashMap<>();

        // Set default scores.
        personality.put(Traits.O, 0.0d);
        personality.put(Traits.C, 0.0d);
        personality.put(Traits.E, 0.0d);
        personality.put(Traits.A, 0.0d);
        personality.put(Traits.N, 0.0d);

        // Accumulate scores based on answers.
        for (BfiQuestion question : bfiModel.getQuestions()) {
            Traits trait = question.getTrait();
            int answer = bfiAnswers.getAnswers().get(question.getNumber() - 1);

            if (question.isReverse()) {
                answer = 6 - answer;
            }

            personality.put(trait, personality.get(trait) + answer);
        }

        // Average scores.
        personality.put(Traits.O, personality.get(Traits.O) / 10.0d);
        personality.put(Traits.C, personality.get(Traits.C) / 9.0d);
        personality.put(Traits.E, personality.get(Traits.E) / 8.0d);
        personality.put(Traits.A, personality.get(Traits.A) / 9.0d);
        personality.put(Traits.N, personality.get(Traits.N) / 8.0d);

        return personality;
    }
}
