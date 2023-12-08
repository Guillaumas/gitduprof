package fr.enzosandre;

import fr.enzosandre.console.DetectionMomentJournee;
import fr.enzosandre.domain.PeriodeDeLaJournee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MomentDeLajourneeTest {
    static Stream<Arguments> casMomentDeLaJourneeSelonHeure(){
        return Stream.of(
                Arguments.of(0, PeriodeDeLaJournee.NUIT),
                Arguments.of(8, PeriodeDeLaJournee.MATIN),
                Arguments.of(11, PeriodeDeLaJournee.MATIN),
                Arguments.of(13, PeriodeDeLaJournee.APRES_MIDI),
                Arguments.of(17, PeriodeDeLaJournee.APRES_MIDI),
                Arguments.of(20, PeriodeDeLaJournee.SOIREE),
                Arguments.of(21, PeriodeDeLaJournee.SOIREE),
                Arguments.of(23, PeriodeDeLaJournee.NUIT)
        );
    }


    @ParameterizedTest
    @MethodSource("casMomentDeLaJourneeSelonHeure")
    public void testMomentDeLaJourneeSelonHeure(int heure, PeriodeDeLaJournee periodeAttendue){
        var periode = DetectionMomentJournee.Detecter(heure);
        assert periode == periodeAttendue;
    }

}
