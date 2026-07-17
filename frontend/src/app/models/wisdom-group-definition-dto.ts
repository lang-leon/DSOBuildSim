import { WisdomSkillDefinitionDTO } from "./wisdom-skill-definition-dto";

export interface WisdomGroupDefinitionDTO {
    type: string;
    name: string;
    maxLevel: number;
    wisdomSkills: Record<string, WisdomSkillDefinitionDTO>;
}