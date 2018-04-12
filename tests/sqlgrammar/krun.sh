#!/bin/bash

J=1
sqlcmd < ddl.sql
while [ $J -lt 101 ] ; do
    echo ":----------- $J ---------:" 
    for file in truncs.sql exec.sql crash.sql; do
        sqlcmd --stop-on-error=false < $file
    done
    if ! sqlcmd < /dev/null &> /dev/null; then
        break
    fi
    J=$(( $J + 1 ))
done

echo ":============= Done after $J rounds =============:"
