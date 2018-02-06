create table queryresult(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    version varchar(50),
    condition varchar(50),
    prediction varchar(50),
    score float
 );

create table querycondition(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    version varchar(50),
    condition varchar(50),
    prediction varchar(50),
    score float
 );