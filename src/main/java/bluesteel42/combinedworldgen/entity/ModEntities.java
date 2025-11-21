package bluesteel42.combinedworldgen.entity;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.entity.cluckshroom.CluckshroomEggEntity;
import bluesteel42.combinedworldgen.entity.cluckshroom.CluckshroomEntity;
import bluesteel42.combinedworldgen.entity.moobloom.MoobloomEntity;
import bluesteel42.combinedworldgen.entity.snow_golem.GreenPumpkinSnowGolemEntity;
import bluesteel42.combinedworldgen.entity.snow_golem.WhitePumpkinSnowGolemEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ShelfBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;

public class ModEntities {
    public static final String WHITE_PUMPKIN_SNOW_GOLEM_PATH = "white_pumpkin_snow_golem";
    public static final String GREEN_PUMPKIN_SNOW_GOLEM_PATH = "green_pumpkin_snow_golem";
    public static final String MOOBLOOM_PATH = "moobloom";
    public static final String CLUCKSHROOM_PATH = "cluckshroom";
    public static final String CLUCKSHROOM_EGG_PATH = "cluckshroom_egg";

    public static final EntityType<WhitePumpkinSnowGolemEntity> WHITE_PUMPKIN_SNOW_GOLEM = registerWhitePumpkinSnowGolem();
    public static final EntityType<GreenPumpkinSnowGolemEntity> GREEN_PUMPKIN_SNOW_GOLEM = registerGreenPumpkinSnowGolem();
    public static final EntityType<MoobloomEntity> MOOBLOOM = registerMoobloom();
    public static final EntityType<CluckshroomEntity> CLUCKSHROOM = registerCluckshroom();
    public static final EntityType<CluckshroomEggEntity> CLUCKSHROOM_EGG = registerCluckshroomEgg();

    public static EntityType<WhitePumpkinSnowGolemEntity> registerWhitePumpkinSnowGolem() {
        final Identifier identifier = Identifier.of(CombinedWorldgen.MOD_ID, WHITE_PUMPKIN_SNOW_GOLEM_PATH);
        final RegistryKey<EntityType<?>> registryKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, identifier);

        return Registry.register(
                Registries.ENTITY_TYPE,
                identifier,
                EntityType.Builder.create(WhitePumpkinSnowGolemEntity::new, SpawnGroup.MISC)
                        .allowSpawningInside(Blocks.POWDER_SNOW)
                        .dimensions(0.7F, 1.9F)
                        .eyeHeight(1.7F)
                        .maxTrackingRange(8)
                        .build(registryKey)
        );
    }
    public static EntityType<GreenPumpkinSnowGolemEntity> registerGreenPumpkinSnowGolem() {
        final Identifier identifier = Identifier.of(CombinedWorldgen.MOD_ID, GREEN_PUMPKIN_SNOW_GOLEM_PATH);
        final RegistryKey<EntityType<?>> registryKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, identifier);

        return Registry.register(
                Registries.ENTITY_TYPE,
                identifier,
                EntityType.Builder.create(GreenPumpkinSnowGolemEntity::new, SpawnGroup.MISC)
                        .allowSpawningInside(Blocks.POWDER_SNOW)
                        .dimensions(0.7F, 1.9F)
                        .eyeHeight(1.7F)
                        .maxTrackingRange(8)
                        .build(registryKey)
        );
    }

    public static EntityType<MoobloomEntity> registerMoobloom() {
        final Identifier identifier = Identifier.of(CombinedWorldgen.MOD_ID, MOOBLOOM_PATH);
        final RegistryKey<EntityType<?>> registryKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, identifier);

        return Registry.register(
                Registries.ENTITY_TYPE,
                identifier,
                EntityType.Builder.create(MoobloomEntity::new, SpawnGroup.CREATURE)
                        .dimensions(0.9F, 1.4F)
                        .eyeHeight(1.3F)
                        .passengerAttachments(1.36875F)
                        .maxTrackingRange(10)
                        .build(registryKey)
        );
    }

    public static EntityType<CluckshroomEntity> registerCluckshroom() {
        final Identifier identifier = Identifier.of(CombinedWorldgen.MOD_ID, CLUCKSHROOM_PATH);
        final RegistryKey<EntityType<?>> registryKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, identifier);

        EntityType<CluckshroomEntity> cluckshroom = Registry.register(
                Registries.ENTITY_TYPE,
                identifier,
                EntityType.Builder.create(CluckshroomEntity::new, SpawnGroup.CREATURE)
                        .dimensions(0.4F, 0.7F)
                        .eyeHeight(0.644F)
                        .passengerAttachments(new Vec3d(0.0, 0.7, -0.1))
                        .maxTrackingRange(10)
                        .build(registryKey)
        );

        SpawnRestriction.register(cluckshroom, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CluckshroomEntity::canSpawn);

        return cluckshroom;
    }

    public static EntityType<CluckshroomEggEntity> registerCluckshroomEgg() {
        final Identifier identifier = Identifier.of(CombinedWorldgen.MOD_ID, CLUCKSHROOM_EGG_PATH);
        final RegistryKey<EntityType<?>> registryKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, identifier);

        return Registry.register(
                Registries.ENTITY_TYPE,
                identifier,
                EntityType.Builder.<CluckshroomEggEntity>create(CluckshroomEggEntity::new, SpawnGroup.MISC)
                        .dropsNothing()
                        .dimensions(0.25F, 0.25F)
                        .maxTrackingRange(4)
                        .trackingTickInterval(10)
                        .build(registryKey)
        );
    }

    public static void initialize() {
        FabricDefaultAttributeRegistry.register(WHITE_PUMPKIN_SNOW_GOLEM, WhitePumpkinSnowGolemEntity.createSnowGolemAttributes());
        FabricDefaultAttributeRegistry.register(GREEN_PUMPKIN_SNOW_GOLEM, GreenPumpkinSnowGolemEntity.createSnowGolemAttributes());
        FabricDefaultAttributeRegistry.register(MOOBLOOM, MoobloomEntity.createCowAttributes());
        FabricDefaultAttributeRegistry.register(CLUCKSHROOM, CluckshroomEntity.createChickenAttributes());
    }
}
