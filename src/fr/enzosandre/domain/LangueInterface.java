package fr.enzosandre.domain;

public interface LangueInterface {
    String Féliciter();
    String DireBonjour();
    String DireAuRevoir();
    String getSalutation(PeriodeDeLaJournee periode);
    String getAuRevoir(PeriodeDeLaJournee periode);
}