package jackdaw.fatchicken.exception;

import net.minecraft.world.entity.EntityType;

public class NoSuchTransformationException extends RuntimeException {
    public NoSuchTransformationException(EntityType<?> type) {
        super("No Transformation has been found for the entitytype " + type.getDescriptionId());
    }
    public NoSuchTransformationException(String message) {
        super(message);
    }
}
