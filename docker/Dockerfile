FROM mongo
MAINTAINER Justin Grant

ADD data/test-data.js /bootstrap/data/test-data.js
ADD sh/testConnection.js /bootstrap/sh/testConnection.js
ADD sh/init.sh /bootstrap/sh/init.sh

RUN chmod 777 /bootstrap/sh/init.sh

#bootstrap data and start mongodb
CMD ["/bootstrap/sh/init.sh"]