#!/bin/bash

# Script to update package names from eu.janschupke to io.schupke
# This script updates both package declarations and import statements

echo "Updating package names from eu.janschupke to io.schupke..."

# Update package declarations in Java files
find . -name "*.java" -type f -exec sed -i '' 's/package eu\.janschupke/package io.schupke/g' {} \;

# Update import statements in Java files
find . -name "*.java" -type f -exec sed -i '' 's/import eu\.janschupke/import io.schupke/g' {} \;

# Update any references in other file types (properties, gradle files, etc.)
find . -name "*.properties" -type f -exec sed -i '' 's/eu\.janschupke/io.schupke/g' {} \;
find . -name "*.gradle" -type f -exec sed -i '' 's/eu\.janschupke/io.schupke/g' {} \;
find . -name "*.xml" -type f -exec sed -i '' 's/eu\.janschupke/io.schupke/g' {} \;
find . -name "*.txt" -type f -exec sed -i '' 's/eu\.janschupke/io.schupke/g' {} \;
find . -name "*.md" -type f -exec sed -i '' 's/eu\.janschupke/io.schupke/g' {} \;

echo "Package names updated successfully!"
echo "Now updating folder structure..."

# Create the new directory structure
mkdir -p core/src/io/schupke/tale
mkdir -p desktop/src/io/schupke/tale
mkdir -p test/io/schupke/tale

# Move the content from old structure to new structure
if [ -d "core/src/eu/janschupke/tale" ]; then
    mv core/src/eu/janschupke/tale/* core/src/io/schupke/tale/
    rm -rf core/src/eu/janschupke
fi

if [ -d "desktop/src/eu/janschupke/tale" ]; then
    mv desktop/src/eu/janschupke/tale/* desktop/src/io/schupke/tale/
    rm -rf desktop/src/eu/janschupke
fi

if [ -d "test/eu/janschupke/tale" ]; then
    mv test/eu/janschupke/tale/* test/io/schupke/tale/
    rm -rf test/eu/janschupke
fi

echo "Folder structure updated successfully!"
echo "All package references have been updated from eu.janschupke to io.schupke" 
