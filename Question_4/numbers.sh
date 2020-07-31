#!/bin/bash

read -p "Enter X: "  X
read -p "Enter Y: " Y

if [ $X -lt $Y ];
then
    echo "Y is greater than X"
elif [ $X -gt $Y ];
then
    echo "X is greater than Y"
else
    echo "X is equal to Y"
fi
