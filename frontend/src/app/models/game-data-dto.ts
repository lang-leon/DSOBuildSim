import { BuffDefinitionDTO } from "./buff-definition-dto";
import { ClassStatsDTO } from "./class-stats-dto";
import { DragonStoneDefinitionDTO } from "./dragon-stone-definition-dto";
import { EnchantmentDTO } from "./enchantment-dto";
import { EssenceDefinitionDTO } from "./essence-definition-dto";
import { GemDefinitionDTO } from "./gem-definition-dto";
import { ItemDefinitionDTO } from "./item-definition-dto";
import { JewelDefinitionDTO } from "./jewel-definition-dto";
import { LevelMultiplierTableDTO } from "./level-multiplier-table-dto";
import { PetDefinitionDTO } from "./pet-definition-dto";
import { RuneDefinitionDTO } from "./rune-definition-dto";
import { SetDTO } from "./set-dto";
import { WisdomSkillTreeDefinitionDTO } from "./wisdom-skill-tree-dto";

export interface GameDataDTO {
    characterClassStats:  Record<string, ClassStatsDTO>;
    items: Record<string, ItemDefinitionDTO[]>;
    sets: Record<string, SetDTO[]>;
    jewels: Record<string, JewelDefinitionDTO[]>;
    enchantments: EnchantmentDTO[];
    gems: GemDefinitionDTO[];
    runes: RuneDefinitionDTO[];
    dragonStones: DragonStoneDefinitionDTO[];
    pets: PetDefinitionDTO[];
    essences: EssenceDefinitionDTO[];
    tonics: BuffDefinitionDTO[];
    physics: BuffDefinitionDTO[];
    levelMultiplierTable: LevelMultiplierTableDTO;
    wisdomSkillTree: WisdomSkillTreeDefinitionDTO;
}