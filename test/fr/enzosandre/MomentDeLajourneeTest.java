package fr.enzosandre;

import fr.enzosandre.console.DetectionMomentJournee;
import fr.enzosandre.domain.LangueAnglaise;
import fr.enzosandre.domain.LangueFrançaise;
import fr.enzosandre.domain.LangueInterface;
import fr.enzosandre.domain.PeriodeDeLaJournee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MomentDeLajourneeTest {
    static Stream<Arguments> casMomentDeLaJournee(){
        return Stream.concat(
                IntStream.range(0, 24).mapToObj(heure -> Arguments.of(heure, new LangueAnglaise(), DetectionMomentJournee.Detecter(heure), new LangueAnglaise().getSalutation(DetectionMomentJournee.Detecter(heure)))),
                IntStream.range(0, 24).mapToObj(heure -> Arguments.of(heure, new LangueFrançaise(), DetectionMomentJournee.Detecter(heure), new LangueFrançaise().getSalutation(DetectionMomentJournee.Detecter(heure))))
        );
    }

    @ParameterizedTest
    @MethodSource("casMomentDeLaJournee")
    public void testMomentDeLaJournee(int heure, LangueInterface langue, PeriodeDeLaJournee periodeAttendue, String salutationAttendue){
        var periode = DetectionMomentJournee.Detecter(heure);
        assert periode == periodeAttendue;

        var salutation = langue.getSalutation(periode);
        assert salutation.equals(salutationAttendue);
    }
}