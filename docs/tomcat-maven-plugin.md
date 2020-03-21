---
title: Tomcat Maven Plugin
tag: Tomcat, Maven
date: 2018-04-07
---

> Funny Prerequisites - You must have an understanding of how to install software on your computer. If you don’t know how to do this, please ask someone at your office, school, etc or pay someone to explain this to you.

Start maven project
---

-   step1: building project with maven command(mvn clean install/mvn verify/mvn clean package…)
-   step2: mvn tomcat7:run

How that would be?
---

config: start server by tomcat maven plugin

```xml
    <build>
        <finalName>jjuina</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>${tomcat7-maven-plugin.version}</version>
                <configuration>
                    <port>9000</port>
                    <path>/jjuina</path>
                    <systemProperties>
                        <application.environment>dev</application.environment>
                        <application.name>jjuina</application.name>
                        <application.home>.</application.home>
                    </systemProperties>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>2.3</version>
                <configuration>
                    <failOnMissingWebXml>false</failOnMissingWebXml>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

Configuring local repository
---

```xml
    <settings>
        ...
        <ocalRepository>/path/to/local/repo/</localRepository>
        ...
    </settings>
```

Apache Tomcat Maven Plugin
---

> Goals: it gives an opportunity to quickly develop our application without needing to install a standalone Tomcat instance.

1.  manipulate WAR projects within Apache Tomcat servlet container
2.  run WAR project with a embedded Apache Tomcat.

Public Maven Repositories
---

-   Maven Central - [https://repo.maven.apache.org/maven2/](https://repo.maven.apache.org/maven2/)
-   Sonatype Releases - [https://oss.sonatype.org/content/repositories/releases/](https://oss.sonatype.org/content/repositories/releases/)
-   JCenter - [https://jcenter.bintray.com/](https://jcenter.bintray.com/)
-   JBoss - [https://repository.jboss.org/nexus/content/repositories/releases/](https://repository.jboss.org/nexus/content/repositories/releases/)
-   Clojars - [https://repo.clojars.org/](https://repo.clojars.org/)
-   Atlassian Maven - [https://packages.atlassian.com/maven-public/](https://packages.atlassian.com/maven-public/)


Reference Link
---

[https://www.deps.co/guides/public-maven-repositories/](https://www.deps.co/guides/public-maven-repositories/)