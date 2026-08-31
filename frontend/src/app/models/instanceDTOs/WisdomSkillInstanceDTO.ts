import { WisdomSkillType } from "../../enums/WisdomSkillType";

export interface WisdomSkillInstanceDTO {
    type: WisdomSkillType;
    currentLevel: number;
}