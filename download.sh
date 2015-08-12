read -p "What version do you want to download? " version
read -p "Where do you want to download these files? " filelocation

rm -rf p $filelocation/*
mkdir -p $filelocation
mkdir -p $filelocation/object-chronicles
mkdir -p $filelocation/search
mkdir -p $filelocation/uploads

echo "Preparing to download version '$version'..."

mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get \
      -DremoteRepositories=http://myrepo.com/ \
      -DgroupId=gov.vha.solor.modules \
      -DartifactId=snomed \
      -Dclassifier=all.cradle \
      -Dversion=$version \
      -Dpackaging=zip

 mvn org.apache.maven.plugins:maven-dependency-plugin:2.10:get \
      -DremoteRepositories=http://myrepo.com/ \
      -DgroupId=gov.vha.solor.modules \
      -DartifactId=snomed \
      -Dclassifier=all.lucene \
      -Dversion=$version \
      -Dpackaging=zip

echo "Preparing to unzip to location '$filelocation'..."
cd $filelocation && \
	unzip ~/.m2/repository/gov/vha/solor/modules/snomed/$version/snomed-$version-all.cradle.zip -d $filelocation && \
	mv $filelocation/snomed-$version-all.data/object-chronicles/* $filelocation/object-chronicles && \
	rm -rf $filelocation/snomed-$version-all.data/

cd $filelocation && \
	unzip ~/.m2/repository/gov/vha/solor/modules/snomed/$version/snomed-$version-all.lucene.zip -d $filelocation && \
	mv $filelocation/snomed-$version-all.data/search/* $filelocation/search && \
	rm -rf $filelocation/snomed-$version-all.data/

echo "Download and extraction completed!"