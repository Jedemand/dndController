CREATE TABLE actor(
    id          INTEGER         NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100)    NOT NULL,
    armor       INTEGER,
    health      INTEGER,
    challenge   INTEGER,
    speed       VARCHAR(150),
    strength    INTEGER,
    dexterity   INTEGER,
    constitution INTEGER,
    intelligence INTEGER,
    wisdom      INTEGER,
    charisma    INTEGER,

    PRIMARY KEY (id)
);

