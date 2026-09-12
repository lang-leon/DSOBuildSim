import { WisdomGroupType } from "../../enums/WisdomGroupType";
import { WisdomSkillType } from "../../enums/WisdomSkillType";
import { BuffDefinitionDTO } from "./BuffDefinitionDTO";
import { ClassStatsDTO } from "./ClassStatsDTO";
import { CollectorBagCategoryBonusDefinitionDTO } from "./CollectorBagCategoryBonusDefinitionDTO";
import { DragonStoneDefinitionDTO } from "./DragonStoneDefinitionDTO";
import { EnchantmentDTO } from "./EnchantmentDTO";
import { EssenceDefinitionDTO } from "./EssenceDefinitionDTO";
import { GemDefinitionDTO } from "./GemDefinitionDTO";
import { ItemDefinitionDTO } from "./ItemDefinitionDTO";
import { JewelDefinitionDTO } from "./JewelDefinitionDTO";
import { LevelMultiplierTableDTO } from "./LevelMultiplierTableDTO";
import { PetDefinitionDTO } from "./PetDefinitionDTO";
import { RuneDefinitionDTO } from "./RuneDefinitionDTO";
import { SetDTO } from "./SetDTO";
import { WisdomGroupDefinitionDTO } from "./WisdomGroupDefinitionDTO";
import { WisdomSkillDefinitionDTO } from "./WisdomSkillDefinitionDTO";

export interface GameDataDTO {
    characterClassStats:  Record<string, ClassStatsDTO>;
    items: Record<string, ItemDefinitionDTO[]>;
    sets: Record<string, Record<string, SetDTO[]>>;
    jewels: Record<string, Record<string, JewelDefinitionDTO>>;
    jewelLimits: Record<string, number>;
    enchantments: EnchantmentDTO[];
    gems: GemDefinitionDTO[];
    runes: Record<string, RuneDefinitionDTO>;
    runeLimits: Record<string, number>;
    dragonStones: DragonStoneDefinitionDTO[];
    pets: PetDefinitionDTO[];
    essences: EssenceDefinitionDTO[];
    tonics: BuffDefinitionDTO[];
    physics: BuffDefinitionDTO[];
    levelMultiplierTable: LevelMultiplierTableDTO;
    wisdomSkills: Record<WisdomSkillType, WisdomSkillDefinitionDTO>
    wisdomGroups: Record<WisdomGroupType, WisdomGroupDefinitionDTO>
    collectorBagBuffs: CollectorBagCategoryBonusDefinitionDTO[];
}