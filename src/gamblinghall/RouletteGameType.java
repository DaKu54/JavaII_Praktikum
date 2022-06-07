package gamblinghall;

public enum RouletteGameType {
    NUMBER("Plein", 52),
    RED("Rouge", 2),
    BLACK("Noir", 2),
    EVEN("Pair", 2),
    ODD("Impair", 2),
    LOW("Manque", 2),
    HIGH("Passe", 2),
    P12("Premiere douzaine", 3),
    M12("Moyenne douzaine", 3),
    D12("Derniere douzaine", 3);

    private final String Name;
    private final int auszahlungsfaktor;

    /**
     * @param Name
     * @param auszahlungsfaktor
     */
    private RouletteGameType(String Name, int auszahlungsfaktor)
    {
        this.auszahlungsfaktor = auszahlungsfaktor;
        this.Name = Name;
    }

    public String getTitle(){
        return Name;
    }

    public int getAuszahlungsfaktor(){
        return auszahlungsfaktor;
    }
}
