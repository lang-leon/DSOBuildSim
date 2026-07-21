import { WisdomGroupType } from "../../enums/WisdomGroupType";
import { WisdomSkillType } from "../../enums/WisdomSkillType";
import { WisdomSkillInstanceDTO } from "./WisdomSkillInstanceDTO";

export interface WisdomGroupInstanceDTO {
    type: WisdomGroupType;
    wisdomSkills: Record<WisdomSkillType, WisdomSkillInstanceDTO>;
}