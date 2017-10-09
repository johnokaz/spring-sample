INSERT INTO sales
(
    sales_year,
    sales_month,
    software_sale,
    labor_cost,
    outsourcing_cost,
    division_cost,
    current_software_cost,
    gross_profit,    
    sga,
    operating_income,    
    non_operating_income,
    non_operating_expense,
    ordinary_income,
    created_on,
    updated_on
) 
VALUES (
    '2017',
    '07',
    168903,
    87788,
    28267,
    4246,
    120301,
    48602,
    20854,
    27748,
    425,
    389,
    27784,
    current_timestamp,
    current_timestamp
    );

--　顧客マスタ
INSERT INTO CUSTOMERS
(
    customer_name,
    created_on,
    updated_on
) 
VALUES (
    'Toyota',
    current_timestamp,
    current_timestamp
    );

INSERT INTO CUSTOMERS
(
    customer_name,
    created_on,
    updated_on
) 
VALUES (
    'Nissan',
    current_timestamp,
    current_timestamp
    );

INSERT INTO CUSTOMERS
(
    customer_name,
    created_on,
    updated_on
) 
VALUES (
    'Mazda',
    current_timestamp,
    current_timestamp
    );

-- 職能ランク
INSERT INTO JOB_RANKS
(
    job_rank_cd,
    job_rank_name,
    job_rank_year,
    cost,
    created_on,
    updated_on
) 
VALUES (
    'M1',
    'マネージャ職 ランク1',
    '2017',
    '1000000',
    current_timestamp,
    current_timestamp
    );


INSERT INTO JOB_RANKS
(
    job_rank_cd,
    job_rank_name,
    job_rank_year,
    cost,
    created_on,
    updated_on
) 
VALUES (
    'M2',
    'マネージャ職 ランク2',
    '2017',
    '800000',
    current_timestamp,
    current_timestamp
    );


INSERT INTO JOB_RANKS
(
    job_rank_cd,
    job_rank_name,
    job_rank_year,
    cost,
    created_on,
    updated_on
) 
VALUES (
    'M3',
    'マネージャ職 ランク3',
    '2017',
    '700000',
    current_timestamp,
    current_timestamp
    );

-- 要員マスタ
INSERT INTO MEMBERS
(
    lastname,
    firstname,
    job_rank_id,
    member_kbn,
    created_on,
    updated_on
) 
VALUES (
    '織田',
    '信長',
    '1',
    '1',
    current_timestamp,
    current_timestamp
    );

INSERT INTO MEMBERS
(
    lastname,
    firstname,
    job_rank_id,
    member_kbn,
    created_on,
    updated_on
) 
VALUES (
    '豊臣',
    '秀吉',
    '2',
    '2',
    current_timestamp,
    current_timestamp
    );

INSERT INTO MEMBERS
(
    lastname,
    firstname,
    job_rank_id,
    member_kbn,
    created_on,
    updated_on
) 
VALUES (
    '徳川',
    '家康',
    '3',
    '1',
    current_timestamp,
    current_timestamp
    );