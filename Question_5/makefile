# java compiler
JCC = javac

# output directory
OUTDIR = bin/

SRCDIR= src/

# compilation flags
JFLAGS = -g -d $(OUTDIR)

# default target entry
default: DamArrayApp.class

#Dam.class: $(SRCDIR)Dam.java
#	$(JCC) $(JFLAGS) $(SRCDIR)Dam.java

DamArrayApp.class: $(SRCDIR)DamArrayApp.java
	$(JCC) $(JFLAGS) $(SRCDIR)DamArrayApp.java

# To start over from scratch, type 'make clean'.
# Removes all .class files, so that the next make rebuilds them
clean:
	$(RM) $(OUTDIR)*.class
