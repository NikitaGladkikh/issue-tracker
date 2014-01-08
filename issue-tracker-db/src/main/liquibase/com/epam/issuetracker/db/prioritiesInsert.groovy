databaseChangeLog {
    changeSet(id: '2014-01-04-00', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Insert 'priority' data")

        insert(schemaName: issueTrackerShema, tableName: 'priority') {
            column(name: 'priority_uid', value: '10')
            column(name: 'priority_name', value: 'Urgent')
        }
        insert(schemaName: issueTrackerShema, tableName: 'priority') {
            column(name: 'priority_uid', value: '20')
            column(name: 'priority_name', value: 'High')
        }
        insert(schemaName: issueTrackerShema, tableName: 'priority') {
            column(name: 'priority_uid', value: '30')
            column(name: 'priority_name', value: 'Low')
        }
        insert(schemaName: issueTrackerShema, tableName: 'priority') {
            column(name: 'priority_uid', value: '40')
            column(name: 'priority_name', value: 'Lowest')
        }

        rollback {
            delete(schemaName: issueTrackerShema, tableName: 'priority') {
                where "priority_uid in (10,20,30,40)'"
            }
        }
    }
}
