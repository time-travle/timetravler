FROM java:8
VOLUME /tmp
ADD cache-0.0.1-SNAPSHOT.jar cache-0.0.1-SNAPSHOT.jar.jar
EXPOSE 9001
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/cache-0.0.1-SNAPSHOT.jar.jar" ]