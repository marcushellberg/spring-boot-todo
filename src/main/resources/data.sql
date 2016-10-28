CREATE TABLE IF NOT EXISTS Todo(id IDENTITY PRIMARY KEY, done BOOLEAN, text VARCHAR(255));
DELETE FROM Todo;
INSERT INTO Todo VALUES(1, true, 'Prepare presentation');
INSERT INTO Todo VALUES(2, true, 'Procrastinate');
INSERT INTO Todo VALUES(3, false, 'Have presentation');
