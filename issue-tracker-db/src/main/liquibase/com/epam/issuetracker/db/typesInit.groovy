databaseChangeLog {
    changeSet(id: '2014-01-04-02', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'type' table")

        createTable(tableName: 'type', schemaName: 'public', tablespace: 'works_data',
                remarks: 'Reference table for storing type which will be used in the application') {

            column(name: 'type_uid', type: 'VARCHAR(3)', remarks: 'The id of the type') {
                constraints(nullable: false)
            }
            column(name: 'type_name', type: 'VARCHAR(255)', remarks: 'The name of the type') {
                constraints(nullable: false)
            }
        }

        addPrimaryKey(schemaName: 'public', tableName: 'type', tablespace: 'works_index',
                columnNames: 'type_uid', constraintName: 'PK_type_uid')

        rollback {
            //automatic rollback
        }
    }
}
