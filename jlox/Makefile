SOURCES = \
	com/craftinginterpreters/lox/Lox.java \
	com/craftinginterpreters/lox/Scanner.java \
	com/craftinginterpreters/lox/Token.java \
	com/craftinginterpreters/lox/TokenType.java \
	com/craftinginterpreters/lox/jlox.java

CLASSES = $(patsubst com/craftinginterpreters/lox/%.java,com/craftinginterpreters/lox/%.class,$(SOURCES))

.PHONY: all run clean

all: $(CLASSES)

run: all
	@java --class-path com/craftinginterpreters/lox jlox

clean:
	rm -rf com/craftinginterpreters/lox/*.class

# How to compile java
com/craftinginterpreters/lox/%.class : com/craftinginterpreters/lox/%.java
	javac -d com/craftinginterpreters/lox $<

$(CLASSES) : $(SOURCES)
