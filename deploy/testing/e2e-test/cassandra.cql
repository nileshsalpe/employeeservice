create keyspace salpe  WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};

use salpe;

CREATE TYPE salpe.address (
  lines List<text>,
  city text,
  state text,
  country text,
);

CREATE TABLE employees (
    userid uuid,
    fname text ,
    lname text,
    address list<frozen<address>>,
    PRIMARY KEY (userid)
    ) WITH comment='Employee Records';



