-- ALTER TABLE sender DROP COLUMN number_reciever_restriction;
ALTER TABLE sender ADD COLUMN number_reciever_restriction integer NOT NULL DEFAULT 2;

-- ALTER TABLE receiver DROP COLUMN number_sender_restriction;

ALTER TABLE receiver ADD COLUMN number_sender_restriction integer NOT NULL DEFAULT 2;

CREATE TABLE rule_fill_amount_management
(
  id bigint NOT NULL,
  entity_version integer DEFAULT 1,
  date_creation timestamp without time zone,
  date_modification timestamp without time zone,
  cable double precision,
  percent_fee double precision,
  rule_type character varying(10),
  sender_type character varying(255),
  usd_amount double precision,
  CONSTRAINT rule_fill_amount_management_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rule_fill_amount_management
  OWNER TO postgres;
  
   
INSERT INTO rule_fill_amount_management(id,date_creation,date_modification, sender_type, usd_amount, percent_fee, cable, rule_type)
    VALUES (1,NOW(),NOW(), 'TO721', 15000, 13, 10, '>');
    
INSERT INTO rule_fill_amount_management(id,date_creation,date_modification, sender_type, usd_amount, percent_fee, cable, rule_type)
    VALUES (2,NOW(),NOW(), 'TO721', 15000, 0, 20, '<=');

INSERT INTO rule_fill_amount_management(id,date_creation,date_modification, sender_type, usd_amount, percent_fee, cable, rule_type)
    VALUES (3,NOW(),NOW(), 'VI731', 15000, 13, 10, '>');

INSERT INTO rule_fill_amount_management(id,date_creation,date_modification, sender_type, usd_amount, percent_fee, cable, rule_type)
    VALUES (4,NOW(),NOW(), 'VI731', 15000, 0, 20, '<=');

INSERT INTO rule_fill_amount_management(id,date_creation,date_modification, sender_type, usd_amount, percent_fee, cable, rule_type)
    VALUES (5,NOW(),NOW(), 'CH741', 15000, 13, 10, '>');

INSERT INTO rule_fill_amount_management(id,date_creation,date_modification, sender_type, usd_amount, percent_fee, cable, rule_type)
    VALUES (6,NOW(),NOW(), 'CH741', 15000, 0, 20, '<=');
    
    
-- Change type from string to double
ALTER TABLE sender_receiver_transaction ALTER COLUMN postage type double precision USING(postage::double precision);
ALTER TABLE sender_receiver_transaction ALTER COLUMN other type double precision USING(other::double precision);

-- ALTER TABLE branch DROP COLUMN init_bank_code;
ALTER TABLE branch ADD COLUMN init_bank_code character varying(50);
