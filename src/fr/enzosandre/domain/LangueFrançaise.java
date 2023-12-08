package fr.enzosandre.domain;

public class LangueFrançaise implements LangueInterface {
    @Override
    public String Féliciter() {
        return Expressions.BienDit;
    }

    @Override
    public String DireBonjour() {
        return Expressions.Bonjour;
    }

    @Override
    public String DireAuRevoir() {
        return Expressions.AuRevoir;
    }
    @Override
    public String getSalutation(PeriodeDeLaJournee periode) {
        if (periode == null) {
            return Expressions.Bonjour;
        }
        switch (periode) {
            case MATIN:
                return "Bonjour";
            case APRES_MIDI:
                return "Bon après-midi";
            case SOIREE:
                return "Bonsoir";
            case NUIT:
                return "Bonne nuit";
            default:
                return Expressions.Bonjour;
        }
    }
    @Override
    public String getAuRevoir(PeriodeDeLaJournee periode) {
        if (periode == null) {
            return Expressions.AuRevoir;
        }
        switch (periode) {
            case MATIN:
                return "Au revoir, passez une bonne journée";
            case APRES_MIDI:
                return "Au revoir, passez une bonne après-midi";
            case SOIREE:
                return "Au revoir, passez une bonne soirée";
            case NUIT:
                return "Au revoir, bonne nuit";
            default:
                return Expressions.AuRevoir;
        }
    }
}
