package net.minecountry.world.api.structure.model.metadata;

import net.minecountry.world.api.structure.registries.BlockType;

public class PlantMeta extends BlockMeta {
    public short plantHeight = 1;
    public BlockType plantType;

    public PlantMeta(BlockType plantType) {
        this.plantType = plantType;
    }

    public BlockType getPlantType() {
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
