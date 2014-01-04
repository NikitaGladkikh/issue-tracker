databaseChangeLog {
    changeSet(id: '2014-01-04-05', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'resolution' table")

        createTable(tableName: 'resolution', schemaName: 'public', tablespace: 'works_data',
                remarks: 'Reference table for storing resolution which will be used in the application') {

            column(name: 'resolution_uid', type: 'VARCHAR(3)', remarks: 'The id of the resolution') {
                constraints(nullable: false)
            }
            column(name: 'resolution_name', type: 'VARCHAR(255)', remarks: 'The name of the resolution') {
                constraints(nullable: false)
            }
        }

        addPrimaryKey(schemaName: 'public', tableName: 'resolution', tablespace: 'works_index',
                columnNames: 'resolution_uid', constraintName: 'PK_resolution_uid')

        rollback {
            //automatic rollback
        }
    }
}
