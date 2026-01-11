package jackdaw.fatchicken.entity.render.cloth;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;

public class TableClothRenderState extends EntityRenderState {

    public final ItemStackRenderState clothState = new ItemStackRenderState();
    public Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public TableClothRenderState() {
        this.direction = Direction.NORTH;
    }
}
