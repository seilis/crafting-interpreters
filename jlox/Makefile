# Class path
CLASSPATH = com/craftinginterpreters

# Removed from sources because it's no longer used by the book
#	$(CLASSPATH)/lox/AstPrinter.java

SOURCES = \
	$(CLASSPATH)/lox/Environment.java \
	$(CLASSPATH)/lox/Expr.java \
	$(CLASSPATH)/lox/Interpreter.java \
	$(CLASSPATH)/lox/Lox.java \
	$(CLASSPATH)/lox/LoxCallable.java \
	$(CLASSPATH)/lox/LoxFunction.java \
	$(CLASSPATH)/lox/Parser.java \
	$(CLASSPATH)/lox/Return.java \
	$(CLASSPATH)/lox/RuntimeError.java \
	$(CLASSPATH)/lox/Scanner.java \
	$(CLASSPATH)/lox/Stmt.java \
	$(CLASSPATH)/lox/Token.java \
	$(CLASSPATH)/lox/TokenType.java

CLASSES = $(patsubst com/craftinginterpreters/lox/%.java,com/craftinginterpreters/lox/%.class,$(SOURCES))


.PHONY: all run clean

all: $(CLASSES)

run: all
	@java $(CLASSPATH)/lox/Lox

run-test: all
	@java $(CLASSPATH)/lox/Lox test.lox

run-ast: $(CLASSPATH)/lox/Expr.java

$(CLASSPATH)/lox/Expr.java $(CLASSPATH)/lox/Stmt.java: $(CLASSPATH)/tool/GenerateAst.class
	@java $(CLASSPATH)/tool/GenerateAst.java $(CLASSPATH)/lox

clean:
	rm -rf $(CLASSPATH)/lox/*.class
	rm -rf $(CLASSPATH)/lox/Expr*.java
	rm -rf $(CLASSPATH)/lox/Stmt*.java

# How to compile java
com/craftinginterpreters/lox/%.class : com/craftinginterpreters/lox/%.java
	javac -d . $<

$(CLASSES) : $(SOURCES)
