# hmrc

TO RUN

open a terminal at the working directory and run the following commands:
	-> mvn install
	->java -jar target/hmrc-0.0.1-SNAPSHOT.jar
or  
	run from HmrcApplication.java

The application will most likely be running on localhost:8080


ENDPOINTS

http://localhost:8080/crime/categories
	returns:
	200 if successful
	404 if no data found

http://localhost:8080/crimes?postcode={postcode}&date={yyyy-MM}
	returns:
	200 if successful
	400 if the post code or date is invalid
	404 if no data found
