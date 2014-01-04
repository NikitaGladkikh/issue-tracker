databaseChangeLog {
    changeSet(id: '2014-01-04-00', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'projects' table")

        createTable(tableName: 'projects', schemaName: 'public', tablespace: 'works_data',
                remarks: 'Reference table for storing projects which will be used in the application') {

            column(name: 'project_uid', type: 'VARCHAR(255)', remarks: 'The id of the project') {
                constraints(nullable: false)
            }
            column(name: 'project_name', type: 'VARCHAR(255)', remarks: 'The name of the project') {
                constraints(nullable: false)
            }
            column(name: 'project_short_name', type: 'VARCHAR(255)', remarks: 'The short name of the project') {
                constraints(nullable: false)
            }
            column(name: 'project_description', type: 'VARCHAR(255)', remarks: 'The description of the project') {
                constraints(nullable: false)
            }
            column(name: 'project_state', type: 'BOOLEAN', remarks: 'The state of the project') {
                constraints(nullable: false)
            }
            column(name: 'created_datetime', type: 'TIMESTAMPTZ', defaultValueDate: 'now()', remarks: 'The date and time this project was created') {
                constraints(nullable: false)
            }
        }

        addPrimaryKey(schemaName: 'public', tableName: 'projects', tablespace: 'works_index',
                columnNames: 'project_uid', constraintName: 'PK_project_uid')

        rollback {
            //automatic rollback
        }
    }
}
