# Class path
CLASSPATH = com/craftinginterpreters

SOURCES = \
	$(CLASSPATH)/lox/AstPrinter.java \
	$(CLASSPATH)/lox/Expr.java \
	$(CLASSPATH)/lox/Interpreter.java \
	$(CLASSPATH)/lox/Lox.java \
	$(CLASSPATH)/lox/Parser.java \
	$(CLASSPATH)/lox/RuntimeError.java \
	$(CLASSPATH)/lox/Scanner.java \
	$(CLASSPATH)/lox/Token.java \
	$(CLASSPATH)/lox/TokenType.java

CLASSES = $(patsubst com/craftinginterpreters/lox/%.java,com/craftinginterpreters/lox/%.class,$(SOURCES))


.PHONY: all run clean

all: $(CLASSES)

run: all
	@java $(CLASSPATH)/lox/Lox

run-ast: $(CLASSPATH)/lox/Expr.java

$(CLASSPATH)/lox/Expr.java: $(CLASSPATH)/tool/GenerateAst.class
	@java $(CLASSPATH)/tool/GenerateAst.java $(CLASSPATH)/lox

clean:
	rm -rf $(CLASSPATH)/lox/*.class
	rm -rf $(CLASSPATH)/lox/Expr*.java

# How to compile java
com/craftinginterpreters/lox/%.class : com/craftinginterpreters/lox/%.java
	javac -d . $<

$(CLASSES) : $(SOURCES)
