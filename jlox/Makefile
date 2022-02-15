.PHONY: all run

all: src/jlox.class

run: all
	@java --class-path src jlox

clean:
	rm -rf src/*.class

src/jlox.class: src/main.java
	javac src/main.java
