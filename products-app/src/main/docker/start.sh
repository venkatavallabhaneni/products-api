#! /bin/bash
./wait-for-it.sh mypostgres:5432 -t 15
java -jar products.jar