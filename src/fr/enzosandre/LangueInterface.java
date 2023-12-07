package fr.enzosandre;

import fr.enzosandre.utilities.PeriodeDeLaJournee;

public interface LangueInterface {
    String Féliciter();
    String DireBonjour();
    String DireAuRevoir();
    String getSalutation(PeriodeDeLaJournee periode);
    String getAuRevoir(PeriodeDeLaJournee periode);
}