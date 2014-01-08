databaseChangeLog {
    changeSet(id: '2014-01-04-00', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Insert 'resolution' data")

        insert(schemaName: issueTrackerShema, tableName: 'resolution') {
            column(name: 'resolution_uid', value: '10')
            column(name: 'resolution_name', value: 'Fixed')
        }
        insert(schemaName: issueTrackerShema, tableName: 'resolution') {
            column(name: 'resolution_uid', value: '20')
            column(name: 'resolution_name', value: 'Won\'t Fix')
        }
        insert(schemaName: issueTrackerShema, tableName: 'resolution') {
            column(name: 'resolution_uid', value: '30')
            column(name: 'resolution_name', value: 'Duplicate')
        }
        insert(schemaName: issueTrackerShema, tableName: 'resolution') {
            column(name: 'resolution_uid', value: '40')
            column(name: 'resolution_name', value: 'Incomplete')
        }
        insert(schemaName: issueTrackerShema, tableName: 'resolution') {
            column(name: 'resolution_uid', value: '50')
            column(name: 'resolution_name', value: 'Cannot Reproduce')
        }

        rollback {
            delete(schemaName: issueTrackerShema, tableName: 'resolution') {
                where "resolution_uid in (10,20,30,40,50)'"
            }
        }
    }
}
