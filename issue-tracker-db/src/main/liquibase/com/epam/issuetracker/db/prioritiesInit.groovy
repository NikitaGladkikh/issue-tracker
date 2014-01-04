databaseChangeLog {
    changeSet(id: '2014-01-04-03', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'priority' table")

        createTable(tableName: 'priority', schemaName: 'public', tablespace: 'works_data',
                remarks: 'Reference table for storing priority which will be used in the application') {

            column(name: 'priority_uid', type: 'VARCHAR(3)', remarks: 'The id of the priority') {
                constraints(nullable: false)
            }
            column(name: 'priority_name', type: 'VARCHAR(255)', remarks: 'The name of the priority') {
                constraints(nullable: false)
            }
        }

        addPrimaryKey(schemaName: 'public', tableName: 'priority', tablespace: 'works_index',
                columnNames: 'priority_uid', constraintName: 'PK_priority_uid')

        rollback {
            //automatic rollback
        }
    }
}
