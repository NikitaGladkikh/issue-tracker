package com.epam.issuetracker.domain.enums;

/**
 * Represent enum type data object.
 * <p/>
 * Date: 12/20/13
 *
 * @author Mikita_Hladkikh
 */
public enum TypeEnum {

    BUG("1", "bug"),
    ENVIRONMENT("2", "environment"),
    SPECIFICATION("3", "specification");

    private String id;
    private String name;

    private TypeEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for id of type.
     *
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for name of type.
     *
     * @return name.
     */
    public String getType() {
        return name;
    }

    public static TypeEnum lookById(String id) {
        for (TypeEnum type : values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Type not found");
    }
}
