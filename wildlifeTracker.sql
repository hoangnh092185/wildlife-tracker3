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
-- Name: animals; Type: TABLE; Schema: public; Owner: divangtrongmo
--

CREATE TABLE animals (
    id integer NOT NULL,
    name character varying,
    health character varying,
    age character varying,
    type character varying
);


ALTER TABLE animals OWNER TO divangtrongmo;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: divangtrongmo
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO divangtrongmo;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: divangtrongmo
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: divangtrongmo
--

CREATE TABLE sightings (
    id integer NOT NULL,
    location character varying,
    rangername character varying,
    animalid integer,
    timesighted timestamp without time zone
);


ALTER TABLE sightings OWNER TO divangtrongmo;

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: divangtrongmo
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO divangtrongmo;

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: divangtrongmo
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: divangtrongmo
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: divangtrongmo
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: divangtrongmo
--

COPY animals (id, name, health, age, type) FROM stdin;
1	Nhat	\N	\N	nonendanger
2		\N	\N	nonendanger
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: divangtrongmo
--

SELECT pg_catalog.setval('animals_id_seq', 2, true);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: divangtrongmo
--

COPY sightings (id, location, rangername, animalid, timesighted) FROM stdin;
1	Hoang	cool	1	2016-10-04 16:01:11.082891
2			2	2016-10-04 16:13:28.054843
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: divangtrongmo
--

SELECT pg_catalog.setval('sightings_id_seq', 2, true);


--
-- Name: animals_pkey; Type: CONSTRAINT; Schema: public; Owner: divangtrongmo
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: divangtrongmo
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: divangtrongmo
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM divangtrongmo;
GRANT ALL ON SCHEMA public TO divangtrongmo;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

