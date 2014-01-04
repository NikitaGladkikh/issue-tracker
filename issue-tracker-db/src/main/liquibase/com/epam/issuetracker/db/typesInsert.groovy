databaseChangeLog {
    changeSet(id: '2014-01-04-13', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Insert 'type' data")

        insert(schemaName: 'public', tableName: 'type') {
            column(name: 'type_uid', value: '10')
            column(name: 'type_name', value: 'Bug')
        }
        insert(schemaName: 'public', tableName: 'type') {
            column(name: 'type_uid', value: '20')
            column(name: 'type_name', value: 'Environment')
        }
        insert(schemaName: 'public', tableName: 'type') {
            column(name: 'type_uid', value: '30')
            column(name: 'type_name', value: 'Specification')
        }

        rollback {
            delete(schemaName: 'public', tableName: 'type') {
                where "type_uid in (10,20,30)'"

            }
        }
    }
}
