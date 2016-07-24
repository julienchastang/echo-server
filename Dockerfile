###
# From Clojure base image
###

FROM clojure

###
# App dir
###

ENV APP_DIR /usr/src/app

###
# Create app directory where Clojure project will be deployed 
###

RUN mkdir -p ${APP_DIR}

###
# Current Docker working directory
###

WORKDIR ${APP_DIR}

###
# Copy the project into the Docker image
###

COPY project.clj ${APP_DIR}/

COPY . ${APP_DIR}/

###
# Copy the script that will invoke the echo server into the Docker image
###

COPY echo-server.sh ${APP_DIR}/

RUN chmod +x ${APP_DIR}/echo-server.sh

###
# Grab the dependencies at Docker build time
###

RUN lein deps

###
# Build the stand alone jar 
###

RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" echo-server.jar

###
# Run it!
###

CMD /usr/src/app/echo-server.sh
