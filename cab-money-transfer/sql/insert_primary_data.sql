---------------------
-- ROLE
---------------------
INSERT INTO ROLE (id, entity_version, date_creation, date_modification, code, label) VALUES (1, 1, TIMESTAMP '2014-10-01 12:00:00', TIMESTAMP '2014-10-01 12:00:00', 'role_administrator', 'Administrator');
INSERT INTO ROLE (id, entity_version, date_creation, date_modification, code, label) VALUES (2, 1, TIMESTAMP '2014-10-01 12:00:00', TIMESTAMP '2014-10-01 12:00:00', 'role_compliance_officer', 'Compliance Officer');
INSERT INTO ROLE (id, entity_version, date_creation, date_modification, code, label) VALUES (3, 1, TIMESTAMP '2014-10-01 12:00:00', TIMESTAMP '2014-10-01 12:00:00', 'role_teller', 'Teller');
INSERT INTO ROLE (id, entity_version, date_creation, date_modification, code, label) VALUES (4, 1, TIMESTAMP '2014-10-01 12:00:00', TIMESTAMP '2014-10-01 12:00:00', 'role_reporter', 'Reporter');
---------------------
-- BRANCH
---------------------
INSERT INTO BRANCH (
	id, entity_version, 
	date_creation, 
	date_modification, 
	address, 
	name, 
	phone, bank_ref) 
VALUES (
	1, 1, 
	TIMESTAMP '2014-10-01 12:00:00', 
	TIMESTAMP '2014-10-01 12:00:00', 
	'#2, Phnom Penh', 
	'CAB Olympic', 
	'023847567','OTX-CD'
);

---------------------
-- CURRENCY
---------------------
INSERT INTO CURRENCY (
	id, entity_version,
	date_creation,
	date_modification,
	description,
	name
) VALUES (
	1, 1,
	TIMESTAMP '2014-10-01 12:00:00', 
	TIMESTAMP '2014-10-01 12:00:00',
	'EURO-description',
	'EURO'
);
INSERT INTO CURRENCY (
	id, entity_version,
	date_creation,
	date_modification,
	description,
	name
) VALUES (
	2, 1,
	TIMESTAMP '2014-10-01 12:00:00', 
	TIMESTAMP '2014-10-01 12:00:00',
	'USD-description',
	'USD'
);

---------------------
-- MODE_PAYMENT
---------------------
INSERT INTO MODE_PAYMENT (
	id, entity_version,
	date_creation,
	date_modification,
	description,
	name
) VALUES (
	1, 1,
	TIMESTAMP '2014-10-01 12:00:00', 
	TIMESTAMP '2014-10-01 12:00:00',
	'Cash-description',
	'cash'
);
INSERT INTO MODE_PAYMENT (
	id, entity_version,
	date_creation,
	date_modification,
	description,
	name
) VALUES (
	2, 1,
	TIMESTAMP '2014-10-01 12:00:00', 
	TIMESTAMP '2014-10-01 12:00:00',
	'Cheque-description',
	'cheque'
);
INSERT INTO MODE_PAYMENT (
	id, entity_version,
	date_creation,
	date_modification,
	description,
	name
) VALUES (
	3, 1,
	TIMESTAMP '2014-10-01 12:00:00', 
	TIMESTAMP '2014-10-01 12:00:00',
	'Bank Debit-description',
	'bank_debit'
);

---------------------
-- ACCOUNT
---------------------
INSERT INTO ACCOUNT (
	id, entity_version, 
	date_creation, 
	date_modification, 
	address,
	date_of_birth,
	email,
	full_name, 
	identity_number,
	phone, 
	active,
	password,
	username,
	branch_id,
	role_id
	) 
VALUES (1, 1, 
	TIMESTAMP '2014-10-01 12:00:00', 
	TIMESTAMP '2014-10-01 12:00:00', 
	'Phnom Penh, Cambodia',
	TIMESTAMP '1989-07-29',
	'admin@cab.com',
	'Administrator',
	'0102983774',
	'012994433',
	true,
	'123456',
	'admin',
	1,
	1
);