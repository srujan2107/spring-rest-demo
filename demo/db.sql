-- Create user with password
-- CREATE USER demo_user WITH PASSWORD 'P@ssw0rd';

-- Create Database
-- CREATE DATABASE IF NOT EXIST demo_db;

-- Create Schema
CREATE SCHEMA IF NOT EXIST user_schema;

-- DROP TABLE user_schema.app_user;

CREATE TABLE user_schema.app_user (
	id serial NOT NULL,
	f_name varchar(25) NOT NULL,
	m_name varchar(20) NULL,
	l_name varchar(25) NOT NULL,
	u_name varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	phone varchar(20) NULL,
	CONSTRAINT app_user_pkey PRIMARY KEY (id)
);
