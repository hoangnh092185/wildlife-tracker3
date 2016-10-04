--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE animals (
    id integer NOT NULL,
    name character varying,
    health character varying,
    age character varying,
    type character varying
);


ALTER TABLE animals OWNER TO "Guest";

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO "Guest";

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE sightings (
    id integer NOT NULL,
    location character varying,
    rangername character varying,
    animalid integer,
    timesighted timestamp without time zone
);


ALTER TABLE sightings OWNER TO "Guest";

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO "Guest";

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY animals (id, name, health, age, type) FROM stdin;
1	\N	\N	\N	\N
2	\N	\N	\N	\N
3	batman	\N	\N	\N
4	batman	\N	\N	\N
5	batman	\N	\N	\N
6	batman	\N	\N	\N
7	batman	\N	\N	\N
8	robbin	\N	\N	\N
9	Batman	\N	\N	\N
10	test1	\N	\N	\N
11	test2	\N	\N	\N
12	Robbin	\N	\N	nonendanger
13	test1	Healthy	Newborn	endanger
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('animals_id_seq', 13, true);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY sightings (id, location, rangername, animalid, timesighted) FROM stdin;
1	Gotham	Gordan	1	2016-10-03 17:38:03.732422
2	Gotham	Gordan	2	2016-10-03 17:39:06.156757
3	gotham	gordan	3	2016-10-03 17:40:47.533683
4	gotham	ranger 	1	2016-10-03 18:11:05.422606
5	downtown	nate	8	2016-10-03 18:13:37.888396
6	LA	ranger 	12	2016-10-03 23:05:03.332959
7	Home	Sandman	13	2016-10-03 23:09:33.215469
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('sightings_id_seq', 7, true);


--
-- Name: animals_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

