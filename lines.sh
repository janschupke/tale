#!/bin/bash

find core/src -type f -name '*java' -exec wc -l {} \; | awk '{ sum+=$1; print $1, "\t", $2; } END { print sum; }'
