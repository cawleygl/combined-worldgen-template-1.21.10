package bluesteel42.combinedworldgen.sound;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent ITEM_HONEY_DRINK = register("item.honey_bottle.drink");

    private static SoundEvent register(String id) {
        return Registry.register(Registries.SOUND_EVENT, Identifier.of(CombinedWorldgen.MOD_ID, id), SoundEvent.of(Identifier.ofVanilla(id)));
    }

    public static void initialize() {}
}
