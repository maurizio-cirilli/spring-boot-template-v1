DROP TABLE IF EXISTS BOOK CASCADE;

CREATE TABLE BOOK (
          ID INT AUTO_INCREMENT  PRIMARY KEY,
          TITLE VARCHAR(30) NOT NULL,
          AUTHOR VARCHAR(30) NOT NULL,
          RELEASE_DATE DATE
);


INSERT INTO BOOK (ID, TITLE, AUTHOR, RELEASE_DATE) VALUES (101, 'BATMAN HASH', 'LOEB', NOW());
INSERT INTO BOOK (ID, TITLE, AUTHOR, RELEASE_DATE) VALUES (102, 'MARVEL OMNIBUS SPIDER-MAN', 'TOD MacFARLANE', NOW());
COMMIT;