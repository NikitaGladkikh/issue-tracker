databaseChangeLog {

    props = new java.util.Properties();
    props.load(new FileInputStream("gradle.properties"))

    changeSet(id: '2014-03-01', author: 'Mikita Hladkikh <mikita_hladkikh@epam.com>', runInTransaction: false) {
        sql(stripComments: true, splitStatements: false, endDelimiter: ';') {
            "CREATE ROLE " + props.getProperty("postgreUserName") + " LOGIN PASSWORD '" + props.getProperty("postgreUserPassword") + "'"
        }
        sql(stripComments: true, splitStatements: false, endDelimiter: ';') {
            "COMMIT; CREATE TABLESPACE works_data OWNER " + props.getProperty("postgreUserName") + " LOCATION '" + props.getProperty("tablespaceLocationData") + "'"
        }
        sql(stripComments: true, splitStatements: false, endDelimiter: ';') {
            "COMMIT; CREATE TABLESPACE works_index OWNER " + props.getProperty("postgreUserName") + " LOCATION '" + props.getProperty("tablespaceLocationIndex") + "'"
        }
        sql(stripComments: true, splitStatements: false, endDelimiter: ';') {
            "COMMIT; CREATE DATABASE " + props.getProperty("postgreDB") + " WITH OWNER=" + props.getProperty("postgreUserName") + " ENCODING='UTF8' TABLESPACE=works_data"
        }
        sql(stripComments: true, splitStatements: false, endDelimiter: ';') {
            "GRANT ALL PRIVILEGES ON DATABASE " + props.getProperty("postgreDB") + " TO " + props.getProperty("postgreUserName")
        }
    }
}
