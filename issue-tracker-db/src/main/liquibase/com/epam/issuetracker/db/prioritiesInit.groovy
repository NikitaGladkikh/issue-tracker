databaseChangeLog {
    changeSet(id: '2014-01-04-00', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'priority' table")

        createTable(tableName: 'priority', schemaName: issueTrackerShema, tablespace: tableSpaceData,
                remarks: 'Reference table for storing priority which will be used in the application') {

            column(name: 'priority_uid', type: 'VARCHAR(3)', remarks: 'The id of the priority') {
                constraints(nullable: false)
            }
            column(name: 'priority_name', type: 'VARCHAR(255)', remarks: 'The name of the priority') {
                constraints(nullable: false)
            }
        }

        addPrimaryKey(schemaName: issueTrackerShema, tableName: 'priority', tablespace: tableSpaceIndex,
                columnNames: 'priority_uid', constraintName: 'PK_priority_uid')

        rollback {
            //automatic rollback
        }
    }
}
