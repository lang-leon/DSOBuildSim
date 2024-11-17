package kaukasus.Enums;

public enum SetTypeEnum {
    SET1("test");


    private final String name;

    SetTypeEnum(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
