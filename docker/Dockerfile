FROM mongo
MAINTAINER Justin Grant "http://www.justinleegrant.com"

# supervisor installation && 
# create directory for child images to store configuration in
RUN apt-get -y install supervisor

RUN mkdir -p /var/log/supervisor && \
  mkdir -p /etc/supervisor/conf.d

# supervisor base configuration
ADD supervisor.conf /etc/supervisor.conf

#add bootstrap files for loading
ADD data/test-data.js /bootstrap/data/test-data.js
ADD sh/testConnection.js /bootstrap/sh/testConnection.js

# default command
CMD ["supervisord", "-c", "/etc/supervisor.conf"]
