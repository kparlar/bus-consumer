CREATE SCHEMA IF NOT EXISTS bus;

CREATE TABLE bus.message_line (
	message_line_id varchar(36) NOT NULL,
	message jsonb NOT NULL,
	status varchar(25) NOT NULL,
	create_date timestamp with time zone NULL,
	"update" timestamp with time zone NULL,
	CONSTRAINT message_line_pk PRIMARY KEY (message_line_id)
);

CREATE TABLE bus.line (
	code varchar(36) NOT NULL,
	message_line_id varchar(36) NOT NULL,
	"name" varchar(100) NOT NULL,
	recipe varchar(100) NOT NULL,
	length decimal NOT NULL,
	duration decimal NOT NULL,
	create_date timestamp with time zone NULL,
	"update" timestamp with time zone NULL,
	CONSTRAINT line_pk PRIMARY KEY (code)
);