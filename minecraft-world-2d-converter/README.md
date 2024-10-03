# WorldConverter
`WorldConverter` is a utility for converting Minecraft world regions into a 2D compressed format. This tool reads regions from a specified directory and saves them in a new format that uses less memory, making it suitable for network transmission and browser usage.

## Installation
1. Ensure that you have Java Development Kit (JDK) version 11 or higher installed.
2. Download or clone the repository containing the code.
3. Build the project using your preferred build system (e.g., Maven or Gradle).

## Usage
To run `WorldConverter`, use the command in your terminal:

```bash
java -jar WorldConverter.jar -source-dir=/path/to/minecraft/regions -destination-dir=/path/to/output/regions
```

## *.dat File Structure
```yaml
CompressedRegion:
version: 1.0
chunks:
  - index: short        # Chunk index (16-bit integer)
  - chunk:
      - blockLayer: short[256]         # Array of block types (256 elements, 16-bit integers)
      - blockHeights: short[256]       # Array of block heights (256 elements, 16-bit integers)
      - waterLayer: byte[32]            # Bit map of water layer (32 elements, 8-bit integers)
      - waterDepth: short[256]          # Array of water depths (256 elements, 16-bit integers)
      - plantLayer: short[256]          # Array of plant types (256 elements, 16-bit integers)
      - plantHeight: short[256]         # Array of plant heights (256 elements, 16-bit integers)
```

## Field Descriptions
- **CompressedRegion**: The main structure representing a compressed region of the world.
- **chunks**: A list of chunks containing information about block types, heights, and other layers (water, vegetation).
- **index**: A unique index for each chunk. (range 0 - 256)
- **blockLayer**: An array containing block types for each position in the chunk.
- **blockHeights**: An array containing heights of blocks for each position in the chunk.
- **waterLayer**: A bit map indicating whether there is water at corresponding positions.
- **waterDepth**: An array containing water depths for each position.
- **plantLayer**: An array containing plant types for each position.
- **plantHeight**: An array containing plant heights for each position.

## Block Position from Index Formula
To calculate the X and Y positions of a block within a chunk based on its index, use the following formulas:

- **X Position in Chunk**:  
  `X = index / 256`

- **Y Position in Chunk**:  
  `Y = index / 256 + index % 256`

### Explanation
- **Index**: The linear index of the block within the chunk, ranging from `0` to `255` (for a 16x16 chunk).
- **X**: The horizontal coordinate of the block in the chunk.
- **Y**: The vertical coordinate of the block in the chunk.

