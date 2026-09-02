import { CharacterClass } from "../../enums/CharacterClass";
import { ClassSkillType } from "../../enums/ClassSkillType";
import { ItemSlot } from "../../enums/ItemSlot";
import { MasteryType } from "../../enums/MasteryType";
import { BuffInstanceDTO } from "./BuffInstanceDTO";
import { CollectorBagCategoryBonusInstanceDTO } from "./CollectorBagCategoryBonusInstanceDTO";
import { DragonCrestTrinketDTO } from "./DragonCrestTrinketDTO";
import { EssenceInstanceDTO } from "./EssenceInstanceDTO";
import { ItemInstanceDTO } from "./ItemInstanceDTO";
import { JewelTrinketDTO } from "./JewelTrinketDTO";
import { PetInstanceDTO } from "./PetInstanceDTO";
import { runeTrinketDTO } from "./RuneTrinketDTO";
import { WisdomSkillTreeInstanceDTO } from "./WisdomSkillTreeInstanceDTO";

export interface CharacterDTO {
    characterClass: CharacterClass;
    name: string;
    masteryType: MasteryType;
    masteryLevel: number;
    classSkillType: ClassSkillType;
    classSkillLevel: number;
    runeTrinkets: runeTrinketDTO[];
    jewelTrinkets: JewelTrinketDTO[];
    dragonCrest: DragonCrestTrinketDTO;
    items: Partial<Record<ItemSlot, ItemInstanceDTO>>;
    pet: PetInstanceDTO | null;
    essence: EssenceInstanceDTO | null;
    tonic: BuffInstanceDTO | null;
    physic: BuffInstanceDTO | null;
    wisdomSkillTree: WisdomSkillTreeInstanceDTO;
    collectorBagBuffs: CollectorBagCategoryBonusInstanceDTO[];
}