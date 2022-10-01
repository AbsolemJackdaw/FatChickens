package jackdaw.fatchicken.capability;

import dev.onyxstudios.cca.api.v3.component.TransientComponent;
import net.minecraft.world.entity.LivingEntity;

import java.util.Optional;

public class FabricFat extends CommonFat implements TransientComponent {

    public static class Fake extends FabricFat {

    }

    public static Optional<FabricFat> get(LivingEntity animal) {

        return Components.DATA.maybeGet(animal);
    }
}
