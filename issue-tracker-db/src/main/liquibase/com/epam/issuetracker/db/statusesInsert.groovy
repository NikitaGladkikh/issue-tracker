databaseChangeLog {
    changeSet(id: '2014-01-04-00', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Insert 'status' data")

        insert(schemaName: issueTrackerShema, tableName: 'status') {
            column(name: 'status_uid', value: '10')
            column(name: 'status_name', value: 'Open')
        }
        insert(schemaName: issueTrackerShema, tableName: 'status') {
            column(name: 'status_uid', value: '20')
            column(name: 'status_name', value: 'In Progress')
        }
        insert(schemaName: issueTrackerShema, tableName: 'status') {
            column(name: 'status_uid', value: '30')
            column(name: 'status_name', value: 'Resolved')
        }
        insert(schemaName: issueTrackerShema, tableName: 'status') {
            column(name: 'status_uid', value: '40')
            column(name: 'status_name', value: 'Reopened')
        }
        insert(schemaName: issueTrackerShema, tableName: 'status') {
            column(name: 'status_uid', value: '50')
            column(name: 'status_name', value: 'Closed')
        }
        rollback {
            delete(schemaName: issueTrackerShema, tableName: 'status') {
                where "status_uid in (10,20,30,40,50)'"

            }
        }
    }
}
