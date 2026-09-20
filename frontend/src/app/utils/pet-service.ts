import { Injectable } from "@angular/core";
import { PetDefinitionDTO } from "../models/gamedataDTOs/PetDefinitionDTO";
import { formatStatName } from "./display-utils";
import { PetInstanceDTO } from "../models/instanceDTOs/PetInstanceDTO";

@Injectable({ providedIn: 'root' })
export class PetService {
  private petConfig!: Record<string, PetDefinitionDTO>;

  setPetConfig(config: Record<string, PetDefinitionDTO>) {
    this.petConfig = config;
  }

  private getPetDescription(pet: PetDefinitionDTO | null, tier: number)
  {
    if (pet === null) return "";
    let desc = '';
    for (const [key, value] of Object.entries(pet.stats[tier])) {
      desc += '+ ' + (value*100).toFixed(2) + "% " + formatStatName(key) + '\n';
    }
    if (pet.description[tier] !== undefined) 
        desc += pet.description[tier];
    return desc.trim();
  }

  getPetInstanceDescription(pet: PetInstanceDTO | null): string {
    if (pet === null) return '';
    return this.getPetDescription(this.petConfig[pet.petType], pet.tier);
  }

  private getPetName(petType: string | null): string
  {
    if (petType === null) return '';
    return formatStatName(petType);
  }

  getPetInstanceName(pet: PetInstanceDTO | null): string
  {
    if (pet === null) return '';
    return this.getPetName(pet.petType);
  }

}