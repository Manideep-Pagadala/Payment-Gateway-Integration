use miniproject;
create table if not exists payment_data(
		
	payment_ref_id VARCHAR(255) PRIMARY KEY,
    merchant_id VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    currency_type VARCHAR(25) NOT NULL,
    order_id VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    date_of_payment DATE NOT NULL
    
);