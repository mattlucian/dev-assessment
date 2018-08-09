rm -r artifact/*
zip -r assessment.zip products.csv README.md assumptions.txt approach.txt src *.sh pom.xml artifact
mv assessment.zip artifact/
