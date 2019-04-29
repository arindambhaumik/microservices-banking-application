INSERT INTO account_details (account_id, partysysid, account_number, currency, account_holder_name, balance, 
date_of_opening, date_of_closure, account_type, status) VALUES (22289, 1001, 80201114589652, 'GBP', 'Deepak', 
70000.00, '10/11/2012', '', 'Saving', 'Active');

INSERT INTO account_details (account_id, partysysid, account_number, currency, account_holder_name, balance, 
date_of_opening, date_of_closure, account_type, status) VALUES (22290, 1001, 90401114589654, 'GBP', 'Deepak', 
40000.00, '10/11/2014', '', 'Current', 'Active');

INSERT INTO account_details (account_id, partysysid, account_number, currency, account_holder_name, balance, 
date_of_opening, date_of_closure, account_type, status) VALUES (22291, 1002, 902015554589652, 'GBP', 'Saurabh', 
20000.00, '10/12/2015', '', 'Saving','Active');

INSERT INTO account_details (account_id, partysysid, account_number, currency, account_holder_name, balance, 
date_of_opening, date_of_closure, account_type, status) VALUES (22292, 1002, 705015554589654, 'GBP', 'Saurabh', 
80000.00, '10/12/2016', '', 'Current','Active');

INSERT INTO account_transaction(account_Id,Transaction_Id,Transaction_Reference,Amount,Type) values(22289,1000,'CASH',12.00,'Credit');
INSERT INTO account_transaction(account_Id,Transaction_Id,Transaction_Reference,Amount,Type) values(22289,1001,'Standing order to XYZ',10.00,'Debit');
INSERT INTO account_transaction(account_Id,Transaction_Id,Transaction_Reference,Amount,Type) values(22290,1002,'CASH',11.00,'Credit');
INSERT INTO account_transaction(account_Id,Transaction_Id,Transaction_Reference,Amount,Type) values(22290,1003,'Transfferred',21.00,'Debit');
INSERT INTO account_transaction(account_Id,Transaction_Id,Transaction_Reference,Amount,Type) values(22291,1004,'CASH',101.00,'Credit');
INSERT INTO account_transaction(account_Id,Transaction_Id,Transaction_Reference,Amount,Type) values(22291,1005,'Transfferred',121.00,'Debit');
INSERT INTO account_transaction(account_Id,Transaction_Id,Transaction_Reference,Amount,Type) values(22292,1006,'Direct Debit',30.00,'Debit');
INSERT INTO account_transaction(account_Id,Transaction_Id,Transaction_Reference,Amount,Type) values(22292,1007,'CASH',41.00,'Debit');
