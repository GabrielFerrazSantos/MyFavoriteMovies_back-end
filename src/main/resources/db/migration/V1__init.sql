IF OBJECT_ID(N'dbo.tbl_user', N'U') IS NULL BEGIN
	CREATE TABLE tbl_user (
		id int NOT NULL IDENTITY(1,1) PRIMARY KEY,
		name varchar(50) NOT NULL,
		username varchar(15) NOT NULL,
		password varchar(100) NOT NULL
	);

	IF IndexProperty(Object_Id('dbo.tbl_user'), 'u_username', 'IndexID') IS NULL BEGIN
    	ALTER TABLE tbl_user ADD CONSTRAINT u_username UNIQUE(username)
    END
END