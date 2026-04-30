package net.shackles_dev.tutorialbox.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public record RepugnantEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<RepugnantEnchantmentEffect> CODEC = MapCodec.unit(RepugnantEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(level == 1) {
            if(user.getType() != EntityType.PLAYER) {
                //user.dropStack(user.getWeaponStack().split(1));
                user.dropStack(context.stack());
            }
        }
        if(level == 2) {
            if(user.getType() != EntityType.PLAYER) {
                user.kill();
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
