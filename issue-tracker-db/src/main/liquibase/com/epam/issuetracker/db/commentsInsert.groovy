databaseChangeLog {
    changeSet(id: '2014-01-04-15', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Insert 'comments' data")

        insert(schemaName: 'public', tableName: 'comments') {
            column(name: 'comments_uid', value: '10')
            column(name: 'comments_desription', value: ' Azazaazazazazazaazazazazazazazazaza')
            column(name: 'issue_uid', value: 'da1f25dc-5c0f-4885-assa-5f369b55104a')
        }
        insert(schemaName: 'public', tableName: 'comments') {
            column(name: 'comments_uid', value: '11')
            column(name: 'comments_desription', value: ' Azazaazazazazazaazazazazazazazazaza')
            column(name: 'issue_uid', value: 'da1f25dc-5c0f-4885-assa-5f369b55104a')
        }
        insert(schemaName: 'public', tableName: 'comments') {
            column(name: 'comments_uid', value: '12')
            column(name: 'comments_desription', value: ' Azazaazazazazazaazazazazazazazazaza')
            column(name: 'issue_uid', value: 'da1f25dc-5c0f-4885-assa-5f369b55104a')
        }
        insert(schemaName: 'public', tableName: 'comments') {
            column(name: 'comments_uid', value: '13')
            column(name: 'comments_desription', value: ' Azazaazazazazazaazazazazazazazazaza')
            column(name: 'issue_uid', value: 'da1f25dc-5c0f-4885-assa-5f369b55104a')
        }

        rollback {
            delete(schemaName: 'public', tableName: 'comments') {
                where "comments_uid in (10,11,12,13)"
            }
        }
    }
}
