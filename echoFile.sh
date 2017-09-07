#!/bin/bash

echo "it is executing the script"
while IFS='' read -r line || [[ -n "$line" ]]; do
    echo "$line"
done < "$1"