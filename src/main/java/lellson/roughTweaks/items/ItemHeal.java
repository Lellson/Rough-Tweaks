package lellson.roughTweaks.items;

import java.util.List;
import java.util.Random;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHeal extends Item {
	
	private final int healRate;
	private final float healAmount;
	private final PotionEffect effect;
	private final ItemStack returnStack;

	public ItemHeal(String name, int useCount, int healRate, float healAmount, PotionEffect effect, ItemStack returnStack) {
		
		this.healRate = healRate;
		this.healAmount = healAmount;
		this.effect = effect;
		this.returnStack = returnStack;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		setMaxStackSize(1);
		setMaxDamage(useCount);
		
		if (useCount > 0)
			RoughItems.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		
		ItemStack stack = player.getHeldItem(hand);
		
		if (player.capabilities.isCreativeMode)
			return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
		
		player.setActiveHand(hand);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

	@Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return effect != null;
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
		
		if (count % healRate == 1) 
		{
			stack.damageItem(1, player);
			player.heal(healAmount);
			
			if (effect != null)
				player.addPotionEffect(new PotionEffect(effect));
			
			if (stack.getItemDamage() >= getMaxDamage(stack))
			{
				player.setHeldItem(player.getActiveHand(), returnStack == null ? ItemStack.EMPTY : returnStack);
				player.playSound(SoundEvents.BLOCK_CLOTH_PLACE, 1.0F, 0.5F);
				player.stopActiveHand();
			}
			else
			{
				player.playSound(SoundEvents.BLOCK_CLOTH_PLACE, 1.0F, 1.5F);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		if (GuiScreen.isShiftKeyDown())
		{
			float hearts = healAmount/2;
			if (hearts % 1.0 == 0)
				tooltip.add(TextFormatting.BLUE + "Heal Amount: " + (int)hearts + " Hearts");
			else
				tooltip.add(TextFormatting.BLUE + "Heal Amount: " + hearts + " Hearts");
		}
	}
}
