import { WisdomGroupType } from "../../enums/WisdomGroupType";
import { WisdomGroupInstanceDTO } from "./WisdomGroupInstanceDTO";

export interface WisdomSkillTreeInstanceDTO {
    wisdomGroups: Record<WisdomGroupType, WisdomGroupInstanceDTO>;
}