databaseChangeLog {
    changeSet(id: '2014-01-04-08', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Insert issues data")

        insert(schemaName: 'public', tableName: 'issues') {
            column(name: 'issue_uid', value: 'da1f25dc-5c0f-4885-assa-5f369b55104a')
            column(name: 'issue_summary', value: 'Create wolf')
            column(name: 'issue_short_name', value: 'as-1')
            column(name: 'issue_description', value: 'Wolf must be gray and fanged')
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551zzz')
            column(name: 'type_uid', value: '20')
            column(name: 'status_uid', value: '10')
            column(name: 'priority_uid', value: '20')
            column(name: 'severity_uid', value: '30')
            column(name: 'resolution_uid', value: '20')
        }
        insert(schemaName: 'public', tableName: 'issues') {
            column(name: 'issue_uid', value: 'da1f25dc-5c0f-4885-as1a-5f369b55104a')
            column(name: 'issue_summary', value: 'Create sheep')
            column(name: 'issue_short_name', value: 'as-2')
            column(name: 'issue_description', value: 'Sheep must be white and fluffy')
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551zzz')
            column(name: 'type_uid', value: '30')
            column(name: 'status_uid', value: '20')
            column(name: 'priority_uid', value: '10')
            column(name: 'severity_uid', value: '40')
            column(name: 'resolution_uid', value: '50')
        }
        insert(schemaName: 'public', tableName: 'issues') {
            column(name: 'issue_uid', value: 'da1f12dc-5c0f-4885-as1a-5f369b55104a')
            column(name: 'issue_summary', value: 'Create surroundings')
            column(name: 'issue_short_name', value: 'as-3')
            column(name: 'issue_description', value: 'I want green meadows and rainbow')
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551zzz')
            column(name: 'type_uid', value: '10')
            column(name: 'status_uid', value: '10')
            column(name: 'priority_uid', value: '10')
            column(name: 'severity_uid', value: '10')
            column(name: 'resolution_uid', value: '10')
        }
        insert(schemaName: 'public', tableName: 'issues') {
            column(name: 'issue_uid', value: 'ed1f12dc-5c0f-4885-rs1a-5f369b55104a')
            column(name: 'issue_summary', value: '???????????????????????????????????')
            column(name: 'issue_short_name', value: 'zzz-1')
            column(name: 'issue_description', value: 'Secret secret secret...all questions to customer')
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551789')
            column(name: 'type_uid', value: '20')
            column(name: 'status_uid', value: '20')
            column(name: 'priority_uid', value: '20')
            column(name: 'severity_uid', value: '20')
            column(name: 'resolution_uid', value: '20')
        }
        insert(schemaName: 'public', tableName: 'issues') {
            column(name: 'issue_uid', value: 'ed1f12dc-5c0f-4885-rs1a-5fzzzb55104a')
            column(name: 'issue_summary', value: 'Balls colors')
            column(name: 'issue_short_name', value: 'fe-1')
            column(name: 'issue_description', value: 'Colors: red, green, purple, black, blue, yellow')
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551318')
            column(name: 'type_uid', value: '30')
            column(name: 'status_uid', value: '20')
            column(name: 'priority_uid', value: '40')
            column(name: 'severity_uid', value: '10')
            column(name: 'resolution_uid', value: '50')
        }
        insert(schemaName: 'public', tableName: 'issues') {
            column(name: 'issue_uid', value: 'ed1f12dc-4441-4885-rs1a-5fyyyb55104a')
            column(name: 'issue_summary', value: 'Billiard cue')
            column(name: 'issue_short_name', value: 'fe-2')
            column(name: 'issue_description', value: 'billiard cue: wood, long, thin')
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551318')
            column(name: 'type_uid', value: '10')
            column(name: 'status_uid', value: '40')
            column(name: 'priority_uid', value: '10')
            column(name: 'severity_uid', value: '30')
            column(name: 'resolution_uid', value: '10')
        }
        insert(schemaName: 'public', tableName: 'issues') {
            column(name: 'issue_uid', value: 'ui1f12dc-4441-4885-rs1a-5fyyyb55104a')
            column(name: 'issue_summary', value: 'Help Desk')
            column(name: 'issue_short_name', value: 'hd-1')
            column(name: 'issue_description', value: 'Help Desk')
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551159')
            column(name: 'type_uid', value: '10')
            column(name: 'status_uid', value: '40')
            column(name: 'priority_uid', value: '10')
            column(name: 'severity_uid', value: '30')
            column(name: 'resolution_uid', value: '10')
        }
        insert(schemaName: 'public', tableName: 'issues') {
            column(name: 'issue_uid', value: 'ui1f12dc-4441-4885-rs1a-5fyyy123104a')
            column(name: 'issue_summary', value: 'Big project')
            column(name: 'issue_short_name', value: 'big-1')
            column(name: 'issue_description', value: 'Never mind that there are many thing to')
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b55104a')
            column(name: 'type_uid', value: '30')
            column(name: 'status_uid', value: '20')
            column(name: 'priority_uid', value: '20')
            column(name: 'severity_uid', value: '30')
            column(name: 'resolution_uid', value: '10')
        }

        rollback {
            //automatic rollback
        }
    }
}
