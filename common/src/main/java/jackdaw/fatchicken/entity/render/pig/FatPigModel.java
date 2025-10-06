package jackdaw.fatchicken.entity.render.pig;

import jackdaw.fatchicken.entity.FatPig;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class FatPigModel<F extends FatPig> extends PigModel<FatPig> {
    public FatPigModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, CubeDeformation.NONE);
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 8).addBox(-5.0F, -11.0F, -7.0F, 10.0F, 16.0F, 8.0F, CubeDeformation.NONE.extend(1.5f)), PartPose.offsetAndRotation(0.0F, 11f, 2.0F, ((float) Math.PI / 2F), 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F).texOffs(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 12.0F, -6.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }
}
