import { StatType } from "../enums/StatType";

export function formatStatName(stat: StatType | string): string 
{
    return stat
        .toString()
        .toLowerCase()
        .split('_')
        .map(word =>
            word.charAt(0).toUpperCase() + word.slice(1)
        )
        .join(' ');
}

export function formatName<T>(value: T): string {
  return String(value)
    .toLowerCase()
    .split('_')
    .map(word =>
      word.charAt(0).toUpperCase() + word.slice(1)
    )
    .join(' ');
}

export function formatStatValueRelative(value: number, digits: number): string
{
    return "+ "+(value*100).toFixed(digits)+"%";
}

export function formatStatValueAbsolute(value: number, digits: number): string
{
    return "+ "+value.toFixed(digits);
}