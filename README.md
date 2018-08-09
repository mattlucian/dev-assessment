# Developer Assessment - Integrations
This assessment gauges development skills regarding data transformation and coding practices relating to integrations. 


# Resources : 
0. Installing `mvn` if it's not installed already
- https://maven.apache.org/install.html
1. Adding a Maven Dependency
- http://www.tech-recipes.com/rx/39256/add-dependencies-to-maven-pom-xml-file/
2. XML format
- https://en.wikipedia.org/wiki/XML
3. What is a CSV file
- https://en.wikipedia.org/wiki/Comma-separated_values


# Given information : 
1. You are given an input file : 
- products.csv
2. These files contain a list of products
3. The CSV file is a valid format
4. Third party libraries are allowed for parsing & transforming data
5. Googling is allowed to understand how to use 3rd Party Libraries

# Run Instructions

        # creates "target/dev-assessment-1.0.jar"
        mvn package
        # execute the jar
        java -jar target/dev-assessment-1.0.jar
        

        # OR - run the following script
        sh run.sh


# Your assessment is : 
1. Document your approach before starting in the approach.txt file
2. Parse the CSV file into Product objects
3. Output these transformations to products.xml file using proper XML format
4. If unsure about something - make an assumption and continue moving forward. Document this assumption in the "assumptions.txt" file 


# This will be assessed on :
- How you parse the CSV file
- How modular the project is
- How you create the XML for products.xml
- Valid XML file format
- How you handle errors
- General coding style, readability, & comments

# Hints
- XML files require a root node
- CSV files could contain a comma that's not a delimiter
