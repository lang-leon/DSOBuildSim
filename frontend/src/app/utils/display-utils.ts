import { StatType } from '../enums/StatType';

const tierNames: Record<number, string> = {
  0: 'set',
  1: 'common',
  2: 'improved',
  3: 'magic',
  4: 'extraordinary',
  5: 'legendary',
  6: 'unique',
  7: 'mythic',
  8: 'mythic+',
};

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

export function getIcon<T>(type: string | undefined, tier: number | undefined) {
  if (type === undefined || type === null) return 'default.png';
  const typeName = type.toLowerCase().replaceAll('_', '-').replaceAll(' ', '-');

  let tierName = tierNames[tier ?? -1];

  return `${typeName}-${tierName}.png`;
}

export function matchesSearch(text: string, search: string): boolean {
  const searchWords = search.toLowerCase().trim().split(/\s+/);

  const textLower = text.toLowerCase();

  return searchWords.every((word) => textLower.includes(word));
}
