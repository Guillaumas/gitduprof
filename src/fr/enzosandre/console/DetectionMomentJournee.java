package fr.enzosandre.console;

import fr.enzosandre.domain.PeriodeDeLaJournee;

import java.time.LocalTime;

public class DetectionMomentJournee {
    public static PeriodeDeLaJournee Detecter(){
        var heure = LocalTime.now().getHour();

        if (heure >= 6 && heure < 12)
            return PeriodeDeLaJournee.MATIN;
        else if (heure >= 12 && heure < 18)
            return PeriodeDeLaJournee.APRES_MIDI;
        else if (heure >= 18 && heure < 22)
            return PeriodeDeLaJournee.SOIREE;
        else
            return PeriodeDeLaJournee.NUIT;
    }

    public static PeriodeDeLaJournee Detecter(int heure){
        if (heure >= 6 && heure < 12)
            return PeriodeDeLaJournee.MATIN;
        else if (heure >= 12 && heure < 18)
            return PeriodeDeLaJournee.APRES_MIDI;
        else if (heure >= 18 && heure < 22)
            return PeriodeDeLaJournee.SOIREE;
        else
            return PeriodeDeLaJournee.NUIT;
    }
}
