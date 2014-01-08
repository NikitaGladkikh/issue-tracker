databaseChangeLog {
    //create table projects
    include(file: 'projectsInit.groovy', relativeToChangelogFile: true)
    //create table status
    include(file: 'statusesInit.groovy', relativeToChangelogFile: true)
    //create table type
    include(file: 'typesInit.groovy', relativeToChangelogFile: true)
    //create table priority
    include(file: 'prioritiesInit.groovy', relativeToChangelogFile: true)
    //create table severity
    include(file: 'severetiesInit.groovy', relativeToChangelogFile: true)
    //create table resolution
    include(file: 'resolutionsInit.groovy', relativeToChangelogFile: true)
    //insert status data
    include(file: 'statusesInsert.groovy', relativeToChangelogFile: true)
    //insert type data
    include(file: 'typesInsert.groovy', relativeToChangelogFile: true)
    //insert priority data
    include(file: 'prioritiesInsert.groovy', relativeToChangelogFile: true)
    //insert severity data
    include(file: 'severetiesInsert.groovy', relativeToChangelogFile: true)
    //insert resolution data
    include(file: 'resolutionsInsert.groovy', relativeToChangelogFile: true)
    //insert project data
    include(file: 'projectInsert.groovy', relativeToChangelogFile: true)
    //insert issues table
    include(file: 'issuesInit.groovy', relativeToChangelogFile: true)
    //insert issues data
    include(file: 'issuesInsert.groovy', relativeToChangelogFile: true)
    //insert comments table
    include(file: 'commentsInit.groovy', relativeToChangelogFile: true)
    //insert comments data
    include(file: 'commentsInsert.groovy', relativeToChangelogFile: true)
}
