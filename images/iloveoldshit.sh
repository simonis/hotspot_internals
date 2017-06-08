for i in {1..100}; do
  /share/output-jdk9-dev-dbg/images/jdk/bin/jstack $1 >> iloveoldshit.jstk;
  sleep 0.1;
done
