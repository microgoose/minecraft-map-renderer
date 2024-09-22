package net.world.map.structure.model.metadata;

import net.world.map.structure.collecions.BlockType;

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
