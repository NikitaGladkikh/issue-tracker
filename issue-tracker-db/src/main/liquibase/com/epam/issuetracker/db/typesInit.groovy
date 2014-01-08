databaseChangeLog {
    changeSet(id: '2014-01-04-00', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'type' table")

        createTable(tableName: 'type', schemaName: issueTrackerShema, tablespace: tableSpaceData,
                remarks: 'Reference table for storing type which will be used in the application') {

            column(name: 'type_uid', type: 'VARCHAR(3)', remarks: 'The id of the type') {
                constraints(nullable: false)
            }
            column(name: 'type_name', type: 'VARCHAR(255)', remarks: 'The name of the type') {
                constraints(nullable: false)
            }
        }

        addPrimaryKey(schemaName: issueTrackerShema, tableName: 'type', tablespace: tableSpaceIndex,
                columnNames: 'type_uid', constraintName: 'PK_type_uid')

        rollback {
            //automatic rollback
        }
    }
}
