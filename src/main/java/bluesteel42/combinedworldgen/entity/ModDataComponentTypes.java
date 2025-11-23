package bluesteel42.combinedworldgen.entity;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.entity.cluckshroom.CluckshroomEntity;
import bluesteel42.combinedworldgen.entity.moobloom.MoobloomEntity;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<MoobloomEntity.Variant> MOOBLOOM_VARIANT = register(
            "moobloom/variant", builder -> builder.codec(MoobloomEntity.Variant.CODEC).packetCodec(MoobloomEntity.Variant.PACKET_CODEC)
    );
    public static final ComponentType<CluckshroomEntity.Variant> CLUCKSHROOM_VARIANT = register(
            "cluckshroom/variant", builder -> builder.codec(CluckshroomEntity.Variant.CODEC).packetCodec(CluckshroomEntity.Variant.PACKET_CODEC)
    );

    private static <T> ComponentType<T> register(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(CombinedWorldgen.MOD_ID, id), ((ComponentType.Builder)builderOperator.apply(ComponentType.builder())).build());
    }


    public static void initialize() {}
}
