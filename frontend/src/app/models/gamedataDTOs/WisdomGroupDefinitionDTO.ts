import { WisdomGroupType } from "../../enums/WisdomGroupType";
import { WisdomSkillType } from "../../enums/WisdomSkillType";
import { WisdomSkillDefinitionDTO } from "./WisdomSkillDefinitionDTO";

export interface WisdomGroupDefinitionDTO {
    type: WisdomGroupType;
    name: string;
    maxLevel: number;
    wisdomSkills: Record<WisdomSkillType, WisdomSkillDefinitionDTO>;
}