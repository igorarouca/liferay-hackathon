JAVA_OPTS="$JAVA_OPTS -Dfile.encoding=UTF8 -Djava.net.preferIPv4Stack=true"
JAVA_OPTS="$JAVA_OPTS -Dorg.apache.catalina.loader.WebappClassLoader.ENABLE_CLEAR_REFERENCES=false"

CATALINA_OPTS="$CATALINA_OPTS -Duser.timezone=GMT"

# If you need to implement sticky sessions on this Tomcat, you need to detect and provide jvmRoute
# to the JVM. This then has to match whatever is set on your load balancer (httpd / nginx).
# This is the same as providing 'jvmRoute="..."' on <Engine /> in tomcat/conf/server.xml, but allows
# us to run some auto-detection, keeping server.xml the same in all nodes on one Liferay environment.

# TODO you need to figure out which shell script code will give you a good jvmRoute
# This is not needed in AWS when ELB balancing is used
#JVM_ROUTE=`hostname -s`
#CATALINA_OPTS="$CATALINA_OPTS -DjvmRoute=$JVM_ROUTE"

# In case we need to pass the ip address to the JVM (e.g. for jGroups / JMX server binding):
#CATALINA_OPTS="$CATALINA_OPTS -Djgroups.bind_addr=$ETH0_IP_ADDRESS"

# Enable JMX if needed
# TODO you need to figure out which shell script code will give you a good (public) IP address, where JMX can bind and be reachable
# to which you can connect your JMX client remotely
#IP_ADDRESS=`hostname --all-ip-addresses`
#CATALINA_OPTS="$CATALINA_OPTS -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9000"
#CATALINA_OPTS="$CATALINA_OPTS -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
#CATALINA_OPTS="$CATALINA_OPTS -Djava.rmi.server.hostname=$IP_ADDRESS"


##
## JVM tuning for Oracle JDK 8
##

# TODO check all the settings and make sure they work for you

# Log GC activity
# * 6.2 Deployment Checklist
# * https://blogs.oracle.com/jonthecollector/entry/the_unspoken_gc_times
# * http://blog.ragozin.info/2011/09/hotspot-jvm-garbage-collection-options.html
# * https://jyates.github.io/2012/11/05/rolling-java-gc-logs.html
CATALINA_OPTS="$CATALINA_OPTS -Xloggc:$CATALINA_HOME/logs/gc.log -verbosegc -XX:+PrintGCDetails"
CATALINA_OPTS="$CATALINA_OPTS -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime"
CATALINA_OPTS="$CATALINA_OPTS -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps"
CATALINA_OPTS="$CATALINA_OPTS -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=20 -XX:GCLogFileSize=10M"

# Dump the memory when OOM error occurs.
# If '-XX:HeapDumpPath' is a folder, then the filename will be appended with pid in it
# * https://stackoverflow.com/questions/24809655/using-xxheapdumppath-option-but-want-to-integrate-the-process-id
# * http://www.oracle.com/technetwork/java/javase/tech/vmoptions-jsp-140102.html
CATALINA_OPTS="$CATALINA_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$CATALINA_HOME/logs"

# TODO based on your VM size, set the tuning params and run a load test to confirm them

# Heap size, Metaspace

# defaults from liferay-portal-tomcat bundle (-Xmx1024m -XX:MaxMetaspaceSize=384m)
CATALINA_OPTS="$CATALINA_OPTS -Xmx1024m -XX:MaxMetaspaceSize=384m"

# * 6.2 Deployment Checklist
# * https://blogs.oracle.com/jonthecollector/entry/the_second_most_important_gc
# '-Xmn768m' is equivalent to '-XX:NewSize=768m -XX:MaxNewSize=768m'
#CATALINA_OPTS="$CATALINA_OPTS -server -Xms4096m -Xmx4096m -XX:PermSize=256m -XX:MaxPermSize=400m"
#CATALINA_OPTS="$CATALINA_OPTS -XX:NewSize=768m -XX:MaxNewSize=768m"
#CATALINA_OPTS="$CATALINA_OPTS -XX:SurvivorRatio=6 -XX:TargetSurvivorRatio=90 -XX:MaxTenuringThreshold=15"

# GC (we will have quad-core CPU with 2 threads per core, effectively 8 processors)
#CATALINA_OPTS="$CATALINA_OPTS -XX:+UseParNewGC -XX:ParallelGCThreads=4"
#CATALINA_OPTS="$CATALINA_OPTS -XX:+UseConcMarkSweepGC -XX:ParallelCMSThreads=2"
#CATALINA_OPTS="$CATALINA_OPTS -XX:CMSInitiatingOccupancyFraction=85"
#CATALINA_OPTS="$CATALINA_OPTS -XX:+CMSScavengeBeforeRemark -XX:+ScavengeBeforeFullGC"
#CATALINA_OPTS="$CATALINA_OPTS -XX:+CMSConcurrentMTEnabled"
#CATALINA_OPTS="$CATALINA_OPTS -XX:+CMSParallelRemarkEnabled -XX:+CMSCompactWhenClearAllSoftRefs"

