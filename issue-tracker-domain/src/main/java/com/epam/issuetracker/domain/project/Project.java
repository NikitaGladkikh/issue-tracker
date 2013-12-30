package com.epam.issuetracker.domain.project;

/**
 * Represents project data object
 * <p/>
 * Date: 12/18/13
 *
 * @author Mikita_Hladkikh
 */
public class Project {

    private String id;
    private String name;
    private String shortName;
    private String description;

    /**
     * Getter for id.
     *
     * @return id of project
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for id.
     *
     * @param id set new id for project.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for name.
     *
     * @return name of project
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name set new name for project.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for short name.
     *
     * @return short name of project
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Setter for short name.
     *
     * @param shortName set new short name of project.
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Getter for description.
     *
     * @return description of project.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description.
     *
     * @param description set new description of project.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Project)) {
            return false;
        }
        Project that = (Project) object;
        if (null != id ? !id.equals(that.id) : null != that.id) {
            return false;
        }
        if (null != name ? !name.equals(that.name) : null != that.name) {
            return false;
        }
        if (null != shortName ? !shortName.equals(that.shortName) : null != that.shortName) {
            return false;
        }
        if (null != description ? !description.equals(that.description) : null != that.description) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 37 + (null == id ? 0 : id.hashCode());
        result = 31 * result + (null == name ? 0 : name.hashCode());
        result = 31 * result + (null == shortName ? 0 : shortName.hashCode());
        return 31 * result + (null == description ? 0 : description.hashCode());
    }

    @Override
    public String toString() {
        return new StringBuilder("Name: ").append(name)
            .append(", Short Name: ")
            .append(shortName)
            .append(", Description: ")
            .append(description)
            .toString();
    }
}
