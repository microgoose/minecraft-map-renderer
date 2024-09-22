package net.world.map.structure.model.metadata;

public class PlantMeta extends BlockMeta {
    public short plantHeight = 1;
    public String plantType;

    public PlantMeta(String plantType) {
        this.plantType = plantType;
    }

    public String getPlantType() {
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
