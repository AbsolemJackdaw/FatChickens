package jackdaw.fatchicken.capability;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.ladysnake.cca.api.v3.component.TransientComponent;

import java.util.Optional;

public class FabricFat extends CommonFat implements TransientComponent {

    public static Optional<FabricFat> get(LivingEntity animal) {

        return Components.DATA.maybeGet(animal);
    }

    @Override
    public void readData(ValueInput tag) {
        super.readFatData(tag);
    }

    @Override
    public void writeData(ValueOutput tag) {
        super.writeFatData(tag);

    }
}
