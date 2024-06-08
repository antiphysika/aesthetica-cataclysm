SHELL = /bin/bash

TOP_DIR = $(shell pwd)
MAINT_DIR = $(TOP_DIR)/maint

JAVA_HOME = $(shell $(MAINT_DIR)/detect-java-home)
ifeq ($(JAVA_HOME),none)
	$(warning Unable to automatically detect JDK, falling back to Gradle\'s auto detection)
else
	export JAVA_HOME
endif

GRADLEW = $(TOP_DIR)/gradlew

ALL_TARGETS = \
  jar

.PHONY: all
all: $(ALL_TARGETS)

.PHONY: jar
jar:
	@$(GRADLEW) jar

.PHONY: maint
maint:
	@echo "JAVA_HOME=$(JAVA_HOME)"

##
# vim: ts=8 sw=8 noet fdm=marker :
##
