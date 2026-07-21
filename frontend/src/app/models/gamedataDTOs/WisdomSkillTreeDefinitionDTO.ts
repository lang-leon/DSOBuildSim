import { WisdomGroupType } from "../../enums/WisdomGroupType";
import { WisdomGroupDefinitionDTO } from "./WisdomGroupDefinitionDTO";

export interface WisdomSkillTreeDefinitionDTO {
    wisdomGroups: Record<WisdomGroupType, WisdomGroupDefinitionDTO>
}