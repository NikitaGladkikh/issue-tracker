databaseChangeLog {
    changeSet(id: '2014-01-04-00', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'severity' table")

        createTable(tableName: 'severity', schemaName: issueTrackerShema, tablespace: tableSpaceData,
                remarks: 'Reference table for storing severity which will be used in the application') {

            column(name: 'severity_uid', type: 'VARCHAR(3)', remarks: 'The id of the severity') {
                constraints(nullable: false)
            }
            column(name: 'severity_name', type: 'VARCHAR(255)', remarks: 'The name of the severity') {
                constraints(nullable: false)
            }
        }

        addPrimaryKey(schemaName: issueTrackerShema, tableName: 'severity', tablespace: tableSpaceIndex,
                columnNames: 'severity_uid', constraintName: 'PK_severity_uid')

        rollback {
            //automatic rollback
        }
    }
}
