CREATE TABLE tblteams(
                         team_id serial PRIMARY KEY,
                         team_name VARCHAR(80),
                         budget bigint
);

CREATE TABLE tblplayers(
                           player_id serial PRIMARY KEY,
                           team_id int,
                           player_name VARCHAR(50),
                           player_age varchar(15),
                           skill_level int,
                           player_value bigint,
                           FOREIGN KEY (team_id) REFERENCES tblteams(team_id)
);