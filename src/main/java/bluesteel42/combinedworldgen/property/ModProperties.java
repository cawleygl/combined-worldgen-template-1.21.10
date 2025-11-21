package bluesteel42.combinedworldgen.property;

import net.minecraft.state.property.IntProperty;

public class ModProperties {
    /**
     * A property that specifies the amount of mushrooms attached to a birch trunk/log.
     */
    public static final IntProperty MUSHROOMS = IntProperty.of("mushrooms", 1, 3);
    /**
     * A property that specifies the amount of healthy flowers on a moobloom.
     */
    public static final IntProperty FLOWERS = IntProperty.of("flowers", 0, 4);
}
