#!/bin/bash

set -e

# shellcheck disable=SC2045
for elem in $(ls "java/src/main/java/com") ; do
  filename="java/src/main/java/com/$elem/Solution.java"
  if [ -e "$filename" ]; then
    mkdir -p "code/$elem"
    ln -s "../../$filename" "code/$elem/Solution.java"
  fi
done

