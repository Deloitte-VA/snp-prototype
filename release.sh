#!/bin/bash
set -e

mvn release:clean release:prepare release:perform
