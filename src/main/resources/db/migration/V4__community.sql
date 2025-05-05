IF OBJECT_ID(N'dbo.tbl_commentary', N'U') IS NULL BEGIN
	CREATE TABLE tbl_commentary (
	    id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
		news_id INT NOT NULL FOREIGN KEY REFERENCES tbl_news(id),
		user_id INT NOT NULL FOREIGN KEY REFERENCES tbl_user(id),
		commentary VARCHAR(500) NOT NULL,
		date DATETIME NOT NULL
	);
END

IF OBJECT_ID(N'dbo.tbl_review', N'U') IS NULL BEGIN
	CREATE TABLE tbl_review (
	    id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
		movie_id INT NOT NULL FOREIGN KEY REFERENCES tbl_movie(id),
		user_id INT NOT NULL FOREIGN KEY REFERENCES tbl_user(id),
		review VARCHAR(500) NOT NULL,
		score INT NOT NULL,
		date DATETIME NOT NULL
	);
END