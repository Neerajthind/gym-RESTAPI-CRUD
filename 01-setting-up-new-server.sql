-- Drop user first if they exist
DROP USER if exists 'member_mgmt'@'%' ;

-- Now  we create user with prop privileges
CREATE USER 'member_mgmt'@'%' IDENTIFIED BY 'member_mgmt';

-- This will grant all the privileges
GRANT ALL PRIVILEGES ON * . * TO 'member_mgmt'@'%';