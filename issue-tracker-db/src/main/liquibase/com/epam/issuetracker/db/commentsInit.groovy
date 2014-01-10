databaseChangeLog {
    changeSet(id: '2014-01-04-00', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'comments' table")

        createTable(tableName: 'comments', schemaName: issueTrackerShema, tablespace: tableSpaceData,
                remarks: 'Reference table for storing comments which will be used in the application') {

            column(name: 'comments_uid', type: 'VARCHAR(255)', remarks: 'The id of the comment') {
                constraints(nullable: false)
            }
            column(name: 'comments_desription', type: 'VARCHAR(255)', remarks: 'The name of the comment') {
                constraints(nullable: false)
            }
            column(name: 'issue_uid', type: 'VARCHAR(255)', remarks: 'The id of the issue') {
                constraints(nullable: false)
            }
            column(name: 'created_datetime', type: 'TIMESTAMPTZ', defaultValueDate: 'now()', remarks: 'The date and time this comment was created') {
                constraints(nullable: false)
            }
        }

        addPrimaryKey(schemaName: issueTrackerShema, tableName: 'comments', tablespace: tableSpaceIndex,
                columnNames: 'comments_uid', constraintName: 'PK_comments_uid')
        addForeignKeyConstraint(constraintName: 'FK_issue_uid',
                baseTableSchemaName: issueTrackerShema, baseTableName: 'comments', baseColumnNames: 'issue_uid',
                referencedTableSchemaName: issueTrackerShema, referencedTableName: 'issues', referencedColumnNames: 'issue_uid')
        rollback {
            //automatic rollback
        }
    }
}
