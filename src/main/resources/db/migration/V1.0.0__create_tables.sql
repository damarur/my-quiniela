DROP TABLE IF EXISTS QUINIELA_GAMES CASCADE;
DROP TABLE IF EXISTS QUINIELA CASCADE;
DROP TABLE IF EXISTS TEAM CASCADE;

CREATE TABLE TEAM
(
    ID   VARCHAR(255) NOT NULL,
    NAME VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE QUINIELA
(
    ID          VARCHAR(255) NOT NULL,
    DATE_TIME   TIMESTAMP(6) NOT NULL,
    TITLE       VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(255),
    PRIMARY KEY (ID)
);

CREATE TABLE QUINIELA_GAMES
(
    QUINIELA_ID     VARCHAR(255) NOT NULL,
    SECUENCE_ORDER  INTEGER      NOT NULL,
    LOCAL_TEAM_ID   VARCHAR(255) NOT NULL,
    LOCAL_GOALS     INTEGER,
    VISITOR_TEAM_ID VARCHAR(255) NOT NULL,
    VISITOR_GOALS   INTEGER,
    PRIMARY KEY (QUINIELA_ID, SECUENCE_ORDER)
);

ALTER TABLE IF EXISTS QUINIELA_GAMES ADD CONSTRAINT LOCAL_TEAM_FK FOREIGN KEY (LOCAL_TEAM_ID) REFERENCES TEAM;
ALTER TABLE IF EXISTS QUINIELA_GAMES ADD CONSTRAINT VISITOR_TEAM_FK FOREIGN KEY (VISITOR_TEAM_ID) REFERENCES TEAM;
ALTER TABLE IF EXISTS QUINIELA_GAMES ADD CONSTRAINT QUINIELA_FK FOREIGN KEY (QUINIELA_ID) REFERENCES QUINIELA;

COMMIT;