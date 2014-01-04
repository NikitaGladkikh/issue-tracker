databaseChangeLog {
    changeSet(id: '2014-01-04-01', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'status' table")

        createTable(tableName: 'status', schemaName: 'public', tablespace: 'works_data',
                remarks: 'Reference table for storing projects which will be used in the application') {

            column(name: 'status_uid', type: 'VARCHAR(3)', remarks: 'The id of the status') {
                constraints(nullable: false)
            }
            column(name: 'status_name', type: 'VARCHAR(255)', remarks: 'The name of the status') {
                constraints(nullable: false)
            }
        }

        addPrimaryKey(schemaName: 'public', tableName: 'status', tablespace: 'works_index',
                columnNames: 'status_uid', constraintName: 'PK_status_uid')

        rollback {
            //automatic rollback
        }
    }
}
