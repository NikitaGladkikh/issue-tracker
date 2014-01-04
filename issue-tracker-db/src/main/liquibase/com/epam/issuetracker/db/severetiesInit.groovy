databaseChangeLog {
    changeSet(id: '2014-01-04-04', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'severity' table")

        createTable(tableName: 'severity', schemaName: 'public', tablespace: 'works_data',
                remarks: 'Reference table for storing severity which will be used in the application') {

            column(name: 'severity_uid', type: 'VARCHAR(3)', remarks: 'The id of the severity') {
                constraints(nullable: false)
            }
            column(name: 'severity_name', type: 'VARCHAR(255)', remarks: 'The name of the severity') {
                constraints(nullable: false)
            }
        }

        addPrimaryKey(schemaName: 'public', tableName: 'severity', tablespace: 'works_index',
                columnNames: 'severity_uid', constraintName: 'PK_severity_uid')

        rollback {
            //automatic rollback
        }
    }
}
