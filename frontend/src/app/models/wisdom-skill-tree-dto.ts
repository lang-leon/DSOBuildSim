import { WisdomGroupDefinitionDTO } from "./wisdom-group-definition-dto";

export interface WisdomSkillTreeDefinitionDTO {
    wisdomGroups: Record<string, WisdomGroupDefinitionDTO>
}