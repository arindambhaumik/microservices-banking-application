create table account_details
(
	account_id NUMBER(20) NOT NULL AUTO_INCREMENT,
	partysysid NUMBER(20) NOT NULL,
	account_number NUMBER(20) NOT NULL,
	currency VARCHAR(50) NOT NULL,
	account_holder_name VARCHAR(100) NOT NULL,
	balance NUMBER(20) NOT NULL,
	date_of_opening VARCHAR(50) NOT NULL,
	date_of_closure VARCHAR(50),
	account_type VARCHAR(100) NOT NULL,
	status VARCHAR(20) NOT NULL,
	primary key(account_id)
);

create table account_transaction
(
	account_id NUMBER(20) NOT NULL,
	Transaction_Id NUMBER(20) NOT NULL AUTO_INCREMENT,
	Transaction_Reference VARCHAR(50) NOT NULL,
	Amount NUMBER(20) NOT NULL,
	Type VARCHAR(50) NOT NULL,
	primary key(Transaction_Id)
);