package jackdaw.fatchicken;

import jackdaw.fatchicken.entity.FatAnimal;
import jackdaw.fatchicken.exception.NoSuchTransformationException;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class FatAnimalRegistry {

    private static final Map<EntityType<?>, FatAnimal> fatAnimals = new HashMap<>();

    public static void register(EntityType<?> skinny, FatAnimal fatAnimal) {
        fatAnimals.put(skinny, fatAnimal);
    }

    public static LivingEntity getFattyFromSkinny(@NotNull EntityType<?> skinny, @NotNull Level level) {
        if (fatAnimals.isEmpty())
            throw new RuntimeException("Empty Registry ! No entity will be spawned");
        if (fatAnimals.get(skinny) == null)
            throw new NoSuchTransformationException(skinny);
        if (fatAnimals.get(skinny).make() == null)
            throw new NoSuchTransformationException(String.format("no fatty registered for %s", skinny.getDescriptionId()));

        return (LivingEntity) fatAnimals.get(skinny).make().create(level);
    }
}
