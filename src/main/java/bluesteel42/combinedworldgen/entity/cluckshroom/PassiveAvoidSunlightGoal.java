package bluesteel42.combinedworldgen.entity.cluckshroom;

import net.minecraft.entity.ai.NavigationConditions;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.mob.PathAwareEntity;

public class PassiveAvoidSunlightGoal extends Goal {
    private final PathAwareEntity mob;

    public PassiveAvoidSunlightGoal(PathAwareEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canStart() {
        return this.mob.getEntityWorld().isDay() && NavigationConditions.hasMobNavigation(this.mob);
    }

    @Override
    public void start() {
        if (this.mob.getNavigation() instanceof MobNavigation mobNavigation) {
            mobNavigation.setAvoidSunlight(true);
        }
    }

    @Override
    public void stop() {
        if (NavigationConditions.hasMobNavigation(this.mob) && this.mob.getNavigation() instanceof MobNavigation mobNavigation) {
            mobNavigation.setAvoidSunlight(false);
        }
    }
}

