package Aufgabe_II;

public enum Category {
    ANIMAL("Animal", "Animals roaming the land"),
    MACHINE("Robot", "Robots from the far future"),
    MAGICAL_CREATURE("Magical Creature", "Magical creature from the mystical plane"),
    PLANT("Plant", "Awoken plant that defend themselves");

    private final String title;
    private final String description;

    private Category(String title, String description)
    {
        this.description = description;
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }
}
