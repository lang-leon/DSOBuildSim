import { MasteryType } from '../enums/MasteryType';

export function getMasteryDescription(type: MasteryType, level: number): string {
  if (type === undefined) return '';
  switch (type) {
    case MasteryType.FIRE:
      return (
        '+ ' +
        (50 + (level - 1) * 5).toFixed(2) +
        ' % Fire Resistance\n- ' +
        (25).toFixed(2) +
        ' % Ice Resistance\n- ' +
        (25).toFixed(2) +
        ' % Lightning Resistance\n- ' +
        (25).toFixed(2) +
        ' % Poison Resistance'
      );
    case MasteryType.ICE:
      return (
        '- ' +
        (25).toFixed(2) +
        ' % Fire Resistance\n+ ' +
        (50 + (level - 1) * 5).toFixed(2) +
        ' % Ice Resistance\n- ' +
        (25).toFixed(2) +
        ' % Lightning Resistance\n- ' +
        (25).toFixed(2) +
        ' % Poison Resistance'
      );
    case MasteryType.LIGHTNING:
      return (
        '- ' +
        (25).toFixed(2) +
        ' % Fire Resistance\n- ' +
        (25).toFixed(2) +
        ' % Ice Resistance\n+ ' +
        (50 + (level - 1) * 5).toFixed(2) +
        ' % Lightning Resistance\n- ' +
        (25).toFixed(2) +
        ' % Poison Resistance'
      );
    case MasteryType.POISON:
      return (
        '- ' +
        (25).toFixed(2) +
        ' % Fire Resistance\n- ' +
        (25).toFixed(2) +
        ' % Ice Resistance\n- ' +
        (25).toFixed(2) +
        ' % Lightning Resistance\n+ ' +
        (50 + (level - 1) * 5).toFixed(2) +
        ' % Poison Resistance'
      );
    case MasteryType.NONE:
      return '';
  }
}

export function getTierName(tier: number | null): string {
  if (tier === null) return '';
  switch (tier) {
    case 0:
      return 'set';
    case 1:
      return 'common';
    case 2:
      return 'improved';
    case 3:
      return 'magic';
    case 4:
      return 'extraordinary';
    case 5:
      return 'legendary';
    case 6:
      return 'unique';
    case 7:
      return 'mythic';
    case 8:
      return 'mythicplus';
    default:
      return '';
  }
}
