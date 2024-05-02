insert into company (name_company)
values('Google'),('Meta'),('Amazon');
insert into company_loclas(company_id, lang, description)
values ((select id from company where name_company = 'Google'), 'en', 'Google decription'),
((select id from company where name_company = 'Google'), 'ru', 'Google decription'),
((select id from company where name_company = 'Meta'), 'en', 'Meta decription'),
((select id from company where name_company = 'Meta'), 'ru', 'Meta decription'),
((select id from company where name_company = 'Amazon'), 'en', 'Amazon decription'),
((select id from company where name_company = 'Amazon'), 'ru', 'Amazon decription');
insert into users(birthday_date, firstname, lastname, role, username, company_id)
values ('1990-01-10', 'Ivan', 'Ivanov', 'ADMIN', 'ivanov@gmail.com', (select id from company where name_company = 'Google')),
('1995-01-10', 'Petr', 'Petrov', 'USER', 'petrov@gmail.com', (select id from company where name_company = 'Google')),
('1997-01-10', 'Nina', 'Sidorov', 'USER', 'sidorov@gmail.com', (select id from company where name_company = 'Meta')),
('1998-01-10', 'Roma', 'Gogin', 'ADMIN', 'gogin@gmail.com', (select id from company where name_company = 'Amazon'));