# Class path
CLASSPATH = com/craftinginterpreters

SOURCES = \
	$(CLASSPATH)/lox/Expr.java \
	$(CLASSPATH)/lox/Lox.java \
	$(CLASSPATH)/lox/Scanner.java \
	$(CLASSPATH)/lox/Token.java \
	$(CLASSPATH)/lox/TokenType.java \
	$(CLASSPATH)/lox/jlox.java

CLASSES = $(patsubst com/craftinginterpreters/lox/%.java,com/craftinginterpreters/lox/%.class,$(SOURCES))


.PHONY: all run clean

all: $(CLASSES)

run: all
	@java --class-path $(CLASSPATH)/lox jlox

run-ast: $(CLASSPATH)/lox/Expr.java

$(CLASSPATH)/lox/Expr.java: $(CLASSPATH)/tool/GenerateAst.class
	@java $(CLASSPATH)/tool/GenerateAst.java $(CLASSPATH)/lox

clean:
	rm -rf com/craftinginterpreters/lox/*.class

# How to compile java
com/craftinginterpreters/lox/%.class : com/craftinginterpreters/lox/%.java
	javac -d . $<

$(CLASSES) : $(SOURCES)
