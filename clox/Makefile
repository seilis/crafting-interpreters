SOURCES = \
	src/chunk.c \
	src/debug.c \
	src/main.c \
	src/memory.c \
	src/value.c \
	src/vm.c

OBJECTS = $(patsubst src/%.c,src/%.o,$(SOURCES))

.PHONY: all run clean

all: lox

lox: $(OBJECTS)
	gcc -o $@ $^

run: lox
	./lox


run-test: all
	lox test.lox

clean:
	rm -rf src/*.o lox

# How to compile C
src/%.o : src/%.c
	gcc -o $@ -c $<

$(CLASSES) : $(SOURCES)
