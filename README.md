## Run instructions


1. This program uses MySQL database, please import [DumpStructureOnly.sql](database/DumpStructureOnly.sql) (database structure file) or [DumpStructure_and_Data.sql](database/DumpStructure_and_Data.sql) (database file with test data) before use ) into MySQL, and set as follows (can be modified in `dbConn.java`):
    * Database port: 3306
    * Database name: stuManagerDB
    * Database user name: root
    * Database password: 123
2. Registration, the default registration of ordinary users (`userType = 2`), ordinary users do not have the functions of adding users and deleting users; to add an administrator account (`userType = 1`), it must be added in the database.
In the `tb_user` table of the `DumpStructure_and_Data.sql` database, there is a student system administrator account: `admin`, and the password is empty, which can be used to log in for testing.
