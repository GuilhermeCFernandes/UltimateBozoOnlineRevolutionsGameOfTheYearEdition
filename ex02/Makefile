all:
	mkdir build
	javac src/com/webserver/core/*.java -d ./build
	javac -cp ./build src/com/webserver/languages/*.java -d ./build
	echo "Main-Class: com.webserver.core.WebServer" > manifest.file
	jar cvfm webserver.jar manifest.file -C ./build .

clean:
	find -name "*~" -exec rm -rf {} \;
	rm -rf build

run:
	java -jar webserver.jar

full: clean all run
