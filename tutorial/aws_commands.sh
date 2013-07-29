#commands to set up a project on AWS EC2 (Ubuntu)

sudo apt-get install git
sudo apt-get install openjdk-6-jdk
sudo apt-get install python-mysqldb


git clone https://github.com/rozac/esalib.git
cd esalib
ln -s example/esa_en.db esadb.db
./run_analyzer "computer" "apple"

mkdir downloads
cd downloads
wget http://dumps.wikimedia.org/plwiki/latest/plwiki-latest-pages-articles1.xml.bz2
bzip2 -d plwiki-latest-pages-articles1.xml.bz2

sudo apt-get install mysql-server mysql-client
# I set password 'pass' for the root user




#useful MYSQL commands

mysql [-u username] [-h hostname] database-name
show databases
use <database-name>
show tables
desc <table-name>


# execute sql commands fron the script

mysql -u root -p < yourscript.sql
