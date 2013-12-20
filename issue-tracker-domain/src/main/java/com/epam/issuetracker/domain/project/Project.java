package com.epam.issuetracker.domain.project;

/**
 * Represents project data object
 * <p/>
 * Date: 12/18/13
 *
 * @author Mikita_Hladkikh
 */
public class Project {

    private String name;
    private String shortName;
    private String description;

    /**
     * Default constructor.
     */
    public Project() {

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
        if (null == object) {
            return false;
        }
        if (!(object instanceof Project)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        Project project = (Project) object;
        return name.equals(project.name) && shortName.equals(project.shortName) && description.equals(
            project.description);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 37 * result + name.hashCode();
        result = 37 * result + shortName.hashCode();
        result = 37 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Name: ")
            .append(name)
            .append(", Short Name: ")
            .append(shortName)
            .append(", Description: ")
            .append(
                description)
            .toString();
    }
}
