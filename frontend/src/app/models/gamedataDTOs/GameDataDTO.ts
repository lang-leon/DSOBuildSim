import { CharacterClass } from "../../enums/CharacterClass";
import { StatType } from "../../enums/StatType";
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
    items: Record<CharacterClass, Record<string, ItemDefinitionDTO>>;
    sets: Record<string, Record<string, SetDTO>>;
    jewels: Record<string, Record<string, JewelDefinitionDTO>>;
    jewelLimits: Record<string, number>;
    enchantments: Partial<Record<StatType, EnchantmentDTO>>;
    gems: Record<string, GemDefinitionDTO>;
    gemLimits: Record<string, number>;
    runes: Record<string, RuneDefinitionDTO>;
    runeLimits: Record<string, number>;
    dragonStones: Record<string, DragonStoneDefinitionDTO>;
    pets: Record<string, PetDefinitionDTO>;
    essences: Record<string, EssenceDefinitionDTO>;
    tonics: Record<string, BuffDefinitionDTO>;
    physics: Record<string, BuffDefinitionDTO>;
    levelMultiplierTable: LevelMultiplierTableDTO;
    wisdomSkills: Record<WisdomSkillType, WisdomSkillDefinitionDTO>
    wisdomGroups: Record<WisdomGroupType, WisdomGroupDefinitionDTO>
    collectorBagBuffs: CollectorBagCategoryBonusDefinitionDTO[];
}