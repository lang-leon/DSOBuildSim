import { Injectable } from "@angular/core";
import { EssenceDefinitionDTO } from "../models/gamedataDTOs/EssenceDefinitionDTO";
import { EssenceInstanceDTO } from "../models/instanceDTOs/EssenceInstanceDTO";
import { formatStatValueRelative } from "./display-utils";

@Injectable({ providedIn: 'root' })
export class EssenceService {
  private essenceConfig!: Record<string, EssenceDefinitionDTO>;

  setEssenceConfig(config: Record<string, EssenceDefinitionDTO>) {
    this.essenceConfig = config;
  }

  private getEssenceDescription(essence: EssenceDefinitionDTO | null, tier: number)
  {
    if (essence === null) return "";
    let desc = '';
    desc += (essence.damage[tier] !== undefined && essence.damage[tier] > 0) ? formatStatValueRelative(essence.damage[tier], 2) + " Damage" : "";
    if (essence.description[tier] !== undefined) 
        desc += "\n" + essence.description[tier];
    desc+="\nNo effect in official arenas."
    return desc.trim();
  }

  getEssenceInstanceDescription(essence: EssenceInstanceDTO | null): string {
    if (essence === null) return '';
    return this.getEssenceDescription(this.essenceConfig[essence.essenceType], essence.tier);
  }

  private getEssenceName(essenceType: string | null): string
  {
    if (essenceType === null) return '';
    return this.essenceConfig[essenceType].name;
  }

  getEssenceInstanceName(essence: EssenceInstanceDTO | null): string
  {
    if (essence === null) return '';
    return this.getEssenceName(essence.essenceType);
  }

}