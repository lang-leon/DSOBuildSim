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

export function formatStatValue(value: number): string
{
    return "+ "+value*100+"%";
}