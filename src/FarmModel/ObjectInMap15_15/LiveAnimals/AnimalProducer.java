package FarmModel.ObjectInMap15_15.LiveAnimals;

public abstract class AnimalProducer extends Animals {
    private int animalHealth;

    public abstract void Produce();

    public void EatGrass() {
    }

    public int getAnimalHealth() {
        return animalHealth;
    }

    public void setAnimalHealth(int animalHealth) {
        this.animalHealth = animalHealth;
    }
}
