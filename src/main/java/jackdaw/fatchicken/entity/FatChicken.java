package jackdaw.fatchicken.entity;

import jackdaw.fatchicken.registry.EntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FatChicken extends Chicken {
    public FatChicken(EntityType<? extends Chicken> p_28236_, Level p_28237_) {
        super(p_28236_, p_28237_);
    }

    public static FatChicken make(Level level) {
        return new FatChicken(EntityRegistry.FAT_CHICKEN.get(), level);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround && vec3.y < 0.0D) {
            this.setDeltaMovement(vec3.multiply(1.0D, 1.2D, 1.0D)); //fall faster then a real chicken
        }
    }

    @Override
    public boolean canBreed() {
        return false;
    }
}
