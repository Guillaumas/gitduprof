package fr.enzosandre;

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
}