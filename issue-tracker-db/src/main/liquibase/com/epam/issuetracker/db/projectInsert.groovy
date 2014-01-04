databaseChangeLog {
    changeSet(id: '2014-01-04-06', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Insert projects data")

        insert(schemaName: 'public', tableName: 'projects') {
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b55104a')
            column(name: 'project_name', value: 'There is one big project')
            column(name: 'project_short_name', value: 'big')
            column(name: 'project_description', value: 'That project must be big, god and quite')
            column(name: 'project_state', value: 'true')
        }
        insert(schemaName: 'public', tableName: 'projects') {
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551789')
            column(name: 'project_name', value: 'Project ZZZ')
            column(name: 'project_short_name', value: 'zzz')
            column(name: 'project_description', value: 'This is secret information. Please, call to customer')
            column(name: 'project_state', value: 'true')
        }
        insert(schemaName: 'public', tableName: 'projects') {
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551159')
            column(name: 'project_name', value: 'Help Desk')
            column(name: 'project_short_name', value: 'hd')
            column(name: 'project_description', value: 'Public issue tracker for the Help Desk')
            column(name: 'project_state', value: 'true')
        }
        insert(schemaName: 'public', tableName: 'projects') {
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551318')
            column(name: 'project_name', value: 'FishEye')
            column(name: 'project_short_name', value: 'fe')
            column(name: 'project_description', value: 'Online simulator game in billiards')
            column(name: 'project_state', value: 'true')
        }
        insert(schemaName: 'public', tableName: 'projects') {
            column(name: 'project_uid', value: 'da1f25dc-5c0f-4885-abbe-5f369b551zzz')
            column(name: 'project_name', value: 'Angry Sheep')
            column(name: 'project_short_name', value: 'as')
            column(name: 'project_description', value: 'Run for the wolf and eat the sheep')
            column(name: 'project_state', value: 'true')
        }

        rollback {
            //automatic rollback
        }
    }
}
