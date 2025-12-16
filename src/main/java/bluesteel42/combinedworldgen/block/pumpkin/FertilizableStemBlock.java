package bluesteel42.combinedworldgen.block.pumpkin;

import com.mojang.datafixers.DataFixUtils;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Optional;

public class FertilizableStemBlock extends PlantBlock implements Fertilizable {
    public static final MapCodec<FertilizableStemBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            RegistryKey.createCodec(RegistryKeys.BLOCK).fieldOf("fruit").forGetter(block -> block.gourdBlock),
                            RegistryKey.createCodec(RegistryKeys.BLOCK).fieldOf("attached_stem").forGetter(block -> block.attachedStemBlock),
                            RegistryKey.createCodec(RegistryKeys.ITEM).fieldOf("seed").forGetter(block -> block.pickBlockItem),
                            createSettingsCodec()
                    )
                    .apply(instance, FertilizableStemBlock::new)
    );
    public static final int MAX_AGE = 7;
    public static final IntProperty AGE = Properties.AGE_7;
    private static final VoxelShape[] SHAPES_BY_AGE = Block.createShapeArray(7, age -> Block.createColumnShape(2.0, 0.0, 2 + age * 2));
    private final RegistryKey<Block> gourdBlock;
    private final RegistryKey<Block> attachedStemBlock;
    private final RegistryKey<Item> pickBlockItem;

    @Override
    public MapCodec<FertilizableStemBlock> getCodec() {
        return CODEC;
    }

    public FertilizableStemBlock(RegistryKey<Block> gourdBlock, RegistryKey<Block> attachedStemBlock, RegistryKey<Item> pickBlockItem, AbstractBlock.Settings settings) {
        super(settings);
        this.gourdBlock = gourdBlock;
        this.attachedStemBlock = attachedStemBlock;
        this.pickBlockItem = pickBlockItem;
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES_BY_AGE[state.get(AGE)];
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.FARMLAND);
    }

    protected static float getAvailableMoisture(Block block, BlockView world, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockPos = pos.down();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                float g = 0.0F;
                BlockState blockState = world.getBlockState(blockPos.add(i, 0, j));
                if (blockState.isOf(Blocks.FARMLAND)) {
                    g = 1.0F;
                    if ((Integer)blockState.get(FarmlandBlock.MOISTURE) > 0) {
                        g = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    g /= 4.0F;
                }

                f += g;
            }
        }

        BlockPos blockPos2 = pos.north();
        BlockPos blockPos3 = pos.south();
        BlockPos blockPos4 = pos.west();
        BlockPos blockPos5 = pos.east();
        boolean bl = world.getBlockState(blockPos4).isOf(block) || world.getBlockState(blockPos5).isOf(block);
        boolean bl2 = world.getBlockState(blockPos2).isOf(block) || world.getBlockState(blockPos3).isOf(block);
        if (bl && bl2) {
            f /= 2.0F;
        } else {
            boolean bl3 = world.getBlockState(blockPos4.north()).isOf(block)
                    || world.getBlockState(blockPos5.north()).isOf(block)
                    || world.getBlockState(blockPos5.south()).isOf(block)
                    || world.getBlockState(blockPos4.south()).isOf(block);
            if (bl3) {
                f /= 2.0F;
            }
        }

        return f;
    }

    private void growGourdBlock(ServerWorld world, BlockPos pos, Random random) {
        Direction direction = Direction.Type.HORIZONTAL.random(random);
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos.down());
        if (world.getBlockState(blockPos).isAir() && (blockState.isOf(Blocks.FARMLAND) || blockState.isIn(BlockTags.DIRT))) {
            Registry<Block> registry = world.getRegistryManager().getOrThrow(RegistryKeys.BLOCK);
            Optional<Block> optional = registry.getOptionalValue(this.gourdBlock);
            Optional<Block> optional2 = registry.getOptionalValue(this.attachedStemBlock);
            if (optional.isPresent() && optional2.isPresent()) {
                world.setBlockState(blockPos, ((Block)optional.get()).getDefaultState());
                world.setBlockState(pos, ((Block)optional2.get()).getDefaultState().with(HorizontalFacingBlock.FACING, direction));
            }
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            float f = getAvailableMoisture(this, world, pos);
            if (random.nextInt((int)(25.0F / f) + 1) == 0) {
                int i = (Integer)state.get(AGE);
                if (i < 7) {
                    state = state.with(AGE, i + 1);
                    world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
                } else {
                    growGourdBlock(world, pos, random);
                }
            }
        }
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(DataFixUtils.orElse(world.getRegistryManager().getOrThrow(RegistryKeys.ITEM).getOptionalValue(this.pickBlockItem), this));
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    private void growStemBlock(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = Math.min(7, (Integer)state.get(AGE) + MathHelper.nextInt(world.random, 2, 5));
        BlockState blockState = state.with(AGE, i);
        world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
        if (i == 7) {
            blockState.randomTick(world, pos, world.random);
        }
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if ((Integer)state.get(AGE) < 7) {
            growStemBlock(world, random, pos, state);
        } else {
            growGourdBlock(world, pos, random);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
