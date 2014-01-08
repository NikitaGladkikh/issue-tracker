databaseChangeLog {
    changeSet(id: '2014-01-04-00', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Insert 'severity' data")

        insert(schemaName: issueTrackerShema, tableName: 'severity') {
            column(name: 'severity_uid', value: '10')
            column(name: 'severity_name', value: 'Blocker')
        }
        insert(schemaName: issueTrackerShema, tableName: 'severity') {
            column(name: 'severity_uid', value: '20')
            column(name: 'severity_name', value: 'Critical')
        }
        insert(schemaName: issueTrackerShema, tableName: 'severity') {
            column(name: 'severity_uid', value: '30')
            column(name: 'severity_name', value: 'Major')
        }
        insert(schemaName: issueTrackerShema, tableName: 'severity') {
            column(name: 'severity_uid', value: '40')
            column(name: 'severity_name', value: 'Minor')
        }
        insert(schemaName: issueTrackerShema, tableName: 'severity') {
            column(name: 'severity_uid', value: '50')
            column(name: 'severity_name', value: 'Trivial')
        }

        rollback {
            delete(schemaName: issueTrackerShema, tableName: 'severity') {
                where "severity_uid in (10,20,30,40,50)'"

            }
        }
    }
}
