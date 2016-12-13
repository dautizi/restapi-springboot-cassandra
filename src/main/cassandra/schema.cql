
-- ######################################
-- ####### CASSANDRA SCHEMA #############
-- ######################################

-- Drop KEYSPACE if it exists
DROP KEYSPACE IF EXISTS "daniele_autizi";

-- KEYSPACE creation
CREATE KEYSPACE "daniele_autizi" WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};

-- KEYSPACE selection
USE "daniele_autizi";

-- adventure table
CREATE TABLE adventure (
adv_uuid uuid PRIMARY KEY,
adv_id bigint,
adv_title text,
adv_category text,
adv_section text, 
adv_tag text,
adv_keywords text,
adv_css_class text,
adv_image text,
adv_icon text,
adv_alt_image text,
adv_article_url text,
adv_static_url text,
adv_description text,
adv_adventure_type text,
adv_view_type text,
adv_media_css_class text,
adv_datetime text,
adv_prg varint,
adv_active varint
);
