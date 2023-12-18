SELECT * FROM Dealership;

-- R
SELECT *
 FROM Dealership
 WHERE dealership_id = 'dealership_id';

-- C
INSERT INTO Dealership (NAME, address, phone) 
VALUES  ('NAME', 'address', 'phone');

-- U
UPDATE Dealership SET NAME = ?, address = ?, phone = ? WHERE dealership_id = ?;
#18:40:00	UPDATE Dealership  SET NAME = 'NAME', address = 'address', phone = 'phone'  WHERE dealership_id = 'dealership_id'	Error Code: 1292. Truncated incorrect DOUBLE value: 'dealership_id'	0.047 sec


-- D
DELETE FROM Dealership 
WHERE dealership_id = 'dealership_id';