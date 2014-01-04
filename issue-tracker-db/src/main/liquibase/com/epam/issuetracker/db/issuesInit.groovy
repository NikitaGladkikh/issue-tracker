databaseChangeLog {
    changeSet(id: '2014-01-04-07', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>') {
        comment("Creates 'issues' table")

        createTable(tableName: 'issues', schemaName: 'public', tablespace: 'works_data',
                remarks: 'Reference table for storing issues which will be used in the application') {

            column(name: 'issue_uid', type: 'VARCHAR(255)', remarks: 'The id of the issue') {
                constraints(nullable: false)
            }
            column(name: 'issue_summary', type: 'VARCHAR(255)', remarks: 'The name of the issue') {
                constraints(nullable: false)
            }
            column(name: 'issue_short_name', type: 'VARCHAR(255)', remarks: 'The short name of the issue') {
                constraints(nullable: false)
            }
            column(name: 'issue_description', type: 'VARCHAR(255)', remarks: 'The description of the issue') {
                constraints(nullable: false)
            }
            column(name: 'created_datetime', type: 'TIMESTAMPTZ', defaultValueDate: 'now()', remarks: 'The date and time this issue was created') {
                constraints(nullable: false)
            }
            column(name: 'project_uid', type: 'VARCHAR(255)', remarks: 'The id of the project') {
                constraints(nullable: false)
            }
            column(name: 'type_uid', type: 'VARCHAR(3)', remarks: 'The id of the type') {
                constraints(nullable: false)
            }
            column(name: 'status_uid', type: 'VARCHAR(3)', remarks: 'The id of the status') {
                constraints(nullable: false)
            }
            column(name: 'priority_uid', type: 'VARCHAR(3)', remarks: 'The id of the priority') {
                constraints(nullable: false)
            }
            column(name: 'severity_uid', type: 'VARCHAR(3)', remarks: 'The id of the severity') {
                constraints(nullable: false)
            }
            column(name: 'resolution_uid', type: 'VARCHAR(3)', remarks: 'The id of the resolution') {
                constraints(nullable: false)
            }

        }

        addPrimaryKey(schemaName: 'public', tableName: 'issues', tablespace: 'works_index',
                columnNames: 'issue_uid', constraintName: 'PK_issue_uid')
        addForeignKeyConstraint(constraintName: 'FK_project_uid',
                baseTableSchemaName: 'public', baseTableName: 'issues', baseColumnNames: 'project_uid',
                referencedTableSchemaName: 'public', referencedTableName: 'projects', referencedColumnNames: 'project_uid')
        addForeignKeyConstraint(constraintName: 'FK_type_uid',
                baseTableSchemaName: 'public', baseTableName: 'issues', baseColumnNames: 'type_uid',
                referencedTableSchemaName: 'public', referencedTableName: 'type', referencedColumnNames: 'type_uid')
        addForeignKeyConstraint(constraintName: 'FK_status_uid',
                baseTableSchemaName: 'public', baseTableName: 'issues', baseColumnNames: 'status_uid',
                referencedTableSchemaName: 'public', referencedTableName: 'status', referencedColumnNames: 'status_uid')
        addForeignKeyConstraint(constraintName: 'FK_priority_uid',
                baseTableSchemaName: 'public', baseTableName: 'issues', baseColumnNames: 'priority_uid',
                referencedTableSchemaName: 'public', referencedTableName: 'priority', referencedColumnNames: 'priority_uid')
        addForeignKeyConstraint(constraintName: 'FK_severity_uid',
                baseTableSchemaName: 'public', baseTableName: 'issues', baseColumnNames: 'severity_uid',
                referencedTableSchemaName: 'public', referencedTableName: 'severity', referencedColumnNames: 'severity_uid')
        addForeignKeyConstraint(constraintName: 'FK_resolution_uid',
                baseTableSchemaName: 'public', baseTableName: 'issues', baseColumnNames: 'resolution_uid',
                referencedTableSchemaName: 'public', referencedTableName: 'resolution', referencedColumnNames: 'resolution_uid')

        rollback {
            //automatic rollback
        }
    }
}
