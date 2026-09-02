import { StatType } from '../enums/StatType';
import { DragonStoneDefinitionDTO } from '../models/gamedataDTOs/DragonStoneDefinitionDTO';
import { DragonStoneInstanceDTO } from '../models/instanceDTOs/DragonStoneInstanceDTO';

export function formatStatName(stat: StatType | string): string {
  return stat
    .toString()
    .toLowerCase()
    .split('_')
    .map((word) => word.charAt(0).toUpperCase() + word.slice(1))
    .join(' ');
}

export function formatName<T>(value: T): string {
  return String(value)
    .toLowerCase()
    .split('_')
    .map((word) => word.charAt(0).toUpperCase() + word.slice(1))
    .join(' ');
}

export function formatStatValueRelative(value: number, digits: number): string {
  return '+ ' + (value * 100).toFixed(digits) + '%';
}

export function formatStatValueAbsolute(value: number, digits: number): string {
  return '+ ' + value.toFixed(digits);
}

export function getIcon<T>(type: string, tier: number) {
  const typeName = type.toLowerCase().replace('_', '-');

  let tierName: string;

  switch (tier) {
    case 1:
      tierName = 'common';
      break;
    case 2:
      tierName = 'improved';
      break;
    case 3:
      tierName = 'magic';
      break;
    case 4:
      tierName = 'extraordinary';
      break;
    case 5:
      tierName = 'legendary';
      break;
    case 6:
      tierName = 'unique';
      break;
    case 7:
      tierName = 'mythic';
      break;
    default:
      return 'default.png';
  }

  return `${typeName}-${tierName}.png`;
}

//Dragonstones

export function getDragonStoneIcon(dragonStoneType: string, tier: number) {
  const stoneType = dragonStoneType.toLowerCase().replace('_', '-');

  let tierName: string;

  switch (tier) {
    case 3:
      tierName = 'dragon-hatchlings';
      break;
    case 4:
      tierName = 'mighty-dragons';
      break;
    case 5:
      tierName = 'dragon-elders';
      break;
    default:
      return 'dragon-stone-icons/empty-dragon-stone.png';
  }

  return `dragon-stone-icons/${tierName}-${stoneType}.png`;
}

export function getDragonStoneName(dragonStoneType: string, tier: number) {
  const stoneType = formatName(dragonStoneType);

  let tierName: string;

  switch (tier) {
    case 3:
      tierName = "Dragon Hatchling's";
      break;
    case 4:
      tierName = "Mighty Dragon's";
      break;
    case 5:
      tierName = "Dragon Elder's";
      break;
    default:
      return 'Empty';
  }

  return `${tierName} ${stoneType}`;
}

export function getDragonStoneDescription(dragonStone: DragonStoneDefinitionDTO, tier: number){
    return dragonStone.description[tier];
}


// Jewels
