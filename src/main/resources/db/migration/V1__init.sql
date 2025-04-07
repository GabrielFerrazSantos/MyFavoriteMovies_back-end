IF OBJECT_ID(N'dbo.tbl_user', N'U') IS NULL BEGIN
	CREATE TABLE tbl_user (
		id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
		name VARCHAR(50) NOT NULL,
		username VARCHAR(15) NOT NULL,
		password VARCHAR(100) NOT NULL
	);

	IF IndexProperty(Object_Id('dbo.tbl_user'), 'u_user_username', 'IndexID') IS NULL BEGIN
    	ALTER TABLE tbl_user ADD CONSTRAINT u_user_username UNIQUE(username)
    END
END