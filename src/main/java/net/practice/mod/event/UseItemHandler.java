package net.practice.mod.event;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.practice.mod.Item.ModItems;
import net.practice.mod.util.IEntityDataSaver;

import java.util.Map;
import java.util.stream.Stream;

public class UseItemHandler implements UseItemCallback {


    @Override
    public TypedActionResult<ItemStack> interact(PlayerEntity player, World world, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item itemOnHand = itemStack.getItem();
        String citrineItemName = ModItems.CITRINE.getTranslationKey();
        String itemOnHandName = itemOnHand.getTranslationKey();

        if(world.isClient() || itemOnHandName != citrineItemName ) return TypedActionResult.pass(itemStack);

        IEntityDataSaver dataSaver = (IEntityDataSaver) player;
        int item_level = dataSaver.getPersistentData().getInt("item_level");
        int newItemLevel = item_level + 1;
        if(newItemLevel>20){
            newItemLevel = 1;
        }
        dataSaver.setPersistentData("item_level", newItemLevel );

        player.sendMessage(
                Text.literal(
                        String.valueOf(newItemLevel))
                );
        createExplotion(world,player,item_level);
        return TypedActionResult.pass(itemStack);
    }

    private boolean addFireAspect10(ItemStack itemStack, PlayerEntity player){

        boolean hasAlreadyFireAspect = hasFireAspect10(itemStack, player);

        if(hasAlreadyFireAspect) return false;
        itemStack.addEnchantment(Enchantments.FIRE_ASPECT,10);
        return true;
    }
    private boolean hasFireAspect10(ItemStack itemStack,PlayerEntity player) {
        Enchantment enchantment = Enchantments.FIRE_ASPECT;
        int level = 10;
        Stream<Map.Entry<Enchantment, Integer>> enchantmentStream = EnchantmentHelper.get(itemStack).entrySet().stream();

        boolean isAlreadyEnchanted = enchantmentStream.anyMatch(entry -> entry.getKey() == enchantment && entry.getValue() == level);

       return isAlreadyEnchanted;
    }

    private boolean createExplotion(World world, PlayerEntity player, int explosion_amplifier){

        HitResult hitResult =  player.raycast(100.0D, 0.0F, false);
        if(hitResult.getType() != HitResult.Type.BLOCK) return false;
        Vec3d blockPos = hitResult.getPos();

        final float damagePower = 2.0f * explosion_amplifier;
        final boolean createFire = true;
        final World.ExplosionSourceType explotionSourceType = World.ExplosionSourceType.TNT;
         Explosion explotion = world.createExplosion(null, blockPos.x,blockPos.y,blockPos.z, damagePower ,createFire, explotionSourceType);
        explotion.affectWorld(true);
        explotion.shouldDestroy();

        return true;
    }
}
