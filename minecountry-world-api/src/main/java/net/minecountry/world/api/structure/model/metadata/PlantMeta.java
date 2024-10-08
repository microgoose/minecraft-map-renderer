package net.minecountry.world.api.structure.model.metadata;

public class PlantMeta extends BlockMeta {
    public short plantHeight = 1;
    public short plantType;

    public PlantMeta(short plantType) {
        this.plantType = plantType;
    }

    public short getPlantType() {
        return plantType;
    }

    public short getPlantHeight() {
        return plantHeight;
    }

    public void setPlantHeight(short plantHeight) {
        this.plantHeight = plantHeight;
    }

    public void increasePlantHeight() {
        plantHeight++;
    }

    public void decreasePlantHeight() {
        plantHeight--;
    }
}
