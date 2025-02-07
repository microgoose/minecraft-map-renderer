package net.minecraft.map.core.registries;

import java.util.HashMap;
import java.util.Map;

public enum BlockType {
    AIR((short) 0),
    STONE((short) 1),
    GRANITE((short) 2),
    POLISHED_GRANITE((short) 3),
    DIORITE((short) 4),
    POLISHED_DIORITE((short) 5),
    ANDESITE((short) 6),
    POLISHED_ANDESITE((short) 7),
    GRASS_BLOCK((short) 8),
    DIRT((short) 9),
    COARSE_DIRT((short) 10),
    PODZOL((short) 11),
    COBBLESTONE((short) 12),
    OAK_PLANKS((short) 13),
    SPRUCE_PLANKS((short) 14),
    BIRCH_PLANKS((short) 15),
    JUNGLE_PLANKS((short) 16),
    ACACIA_PLANKS((short) 17),
    CHERRY_PLANKS((short) 18),
    DARK_OAK_PLANKS((short) 19),
    MANGROVE_PLANKS((short) 20),
    BAMBOO_PLANKS((short) 21),
    BAMBOO_MOSAIC((short) 22),
    OAK_SAPLING((short) 23),
    SPRUCE_SAPLING((short) 24),
    BIRCH_SAPLING((short) 25),
    JUNGLE_SAPLING((short) 26),
    ACACIA_SAPLING((short) 27),
    CHERRY_SAPLING((short) 28),
    DARK_OAK_SAPLING((short) 29),
    MANGROVE_PROPAGULE((short) 30),
    BEDROCK((short) 31),
    WATER((short) 32),
    LAVA((short) 33),
    SAND((short) 34),
    SUSPICIOUS_SAND((short) 35),
    RED_SAND((short) 36),
    GRAVEL((short) 37),
    SUSPICIOUS_GRAVEL((short) 38),
    GOLD_ORE((short) 39),
    DEEPSLATE_GOLD_ORE((short) 40),
    IRON_ORE((short) 41),
    DEEPSLATE_IRON_ORE((short) 42),
    COAL_ORE((short) 43),
    DEEPSLATE_COAL_ORE((short) 44),
    NETHER_GOLD_ORE((short) 45),
    OAK_LOG((short) 46),
    SPRUCE_LOG((short) 47),
    BIRCH_LOG((short) 48),
    JUNGLE_LOG((short) 49),
    ACACIA_LOG((short) 50),
    CHERRY_LOG((short) 51),
    DARK_OAK_LOG((short) 52),
    MANGROVE_LOG((short) 53),
    MANGROVE_ROOTS((short) 54),
    MUDDY_MANGROVE_ROOTS((short) 55),
    BAMBOO_BLOCK((short) 56),
    STRIPPED_SPRUCE_LOG((short) 57),
    STRIPPED_BIRCH_LOG((short) 58),
    STRIPPED_JUNGLE_LOG((short) 59),
    STRIPPED_ACACIA_LOG((short) 60),
    STRIPPED_CHERRY_LOG((short) 61),
    STRIPPED_DARK_OAK_LOG((short) 62),
    STRIPPED_OAK_LOG((short) 63),
    STRIPPED_MANGROVE_LOG((short) 64),
    STRIPPED_BAMBOO_BLOCK((short) 65),
    OAK_WOOD((short) 66),
    SPRUCE_WOOD((short) 67),
    BIRCH_WOOD((short) 68),
    JUNGLE_WOOD((short) 69),
    ACACIA_WOOD((short) 70),
    CHERRY_WOOD((short) 71),
    DARK_OAK_WOOD((short) 72),
    MANGROVE_WOOD((short) 73),
    STRIPPED_OAK_WOOD((short) 74),
    STRIPPED_SPRUCE_WOOD((short) 75),
    STRIPPED_BIRCH_WOOD((short) 76),
    STRIPPED_JUNGLE_WOOD((short) 77),
    STRIPPED_ACACIA_WOOD((short) 78),
    STRIPPED_CHERRY_WOOD((short) 79),
    STRIPPED_DARK_OAK_WOOD((short) 80),
    STRIPPED_MANGROVE_WOOD((short) 81),
    OAK_LEAVES((short) 82),
    SPRUCE_LEAVES((short) 83),
    BIRCH_LEAVES((short) 84),
    JUNGLE_LEAVES((short) 85),
    ACACIA_LEAVES((short) 86),
    CHERRY_LEAVES((short) 87),
    DARK_OAK_LEAVES((short) 88),
    MANGROVE_LEAVES((short) 89),
    AZALEA_LEAVES((short) 90),
    FLOWERING_AZALEA_LEAVES((short) 91),
    SPONGE((short) 92),
    WET_SPONGE((short) 93),
    GLASS((short) 94),
    LAPIS_ORE((short) 95),
    DEEPSLATE_LAPIS_ORE((short) 96),
    LAPIS_BLOCK((short) 97),
    DISPENSER((short) 98),
    SANDSTONE((short) 99),
    CHISELED_SANDSTONE((short) 100),
    CUT_SANDSTONE((short) 101),
    NOTE_BLOCK((short) 102),
    WHITE_BED((short) 103),
    ORANGE_BED((short) 104),
    MAGENTA_BED((short) 105),
    LIGHT_BLUE_BED((short) 106),
    YELLOW_BED((short) 107),
    LIME_BED((short) 108),
    PINK_BED((short) 109),
    GRAY_BED((short) 110),
    LIGHT_GRAY_BED((short) 111),
    CYAN_BED((short) 112),
    PURPLE_BED((short) 113),
    BLUE_BED((short) 114),
    BROWN_BED((short) 115),
    GREEN_BED((short) 116),
    RED_BED((short) 117),
    BLACK_BED((short) 118),
    POWERED_RAIL((short) 119),
    DETECTOR_RAIL((short) 120),
    STICKY_PISTON((short) 121),
    COBWEB((short) 122),
    SHORT_GRASS((short) 123),
    FERN((short) 124),
    DEAD_BUSH((short) 125),
    SEAGRASS((short) 126),
    TALL_SEAGRASS((short) 127),
    PISTON((short) 128),
    PISTON_HEAD((short) 129),
    WHITE_WOOL((short) 130),
    ORANGE_WOOL((short) 131),
    MAGENTA_WOOL((short) 132),
    LIGHT_BLUE_WOOL((short) 133),
    YELLOW_WOOL((short) 134),
    LIME_WOOL((short) 135),
    PINK_WOOL((short) 136),
    GRAY_WOOL((short) 137),
    LIGHT_GRAY_WOOL((short) 138),
    CYAN_WOOL((short) 139),
    PURPLE_WOOL((short) 140),
    BLUE_WOOL((short) 141),
    BROWN_WOOL((short) 142),
    GREEN_WOOL((short) 143),
    RED_WOOL((short) 144),
    BLACK_WOOL((short) 145),
    MOVING_PISTON((short) 146),
    DANDELION((short) 147),
    TORCHFLOWER((short) 148),
    POPPY((short) 149),
    BLUE_ORCHID((short) 150),
    ALLIUM((short) 151),
    AZURE_BLUET((short) 152),
    RED_TULIP((short) 153),
    ORANGE_TULIP((short) 154),
    WHITE_TULIP((short) 155),
    PINK_TULIP((short) 156),
    OXEYE_DAISY((short) 157),
    CORNFLOWER((short) 158),
    WITHER_ROSE((short) 159),
    LILY_OF_THE_VALLEY((short) 160),
    BROWN_MUSHROOM((short) 161),
    RED_MUSHROOM((short) 162),
    GOLD_BLOCK((short) 163),
    IRON_BLOCK((short) 164),
    BRICKS((short) 165),
    TNT((short) 166),
    BOOKSHELF((short) 167),
    CHISELED_BOOKSHELF((short) 168),
    MOSSY_COBBLESTONE((short) 169),
    OBSIDIAN((short) 170),
    TORCH((short) 171),
    WALL_TORCH((short) 172),
    FIRE((short) 173),
    SOUL_FIRE((short) 174),
    SPAWNER((short) 175),
    OAK_STAIRS((short) 176),
    CHEST((short) 177),
    REDSTONE_WIRE((short) 178),
    DIAMOND_ORE((short) 179),
    DEEPSLATE_DIAMOND_ORE((short) 180),
    DIAMOND_BLOCK((short) 181),
    CRAFTING_TABLE((short) 182),
    WHEAT((short) 183),
    FARMLAND((short) 184),
    FURNACE((short) 185),
    OAK_SIGN((short) 186),
    SPRUCE_SIGN((short) 187),
    BIRCH_SIGN((short) 188),
    ACACIA_SIGN((short) 189),
    CHERRY_SIGN((short) 190),
    JUNGLE_SIGN((short) 191),
    DARK_OAK_SIGN((short) 192),
    MANGROVE_SIGN((short) 193),
    BAMBOO_SIGN((short) 194),
    OAK_DOOR((short) 195),
    LADDER((short) 196),
    RAIL((short) 197),
    COBBLESTONE_STAIRS((short) 198),
    OAK_WALL_SIGN((short) 199),
    SPRUCE_WALL_SIGN((short) 200),
    BIRCH_WALL_SIGN((short) 201),
    ACACIA_WALL_SIGN((short) 202),
    CHERRY_WALL_SIGN((short) 203),
    JUNGLE_WALL_SIGN((short) 204),
    DARK_OAK_WALL_SIGN((short) 205),
    MANGROVE_WALL_SIGN((short) 206),
    BAMBOO_WALL_SIGN((short) 207),
    OAK_HANGING_SIGN((short) 208),
    SPRUCE_HANGING_SIGN((short) 209),
    BIRCH_HANGING_SIGN((short) 210),
    ACACIA_HANGING_SIGN((short) 211),
    CHERRY_HANGING_SIGN((short) 212),
    JUNGLE_HANGING_SIGN((short) 213),
    DARK_OAK_HANGING_SIGN((short) 214),
    CRIMSON_HANGING_SIGN((short) 215),
    WARPED_HANGING_SIGN((short) 216),
    MANGROVE_HANGING_SIGN((short) 217),
    BAMBOO_HANGING_SIGN((short) 218),
    OAK_WALL_HANGING_SIGN((short) 219),
    SPRUCE_WALL_HANGING_SIGN((short) 220),
    BIRCH_WALL_HANGING_SIGN((short) 221),
    ACACIA_WALL_HANGING_SIGN((short) 222),
    CHERRY_WALL_HANGING_SIGN((short) 223),
    JUNGLE_WALL_HANGING_SIGN((short) 224),
    DARK_OAK_WALL_HANGING_SIGN((short) 225),
    MANGROVE_WALL_HANGING_SIGN((short) 226),
    CRIMSON_WALL_HANGING_SIGN((short) 227),
    WARPED_WALL_HANGING_SIGN((short) 228),
    BAMBOO_WALL_HANGING_SIGN((short) 229),
    LEVER((short) 230),
    STONE_PRESSURE_PLATE((short) 231),
    IRON_DOOR((short) 232),
    OAK_PRESSURE_PLATE((short) 233),
    SPRUCE_PRESSURE_PLATE((short) 234),
    BIRCH_PRESSURE_PLATE((short) 235),
    JUNGLE_PRESSURE_PLATE((short) 236),
    ACACIA_PRESSURE_PLATE((short) 237),
    CHERRY_PRESSURE_PLATE((short) 238),
    DARK_OAK_PRESSURE_PLATE((short) 239),
    MANGROVE_PRESSURE_PLATE((short) 240),
    BAMBOO_PRESSURE_PLATE((short) 241),
    REDSTONE_ORE((short) 242),
    DEEPSLATE_REDSTONE_ORE((short) 243),
    REDSTONE_TORCH((short) 244),
    REDSTONE_WALL_TORCH((short) 245),
    STONE_BUTTON((short) 246),
    SNOW((short) 247),
    ICE((short) 248),
    SNOW_BLOCK((short) 249),
    CACTUS((short) 250),
    CLAY((short) 251),
    SUGAR_CANE((short) 252),
    JUKEBOX((short) 253),
    OAK_FENCE((short) 254),
    NETHERRACK((short) 255),
    SOUL_SAND((short) 256),
    SOUL_SOIL((short) 257),
    BASALT((short) 258),
    POLISHED_BASALT((short) 259),
    SOUL_TORCH((short) 260),
    SOUL_WALL_TORCH((short) 261),
    GLOWSTONE((short) 262),
    NETHER_PORTAL((short) 263),
    CARVED_PUMPKIN((short) 264),
    JACK_O_LANTERN((short) 265),
    CAKE((short) 266),
    REPEATER((short) 267),
    WHITE_STAINED_GLASS((short) 268),
    ORANGE_STAINED_GLASS((short) 269),
    MAGENTA_STAINED_GLASS((short) 270),
    LIGHT_BLUE_STAINED_GLASS((short) 271),
    YELLOW_STAINED_GLASS((short) 272),
    LIME_STAINED_GLASS((short) 273),
    PINK_STAINED_GLASS((short) 274),
    GRAY_STAINED_GLASS((short) 275),
    LIGHT_GRAY_STAINED_GLASS((short) 276),
    CYAN_STAINED_GLASS((short) 277),
    PURPLE_STAINED_GLASS((short) 278),
    BLUE_STAINED_GLASS((short) 279),
    BROWN_STAINED_GLASS((short) 280),
    GREEN_STAINED_GLASS((short) 281),
    RED_STAINED_GLASS((short) 282),
    BLACK_STAINED_GLASS((short) 283),
    OAK_TRAPDOOR((short) 284),
    SPRUCE_TRAPDOOR((short) 285),
    BIRCH_TRAPDOOR((short) 286),
    JUNGLE_TRAPDOOR((short) 287),
    ACACIA_TRAPDOOR((short) 288),
    CHERRY_TRAPDOOR((short) 289),
    DARK_OAK_TRAPDOOR((short) 290),
    MANGROVE_TRAPDOOR((short) 291),
    BAMBOO_TRAPDOOR((short) 292),
    STONE_BRICKS((short) 293),
    MOSSY_STONE_BRICKS((short) 294),
    CRACKED_STONE_BRICKS((short) 295),
    CHISELED_STONE_BRICKS((short) 296),
    PACKED_MUD((short) 297),
    MUD_BRICKS((short) 298),
    INFESTED_STONE((short) 299),
    INFESTED_COBBLESTONE((short) 300),
    INFESTED_STONE_BRICKS((short) 301),
    INFESTED_MOSSY_STONE_BRICKS((short) 302),
    INFESTED_CRACKED_STONE_BRICKS((short) 303),
    INFESTED_CHISELED_STONE_BRICKS((short) 304),
    BROWN_MUSHROOM_BLOCK((short) 305),
    RED_MUSHROOM_BLOCK((short) 306),
    MUSHROOM_STEM((short) 307),
    IRON_BARS((short) 308),
    CHAIN((short) 309),
    GLASS_PANE((short) 310),
    PUMPKIN((short) 311),
    MELON((short) 312),
    ATTACHED_PUMPKIN_STEM((short) 313),
    ATTACHED_MELON_STEM((short) 314),
    PUMPKIN_STEM((short) 315),
    MELON_STEM((short) 316),
    VINE((short) 317),
    GLOW_LICHEN((short) 318),
    OAK_FENCE_GATE((short) 319),
    BRICK_STAIRS((short) 320),
    STONE_BRICK_STAIRS((short) 321),
    MUD_BRICK_STAIRS((short) 322),
    MYCELIUM((short) 323),
    LILY_PAD((short) 324),
    NETHER_BRICKS((short) 325),
    NETHER_BRICK_FENCE((short) 326),
    NETHER_BRICK_STAIRS((short) 327),
    NETHER_WART((short) 328),
    ENCHANTING_TABLE((short) 329),
    BREWING_STAND((short) 330),
    CAULDRON((short) 331),
    WATER_CAULDRON((short) 332),
    LAVA_CAULDRON((short) 333),
    POWDER_SNOW_CAULDRON((short) 334),
    END_PORTAL((short) 335),
    END_PORTAL_FRAME((short) 336),
    END_STONE((short) 337),
    DRAGON_EGG((short) 338),
    REDSTONE_LAMP((short) 339),
    COCOA((short) 340),
    SANDSTONE_STAIRS((short) 341),
    EMERALD_ORE((short) 342),
    DEEPSLATE_EMERALD_ORE((short) 343),
    ENDER_CHEST((short) 344),
    TRIPWIRE_HOOK((short) 345),
    TRIPWIRE((short) 346),
    EMERALD_BLOCK((short) 347),
    SPRUCE_STAIRS((short) 348),
    BIRCH_STAIRS((short) 349),
    JUNGLE_STAIRS((short) 350),
    COMMAND_BLOCK((short) 351),
    BEACON((short) 352),
    COBBLESTONE_WALL((short) 353),
    MOSSY_COBBLESTONE_WALL((short) 354),
    FLOWER_POT((short) 355),
    POTTED_TORCHFLOWER((short) 356),
    POTTED_OAK_SAPLING((short) 357),
    POTTED_SPRUCE_SAPLING((short) 358),
    POTTED_BIRCH_SAPLING((short) 359),
    POTTED_JUNGLE_SAPLING((short) 360),
    POTTED_ACACIA_SAPLING((short) 361),
    POTTED_CHERRY_SAPLING((short) 362),
    POTTED_DARK_OAK_SAPLING((short) 363),
    POTTED_MANGROVE_PROPAGULE((short) 364),
    POTTED_FERN((short) 365),
    POTTED_DANDELION((short) 366),
    POTTED_POPPY((short) 367),
    POTTED_BLUE_ORCHID((short) 368),
    POTTED_ALLIUM((short) 369),
    POTTED_AZURE_BLUET((short) 370),
    POTTED_RED_TULIP((short) 371),
    POTTED_ORANGE_TULIP((short) 372),
    POTTED_WHITE_TULIP((short) 373),
    POTTED_PINK_TULIP((short) 374),
    POTTED_OXEYE_DAISY((short) 375),
    POTTED_CORNFLOWER((short) 376),
    POTTED_LILY_OF_THE_VALLEY((short) 377),
    POTTED_WITHER_ROSE((short) 378),
    POTTED_RED_MUSHROOM((short) 379),
    POTTED_BROWN_MUSHROOM((short) 380),
    POTTED_DEAD_BUSH((short) 381),
    POTTED_CACTUS((short) 382),
    CARROTS((short) 383),
    POTATOES((short) 384),
    OAK_BUTTON((short) 385),
    SPRUCE_BUTTON((short) 386),
    BIRCH_BUTTON((short) 387),
    JUNGLE_BUTTON((short) 388),
    ACACIA_BUTTON((short) 389),
    CHERRY_BUTTON((short) 390),
    DARK_OAK_BUTTON((short) 391),
    MANGROVE_BUTTON((short) 392),
    BAMBOO_BUTTON((short) 393),
    SKELETON_SKULL((short) 394),
    SKELETON_WALL_SKULL((short) 395),
    WITHER_SKELETON_SKULL((short) 396),
    WITHER_SKELETON_WALL_SKULL((short) 397),
    ZOMBIE_HEAD((short) 398),
    ZOMBIE_WALL_HEAD((short) 399),
    PLAYER_HEAD((short) 400),
    PLAYER_WALL_HEAD((short) 401),
    CREEPER_HEAD((short) 402),
    CREEPER_WALL_HEAD((short) 403),
    DRAGON_HEAD((short) 404),
    DRAGON_WALL_HEAD((short) 405),
    PIGLIN_HEAD((short) 406),
    PIGLIN_WALL_HEAD((short) 407),
    ANVIL((short) 408),
    CHIPPED_ANVIL((short) 409),
    DAMAGED_ANVIL((short) 410),
    TRAPPED_CHEST((short) 411),
    LIGHT_WEIGHTED_PRESSURE_PLATE((short) 412),
    HEAVY_WEIGHTED_PRESSURE_PLATE((short) 413),
    COMPARATOR((short) 414),
    DAYLIGHT_DETECTOR((short) 415),
    REDSTONE_BLOCK((short) 416),
    NETHER_QUARTZ_ORE((short) 417),
    HOPPER((short) 418),
    QUARTZ_BLOCK((short) 419),
    CHISELED_QUARTZ_BLOCK((short) 420),
    QUARTZ_PILLAR((short) 421),
    QUARTZ_STAIRS((short) 422),
    ACTIVATOR_RAIL((short) 423),
    DROPPER((short) 424),
    WHITE_TERRACOTTA((short) 425),
    ORANGE_TERRACOTTA((short) 426),
    MAGENTA_TERRACOTTA((short) 427),
    LIGHT_BLUE_TERRACOTTA((short) 428),
    YELLOW_TERRACOTTA((short) 429),
    LIME_TERRACOTTA((short) 430),
    PINK_TERRACOTTA((short) 431),
    GRAY_TERRACOTTA((short) 432),
    LIGHT_GRAY_TERRACOTTA((short) 433),
    CYAN_TERRACOTTA((short) 434),
    PURPLE_TERRACOTTA((short) 435),
    BLUE_TERRACOTTA((short) 436),
    BROWN_TERRACOTTA((short) 437),
    GREEN_TERRACOTTA((short) 438),
    RED_TERRACOTTA((short) 439),
    BLACK_TERRACOTTA((short) 440),
    WHITE_STAINED_GLASS_PANE((short) 441),
    ORANGE_STAINED_GLASS_PANE((short) 442),
    MAGENTA_STAINED_GLASS_PANE((short) 443),
    LIGHT_BLUE_STAINED_GLASS_PANE((short) 444),
    YELLOW_STAINED_GLASS_PANE((short) 445),
    LIME_STAINED_GLASS_PANE((short) 446),
    PINK_STAINED_GLASS_PANE((short) 447),
    GRAY_STAINED_GLASS_PANE((short) 448),
    LIGHT_GRAY_STAINED_GLASS_PANE((short) 449),
    CYAN_STAINED_GLASS_PANE((short) 450),
    PURPLE_STAINED_GLASS_PANE((short) 451),
    BLUE_STAINED_GLASS_PANE((short) 452),
    BROWN_STAINED_GLASS_PANE((short) 453),
    GREEN_STAINED_GLASS_PANE((short) 454),
    RED_STAINED_GLASS_PANE((short) 455),
    BLACK_STAINED_GLASS_PANE((short) 456),
    ACACIA_STAIRS((short) 457),
    CHERRY_STAIRS((short) 458),
    DARK_OAK_STAIRS((short) 459),
    MANGROVE_STAIRS((short) 460),
    BAMBOO_STAIRS((short) 461),
    BAMBOO_MOSAIC_STAIRS((short) 462),
    SLIME_BLOCK((short) 463),
    BARRIER((short) 464),
    LIGHT((short) 465),
    IRON_TRAPDOOR((short) 466),
    PRISMARINE((short) 467),
    PRISMARINE_BRICKS((short) 468),
    DARK_PRISMARINE((short) 469),
    PRISMARINE_STAIRS((short) 470),
    PRISMARINE_BRICK_STAIRS((short) 471),
    DARK_PRISMARINE_STAIRS((short) 472),
    PRISMARINE_SLAB((short) 473),
    PRISMARINE_BRICK_SLAB((short) 474),
    DARK_PRISMARINE_SLAB((short) 475),
    SEA_LANTERN((short) 476),
    HAY_BLOCK((short) 477),
    WHITE_CARPET((short) 478),
    ORANGE_CARPET((short) 479),
    MAGENTA_CARPET((short) 480),
    LIGHT_BLUE_CARPET((short) 481),
    YELLOW_CARPET((short) 482),
    LIME_CARPET((short) 483),
    PINK_CARPET((short) 484),
    GRAY_CARPET((short) 485),
    LIGHT_GRAY_CARPET((short) 486),
    CYAN_CARPET((short) 487),
    PURPLE_CARPET((short) 488),
    BLUE_CARPET((short) 489),
    BROWN_CARPET((short) 490),
    GREEN_CARPET((short) 491),
    RED_CARPET((short) 492),
    BLACK_CARPET((short) 493),
    TERRACOTTA((short) 494),
    COAL_BLOCK((short) 495),
    PACKED_ICE((short) 496),
    SUNFLOWER((short) 497),
    LILAC((short) 498),
    ROSE_BUSH((short) 499),
    PEONY((short) 500),
    TALL_GRASS((short) 501),
    LARGE_FERN((short) 502),
    WHITE_BANNER((short) 503),
    ORANGE_BANNER((short) 504),
    MAGENTA_BANNER((short) 505),
    LIGHT_BLUE_BANNER((short) 506),
    YELLOW_BANNER((short) 507),
    LIME_BANNER((short) 508),
    PINK_BANNER((short) 509),
    GRAY_BANNER((short) 510),
    LIGHT_GRAY_BANNER((short) 511),
    CYAN_BANNER((short) 512),
    PURPLE_BANNER((short) 513),
    BLUE_BANNER((short) 514),
    BROWN_BANNER((short) 515),
    GREEN_BANNER((short) 516),
    RED_BANNER((short) 517),
    BLACK_BANNER((short) 518),
    WHITE_WALL_BANNER((short) 519),
    ORANGE_WALL_BANNER((short) 520),
    MAGENTA_WALL_BANNER((short) 521),
    LIGHT_BLUE_WALL_BANNER((short) 522),
    YELLOW_WALL_BANNER((short) 523),
    LIME_WALL_BANNER((short) 524),
    PINK_WALL_BANNER((short) 525),
    GRAY_WALL_BANNER((short) 526),
    LIGHT_GRAY_WALL_BANNER((short) 527),
    CYAN_WALL_BANNER((short) 528),
    PURPLE_WALL_BANNER((short) 529),
    BLUE_WALL_BANNER((short) 530),
    BROWN_WALL_BANNER((short) 531),
    GREEN_WALL_BANNER((short) 532),
    RED_WALL_BANNER((short) 533),
    BLACK_WALL_BANNER((short) 534),
    RED_SANDSTONE((short) 535),
    CHISELED_RED_SANDSTONE((short) 536),
    CUT_RED_SANDSTONE((short) 537),
    RED_SANDSTONE_STAIRS((short) 538),
    OAK_SLAB((short) 539),
    SPRUCE_SLAB((short) 540),
    BIRCH_SLAB((short) 541),
    JUNGLE_SLAB((short) 542),
    ACACIA_SLAB((short) 543),
    CHERRY_SLAB((short) 544),
    DARK_OAK_SLAB((short) 545),
    MANGROVE_SLAB((short) 546),
    BAMBOO_SLAB((short) 547),
    BAMBOO_MOSAIC_SLAB((short) 548),
    STONE_SLAB((short) 549),
    SMOOTH_STONE_SLAB((short) 550),
    SANDSTONE_SLAB((short) 551),
    CUT_SANDSTONE_SLAB((short) 552),
    PETRIFIED_OAK_SLAB((short) 553),
    COBBLESTONE_SLAB((short) 554),
    BRICK_SLAB((short) 555),
    STONE_BRICK_SLAB((short) 556),
    MUD_BRICK_SLAB((short) 557),
    NETHER_BRICK_SLAB((short) 558),
    QUARTZ_SLAB((short) 559),
    RED_SANDSTONE_SLAB((short) 560),
    CUT_RED_SANDSTONE_SLAB((short) 561),
    PURPUR_SLAB((short) 562),
    SMOOTH_STONE((short) 563),
    SMOOTH_SANDSTONE((short) 564),
    SMOOTH_QUARTZ((short) 565),
    SMOOTH_RED_SANDSTONE((short) 566),
    SPRUCE_FENCE_GATE((short) 567),
    BIRCH_FENCE_GATE((short) 568),
    JUNGLE_FENCE_GATE((short) 569),
    ACACIA_FENCE_GATE((short) 570),
    CHERRY_FENCE_GATE((short) 571),
    DARK_OAK_FENCE_GATE((short) 572),
    MANGROVE_FENCE_GATE((short) 573),
    BAMBOO_FENCE_GATE((short) 574),
    SPRUCE_FENCE((short) 575),
    BIRCH_FENCE((short) 576),
    JUNGLE_FENCE((short) 577),
    ACACIA_FENCE((short) 578),
    CHERRY_FENCE((short) 579),
    DARK_OAK_FENCE((short) 580),
    MANGROVE_FENCE((short) 581),
    BAMBOO_FENCE((short) 582),
    SPRUCE_DOOR((short) 583),
    BIRCH_DOOR((short) 584),
    JUNGLE_DOOR((short) 585),
    ACACIA_DOOR((short) 586),
    CHERRY_DOOR((short) 587),
    DARK_OAK_DOOR((short) 588),
    MANGROVE_DOOR((short) 589),
    BAMBOO_DOOR((short) 590),
    END_ROD((short) 591),
    CHORUS_PLANT((short) 592),
    CHORUS_FLOWER((short) 593),
    PURPUR_BLOCK((short) 594),
    PURPUR_PILLAR((short) 595),
    PURPUR_STAIRS((short) 596),
    END_STONE_BRICKS((short) 597),
    TORCHFLOWER_CROP((short) 598),
    PITCHER_CROP((short) 599),
    PITCHER_PLANT((short) 600),
    BEETROOTS((short) 601),
    DIRT_PATH((short) 602),
    END_GATEWAY((short) 603),
    REPEATING_COMMAND_BLOCK((short) 604),
    CHAIN_COMMAND_BLOCK((short) 605),
    FROSTED_ICE((short) 606),
    MAGMA_BLOCK((short) 607),
    NETHER_WART_BLOCK((short) 608),
    RED_NETHER_BRICKS((short) 609),
    BONE_BLOCK((short) 610),
    STRUCTURE_VOID((short) 611),
    OBSERVER((short) 612),
    SHULKER_BOX((short) 613),
    WHITE_SHULKER_BOX((short) 614),
    ORANGE_SHULKER_BOX((short) 615),
    MAGENTA_SHULKER_BOX((short) 616),
    LIGHT_BLUE_SHULKER_BOX((short) 617),
    YELLOW_SHULKER_BOX((short) 618),
    LIME_SHULKER_BOX((short) 619),
    PINK_SHULKER_BOX((short) 620),
    GRAY_SHULKER_BOX((short) 621),
    LIGHT_GRAY_SHULKER_BOX((short) 622),
    CYAN_SHULKER_BOX((short) 623),
    PURPLE_SHULKER_BOX((short) 624),
    BLUE_SHULKER_BOX((short) 625),
    BROWN_SHULKER_BOX((short) 626),
    GREEN_SHULKER_BOX((short) 627),
    RED_SHULKER_BOX((short) 628),
    BLACK_SHULKER_BOX((short) 629),
    WHITE_GLAZED_TERRACOTTA((short) 630),
    ORANGE_GLAZED_TERRACOTTA((short) 631),
    MAGENTA_GLAZED_TERRACOTTA((short) 632),
    LIGHT_BLUE_GLAZED_TERRACOTTA((short) 633),
    YELLOW_GLAZED_TERRACOTTA((short) 634),
    LIME_GLAZED_TERRACOTTA((short) 635),
    PINK_GLAZED_TERRACOTTA((short) 636),
    GRAY_GLAZED_TERRACOTTA((short) 637),
    LIGHT_GRAY_GLAZED_TERRACOTTA((short) 638),
    CYAN_GLAZED_TERRACOTTA((short) 639),
    PURPLE_GLAZED_TERRACOTTA((short) 640),
    BLUE_GLAZED_TERRACOTTA((short) 641),
    BROWN_GLAZED_TERRACOTTA((short) 642),
    GREEN_GLAZED_TERRACOTTA((short) 643),
    RED_GLAZED_TERRACOTTA((short) 644),
    BLACK_GLAZED_TERRACOTTA((short) 645),
    WHITE_CONCRETE((short) 646),
    ORANGE_CONCRETE((short) 647),
    MAGENTA_CONCRETE((short) 648),
    LIGHT_BLUE_CONCRETE((short) 649),
    YELLOW_CONCRETE((short) 650),
    LIME_CONCRETE((short) 651),
    PINK_CONCRETE((short) 652),
    GRAY_CONCRETE((short) 653),
    LIGHT_GRAY_CONCRETE((short) 654),
    CYAN_CONCRETE((short) 655),
    PURPLE_CONCRETE((short) 656),
    BLUE_CONCRETE((short) 657),
    BROWN_CONCRETE((short) 658),
    GREEN_CONCRETE((short) 659),
    RED_CONCRETE((short) 660),
    BLACK_CONCRETE((short) 661),
    WHITE_CONCRETE_POWDER((short) 662),
    ORANGE_CONCRETE_POWDER((short) 663),
    MAGENTA_CONCRETE_POWDER((short) 664),
    LIGHT_BLUE_CONCRETE_POWDER((short) 665),
    YELLOW_CONCRETE_POWDER((short) 666),
    LIME_CONCRETE_POWDER((short) 667),
    PINK_CONCRETE_POWDER((short) 668),
    GRAY_CONCRETE_POWDER((short) 669),
    LIGHT_GRAY_CONCRETE_POWDER((short) 670),
    CYAN_CONCRETE_POWDER((short) 671),
    PURPLE_CONCRETE_POWDER((short) 672),
    BLUE_CONCRETE_POWDER((short) 673),
    BROWN_CONCRETE_POWDER((short) 674),
    GREEN_CONCRETE_POWDER((short) 675),
    RED_CONCRETE_POWDER((short) 676),
    BLACK_CONCRETE_POWDER((short) 677),
    KELP((short) 678),
    KELP_PLANT((short) 679),
    DRIED_KELP_BLOCK((short) 680),
    TURTLE_EGG((short) 681),
    SNIFFER_EGG((short) 682),
    DEAD_TUBE_CORAL_BLOCK((short) 683),
    DEAD_BRAIN_CORAL_BLOCK((short) 684),
    DEAD_BUBBLE_CORAL_BLOCK((short) 685),
    DEAD_FIRE_CORAL_BLOCK((short) 686),
    DEAD_HORN_CORAL_BLOCK((short) 687),
    TUBE_CORAL_BLOCK((short) 688),
    BRAIN_CORAL_BLOCK((short) 689),
    BUBBLE_CORAL_BLOCK((short) 690),
    FIRE_CORAL_BLOCK((short) 691),
    HORN_CORAL_BLOCK((short) 692),
    DEAD_TUBE_CORAL((short) 693),
    DEAD_BRAIN_CORAL((short) 694),
    DEAD_BUBBLE_CORAL((short) 695),
    DEAD_FIRE_CORAL((short) 696),
    DEAD_HORN_CORAL((short) 697),
    TUBE_CORAL((short) 698),
    BRAIN_CORAL((short) 699),
    BUBBLE_CORAL((short) 700),
    FIRE_CORAL((short) 701),
    HORN_CORAL((short) 702),
    DEAD_TUBE_CORAL_FAN((short) 703),
    DEAD_BRAIN_CORAL_FAN((short) 704),
    DEAD_BUBBLE_CORAL_FAN((short) 705),
    DEAD_FIRE_CORAL_FAN((short) 706),
    DEAD_HORN_CORAL_FAN((short) 707),
    TUBE_CORAL_FAN((short) 708),
    BRAIN_CORAL_FAN((short) 709),
    BUBBLE_CORAL_FAN((short) 710),
    FIRE_CORAL_FAN((short) 711),
    HORN_CORAL_FAN((short) 712),
    DEAD_TUBE_CORAL_WALL_FAN((short) 713),
    DEAD_BRAIN_CORAL_WALL_FAN((short) 714),
    DEAD_BUBBLE_CORAL_WALL_FAN((short) 715),
    DEAD_FIRE_CORAL_WALL_FAN((short) 716),
    DEAD_HORN_CORAL_WALL_FAN((short) 717),
    TUBE_CORAL_WALL_FAN((short) 718),
    BRAIN_CORAL_WALL_FAN((short) 719),
    BUBBLE_CORAL_WALL_FAN((short) 720),
    FIRE_CORAL_WALL_FAN((short) 721),
    HORN_CORAL_WALL_FAN((short) 722),
    SEA_PICKLE((short) 723),
    BLUE_ICE((short) 724),
    CONDUIT((short) 725),
    BAMBOO_SAPLING((short) 726),
    BAMBOO((short) 727),
    POTTED_BAMBOO((short) 728),
    VOID_AIR((short) 729),
    CAVE_AIR((short) 730),
    BUBBLE_COLUMN((short) 731),
    POLISHED_GRANITE_STAIRS((short) 732),
    SMOOTH_RED_SANDSTONE_STAIRS((short) 733),
    MOSSY_STONE_BRICK_STAIRS((short) 734),
    POLISHED_DIORITE_STAIRS((short) 735),
    MOSSY_COBBLESTONE_STAIRS((short) 736),
    END_STONE_BRICK_STAIRS((short) 737),
    STONE_STAIRS((short) 738),
    SMOOTH_SANDSTONE_STAIRS((short) 739),
    SMOOTH_QUARTZ_STAIRS((short) 740),
    GRANITE_STAIRS((short) 741),
    ANDESITE_STAIRS((short) 742),
    RED_NETHER_BRICK_STAIRS((short) 743),
    POLISHED_ANDESITE_STAIRS((short) 744),
    DIORITE_STAIRS((short) 745),
    POLISHED_GRANITE_SLAB((short) 746),
    SMOOTH_RED_SANDSTONE_SLAB((short) 747),
    MOSSY_STONE_BRICK_SLAB((short) 748),
    POLISHED_DIORITE_SLAB((short) 749),
    MOSSY_COBBLESTONE_SLAB((short) 750),
    END_STONE_BRICK_SLAB((short) 751),
    SMOOTH_SANDSTONE_SLAB((short) 752),
    SMOOTH_QUARTZ_SLAB((short) 753),
    GRANITE_SLAB((short) 754),
    ANDESITE_SLAB((short) 755),
    RED_NETHER_BRICK_SLAB((short) 756),
    POLISHED_ANDESITE_SLAB((short) 757),
    DIORITE_SLAB((short) 758),
    BRICK_WALL((short) 759),
    PRISMARINE_WALL((short) 760),
    RED_SANDSTONE_WALL((short) 761),
    MOSSY_STONE_BRICK_WALL((short) 762),
    GRANITE_WALL((short) 763),
    STONE_BRICK_WALL((short) 764),
    MUD_BRICK_WALL((short) 765),
    NETHER_BRICK_WALL((short) 766),
    ANDESITE_WALL((short) 767),
    RED_NETHER_BRICK_WALL((short) 768),
    SANDSTONE_WALL((short) 769),
    END_STONE_BRICK_WALL((short) 770),
    DIORITE_WALL((short) 771),
    SCAFFOLDING((short) 772),
    LOOM((short) 773),
    BARREL((short) 774),
    SMOKER((short) 775),
    BLAST_FURNACE((short) 776),
    CARTOGRAPHY_TABLE((short) 777),
    FLETCHING_TABLE((short) 778),
    GRINDSTONE((short) 779),
    LECTERN((short) 780),
    SMITHING_TABLE((short) 781),
    STONECUTTER((short) 782),
    BELL((short) 783),
    LANTERN((short) 784),
    SOUL_LANTERN((short) 785),
    CAMPFIRE((short) 786),
    SOUL_CAMPFIRE((short) 787),
    SWEET_BERRY_BUSH((short) 788),
    WARPED_STEM((short) 789),
    STRIPPED_WARPED_STEM((short) 790),
    WARPED_HYPHAE((short) 791),
    STRIPPED_WARPED_HYPHAE((short) 792),
    WARPED_NYLIUM((short) 793),
    WARPED_FUNGUS((short) 794),
    WARPED_WART_BLOCK((short) 795),
    WARPED_ROOTS((short) 796),
    NETHER_SPROUTS((short) 797),
    CRIMSON_STEM((short) 798),
    STRIPPED_CRIMSON_STEM((short) 799),
    CRIMSON_HYPHAE((short) 800),
    STRIPPED_CRIMSON_HYPHAE((short) 801),
    CRIMSON_NYLIUM((short) 802),
    CRIMSON_FUNGUS((short) 803),
    SHROOMLIGHT((short) 804),
    WEEPING_VINES((short) 805),
    WEEPING_VINES_PLANT((short) 806),
    TWISTING_VINES((short) 807),
    TWISTING_VINES_PLANT((short) 808),
    CRIMSON_ROOTS((short) 809),
    CRIMSON_PLANKS((short) 810),
    WARPED_PLANKS((short) 811),
    CRIMSON_SLAB((short) 812),
    WARPED_SLAB((short) 813),
    CRIMSON_PRESSURE_PLATE((short) 814),
    WARPED_PRESSURE_PLATE((short) 815),
    CRIMSON_FENCE((short) 816),
    WARPED_FENCE((short) 817),
    CRIMSON_TRAPDOOR((short) 818),
    WARPED_TRAPDOOR((short) 819),
    CRIMSON_FENCE_GATE((short) 820),
    WARPED_FENCE_GATE((short) 821),
    CRIMSON_STAIRS((short) 822),
    WARPED_STAIRS((short) 823),
    CRIMSON_BUTTON((short) 824),
    WARPED_BUTTON((short) 825),
    CRIMSON_DOOR((short) 826),
    WARPED_DOOR((short) 827),
    CRIMSON_SIGN((short) 828),
    WARPED_SIGN((short) 829),
    CRIMSON_WALL_SIGN((short) 830),
    WARPED_WALL_SIGN((short) 831),
    STRUCTURE_BLOCK((short) 832),
    JIGSAW((short) 833),
    COMPOSTER((short) 834),
    TARGET((short) 835),
    BEE_NEST((short) 836),
    BEEHIVE((short) 837),
    HONEY_BLOCK((short) 838),
    HONEYCOMB_BLOCK((short) 839),
    NETHERITE_BLOCK((short) 840),
    ANCIENT_DEBRIS((short) 841),
    CRYING_OBSIDIAN((short) 842),
    RESPAWN_ANCHOR((short) 843),
    POTTED_CRIMSON_FUNGUS((short) 844),
    POTTED_WARPED_FUNGUS((short) 845),
    POTTED_CRIMSON_ROOTS((short) 846),
    POTTED_WARPED_ROOTS((short) 847),
    LODESTONE((short) 848),
    BLACKSTONE((short) 849),
    BLACKSTONE_STAIRS((short) 850),
    BLACKSTONE_WALL((short) 851),
    BLACKSTONE_SLAB((short) 852),
    POLISHED_BLACKSTONE((short) 853),
    POLISHED_BLACKSTONE_BRICKS((short) 854),
    CRACKED_POLISHED_BLACKSTONE_BRICKS((short) 855),
    CHISELED_POLISHED_BLACKSTONE((short) 856),
    POLISHED_BLACKSTONE_BRICK_SLAB((short) 857),
    POLISHED_BLACKSTONE_BRICK_STAIRS((short) 858),
    POLISHED_BLACKSTONE_BRICK_WALL((short) 859),
    GILDED_BLACKSTONE((short) 860),
    POLISHED_BLACKSTONE_STAIRS((short) 861),
    POLISHED_BLACKSTONE_SLAB((short) 862),
    POLISHED_BLACKSTONE_PRESSURE_PLATE((short) 863),
    POLISHED_BLACKSTONE_BUTTON((short) 864),
    POLISHED_BLACKSTONE_WALL((short) 865),
    CHISELED_NETHER_BRICKS((short) 866),
    CRACKED_NETHER_BRICKS((short) 867),
    QUARTZ_BRICKS((short) 868),
    CANDLE((short) 869),
    WHITE_CANDLE((short) 870),
    ORANGE_CANDLE((short) 871),
    MAGENTA_CANDLE((short) 872),
    LIGHT_BLUE_CANDLE((short) 873),
    YELLOW_CANDLE((short) 874),
    LIME_CANDLE((short) 875),
    PINK_CANDLE((short) 876),
    GRAY_CANDLE((short) 877),
    LIGHT_GRAY_CANDLE((short) 878),
    CYAN_CANDLE((short) 879),
    PURPLE_CANDLE((short) 880),
    BLUE_CANDLE((short) 881),
    BROWN_CANDLE((short) 882),
    GREEN_CANDLE((short) 883),
    RED_CANDLE((short) 884),
    BLACK_CANDLE((short) 885),
    CANDLE_CAKE((short) 886),
    WHITE_CANDLE_CAKE((short) 887),
    ORANGE_CANDLE_CAKE((short) 888),
    MAGENTA_CANDLE_CAKE((short) 889),
    LIGHT_BLUE_CANDLE_CAKE((short) 890),
    YELLOW_CANDLE_CAKE((short) 891),
    LIME_CANDLE_CAKE((short) 892),
    PINK_CANDLE_CAKE((short) 893),
    GRAY_CANDLE_CAKE((short) 894),
    LIGHT_GRAY_CANDLE_CAKE((short) 895),
    CYAN_CANDLE_CAKE((short) 896),
    PURPLE_CANDLE_CAKE((short) 897),
    BLUE_CANDLE_CAKE((short) 898),
    BROWN_CANDLE_CAKE((short) 899),
    GREEN_CANDLE_CAKE((short) 900),
    RED_CANDLE_CAKE((short) 901),
    BLACK_CANDLE_CAKE((short) 902),
    AMETHYST_BLOCK((short) 903),
    BUDDING_AMETHYST((short) 904),
    AMETHYST_CLUSTER((short) 905),
    LARGE_AMETHYST_BUD((short) 906),
    MEDIUM_AMETHYST_BUD((short) 907),
    SMALL_AMETHYST_BUD((short) 908),
    TUFF((short) 909),
    TUFF_SLAB((short) 910),
    TUFF_STAIRS((short) 911),
    TUFF_WALL((short) 912),
    POLISHED_TUFF((short) 913),
    POLISHED_TUFF_SLAB((short) 914),
    POLISHED_TUFF_STAIRS((short) 915),
    POLISHED_TUFF_WALL((short) 916),
    CHISELED_TUFF((short) 917),
    TUFF_BRICKS((short) 918),
    TUFF_BRICK_SLAB((short) 919),
    TUFF_BRICK_STAIRS((short) 920),
    TUFF_BRICK_WALL((short) 921),
    CHISELED_TUFF_BRICKS((short) 922),
    CALCITE((short) 923),
    TINTED_GLASS((short) 924),
    POWDER_SNOW((short) 925),
    SCULK_SENSOR((short) 926),
    CALIBRATED_SCULK_SENSOR((short) 927),
    SCULK((short) 928),
    SCULK_VEIN((short) 929),
    SCULK_CATALYST((short) 930),
    SCULK_SHRIEKER((short) 931),
    COPPER_BLOCK((short) 932),
    EXPOSED_COPPER((short) 933),
    WEATHERED_COPPER((short) 934),
    OXIDIZED_COPPER((short) 935),
    COPPER_ORE((short) 936),
    DEEPSLATE_COPPER_ORE((short) 937),
    OXIDIZED_CUT_COPPER((short) 938),
    WEATHERED_CUT_COPPER((short) 939),
    EXPOSED_CUT_COPPER((short) 940),
    CUT_COPPER((short) 941),
    OXIDIZED_CHISELED_COPPER((short) 942),
    WEATHERED_CHISELED_COPPER((short) 943),
    EXPOSED_CHISELED_COPPER((short) 944),
    CHISELED_COPPER((short) 945),
    WAXED_OXIDIZED_CHISELED_COPPER((short) 946),
    WAXED_WEATHERED_CHISELED_COPPER((short) 947),
    WAXED_EXPOSED_CHISELED_COPPER((short) 948),
    WAXED_CHISELED_COPPER((short) 949),
    OXIDIZED_CUT_COPPER_STAIRS((short) 950),
    WEATHERED_CUT_COPPER_STAIRS((short) 951),
    EXPOSED_CUT_COPPER_STAIRS((short) 952),
    CUT_COPPER_STAIRS((short) 953),
    OXIDIZED_CUT_COPPER_SLAB((short) 954),
    WEATHERED_CUT_COPPER_SLAB((short) 955),
    EXPOSED_CUT_COPPER_SLAB((short) 956),
    CUT_COPPER_SLAB((short) 957),
    WAXED_COPPER_BLOCK((short) 958),
    WAXED_WEATHERED_COPPER((short) 959),
    WAXED_EXPOSED_COPPER((short) 960),
    WAXED_OXIDIZED_COPPER((short) 961),
    WAXED_OXIDIZED_CUT_COPPER((short) 962),
    WAXED_WEATHERED_CUT_COPPER((short) 963),
    WAXED_EXPOSED_CUT_COPPER((short) 964),
    WAXED_CUT_COPPER((short) 965),
    WAXED_OXIDIZED_CUT_COPPER_STAIRS((short) 966),
    WAXED_WEATHERED_CUT_COPPER_STAIRS((short) 967),
    WAXED_EXPOSED_CUT_COPPER_STAIRS((short) 968),
    WAXED_CUT_COPPER_STAIRS((short) 969),
    WAXED_OXIDIZED_CUT_COPPER_SLAB((short) 970),
    WAXED_WEATHERED_CUT_COPPER_SLAB((short) 971),
    WAXED_EXPOSED_CUT_COPPER_SLAB((short) 972),
    WAXED_CUT_COPPER_SLAB((short) 973),
    COPPER_DOOR((short) 974),
    EXPOSED_COPPER_DOOR((short) 975),
    OXIDIZED_COPPER_DOOR((short) 976),
    WEATHERED_COPPER_DOOR((short) 977),
    WAXED_COPPER_DOOR((short) 978),
    WAXED_EXPOSED_COPPER_DOOR((short) 979),
    WAXED_OXIDIZED_COPPER_DOOR((short) 980),
    WAXED_WEATHERED_COPPER_DOOR((short) 981),
    COPPER_TRAPDOOR((short) 982),
    EXPOSED_COPPER_TRAPDOOR((short) 983),
    OXIDIZED_COPPER_TRAPDOOR((short) 984),
    WEATHERED_COPPER_TRAPDOOR((short) 985),
    WAXED_COPPER_TRAPDOOR((short) 986),
    WAXED_EXPOSED_COPPER_TRAPDOOR((short) 987),
    WAXED_OXIDIZED_COPPER_TRAPDOOR((short) 988),
    WAXED_WEATHERED_COPPER_TRAPDOOR((short) 989),
    COPPER_GRATE((short) 990),
    EXPOSED_COPPER_GRATE((short) 991),
    WEATHERED_COPPER_GRATE((short) 992),
    OXIDIZED_COPPER_GRATE((short) 993),
    WAXED_COPPER_GRATE((short) 994),
    WAXED_EXPOSED_COPPER_GRATE((short) 995),
    WAXED_WEATHERED_COPPER_GRATE((short) 996),
    WAXED_OXIDIZED_COPPER_GRATE((short) 997),
    COPPER_BULB((short) 998),
    EXPOSED_COPPER_BULB((short) 999),
    WEATHERED_COPPER_BULB((short) 1000),
    OXIDIZED_COPPER_BULB((short) 1001),
    WAXED_COPPER_BULB((short) 1002),
    WAXED_EXPOSED_COPPER_BULB((short) 1003),
    WAXED_WEATHERED_COPPER_BULB((short) 1004),
    WAXED_OXIDIZED_COPPER_BULB((short) 1005),
    LIGHTNING_ROD((short) 1006),
    POINTED_DRIPSTONE((short) 1007),
    DRIPSTONE_BLOCK((short) 1008),
    CAVE_VINES((short) 1009),
    CAVE_VINES_PLANT((short) 1010),
    SPORE_BLOSSOM((short) 1011),
    AZALEA((short) 1012),
    FLOWERING_AZALEA((short) 1013),
    MOSS_CARPET((short) 1014),
    PINK_PETALS((short) 1015),
    MOSS_BLOCK((short) 1016),
    BIG_DRIPLEAF((short) 1017),
    BIG_DRIPLEAF_STEM((short) 1018),
    SMALL_DRIPLEAF((short) 1019),
    HANGING_ROOTS((short) 1020),
    ROOTED_DIRT((short) 1021),
    MUD((short) 1022),
    DEEPSLATE((short) 1023),
    COBBLED_DEEPSLATE((short) 1024),
    COBBLED_DEEPSLATE_STAIRS((short) 1025),
    COBBLED_DEEPSLATE_SLAB((short) 1026),
    COBBLED_DEEPSLATE_WALL((short) 1027),
    POLISHED_DEEPSLATE((short) 1028),
    POLISHED_DEEPSLATE_STAIRS((short) 1029),
    POLISHED_DEEPSLATE_SLAB((short) 1030),
    POLISHED_DEEPSLATE_WALL((short) 1031),
    DEEPSLATE_TILES((short) 1032),
    DEEPSLATE_TILE_STAIRS((short) 1033),
    DEEPSLATE_TILE_SLAB((short) 1034),
    DEEPSLATE_TILE_WALL((short) 1035),
    DEEPSLATE_BRICKS((short) 1036),
    DEEPSLATE_BRICK_STAIRS((short) 1037),
    DEEPSLATE_BRICK_SLAB((short) 1038),
    DEEPSLATE_BRICK_WALL((short) 1039),
    CHISELED_DEEPSLATE((short) 1040),
    CRACKED_DEEPSLATE_BRICKS((short) 1041),
    CRACKED_DEEPSLATE_TILES((short) 1042),
    INFESTED_DEEPSLATE((short) 1043),
    SMOOTH_BASALT((short) 1044),
    RAW_IRON_BLOCK((short) 1045),
    RAW_COPPER_BLOCK((short) 1046),
    RAW_GOLD_BLOCK((short) 1047),
    POTTED_AZALEA_BUSH((short) 1048),
    POTTED_FLOWERING_AZALEA_BUSH((short) 1049),
    OCHRE_FROGLIGHT((short) 1050),
    VERDANT_FROGLIGHT((short) 1051),
    PEARLESCENT_FROGLIGHT((short) 1052),
    FROGSPAWN((short) 1053),
    REINFORCED_DEEPSLATE((short) 1054),
    DECORATED_POT((short) 1055),
    CRAFTER((short) 1056),
    TRIAL_SPAWNER((short) 1057),
    VAULT((short) 1058);

    private final short id;

    private static final Map<Short, BlockType> idMap = new HashMap<>();
    private static final Map<String, BlockType> nameMap = new HashMap<>();

    static {
        for (BlockType type : BlockType.values()) {
            idMap.put(type.getId(), type);
            nameMap.put(type.name(), type);
        }
    }

    BlockType(short id) {
        this.id = id;
    }

    public short getId() {
        return id;
    }

    public static BlockType getById(short id) {
        return idMap.get(id);
    }

    public static BlockType getByName(String name) {
        return nameMap.get(name);
    }
}