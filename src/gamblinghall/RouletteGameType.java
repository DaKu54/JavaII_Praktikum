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

    private final String name;
    private final int auszahlungsfaktor;

    /**
     * @param name
     * @param auszahlungsfaktor
     */
    private RouletteGameType(String name, int auszahlungsfaktor)
    {
        this.auszahlungsfaktor = auszahlungsfaktor;
        this.name = name;
    }

    public String getTitle(){
        return name;
    }

    public int getAuszahlungsfaktor(){
        return auszahlungsfaktor;
    }
}
