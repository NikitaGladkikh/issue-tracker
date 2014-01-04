databaseChangeLog {
    changeSet(id: '2014-01-04-10', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Insert 'resolution' data")

        insert(schemaName: 'public', tableName: 'resolution') {
            column(name: 'resolution_uid', value: '10')
            column(name: 'resolution_name', value: 'Fixed')
        }
        insert(schemaName: 'public', tableName: 'resolution') {
            column(name: 'resolution_uid', value: '20')
            column(name: 'resolution_name', value: 'Won\'t Fix')
        }
        insert(schemaName: 'public', tableName: 'resolution') {
            column(name: 'resolution_uid', value: '30')
            column(name: 'resolution_name', value: 'Duplicate')
        }
        insert(schemaName: 'public', tableName: 'resolution') {
            column(name: 'resolution_uid', value: '40')
            column(name: 'resolution_name', value: 'Incomplete')
        }
        insert(schemaName: 'public', tableName: 'resolution') {
            column(name: 'resolution_uid', value: '50')
            column(name: 'resolution_name', value: 'Cannot Reproduce')
        }

        rollback {
            delete(schemaName: 'public', tableName: 'resolution') {
                where "resolution_uid in (10,20,30,40,50)'"
            }
        }
    }
}
