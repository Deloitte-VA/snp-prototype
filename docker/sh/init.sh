echo "Starting mongodb..."

# Set monitoring mode to allow for job control
set -m

mongod &
mongo --nodb /bootstrap/sh/testConnection.js
mongo /bootstrap/data/test-data.js
fg
