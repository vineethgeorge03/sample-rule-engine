create database if not exists ruleengine;

create table if not exists lpc_config (
id serial,
lpc varchar(255) primary key
);

create table if not exists  rules (
 id serial primary key,
 rule  varchar(255)
);

create table if not exists rules_lpc (
 lpc varchar(255),
 rule_id integer,
 constraint fk_lpc
    foreign  key(lpc)
        references lpc_config(lpc),
 constraint fk_rules
    foreign key(rule_id)
        references rules(id)
);

insert into lpc_config(lpc) values('CFB'), ('PSE');
insert into rules(rule) values
('applicantList.?[#this.age > 25].size() == applicantList.size()'),
('applicantList.?[#this.age < 50].size() == applicantList.size()'),
('loan.loanTenure > 4'),
('loan.loanAmount > 10000'),
('#pincodeValidator(applicantList)')
;
insert into rules_lpc values('CFB',1),('CFB',2),('CFB',3),('CFB',4),('CFB',5);